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
		// Controller: 取得 url 參數
		String height = req.getParameter("h"); // 身高
		String weight = req.getParameter("w"); // 體重
		
		// Controller: 檢查參數的正確性
		String result = null;
		Double bmiValue = null;
		double h = 0, w = 0;
		try {
			h = Double.parseDouble(height); // 將字串轉 double
			w = Double.parseDouble(weight); // 將字串轉 double
			result = "OK";
		} catch (Exception e) {
			result = "Error";
		}
		
		// Model: 計算BMI
		bmiValue = w / Math.pow(h/100, 2); // bmi 計算公式
		
		// View: 呈現BMI 資料
		resp.getWriter().println("h=" + height);
		resp.getWriter().println("w=" + weight);
		resp.getWriter().println("bmi=" + bmiValue);
		resp.getWriter().println("result=" + result);
	}
	
}
