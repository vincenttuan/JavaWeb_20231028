package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BMIService;

enum Args {
	OK, Error
}

// 設定 Servlet 參數
@WebServlet(value = {"/controller/bmi"})
public class BMIServlet extends HttpServlet {
	
	// 建立 Model 實體
	private BMIService bmiService = new BMIService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Controller: 取得 url 參數
		String height = req.getParameter("h"); // 身高
		String weight = req.getParameter("w"); // 體重
		
		// Controller: 檢查參數的正確性
		Args result = null;
		Double bmiValue = null;
		double h = 0, w = 0;
		try {
			h = Double.parseDouble(height); // 將字串轉 double
			w = Double.parseDouble(weight); // 將字串轉 double
			result = Args.OK;
		} catch (Exception e) {
			result = Args.Error;
		}
		
		// Model: 計算BMI
		if(result.equals(Args.OK)) {
			bmiValue = bmiService.calcBmi(h, w); // 透過 model 來計算 bmi
		}
		
		// View: 呈現 BMI 資料
		// 利用 Dispatcher 分派器
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/bmi_result.jsp");
		
		// 準備要送的資料
		req.setAttribute("h", h);
		req.setAttribute("w", w);
		req.setAttribute("bmiValue", bmiValue);
		req.setAttribute("result", result);
		
		// 傳送
		rd.forward(req, resp);
		
	}
	
}
