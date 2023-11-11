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
import model.guestbook.entity.PageInfo;
import model.guestbook.service.GuestbookService;

@WebServlet(value = "/controller/guestbook/guestbook")
public class GuestbookServlet extends HttpServlet {
	private GuestbookService service = new GuestbookService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageNo = req.getParameter("pageNo");
		String recordsOfPage = req.getParameter("recordsOfPage");
		
		// 取得所有留言紀錄
		//List<Guestbook> guestbooks = service.queryAllGuestbooks();
		
		// 取得所有留言紀錄(分頁板)
		List<Guestbook> guestbooks = service.queryAllGuestbooksByPage(pageNo, recordsOfPage);
		
		// 取得分頁資訊
		PageInfo pageInfo = service.getPageInfo();
		
		// 重導到 /WEB-INF/view/guestbook/guestbook.jsp
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/guestbook/guestbook.jsp");
		req.setAttribute("pageInfo", pageInfo);
		req.setAttribute("guestbooks", guestbooks);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String message = req.getParameter("message");
		
		int rowcount = service.addGuestbook(username, message);
		
		// 轉址到 /controller/guestbook/guestbook
		resp.sendRedirect("/controller/guestbook/guestbook");
		
	}
	
}
