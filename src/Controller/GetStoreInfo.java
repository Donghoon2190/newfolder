package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.BoardInfoBean;
import Dto.StoreInfoBean;
import Dto.pageInfoBean;
import Service.StoreService;
@WebServlet("/GetStoreInfo")
public class GetStoreInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetStoreInfo() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ArrayList<StoreInfoBean> Rlist = new ArrayList<StoreInfoBean>();
		//STATE가 R인것만 가져오기
		StoreService ss = new StoreService();
		ss.enterance(2,0,0,null,Rlist);

	
		int page = 1;	// 처음 시작 페이지
		int limit = 5; 	// 한페이지에 표시되는 게시글의 수
		
		
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int StoreCount = ss.enterance(4,0,0,null, null);
		// PageService만들기
		
		// DB에서 게시글의 갯수 가져오기
		
		
		
		
		//1페이지 : page = 1 / startRow = 1 / endRow = 5
		//2페이지 : page = 2 / startRow = 6 / endRow = 10
		int startRow = (page-1) * limit + 1;
		int endRow = page * limit;
		
				
		ArrayList<StoreInfoBean> Llist = new ArrayList<StoreInfoBean>();
		//STATE가 L인것만 가져오기
		ss.enterance(3,startRow,endRow, null,Llist);
		
		
		// 글 갯수가 정해준 limit 갯수를 넘을때마다 페이지가 1개씩 자동으로 생기게 해주는 기능
		int maxPage = (int)((double)StoreCount / limit + 0.9);
		
		// int로 변환하면 소숫점은 다 없애버림.
		// 나누기로 한 화면에 보여줄 페이지 갯수를 정해줌.  ->page/10  -> 1 2 3 4 5 6 7 8 9 10
		int startPage = (((int)((double)page/10 + 0.9))-1) * 10 +1;
		
		// 현재페이지에 보여줄 끝페이지
		int endPage = startPage + 10 -1;
		
		// endPage가 maxPage보다 클경우 
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		pageInfoBean paging = new pageInfoBean();
		
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		paging.setListCount(StoreCount);
		
		
			RequestDispatcher rd = request.getRequestDispatcher("AdminPage.jsp");
			
			request.setAttribute("Rlist", Rlist);
			request.setAttribute("paging",paging);
			request.setAttribute("Llist", Llist);
			rd.forward(request, response);
			
		}
	}














