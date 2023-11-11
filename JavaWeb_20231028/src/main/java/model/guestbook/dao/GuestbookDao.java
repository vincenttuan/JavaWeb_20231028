package model.guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.annotation.Resource;
import model.guestbook.entity.Guestbook;
import model.guestbook.entity.PageInfo;

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
			// 透過 JNDI 來查找資源
			InitialContext ctx = new InitialContext();
			
			//DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/demo");
			
			Context envContext = (Context)ctx.lookup("java:comp/env");   // 取得環境
			DataSource ds = (DataSource)envContext.lookup("jdbc/demo");  // 透過環境取得資源
			
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
	
	// 取得分頁資料
	public PageInfo getGuestbookPageInfo() {
		if(conn == null) {
			setConn();
			if(conn == null) {
				return null;
			}
		}
		String sql = "select records_of_page, count, max_page from guestbook_page_info";
		PageInfo pageInfo = new PageInfo();
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)) {
			
			if(rs.next()) { // 若資料只有一筆可以直接使用 if
				pageInfo.setRecordsOfPage(rs.getInt("records_of_page"));
				pageInfo.setCount(rs.getInt("count"));
				pageInfo.setMaxPage(rs.getInt("max_page"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageInfo;
	}
	
	// 分頁查詢
	public List<Guestbook> findAllGuestbooksByPage(int limit, int offset) {
		if(conn == null) {
			setConn();
			if(conn == null) {
				return null;
			}
		}
		String sql = "select id, username, message, createtime from guestbook order by id limit ? offset ?";
		List<Guestbook> guestbooks = new ArrayList<>();
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, limit);
			pstmt.setInt(2, offset);
			
			try(ResultSet rs = pstmt.executeQuery()) {
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
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return guestbooks;
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
