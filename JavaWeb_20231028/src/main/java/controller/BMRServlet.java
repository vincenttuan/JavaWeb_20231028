package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//設定 Servlet 參數
@WebServlet(value = {"/controller/bmr"})
public class BMRServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Controller: 取得 url 參數
		
		// Controller: 檢查參數的正確性
		
		// Model: 計算 BMR
		
		// View: 呈現 BMR 資料
		
	}
	
}
