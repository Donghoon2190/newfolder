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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Dto.FoodInfoBean;
import Service.FoodsService;

/**
 * Servlet implementation class getFoodsInfo
 */
@WebServlet("/GetFoodsInfo")
public class GetFoodsInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFoodsInfo() {
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
		
		ArrayList<FoodInfoBean> list = new ArrayList<FoodInfoBean>();
		
		String foodCode = request.getParameter("foodCode");
		if(foodCode==null) foodCode = "0%";
		
		HttpSession hs = request.getSession();
		System.out.println(hs.getAttribute("id"));
		System.out.println(hs.getAttribute("level"));
		
		
		FoodsService fs = new FoodsService();
		fs.enterance(1, list, foodCode);
		
		JSONObject obj = new JSONObject();
		JSONArray arr;
		
		for (int i = 0; i < list.size(); i++) {
			
			arr = new JSONArray();
			arr.add(list.get(i).getFoCode());
			arr.add(list.get(i).getFoName());
			arr.add(list.get(i).getFoComment());
			arr.add(list.get(i).getFoFileName());
			
			obj.put(new Integer(i), arr);
		}
		
		if (list.get(0).getFoName()!=null) {
			request.setAttribute("data", obj);
			hs.setAttribute("level", hs.getAttribute("level"));
			RequestDispatcher rd = request.getRequestDispatcher("MainRank.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("alert.jsp");
			request.setAttribute("result", 1);
			request.setAttribute("value", "데이터를 불러오는데 실패했습니다.");
			rd.forward(request, response);
		}
		
	}

}












