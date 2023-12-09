package rest.booking.controller;

import java.io.IOException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import rest.booking.dao.BookingDao;
import rest.booking.dao.BookingDaoImpl;
import rest.booking.entity.BookingRoom;
import rest.booking.entity.Room;

/**
 * 會議室預訂系統(規定使用 REST/RESTful)
 * 假設您正在為一家公司開發一個會議室預訂系統。
 * 您需要實現一個控制器，該控制器可以處理會議室的
 * 1. 新增預約
 * 	  POST /rest/booking/
 *    請求:                            回應:
 *    {                               {
 *      "roomId": 3,                    "result": "OK",
 *      "username": "John",             "bookingId": 1 
 *      "bookingDate": "2023-12-09"   } 
 *    }
 *    
 * 2. 取消預約
 *    DELETE /rest/booking/{bookingId}
 *    DELETE /rest/booking/1
 *    請求:                            回應:
 *                                    {
 *                                      "result": "OK",
 *                                      "bookingId": 1
 *                                    }
 *    
 * 3. 變更預約時間
 *    PUT /rest/booking/{bookingId}
 *    PUT /rest/booking/1
 *    請求:                            回應:
 *    {                               {
 *      "bookingDate": "2023-12-10"     "result": "OK",
 *    }                                 "bookingId": 1
 *                                    }
 * 4. 查詢當前所有預約狀態。
 * 	  GET /rest/booking/ 
 *    請求:                            回應:
 *                                    [
 *                                      {
 *                                        "bookingId": 1,
 *                                        "roomId": 3,
 *                                        "username": "John",
 *                                        "bookingDate": "2023-12-10",
 *                                        "createDate": "2023-12-09 10:29:35",
 *                                        "room": {"roomId": 3, "roomName": "301中型會議室"}
 *                                      },
 *                                      {
 *                                        "bookingId": 2,
 *                                        "roomId": 5,
 *                                        "username": "Mary",
 *                                        "bookingDate": "2023-12-11",
 *                                        "createDate": "2023-12-09 11:30:50",
 *                                        "room": {"roomId": 5, "roomName": "501大型會議室"}
 *                                      }
 *                                      ...  
 *                                    ]
 */
@WebServlet("/rest/booking/*")
public class BookingController extends HttpServlet {
	
	private BookingDao dao = BookingDaoImpl.getInstance();
	
	// GET /rest/booking/bookingroom/
	// GET /rest/booking/bookingroom/1
	// GET /rest/booking/room/
	// GET /rest/booking/room/1
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		if(pathInfo.contains("/bookingroom")) {
			// 取得 bookingId
			String regex = "^/bookingroom/(\\d+)$";
			Integer id = getId(pathInfo, regex);
			if(id == null) {
				resp.getWriter().print(dao.findAllBookingRooms());
			} else {
				Optional<BookingRoom> bookingRoomOpt = dao.getBookingRoomById(id);
				if(bookingRoomOpt.isPresent()) {
					resp.getWriter().print(bookingRoomOpt.get());
				} else {
					resp.getWriter().print("{}");
				}
			}
			
		} else if(pathInfo.contains("/room")) {
			// 取得 roomId
			String regex = "^/room/(\\d+)$";
			Integer id = getId(pathInfo, regex);
			if(id == null) {
				resp.getWriter().print(dao.findAllRooms());
			} else {
				Optional<Room> roomOpt = dao.getRoomById(id);
				if(roomOpt.isPresent()) {
					resp.getWriter().print(roomOpt.get());
				} else {
					resp.getWriter().print("{}");
				}
			}
		}
		
		
	}
	
	// 新增 POST /rest/booking/bookingroom
	// 新增 POST /rest/booking/room
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gson gson = new Gson();
		String pathInfo = req.getPathInfo();
		switch (pathInfo) {
			case "/bookingroom":
				//resp.getWriter().print(req.getReader().lines().collect(Collectors.joining("\n")));
				String bookingRoomJsonStr = req.getReader().lines().collect(Collectors.joining("\n"));
				// json str 轉 bean
				BookingRoom bookingRoom = gson.fromJson(bookingRoomJsonStr, BookingRoom.class);
				
				try {
					int bookingId = dao.addBookingRoom(bookingRoom);
					resp.getWriter().print("{\"result\": \"OK\", \"bookingId\": " + bookingId + "}");
					
				} catch (Exception e) {
					resp.getWriter().print("{\"result\": \"Fail\", \"exception\": " + e.getMessage() + "}");
				}
				
				break;

			case "/room":
				break;
		}
	}
	
	// 修改 PUT /rest/booking/bookingroom/{bookingId}
	// 修改 PUT /rest/booking/bookingroom/1
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		int bookingId = getId(pathInfo, "^/bookingroom/(\\d+)$");
		resp.getWriter().print(bookingId);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		int bookingId = getId(pathInfo, "^/bookingroom/(\\d+)$");
		resp.getWriter().print(bookingId);
	}
	
	public Integer getId(String pathInfo, String regex) {
		/*
		 * pathInfo = /room/2
		 * regex    = /room/(\\d+)  
		 * */
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(pathInfo);
		if(matcher.find()) {
			System.out.println(matcher.group());
			System.out.println(matcher.group(1));
			
			String numberStr = matcher.group(1);
			return Integer.parseInt(numberStr);
		}
		return null;
	}
}



