package model.guestbook.entity;

import java.sql.Timestamp;

// entity: 對應 guestbook 資料表的紀錄
public class Guestbook {
	
	private Integer id;
	private String username;
	private String message;
	private Timestamp createtime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	
	@Override
	public String toString() {
		return "Guestbook [id=" + id + ", username=" + username + ", message=" + message + ", createtime=" + createtime
				+ "]";
	}
	
	
}
