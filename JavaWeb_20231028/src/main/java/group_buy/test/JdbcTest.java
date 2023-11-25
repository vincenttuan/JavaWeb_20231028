package group_buy.test;

import java.util.List;
import java.util.Optional;

import group_buy.model.dao.GroupBuyDao;
import group_buy.model.dao.GroupBuyDaoMySQL;
import group_buy.model.entity.Cart;
import group_buy.model.entity.CartItem;
import group_buy.model.entity.User;

public class JdbcTest {

	public static void main(String[] args) {
		GroupBuyDao dao = GroupBuyDaoMySQL.getInstance();
		List<User> users = dao.findAllUsers();
		System.out.println(users.size());
		System.out.println(users);
		System.out.println();
		
		Optional<CartItem> cartItemOpt = dao.findCartItemById(1);
		if(cartItemOpt.isPresent()) {
			CartItem cartItem = cartItemOpt.get();
			System.out.println(cartItem);
		} else {
			System.out.println("無此 cartitem 資料");
		}
		System.out.println();
		
		Optional<Cart> cartOpt = dao.findCartById(201);
		if(cartOpt.isPresent()) {
			Cart cart = cartOpt.get();
			System.out.println(cart);
		} else {
			System.out.println("無此 cart 資料");
		}
		
	}

}
