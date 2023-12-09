package rest.booking.dao;

import java.util.List;
import java.util.Optional;

import rest.booking.entity.BookingRoom;
import rest.booking.entity.Room;

public interface BookingDao {
	
	int addBookingRoom(BookingRoom bookingRoom); // 新增預約
	
	int cancelBookingRoomById(Integer bookingId); // 取消預約
	
	int updateBookingRoomDateById(Integer bookingId, String newBookingDate); // 變更預約時間
	
	List<BookingRoom> findAllBookingRooms(); // 查詢當前所有預約狀態
	
	Optional<BookingRoom> getBookingRoomById(Integer bookingId); // 取得單筆預約狀態
	
	List<Room> findAllRooms(); // 查詢所有會議室
	
	Optional<Room> getRoomById(Integer roomId); // 取得單筆會議室
	
}
