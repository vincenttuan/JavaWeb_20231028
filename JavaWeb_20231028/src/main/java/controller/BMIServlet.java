package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 設定 Servlet 參數
@WebServlet(value = {"/controller/bmi"})
public class BMIServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得 url 參數
		String height = req.getParameter("h"); // 身高
		String weight = req.getParameter("w"); // 體重
		
		resp.getWriter().println("h=" + height);
		resp.getWriter().println("w=" + weight);
	}
	
}
