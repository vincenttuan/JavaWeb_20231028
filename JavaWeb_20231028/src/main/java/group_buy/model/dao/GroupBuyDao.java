package group_buy.model.dao;

import java.util.List;

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
	
	
}
