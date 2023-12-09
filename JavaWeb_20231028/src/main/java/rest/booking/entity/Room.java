package rest.booking.entity;

import com.google.gson.Gson;

public class Room {
	private Integer roomId;
	private String roomName;
	
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
