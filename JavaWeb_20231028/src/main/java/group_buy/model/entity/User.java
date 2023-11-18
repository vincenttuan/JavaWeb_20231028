package group_buy.model.entity;

// 使用者
public class User {
	private Integer id; // id
	private String username;
	private String password;
	private Integer level; // 1: 訪客, 2: 後台人員
	
	public User() {
		
	}

	public User(Integer id, String username, String password, Integer level) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.level = level;
	}

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

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", level=" + level + "]";
	}
	
	
}
