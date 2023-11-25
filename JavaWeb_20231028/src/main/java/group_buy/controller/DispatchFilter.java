package group_buy.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import group_buy.model.dao.GroupBuyDao;
import group_buy.model.dao.GroupBuyDaoMySQL;
import group_buy.model.entity.Cart;
import group_buy.model.entity.CartItem;
import group_buy.model.entity.Product;
import group_buy.model.entity.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import static group_buy.controller.URLPath.團購首頁;
import static group_buy.controller.URLPath.登入首頁;
import static group_buy.controller.URLPath.新增完成頁;
import static group_buy.controller.URLPath.購物車頁;
// 過濾路徑分派器
@WebFilter(value = {"/group_buy/*"})
public class DispatchFilter extends HttpFilter {
	
	private GroupBuyDao dao = GroupBuyDaoMySQL.getInstance();
	
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String contextPath = getServletContext().getContextPath();
		String servletPath = request.getServletPath();
		String method = request.getMethod();
		System.out.println(servletPath + ", " + method);
		
		HttpSession session = request.getSession();
		
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
					// 將使用者物件存入到 session 中
					session.setAttribute("user", userOpt.get());
				} 
				
				List<Product> products = dao.findAllProducts();
				System.out.println("商品資訊: " + products);
				request.setAttribute("products", products); // 將商品資訊放入到 request-scope 的屬性中
				break;
			case 新增完成頁:
				if(method.equals("POST")) {
					String productId = request.getParameter("productId"); // 取得欲購買商品
					String quantity = request.getParameter("quantity"); // 取得欲購買數量
					// 取得已登入的使用者
					User user = (User)session.getAttribute("user");
					// 使用者購物車
					Cart cart = null;
					// 先找該 user 目前有沒有還未結帳的購物車
					Optional<Cart> cartOpt = dao.findNoneCheckoutCartByUserId(user.getUserId());
					if(cartOpt.isPresent()) {
						cart = cartOpt.get(); // 取得該使用者的購物車
					} else {
						cart = new Cart(); // 建立一個新的購物車
						cart.setUserId(user.getUserId());
						dao.addCart(cart); // 存放到資料表中
						
						// 新增之後馬上又要查詢建議可以下達一段 delay
						try {
							Thread.sleep(10);
						} catch (Exception e) {
						}
						
						// 再抓一次使用者的 cart, 目的是要得到 carId
						cart = dao.findNoneCheckoutCartByUserId(user.getUserId()).get();
					}
					// 建立購物項目
					CartItem cartItem = new CartItem();
					cartItem.setCartId(cart.getCartId());
					cartItem.setProductId(Integer.parseInt(productId));
					cartItem.setQuantity(Integer.parseInt(quantity));
					dao.addCartItem(cartItem);
					
					// 將商品物件與數量傳下去給 jsp
					request.setAttribute("product", dao.findProductById(Integer.parseInt(productId)).get());
					request.setAttribute("quantity", quantity);
				} else {
					response.getWriter().print("非法進入~");
					return;
				}
				break;
			case 購物車頁:
				// 取得已登入的使用者
				User user = (User)session.getAttribute("user");
				request.setAttribute("cart", dao.findNoneCheckoutCartByUserId(user.getUserId()).get());
				break;
		}
		
		chain.doFilter(request, response);
	}
	
}
