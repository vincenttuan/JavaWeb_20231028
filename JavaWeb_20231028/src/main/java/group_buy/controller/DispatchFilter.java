package group_buy.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import group_buy.model.dao.GroupBuyDao;
import group_buy.model.dao.GroupBuyDaoMySQL;
import group_buy.model.entity.Product;
import group_buy.model.entity.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static group_buy.controller.URLPath.團購首頁;
import static group_buy.controller.URLPath.登入首頁;;

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
			case 團購首頁: // 按下登入頁的"前台登入"按鈕或按下"團購首頁"連結
				if(method.equals("POST")) { // 按下登入頁的"前台登入"按鈕
					String username = request.getParameter("username");
					String password = request.getParameter("password");
					// 找到使用者
					Optional<User> userOpt = dao.findUserByUsername(username);
					// 判斷是否有找到使用者與密碼判斷
					if(userOpt.isEmpty() || !password.equals(userOpt.get().getPassword())) {
						System.out.println("無此使用者或密碼不正確");
						response.sendRedirect(contextPath + 登入首頁);
						return;
					}
					System.out.println("使用者登入成功");
				} 
				
				List<Product> products = dao.findAllProducts();
				System.out.println("商品資訊: " + products);
				request.setAttribute("products", products); // 將商品資訊放入到 request-scope 的屬性中
			break;
		}
		
		chain.doFilter(request, response);
	}
	
}
