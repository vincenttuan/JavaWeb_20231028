package rest;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

/**
 * 會議室預訂系統(規定使用 REST/RESTful)
 * 假設您正在為一家公司開發一個會議室預訂系統。
 * 您需要實現一個控制器，該控制器可以處理會議室的
 * 1. 新增預約
 * 	  POST /rest/booking/
 *    請求:                            回應:
 *    {                               {
 *      "roomId": 3,                    "result": "OK",
 *      "name": "John",                 "bookingId": 1 
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
 *                                        "name": "John",
 *                                        "bookingDate": "2023-12-10",
 *                                        "createDate": "2023-12-09 10:29:35"
 *                                      },
 *                                      {
 *                                        "bookingId": 2,
 *                                        "roomId": 5,
 *                                        "name": "Mary",
 *                                        "bookingDate": "2023-12-11",
 *                                        "createDate": "2023-12-09 11:30:50"
 *                                      }
 *                                      ...  
 *                                    ]
 */
@WebServlet("/rest/booking/*")
public class BookingController extends HttpServlet {

}
