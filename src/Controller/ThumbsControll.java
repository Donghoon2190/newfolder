package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.BoardInfoBean;
import Service.CommunityService;

@WebServlet("/ThumbsControll")
public class ThumbsControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThumbsControll() {
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
		BoardInfoBean bib = new BoardInfoBean();
		
		bib.setWriterId(request.getParameter("meid"));//누른사람
		bib.setWriter(request.getParameter("Cmeid"));//작성자
		bib.setNum(Integer.parseInt(request.getParameter("Num")));
		bib.setThumbs(Integer.parseInt(request.getParameter("value")));
		
		
		CommunityService cs = new CommunityService();
		int result = cs.enterance(8, 0, 0, null, bib);
		if (result>0) {
			RequestDispatcher rd = request.getRequestDispatcher("alert.jsp");
			request.setAttribute("result", 5);
			request.setAttribute("value", "투표해 주셔서 감사합니다.");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("alert.jsp");
			request.setAttribute("result", 5);
			request.setAttribute("value", "이미 투표하셨습니다.");
			rd.forward(request, response);
			
		}
	}

}















