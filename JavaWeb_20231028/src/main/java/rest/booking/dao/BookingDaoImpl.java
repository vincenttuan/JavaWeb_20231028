package rest.booking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.simpleflatmapper.jdbc.JdbcMapper;
import org.simpleflatmapper.jdbc.JdbcMapperFactory;
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.simpleflatmapper.reflect.asm.GetterBuilder;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

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
		//String sql = "select bookingId, roomId, username, bookingDate, createDate from BookingRoom";
		//return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BookingRoom.class));
		
		String sql = "select "
				+ "bookingroom.bookingId, bookingroom.roomId, bookingroom.username, bookingroom.bookingDate, bookingroom.createDate, "
				+ "room.roomId as room_roomId, room.roomName as room_roomName "
				+ "from BookingRoom "
				+ "left join Room on bookingroom.roomId = room.roomId";
		
		ResultSetExtractor<List<BookingRoom>> resultSetExtractor = JdbcTemplateMapperFactory.newInstance()
							.addKeys("roomId")
							.newResultSetExtractor(BookingRoom.class);
		
		List<BookingRoom> bookingRooms = jdbcTemplate.query(sql, resultSetExtractor);
		
		return bookingRooms;
	}

	@Override
	public Optional<BookingRoom> getBookingRoomById(Integer bookingId) {
		String sql = "select bookingId, roomId, username, bookingDate, createDate from BookingRoom where bookingId = ?";
		BookingRoom bookingRoom = null;
		try {
			bookingRoom = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BookingRoom.class), bookingId);
			Optional<Room> roomOpt = getRoomById(bookingRoom.getRoomId());
			if(roomOpt.isPresent()) {
				bookingRoom.setRoom(roomOpt.get()); // 注入 room 物件
			}
		} catch (Exception e) {
			
		}
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
		Room room = null;
		try {
			room = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Room.class), roomId);
		} catch (Exception e) {
		}
		return Optional.ofNullable(room);
		
	}
	
	public static void main(String[] args) {
		String jsonString = BookingDaoImpl.getInstance().findAllBookingRooms().toString();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String formatedJson = gson.toJson(JsonParser.parseString(jsonString));
		System.out.println(formatedJson);
	}

}
