package rest.booking.entity;

import java.sql.Timestamp;

public class BookingRoom {
	private Integer bookingId;
	private Integer roomId;
	private String username;
	private String bookingDate;
	private Timestamp createTime;
	
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "BookingRoom [bookingId=" + bookingId + ", roomId=" + roomId + ", username=" + username
				+ ", bookingDate=" + bookingDate + ", createTime=" + createTime + "]";
	}
	
	
}
