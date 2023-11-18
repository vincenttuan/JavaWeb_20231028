package group_buy.model.dao;

import java.util.List;
import java.util.Optional;

import group_buy.model.entity.Cart;
import group_buy.model.entity.Product;
import group_buy.model.entity.User;

public interface GroupBuyDao {

    /**
     * 查詢所有用戶。
     * @return 返回用戶列表。
     */
    List<User> findAllUsers(); 

    /**
     * 根據用戶名稱查找用戶。
     * @param username 用戶名稱。
     * @return 返回找到的用戶，若未找到則返回 null。
     */
    Optional<User> findUserByUsername(String username); 

    /**
     * 根據用戶ID查找用戶。
     * @param id 用戶ID。
     * @return 返回找到的用戶，若未找到則返回 null。
     */
    Optional<User> findUserById(Integer id); 

    /**
     * 查詢所有產品。
     * @return 返回產品列表。
     */
    List<Product> findAllProducts(); 

    /**
     * 根據產品ID查找產品。
     * @param id 產品ID。
     * @return 返回找到的產品，若未找到則返回 null。
     */
    Optional<Product> findProductById(Integer id); 

    /**
     * 新增產品。
     * @param product 要新增的產品實體。
     */
    void addProduct(Product product); 

    /**
     * 更新產品的上架狀態。
     * @param productId 產品ID。
     * @param isLaunch 產品是否上架。
     */
    void updateProductLaunch(Integer productId, Boolean isLaunch); 

    /**
     * 查詢所有購物車資料。
     * @return 返回購物車列表。
     */
    List<Cart> findAllCarts(); 

    /**
     * 根據用戶ID查詢其所有購物車資料。
     * @param userId 用戶ID。
     * @return 返回該用戶的購物車列表。
     */
    List<Cart> findCartsByUserId(Integer userId); 

    /**
     * 根據用戶ID及結帳狀態查詢購物車資料。
     * @param userId 用戶ID。
     * @param isCheckedOut 是否已結帳。
     * @return 返回符合條件的購物車列表。
     */
    List<Cart> findCartsByUserIdAndCheckoutStatus(Integer userId, Boolean isCheckedOut); 

    /**
     * 查詢用戶的未結帳購物車資料。
     * @param userId 用戶ID。
     * @return 返回找到的購物車，若未找到則返回 null。
     */
    Optional<Cart> findActiveCartByUserId(Integer userId); 

    /**
     * 新增購物車。
     * @param cart 要新增的購物車實體。
     */
    void addCart(Cart cart); 

    /**
     * 根據用戶ID將其所有購物車設置為已結帳狀態。
     * @param userId 用戶ID。
     */
    void checkoutCartsByUserId(Integer userId); 

    /**
     * 根據購物車ID將該購物車設置為已結帳狀態。
     * @param cartId 購物車ID。
     */
    void checkoutCartById(Integer cartId); 

    /**
     * 刪除指定的購物車項目。
     * @param cartItemId 購物車項目ID。
     */
    void removeCartItem(Integer cartItemId); 

    /**
     * 更新購物車項目的數量。
     * @param cartItemId 購物車項目ID。
     * @param quantity 新的數量。
     */
    void updateCartItemQuantity(Integer cartItemId, Integer quantity); 
}
