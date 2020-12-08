package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Dto.FoodInfoBean;
import Service.FoodsService;


@WebServlet("/FoodsInfoControll")
public class FoodsInfoControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FoodsInfoControll() {
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
		
		ArrayList<FoodInfoBean> foodList = new ArrayList<FoodInfoBean>();
		String foodCode = request.getParameter("foodeCode");
		
		
		FoodsService fs = new FoodsService();
		fs.enterance(1, foodList, foodCode);
		
		if (foodList.get(0).getFoName()!=null) {
			request.setAttribute("foodList", foodList);
			request.setAttribute("foodCode", foodCode);
			request.getRequestDispatcher("SortedCategoryByFood.jsp").forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("alert.jsp");
			request.setAttribute("result", 1);
			request.setAttribute("value", "데이터를 불러오는데 실패했습니다.");
			rd.forward(request, response);
		}
		
	}

}











