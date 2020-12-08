package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Discarder;

import Dto.BoardInfoBean;
import Service.CommunityService;


@WebServlet("/communityReply")
public class CommunityReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CommunityReply() {
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
		
		String page = request.getParameter("page");
		BoardInfoBean bib = new BoardInfoBean();
		
		HttpSession hs = request.getSession();
		bib.setID((String)hs.getAttribute("id"));
		bib.setWriter((String)request.getParameter("Cmeid"));
		bib.setReply((String)request.getParameter("reply"));
		bib.setNum(Integer.parseInt(request.getParameter("num")));
		
		
		CommunityService writesvc = new CommunityService();
		
		if(writesvc.enterance(1,null,bib,null)) {
			System.out.println("등록성공");
			request.setAttribute("page", page);
			request.setAttribute("Num", request.getParameter("num"));
			request.getRequestDispatcher("oneCommunityView").forward(request, response);
		}else {
			
			PrintWriter pw = response.getWriter();
			System.out.println("등록실패");
			request.setAttribute("page", page);
			request.setAttribute("Num", request.getParameter("num"));
			request.getRequestDispatcher("oneCommunityView").forward(request, response);
		}
		

	}

}
