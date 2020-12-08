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

import Dto.StoreInfoBean;
import Service.StoreService;

@WebServlet("/StoreReg")
public class StoreReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StoreReg() {
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
		
		StoreInfoBean sib = new StoreInfoBean();
		
		int size = 10 * 1024 * 1024; 
		String savePath = "D:/javaspace/dhspace/newFolderProject/WebContent/fileUpload"; 
		
		MultipartRequest multi = new MultipartRequest(
				request,	
				savePath,	
				size,		
				"UTF-8",	
				new DefaultFileRenamePolicy()
		);
		
		sib.setStoreName(multi.getParameter("name"));
		sib.setCaCode(multi.getParameter("foods"));
		sib.setStoreAdd(multi.getParameter("add"));
		sib.setStoreTel(multi.getParameter("tel"));
		sib.setStoreComment(multi.getParameter("comment"));
		sib.setFileName(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
	
		StoreService ss = new StoreService();
		int result = ss.enterance(1,0,0,sib,null);
		
		if (result>0) {
			RequestDispatcher rd = request.getRequestDispatcher("alert.jsp");
			request.setAttribute("result", 1);
			request.setAttribute("value", "가게 등록 요청을 성공했습니다.");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("alert.jsp");
			request.setAttribute("result", 1);
			request.setAttribute("value", "가게 등록 요청이 실패했습니다.");
			rd.forward(request, response);
		}
	}

}













