package rest;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

/**
 * 會議室預訂系統(規定使用 REST/RESTful)
 * 假設您正在為一家公司開發一個會議室預訂系統。
 * 您需要實現一個控制器，該控制器可以處理會議室的
 * 1. 預訂請求
 * 2. 取消請求
 * 3. 變更預約時間
 * 4. 查詢當前預訂狀態。
 */
@WebServlet("/rest/booking/*")
public class BookingController extends HttpServlet {

}
