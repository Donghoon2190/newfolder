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

@WebServlet("/CommunityMod1")
public class CommunityMod1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CommunityMod1() {
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

		
		ArrayList<FoodInfoBean> foodlist = new ArrayList<FoodInfoBean>();
		FoodsService fs = new FoodsService();
		fs.enterance(2, foodlist, null);

		request.setAttribute("food", foodlist.get(0));
		request.setAttribute("title", request.getParameter("title"));
		request.setAttribute("date", request.getParameter("date"));
		request.setAttribute("file", request.getParameter("file"));
		request.setAttribute("writer", request.getParameter("writer"));
		request.setAttribute("content", request.getParameter("content"));
		request.setAttribute("num", request.getParameter("num"));
		request.setAttribute("page", request.getParameter("page"));
		
		RequestDispatcher dispatcher 
			= request.getRequestDispatcher("Modify.jsp"); // 게시판 페이지로
		dispatcher.forward(request, response);
	}
}













