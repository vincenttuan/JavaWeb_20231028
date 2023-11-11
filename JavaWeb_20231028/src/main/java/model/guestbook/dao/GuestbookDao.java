package model.guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.annotation.Resource;
import model.guestbook.entity.Guestbook;

// 與資料庫進行 CRUD
// 利用 SingleTon 設計模式
public class GuestbookDao {
	
	private Connection conn;
	
	// SingleTon 設計模式 -----------------------------------------------------------------------
	private static GuestbookDao guestbookDao = new GuestbookDao(); // 自己建立 guestbookDao 物件
	
	private GuestbookDao() { // 禁止其他程式自行建立 guestbookDao 物件
		setConn();
	}
	
	public static GuestbookDao getGuestbookDao() { // 提供一個公開的類別方法讓其他程式得到 guestbookDao 物件
		return guestbookDao;
	}
	// ----------------------------------------------------------------------------------------
	
	// 連線設定
	private void setConn() {
		try {
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/demo");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String username = "root";
		String password = "12345678";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 建立 MySQL Driver 物件
			conn = DriverManager.getConnection(dbUrl, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}
	
	public List<Guestbook> findAllGuestbooks() {
		if(conn == null) {
			setConn();
			if(conn == null) {
				return null;
			}
		}
		String sql = "select id, username, message, createtime from guestbook order by id";
		List<Guestbook> guestbooks = new ArrayList<>();
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)) {
			// 將每一筆紀錄讀出並注入到指定物件中
			while (rs.next()) {
				Guestbook guestbook = new Guestbook();
				guestbook.setId(rs.getInt("id"));
				guestbook.setUsername(rs.getString("username"));
				guestbook.setMessage(rs.getString("message"));
				guestbook.setCreatetime(rs.getTimestamp("createtime"));
				// 加入到集合中
				guestbooks.add(guestbook);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return guestbooks;
	}
	
}
