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

import Dto.FoodInfoBean;
import Dto.StoreInfoBean;
import Service.FoodsService;


@WebServlet("/RandomRecommendControll")
public class RandomRecommendControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RandomRecommendControll() {
        super();
 
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ArrayList<FoodInfoBean> foodList = new ArrayList<FoodInfoBean>();
		
		FoodsService fs = new FoodsService();
		if(fs.enterance(2, foodList, null)) {
			RequestDispatcher rd =  request.getRequestDispatcher("RandomRecommend.jsp");
			request.setAttribute("foodList", foodList);
			rd.forward(request, response);
			return;
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("alert.jsp");
			request.setAttribute("result", 1);
			request.setAttribute("value", "잠시뒤에 다시 시도해주세요");
			rd.forward(request, response);
			return;
		}
			
		
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

}
