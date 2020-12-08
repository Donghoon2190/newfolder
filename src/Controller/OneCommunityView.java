package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.CommunityService;
import Dto.BoardInfoBean;
import Dto.pageInfoBean;

/**
 * Servlet implementation class communityBoard
 */
@WebServlet("/oneCommunityView")
public class OneCommunityView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OneCommunityView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		int bNum;
		String page;
		
		if(request.getParameter("Num")==null) {
			bNum = Integer.parseInt((String) request.getAttribute("Num"));
			page = (String)request.getAttribute("page");
		}else {
			bNum = Integer.parseInt(request.getParameter("Num"));
			page = request.getParameter("page");
		}
		int rePage = 1;
		int limit = 4;
		
		
		if(request.getParameter("rePage")!=null) {
			rePage = Integer.parseInt(request.getParameter("rePage"));
		}
		
		ArrayList<BoardInfoBean> reList = new ArrayList<BoardInfoBean>();
		CommunityService cs = new CommunityService();
		BoardInfoBean  board = new BoardInfoBean();
		pageInfoBean pib = new pageInfoBean();
		int start = ((int)(rePage*0.9)*limit)+1;
		int end = (start-1) + limit;
		
		pib.setStartPage(start);
		pib.setEndPage(end);
		pib.setBoardNum(bNum);
		
		if(cs.enterance(3, pib, board,reList)) {
			request.setAttribute("reply", reList);
		}else {
			System.out.println("댓글 불러오기 실패");
		}
		int max = (pib.getMaxPage()%limit)==0?pib.getMaxPage()/limit:pib.getMaxPage()/limit+1;
		System.out.println(max);
		if(board.getContent() != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Communitydeatil.jsp");
			request.setAttribute("view", board);
			request.setAttribute("page", page);
			request.setAttribute("rePage",rePage);
			request.setAttribute("max",max);
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("alert.jsp");
			request.setAttribute("result", 1);
			request.setAttribute("value", "값을 불러오지 못했습니다.");
			dispatcher.forward(request, response);
		}

}
}






