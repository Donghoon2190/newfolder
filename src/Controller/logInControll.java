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
import Service.Access;

@WebServlet("/logInControll")
public class logInControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public logInControll() {
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
		response.setContentType("text/html;charset=UTF-8");
		
		UserInfoBean uib = new UserInfoBean();
		uib.setUserId(request.getParameter("id"));
		uib.setUserPwd(request.getParameter("pwd"));
		
		// 로그인 분기 1
		
		Access ac = new Access(); 
		boolean result = ac.enterance(1,uib,null);
		
		if (result) {// 로그인 성공햇으면 메인페이지
			HttpSession hs = request.getSession();
			
			hs.setAttribute("id", uib.getUserId());
			hs.setAttribute("add", uib.getUserAdd());
			hs.setAttribute("nickname", uib.getUserNickname());
			hs.setAttribute("level", uib.getUserLevel());
			
			
			response.sendRedirect("Main.jsp"); // 로그인 성공 페이지로
			
		}else {// 로그인 실패 시 로그인페이지
			RequestDispatcher rd = request.getRequestDispatcher("alert.jsp");
			request.setAttribute("result", 2);
			request.setAttribute("value", "로그인이 실패하였습니다.");
			rd.forward(request, response);
		}
	}

}














