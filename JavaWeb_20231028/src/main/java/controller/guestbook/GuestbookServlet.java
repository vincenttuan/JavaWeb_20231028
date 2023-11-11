package controller.guestbook;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.guestbook.entity.Guestbook;
import model.guestbook.service.GuestbookService;

@WebServlet(value = "/controller/guestbook/guestbook")
public class GuestbookServlet extends HttpServlet {
	private GuestbookService service = new GuestbookService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得所有留言紀錄
		List<Guestbook> guestbooks = service.queryAllGuestbooks();
		
		// 重導到 /WEB-INF/view/guestbook/guestbook.jsp
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/guestbook/guestbook.jsp");
		req.setAttribute("guestbooks", guestbooks);
		rd.forward(req, resp);
	}
	
	
}
