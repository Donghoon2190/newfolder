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

/**
 * Servlet implementation class logOutControll
 */
@WebServlet("/logOutControll")
public class logOutControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public logOutControll() {
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
		
		HttpSession hs = request.getSession();
		
		String id = (String)hs.getAttribute("id");
		Access ac = new Access();
		ac.enterance(2,null,id);
		
		
		
		hs.invalidate();
		
		//로그아웃 하면 세션값을 다 없애고 로그인 페이지로
		RequestDispatcher rd = request.getRequestDispatcher("alert.jsp");
		request.setAttribute("result", 3);
		request.setAttribute("value", "로그아웃 되었습니다.");
		rd.forward(request, response);
		
	}

}
