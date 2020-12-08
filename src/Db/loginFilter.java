package Db;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dto.TotalInfoBean;
import Service.Management;

@WebFilter("/loginFilter")
public class loginFilter implements Filter {
	private List<String> whitelist ;
	private List<String> resourceLIst;

	public loginFilter() {
		whitelist = new ArrayList<String>();
		whitelist.add("/Loginindex.jsp");
		whitelist.add("/logInControll");
		whitelist.add("/index.jsp");
		whitelist.add("/regControll");
		whitelist.add("/LoadControll");
		resourceLIst = new ArrayList<String>();
		resourceLIst.add("/newFolderProject/css/");
		resourceLIst.add("/newFolderProject/js/");
		resourceLIst.add("/newFolderProject/images/");
	}
	
	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession hs = req.getSession();
		boolean isResource = false;
		boolean flag = true;
		// URI 확인
		String uri = req.getRequestURI();
		// 화이트 리스트 설정
		for (int i = 0; i < whitelist.size(); i++) {
			if (uri.contains(whitelist.get(i))) {
				flag = false;
			}
		}
		// 리소스되는 파일들 설정
		for (String i : resourceLIst) {
			if (uri.startsWith(i)) {
				isResource = true;
				break;
			}
		}
		if (!isResource) {
			if (flag) {
				String Id = (String)hs.getAttribute("id");
				if (Id==null) {
					RequestDispatcher rd = req.getRequestDispatcher("alert.jsp");
					req.setAttribute("result", 2);
					req.setAttribute("value", "로그인이 필요합니다.");
					rd.forward(request, response);
					return;
				}
			}
		}
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
