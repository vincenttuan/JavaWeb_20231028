package group_buy.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import group_buy.model.entity.Cart;
import group_buy.model.entity.CartItem;
import group_buy.model.entity.Product;
import group_buy.model.entity.User;

public class GroupBuyDaoInMemory implements GroupBuyDao {
	
	public static void main(String[] args) {
		System.out.println(users);
		System.out.println(products);
		System.out.println(carts);
	}
	
	// In-memory
	private static List<User> users = new CopyOnWriteArrayList<>();
	private static List<Product> products = new CopyOnWriteArrayList<>();
	private static List<Cart> carts = new CopyOnWriteArrayList<>();
	
	static {
		users.add(new User(1, "John", "1234", 1));
		users.add(new User(2, "Admin", "5678", 2));
		users.add(new User(3, "Mary", "1234", 1));
		
		products.add(new Product(1, "肉羹", 80, "包", true));
		products.add(new Product(2, "肉丸", 60, "包", true));
		products.add(new Product(3, "雞腳凍", 50, "包", true));
		products.add(new Product(4, "乖乖", 200, "箱", false));
		
		List<CartItem> cartItems = new ArrayList<>();
		cartItems.add(new CartItem(1, 1, 1, 7)); // id, cartId, productId, quantity
		cartItems.add(new CartItem(2, 1, 2, 10));
		cartItems.add(new CartItem(3, 1, 3, 5));
		carts.add(new Cart(1, 1, cartItems, false)); // id, userId, cartItems, isCheckedOut
		
		List<CartItem> cartItems2 = new ArrayList<>();
		cartItems2.add(new CartItem(4, 2, 3, 4)); // id, cartId, productId, quantity
		cartItems2.add(new CartItem(5, 2, 1, 3));
		carts.add(new Cart(2, 3, cartItems2, false)); // id, userId, cartItems, isCheckedOut
		
	}
	
	@Override
	public List<User> findAllUsers() {
		return users;
	}

	@Override
	public User findUserByUsername(String username) {
		return users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElseGet(null);
	}

	@Override
	public User findUserById(Integer id) {
		// 在 sequential 順序流(預設) 中 findAny() , findFirst() 效果相同
		return users.stream().filter(user -> user.getId().equals(id)).sequential().findAny().orElseGet(null);
		// 在 parallel 並行流中 findAny() 效率大於 findFirst() , 但是在使用 parallel 時資料量不可以太小, 否則會造成反效果
		//return users.stream().filter(user -> user.getId().equals(id)).parallel().findAny().orElseGet(null);
	}

	@Override
	public List<Product> findAllProducts() {
		return products;
	}

	@Override
	public Product findProductById(Integer id) {
		return products.stream().filter(product -> product.getId().equals(id)).findAny().orElseGet(null);
	}

	@Override
	public void addProduct(Product product) {
		products.add(product);
	}

	@Override
	public void updateProductLaunch(Integer productId, Boolean isLaunch) {
		Product product = findProductById(productId);
		if(product != null) {
			product.setIsLaunch(isLaunch);
		}
	}

	@Override
	public List<Cart> findAllCarts() {
		return carts;
	}

	@Override
	public List<Cart> findCartsByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> findCartsByUserIdAndCheckoutStatus(Integer userId, Boolean isCheckedOut) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart findActiveCartByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCart(Cart cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkoutCartsByUserId(Integer userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkoutCartById(Integer cartId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCartItem(Integer cartItemId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCartItemQuantity(Integer cartItemId, Integer quantity) {
		// TODO Auto-generated method stub
		
	}

}
