package group_buy.model.dao;

import java.util.List;

import group_buy.model.entity.Cart;
import group_buy.model.entity.Product;
import group_buy.model.entity.User;

public interface GroupBuyDao {
	
	List<User> queryAllUsers(); // 取得所有使用者
	User getUserByUsername(String username); // 取得使用者
	User getUserById(Integer id); // 取得使用者
	
	List<Product> queryAllProducts(); // 取得所有商品
	Product getProductById(Integer id); // 取得商品
	void addProduct(Product product); // 新增商品
	void setLaunchProduct(Integer productId, Boolean isLaunch); // 調整商品上下架
	
	List<Cart> queryAllCarts(); // 取得所有購物車主檔
	List<Cart> queryAllCartsByUserId(Integer id); // 取得該使用者的所有購物車主檔
	List<Cart> queryAllCartsByUserId(Integer id, Boolean isCheckedOut); // 取得該使用者的所有購物車主檔(是否有結帳紀錄)
	Cart getNoneCheckoutCartByUserId(Integer id); // 取得該使用者尚未結帳的購物車資料
	
	void addCart(Cart cart); // 新增購物車
	void setCheckOutCartByUserId(Integer userId); // 將該使用者的購物車資訊進行結帳  
	void setCheckOutCartByChartId(Integer cartId); // 將該購物車資訊進行結帳  
	void deleteCartItemById(Integer cartItemId); // 將該筆購物明細刪除
	
	
}
