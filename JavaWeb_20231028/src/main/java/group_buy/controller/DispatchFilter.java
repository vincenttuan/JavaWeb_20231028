package group_buy.controller;

import java.io.IOException;
import java.util.Optional;

import group_buy.model.dao.GroupBuyDao;
import group_buy.model.dao.GroupBuyDaoMySQL;
import group_buy.model.entity.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 過濾路徑分派器
@WebFilter(value = {"/group_buy/*"})
public class DispatchFilter extends HttpFilter {
	
	private GroupBuyDao dao = GroupBuyDaoMySQL.getInstance();
	
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String contextPath = getServletContext().getContextPath();
		String servletPath = request.getServletPath();
		String method = request.getMethod();
		System.out.println(servletPath + ", " + method);
		
		switch (servletPath) {
			case "/group_buy/frontend/main.jsp": // 按下登入頁的"前台登入"按鈕或按下"團購首頁"連結
				if(method.equals("POST")) { // 按下登入頁的"前台登入"按鈕
					String username = request.getParameter("username");
					String password = request.getParameter("password");
					// 找到使用者
					Optional<User> userOpt = dao.findUserByUsername(username);
					if(userOpt.isEmpty() || !password.equals(userOpt.get().getPassword())) {
						System.out.println("無此使用者或密碼不正確");
						response.sendRedirect(contextPath + "/group_buy/login.jsp");
						return;
					}
					System.out.println("使用者登入成功");
				}
			break;
		}
		
		chain.doFilter(request, response);
	}
	
}
