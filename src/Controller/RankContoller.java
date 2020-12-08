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

import Dto.StoreInfoBean;
import Service.FoodsService;


@WebServlet("/RankContoller")
public class RankContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RankContoller() {
        super();
 
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession ss = request.getSession();

		String userId = (String)ss.getAttribute("id");
		String result = request.getParameter("result");
		
		String[] arr = result.split(",");
		System.out.println(arr[0]+"erpogreipgnri");
		
		ArrayList<StoreInfoBean> storeList = new ArrayList<StoreInfoBean>();
		
		FoodsService fs = new FoodsService();
		fs.enterance(1, storeList, arr[0], userId);
		
		
		// 전번 세팅
		for (int i = 0; i < storeList.size(); i++) {
			if(storeList.get(i).getStoreTel().length()==10) {
			storeList.get(i).setStoreTel(storeList.get(i).getStoreTel().substring(0,3) + "-" 
										+ storeList.get(i).getStoreTel().substring(3,6) + "-" 
										+ storeList.get(i).getStoreTel().substring(6)); 
			}else {
			storeList.get(i).setStoreTel(storeList.get(i).getStoreTel().substring(0,3) + "-" 
					+ storeList.get(i).getStoreTel().substring(3,7) + "-" 
					+ storeList.get(i).getStoreTel().substring(7));			
			}
		}
			
		
		RequestDispatcher rd =  request.getRequestDispatcher("TOPRank.jsp");
		request.setAttribute("img", arr[3]);
		request.setAttribute("description", arr[2]);
		request.setAttribute("name", arr[1]);
		request.setAttribute("storeList", storeList);
		rd.forward(request, response);
		return;
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

}
