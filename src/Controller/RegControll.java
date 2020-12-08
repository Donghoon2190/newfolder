package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.UserInfoBean;
import Service.Management;

@WebServlet("/regControll")
public class RegControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegControll() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		UserInfoBean uib = new UserInfoBean();
		uib.setUserId(request.getParameter("id"));
		uib.setUserPwd(request.getParameter("pwd"));
		uib.setUserNickname(request.getParameter("nickname"));
		uib.setUserAdd(request.getParameter("add"));
		uib.setRequestValue("1");
		
		Management mg = new Management();
		boolean result = mg.enterance(1,uib,null);
		
		
		if (result) {// 회원가입이 성공했으면 성공창으로
			
			RequestDispatcher rd = request.getRequestDispatcher("alert.jsp");//로그인 성공 페이지로
			request.setAttribute("result", 2);//로그인 페이지로
			request.setAttribute("value", "회원가입이 성공되었습니다.");
			rd.forward(request, response);
		}else {// 실패했으면 실패창으로
			if (uib.getRequestValue().equals("2")) {
				RequestDispatcher rd = request.getRequestDispatcher("alert.jsp");
				request.setAttribute("result", 3);//다시 회원가입 페이지로
				request.setAttribute("value", "회원가입이 실패했습니다.");
				rd.forward(request, response);
				
			}else if(uib.getRequestValue().equals("3")) {
				RequestDispatcher rd = request.getRequestDispatcher("alert.jsp");
				request.setAttribute("result", 3);//다시 회원가입 페이지로
				request.setAttribute("value", "아이디가 중복됩니다.");
				rd.forward(request, response);
			}
		}
	}

         
}














