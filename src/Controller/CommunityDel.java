package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.CommunityService;

/**
 * Servlet implementation class communityDel
 */
@WebServlet("/communityDel")
public class CommunityDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityDel() {
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
		
		int bNum = Integer.parseInt(request.getParameter("Num"));
		CommunityService delsvc = new CommunityService();
		int delResult = delsvc.enterance(5,bNum,0,null,null);
		// 댓글이랑 떰즈 다 삭제
		
		if(delResult>0) {
			RequestDispatcher rd = request.getRequestDispatcher("alert.jsp");
			request.setAttribute("value", "게시글이 삭제되었습니다.");
			request.setAttribute("result", 5);
			rd.forward(request, response);
			
		} else {
			response.sendRedirect("BoardWrite.jsp"); // 게시글 삭제 실패했을때 페이지
		}
		
	}

}
