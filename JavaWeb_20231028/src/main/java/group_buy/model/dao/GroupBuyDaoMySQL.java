package group_buy.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import group_buy.model.entity.Cart;
import group_buy.model.entity.CartItem;
import group_buy.model.entity.Product;
import group_buy.model.entity.User;

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
		
		//return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
		
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
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean updateUserPassword(Integer userId, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<User> findUserById(Integer userId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Product> findProductById(Integer productId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean updateProductLaunch(Integer productId, Boolean isLaunch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCart(Cart cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cart> findAllCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cart> findCartById(Integer cartId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<CartItem> findCartItemById(Integer itemId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Cart> findCartsByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> findCartsbyUserIdAndCheckoutStatus(Integer userId, Boolean isCheckout) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cart> findNoneCheckoutCartByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Boolean checkoutCartByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean checkoutCartById(Integer cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean removeCartItemById(Integer cartItemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateCartItemQuantity(Integer cartItemId, Integer quantity) {
		// TODO Auto-generated method stub
		return null;
	}

}
