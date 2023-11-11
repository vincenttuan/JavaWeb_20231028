package model.guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;

// 與資料庫進行 CRUD
// 利用 SingleTon 設計模式
public class GuestbookDao {
	
	private Connection conn;
	
	private GuestbookDao() {
		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String username = "root";
		String password = "12345678";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 建立 MySQL Driver 物件
			conn = DriverManager.getConnection(dbUrl, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
