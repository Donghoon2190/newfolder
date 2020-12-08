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

@WebServlet("/UserPassCheck")
public class UserPassCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserPassCheck() {
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
		
		UserInfoBean uib = new UserInfoBean();
		
		HttpSession hs = request.getSession();
		
		uib.setUserId((String)hs.getAttribute("id"));
		uib.setUserPwd(request.getParameter("pass"));
		
		Management mg = new Management();
		boolean result = mg.enterance(3, uib, null);
		
		if (result) {
			response.sendRedirect("MemberModify.jsp");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("alert.jsp");
			request.setAttribute("result", 4);
			request.setAttribute("value", "비밀번호가 일치하지 않습니다.");
			rd.forward(request, response);
		}
		
		
	}
		

}
