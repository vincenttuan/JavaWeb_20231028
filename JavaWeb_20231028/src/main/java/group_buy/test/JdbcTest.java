package group_buy.test;

import java.util.List;

import group_buy.model.dao.GroupBuyDao;
import group_buy.model.dao.GroupBuyDaoMySQL;
import group_buy.model.entity.User;

public class JdbcTest {

	public static void main(String[] args) {
		GroupBuyDao dao = GroupBuyDaoMySQL.getInstance();
		List<User> users = dao.findAllUsers();
		System.out.println(users.size());
		System.out.println(users);
	}

}
