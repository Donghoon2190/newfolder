package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.filters.ExpiresFilter.XServletOutputStream;

import Dto.EventInfoBean;
import Service.Events;

@WebServlet("/GetCouponInfo")
public class GetCouponInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetCouponInfo() {
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
		
		ArrayList<EventInfoBean> list = new ArrayList<EventInfoBean>();
		
		HttpSession hs = request.getSession();
		
		String id =(String)hs.getAttribute("id");
		
		Events ev = new Events();
		ev.enterance(1,id,list);
		RequestDispatcher rd = request.getRequestDispatcher("Event.jsp");//내쿠폰함페이지
		request.setAttribute("list", list);
		rd.forward(request, response);
		
		}
}











