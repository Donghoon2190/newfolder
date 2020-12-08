package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Dto.BoardInfoBean;
import Service.CommunityService;

/**
 * Servlet implementation class communityWrite
 */
@WebServlet("/communityWrite")
public class CommunityWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CommunityWrite() {
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
		
		int size = 10 * 1024 * 1024; 
		String savePath = "D:/javaspace/dhspace/newFolderProject/WebContent/fileUpload"; 
		
		MultipartRequest multi = new MultipartRequest(
				request,	
				savePath,	
				size,		
				"UTF-8",	
				new DefaultFileRenamePolicy()
		);
		
		BoardInfoBean board = new BoardInfoBean();
		
		HttpSession hs = request.getSession();
				
		
		board.setWriter((String)hs.getAttribute("id"));
		board.setTitle(multi.getParameter("title"));
		board.setContent(multi.getParameter("content"));
		board.setFile(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		
		CommunityService writesvc = new CommunityService();
		int writeResult = writesvc.enterance(6,0,0,null,board);
		
		if(writeResult>0) {
			RequestDispatcher rd = request.getRequestDispatcher("alert.jsp");
			request.setAttribute("result", 1);
			request.setAttribute("value", "정상적으로 등록되었습니다.");
			rd.forward(request, response);
			
		} else {
		RequestDispatcher rd = request.getRequestDispatcher("alert.jsp");
		request.setAttribute("result", 1);
		request.setAttribute("value", "등록이 실패하였습니다.");
		rd.forward(request, response);
		}
	}

}
