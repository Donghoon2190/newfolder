package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dto.UserInfoBean;
import Service.Management;

/**
 * Servlet implementation class UserModify
 */
@WebServlet("/UserModify")
public class UserModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserModify() {
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
		UserInfoBean uib = new UserInfoBean();
		HttpSession hs = request.getSession();
		
		uib.setUserId((String)hs.getAttribute("id"));
		uib.setUserPwd(request.getParameter("pass"));
		uib.setUserNickname(request.getParameter("nickname"));
		uib.setUserAdd(request.getParameter("add"));
		
		Management mg = new Management();
		boolean result = mg.enterance(4, uib, null);
		
		System.out.println(result);
		RequestDispatcher rd = request.getRequestDispatcher("alert.jsp");
		if (result) {
			request.setAttribute("value", "정상적으로 수정되었습니다.");
			request.setAttribute("result", 1);
		}else {
			request.setAttribute("value", "수정이 실패하였습니다.");
			request.setAttribute("result", 1);
		}
		rd.forward(request, response);
		
	}

}
