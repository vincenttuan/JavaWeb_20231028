package group_buy.model.entity;

// 團購商品
public class Product {
	private Integer id; // 編號
	private String name; // 品名
	private Integer price; // 價格
	private String unit; // 單位
	private Boolean isLaunch; // 是否上架
	
	public Product() {
		
	}
	
	public Product(Integer id, String name, Integer price, String unit, Boolean isLaunch) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.unit = unit;
		this.isLaunch = isLaunch;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Boolean getIsLaunch() {
		return isLaunch;
	}
	public void setIsLaunch(Boolean isLaunch) {
		this.isLaunch = isLaunch;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", unit=" + unit + ", isLaunch=" + isLaunch
				+ "]";
	}
	
	
	
}
