package rest.booking.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import rest.booking.entity.BookingRoom;
import rest.booking.entity.Room;

public class BookingDaoImpl implements BookingDao {
	
	private static BookingDao _instance = new BookingDaoImpl();
	
	private JdbcTemplate jdbcTemplate;
	
	private BookingDaoImpl() {
		String dbURL = "jdbc:mysql://localhost:3306/booking?serverTimezone=Asia/Taipei";
		String username = "root";
		String password = "12345678";
		
		// 創建 DriverManagerDataSource
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); // MySQL 驅動
		dataSource.setUrl(dbURL);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		// 設定 JdbcTemplate 的數據源
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public static BookingDao getInstance() {
		return _instance;
	}
	
	@Override
	public int addBookingRoom(BookingRoom bookingRoom) {
		String sql = "insert BookingRoom(roomId, username, bookingDate) values(?, ?, ?)";
		return jdbcTemplate.update(sql, bookingRoom.getRoomId(), bookingRoom.getUsername(), bookingRoom.getBookingDate());
	}

	@Override
	public int cancelBookingRoomById(Integer bookingId) {
		String sql = "delete from BookingRoom where bookingId = ?";
		return jdbcTemplate.update(sql, bookingId);
	}

	@Override
	public int updateBookingRoomDateById(Integer bookingId, String newBookingDate) {
		String sql = "update BookingRoom set bookingDate = ? where bookingId = ?";
		return jdbcTemplate.update(sql, newBookingDate, bookingId);
	}

	@Override
	public List<BookingRoom> findAllBookingRooms() {
		String sql = "select bookingId, roomId, username, bookingDate, createDate from BookingRoom";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BookingRoom.class));
	}

	@Override
	public Optional<BookingRoom> getBookingRoomById(Integer bookingId) {
		String sql = "select bookingId, roomId, username, bookingDate, createDate from BookingRoom where bookingId = ?";
		BookingRoom bookingRoom = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BookingRoom.class), bookingId);
		return Optional.ofNullable(bookingRoom);
	}

	@Override
	public List<Room> findAllRooms() {
		String sql = "select roomId, roomName from Room";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Room.class));
	}

	@Override
	public Optional<Room> getRoomById(Integer roomId) {
		String sql = "select roomId, roomName from Room where roomId = ?";
		Room room = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Room.class), roomId);
		return Optional.ofNullable(room);
	}

}
