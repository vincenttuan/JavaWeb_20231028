package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.GuestbookService;

@WebServlet("/controller/guestbook")
public class GuestbookServlet extends HttpServlet {
	
	private GuestbookService guestbookService = new GuestbookService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 從 model 中取得最新留言紀錄
		List<Map<String, String>> records = guestbookService.getRecords();
		
		// 重導到 view
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/guestbook.jsp");
		req.setAttribute("records", records);
		rd.forward(req, resp);
		
	}
	
	
}
