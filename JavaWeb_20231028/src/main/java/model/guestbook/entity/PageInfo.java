package model.guestbook.entity;

public class PageInfo {
	private Integer recordsOfPage; // 每頁的筆數
	private Integer count; // 總共資料筆數
	private Integer maxPage; // 最大頁數
	
	public Integer getRecordsOfPage() {
		return recordsOfPage;
	}
	public void setRecordsOfPage(Integer recordsOfPage) {
		this.recordsOfPage = recordsOfPage;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}
	
	
	
}
