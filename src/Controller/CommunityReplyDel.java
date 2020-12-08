package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Discarder;

import Dto.BoardInfoBean;
import Service.CommunityService;

/**
 * Servlet implementation class communityDel
 */
@WebServlet("/CommunityReplyDel")
public class CommunityReplyDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityReplyDel() {
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
		

		BoardInfoBean bib = new BoardInfoBean();
		bib.setNum(Integer.parseInt(request.getParameter("num")));
		bib.setDate((String)request.getParameter("date"));
		String page = request.getParameter("page");

		CommunityService cs = new CommunityService();
		if(cs.enterance(2, null, bib, null)) {
		request.setAttribute("page", page);
		request.setAttribute("Num", request.getParameter("num"));
		request.getRequestDispatcher("oneCommunityView").forward(request, response);
		}else {
		request.setAttribute("page", page);
		request.setAttribute("Num", request.getParameter("num"));
		request.getRequestDispatcher("oneCommunityView").forward(request, response);
			
		}
		
		
	}

}
