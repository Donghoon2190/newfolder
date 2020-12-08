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
import Dto.FoodInfoBean;
import Dto.pageInfoBean;
import Service.CommunityService;
import Service.FoodsService;

@WebServlet("/pagingControll")
public class PagingControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PagingControll() {
        super();
        // TODO Auto-generated constructor stub
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
		// 좋아요 탑 3 가져오기
		ArrayList<BoardInfoBean> list = new ArrayList<BoardInfoBean>();
		
		CommunityService cs = new CommunityService();
		cs.enterance(7, 0, 0, list, null);
		
		for (int i = list.size()-1; i > 2; i--) {
			list.remove(i);
		}
		
		// 한페이지 게시글 몇개 표시할지 정하기
		int page = 1;	// 처음 시작 페이지
		int limit = 7; 	// 한페이지에 표시되는 게시글의 수
		
		
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		// PageService만들기
		
		// DB에서 게시글의 갯수 가져오기
		int listCount = cs.enterance(1,0,0,null,null);
		
		//1페이지 : page = 1 / startRow = 1 / endRow = 10
		//2페이지 : page = 2 / startRow = 11 / endRow = 20
		int startRow = (page-1) * limit + 1;
		int endRow = page * limit;
		
		ArrayList<BoardInfoBean> boardList = new ArrayList<BoardInfoBean>();
				
		cs.enterance(2,startRow, endRow,boardList,null);
		
		
		// 글 갯수가 정해준 limit 갯수를 넘을때마다 페이지가 1개씩 자동으로 생기게 해주는 기능
		int maxPage = (int)((double)listCount / limit + 0.9);
		
		// int로 변환하면 소숫점은 다 없애버림.
		// 나누기로 한 화면에 보여줄 페이지 갯수를 정해줌.  ->page/10  -> 1 2 3 4 5 6 7 8 9 10
		int startPage = (((int)((double)page/10 + 0.9))-1) * 10 +1;
		
		// 현재페이지에 보여줄 끝페이지
		int endPage = startPage + 10 -1;
		
		// endPage가 maxPage보다 클경우 
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		ArrayList<FoodInfoBean> foodlist = new ArrayList<FoodInfoBean>();
		FoodsService fs = new FoodsService();
		fs.enterance(2, foodlist, null);
		
		pageInfoBean paging = new pageInfoBean();
		
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		paging.setListCount(listCount);
		
		request.setAttribute("top3", list);
		request.setAttribute("paging",paging);
		request.setAttribute("boardList",boardList);
		request.setAttribute("food", foodlist.get(0));
		
		RequestDispatcher dispatcher 
			= request.getRequestDispatcher("community.jsp"); // 게시판 페이지로
		dispatcher.forward(request, response);
	}
}













