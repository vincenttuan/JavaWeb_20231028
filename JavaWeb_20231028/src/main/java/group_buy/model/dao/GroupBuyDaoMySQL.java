package group_buy.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import group_buy.model.entity.Cart;
import group_buy.model.entity.CartItem;
import group_buy.model.entity.Product;
import group_buy.model.entity.User;

// 利用 SingleTon + JdbcTemplate 來設計
public class GroupBuyDaoMySQL implements GroupBuyDao {
	private static GroupBuyDao _instance = new GroupBuyDaoMySQL();
	
	private JdbcTemplate jdbcTemplate;
	
	private GroupBuyDaoMySQL() {
		String dbURL = "jdbc:mysql://localhost:3306/group_buy?serverTimezone=Asia/Taipei";
		String username = "root";
		String password = "12345678";
		
		// 創建 DriverManagerDataSource
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); // MySQL 驅動
		dataSource.setUrl(dbURL);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		// 設定 JdbcTemplate 的數據源
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public static GroupBuyDao getInstance() {
		return _instance;
	}
	
	@Override
	public List<User> findAllUsers() {
		String sql = "select userId, username, password, level from user";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
		/*
		return jdbcTemplate.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setLevel(rs.getInt("level"));
				return user;
			}
			
		});
		*/
	}

	@Override
	public void addUser(User user) {
		String sql = "insert into user(username, password, level) values(?, ?, ?)";
		jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getLevel());
	}

	@Override
	public Boolean updateUserPassword(Integer userId, String newPassword) {
		String sql = "update user set password = ? where userId = ?";
		int rowcount = jdbcTemplate.update(sql, newPassword, userId);
		return rowcount == 1;
	}

	@Override
	public Optional<User> findUserByUsername(String username) {
		String sql = "select userId, username, password, level from user where username = ?";
		User user = null;
		try {
			user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
		} catch (EmptyResultDataAccessException e) {
			//e.printStackTrace();
			return Optional.empty();
		}
		return Optional.ofNullable(user);
	}

	@Override
	public Optional<User> findUserById(Integer userId) {
		String sql = "select userId, username, password, level from user where userId = ?";
		User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), userId);
		return Optional.ofNullable(user);
	}

	@Override
	public List<Product> findAllProducts() {
		String sql = "select productId, productName, price, unit, isLaunch from product";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
	}

	@Override
	public Optional<Product> findProductById(Integer productId) {
		String sql = "select productId, productName, price, unit, isLaunch from product where productId = ?";
		Product product = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class), productId);
		return Optional.ofNullable(product);
	}

	@Override
	public void addProduct(Product product) {
		String sql = "insert into product(productName, price, unit, isLaunch) values(?, ?, ? , ?)";
		jdbcTemplate.update(sql, product.getProductName(), product.getPrice(), product.getUnit(), product.getIsLaunch());
	}

	@Override
	public Boolean updateProductLaunch(Integer productId, Boolean isLaunch) {
		String sql = "update product set isLaunch = ? where productId = ?";
		return jdbcTemplate.update(sql, isLaunch, productId) == 1;
	}

	@Override
	public void addCart(Cart cart) {
		String sql = "insert into cart(userId, isCheckout) values(?, ?)";
		jdbcTemplate.update(sql, cart.getUserId(), cart.getIsCheckout());
	}

	@Override
	public void addCartItem(CartItem cartItem) {
		String sql = "insert into cartitem(cartId, productId, quantity) values(?, ?, ?)";
		jdbcTemplate.update(sql, cartItem.getCartId(), cartItem.getProductId(), cartItem.getQuantity());
	}

	@Override
	public List<Cart> findAllCart() {
		String sql = "select cartId, userId, isCheckout, checkoutTime from cart";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cart.class));
	}

	@Override
	public Optional<Cart> findCartById(Integer cartId) {
		String sql = "select cartId, userId, isCheckout, checkoutTime from cart where cartId = ?";
		Cart cart = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Cart.class), cartId);
		if(cart != null) {
			// 根據 userId 來找到 user 並注入到 cart 中
			findUserById(cart.getUserId()).ifPresent(cart::setUser);
			// 查詢 List<CartItem> 根據 cartId  並注入到 cart 中
			sql = "select itemId, cartId, productId, quantity from cartitem where cartId = ?";
			List<CartItem> cartItems = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CartItem.class), cart.getCartId());
			cart.setCartItems(cartItems);
		}
		return Optional.ofNullable(cart);
	}

	@Override
	public Optional<CartItem> findCartItemById(Integer itemId) {
		String sql = "select itemId, cartId, productId, quantity from cartitem where itemId = ?";
		CartItem cartItem = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(CartItem.class), itemId);
		if(cartItem != null) {
			// 根據 productId 來找到 product 並注入到 cartItem 中
			findProductById(cartItem.getProductId()).ifPresent(cartItem::setProduct);
			// 根據 cartId 來找到 cart 並注入到 cartItem 中
			//findCartById(cartItem.getCartId()).ifPresent(cartItem::setCart); // 在 CartItem 中不需要再透過 cartId 反查 cart 的實體
		}
		return Optional.ofNullable(cartItem);
	}

	@Override
	public List<Cart> findCartsByUserId(Integer userId) {
		String sql = "select cartId, userId, isCheckout, checkoutTime from cart where userId = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cart.class), userId);
	}

	@Override
	public List<Cart> findCartsbyUserIdAndCheckoutStatus(Integer userId, Boolean isCheckout) {
		String sql = "select cartId, userId, isCheckout, checkoutTime from cart where userId = ? and isCheckout = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cart.class), userId, isCheckout);
	}

	@Override
	public Optional<Cart> findNoneCheckoutCartByUserId(Integer userId) {
		String sql = "select cartId, userId, isCheckout, checkoutTime from cart where userId = ? and (isCheckout = false or isCheckout is null)";
		try {
			Cart cart = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Cart.class), userId);
			if(cart != null) {
				// 根據 userId 來找到 user 並注入到 cart 中
				findUserById(cart.getUserId()).ifPresent(cart::setUser);
				// 查詢 List<CartItem> 根據 cartId  並注入到 cart 中
				sql = "select itemId, cartId, productId, quantity from cartitem where cartId = ?";
				List<CartItem> cartItems = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CartItem.class), cart.getCartId());
				cart.setCartItems(cartItems);
			}
			return Optional.ofNullable(cart);
		} catch(EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	@Override
	public Boolean checkoutCartByUserId(Integer userId) {
		String sql = "update cart set isCheckout = true where userId = ? and (isCheckout = false or isCheckout is null)";
		return jdbcTemplate.update(sql, userId) == 1;
	}

	@Override
	public Boolean checkoutCartById(Integer cartId) {
		String sql = "update cart set isCheckout = true where cartId = ? and (isCheckout = false or isCheckout is null)";
		return jdbcTemplate.update(sql, cartId) == 1;
	}

	@Override
	public Boolean removeCartItemById(Integer cartItemId) {
		String sql = "delete from cartItem where itemId = ?";
		return jdbcTemplate.update(sql, cartItemId) == 1;
	}

	@Override
	public Boolean updateCartItemQuantity(Integer cartItemId, Integer quantity) {
		String sql = "update cartitem set quantity = ? where itemId = ?";
		return jdbcTemplate.update(sql, quantity, cartItemId) == 1;
	}

}
