package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Dto.BoardInfoBean;
import Service.CommunityService;

/**
 * Servlet implementation class communityMod1
 */
@WebServlet("/communityMod2")
public class CommunityMod2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityMod2() {
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
		
		int size = 10 * 1024 * 1024; 
		String savePath = "D:/javaspace/dhspace/newFolderProject/WebContent/fileUpload";
		
		MultipartRequest multi = new MultipartRequest(
				request,	
				savePath,	
				size,		
				"UTF-8",	
				new DefaultFileRenamePolicy()
		);
		
		BoardInfoBean bib = new BoardInfoBean();
		bib.setNum(Integer.parseInt(multi.getParameter("num")));
		bib.setTitle(multi.getParameter("title"));
		bib.setContent(multi.getParameter("content"));
		bib.setFile(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));

		
		CommunityService prosvc = new CommunityService();
		int proResult = prosvc.enterance(4,0,0,null,bib);
	
		if(proResult>0) {
				RequestDispatcher rd = request.getRequestDispatcher("alert.jsp");
				request.setAttribute("result", 1);
				request.setAttribute("value", "정상적으로 수정되었습니다.");
				rd.forward(request, response);
				
			} else {
			RequestDispatcher rd = request.getRequestDispatcher("alert.jsp");
			request.setAttribute("result", 1);
			request.setAttribute("value", "수정이 실패하였습니다.");
			rd.forward(request, response);
			}
	}

}
