package group_buy.model.entity;

import java.util.List;

// 購物車主檔(Master)
public class Cart {
	private Integer id; // 序號
	private Integer userId; // 使用者 id
	private List<CartItem> cartItems;
	
	public Cart() {
		
	}
	
	public Cart(Integer id, Integer userId, List<CartItem> cartItems) {
		this.id = id;
		this.userId = userId;
		this.cartItems = cartItems;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", userId=" + userId + ", cartItems=" + cartItems + "]";
	}
	
	
}
