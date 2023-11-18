package group_buy.model.entity;

// 購物車明細檔(Detail)
public class CartItem {
	private Integer id; // 序號
	private Integer cartId; // 購物車主檔序號
	private Integer productId; // 商品 id
	private Integer amount; // 商品數量
	
	public CartItem() {
		
	}
	
	public CartItem(Integer id, Integer cartId, Integer productId, Integer amount) {
		this.id = id;
		this.cartId = cartId;
		this.productId = productId;
		this.amount = amount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", cartId=" + cartId + ", productId=" + productId + ", amount=" + amount + "]";
	}
	
	
}
