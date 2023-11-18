package group_buy.model.entity;

// 使用者
public class User {
	private String username;
	private String password;
	private Integer level; // 0: 訪客, 1: 後台人員
	
	public User() {
		
	}
	
	public User(String username, String password, Integer level) {
		this.username = username;
		this.password = password;
		this.level = level;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	
	
}
