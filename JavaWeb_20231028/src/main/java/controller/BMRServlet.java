package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BMRService;

enum BMRArgs {
	OK, Error
}

//設定 Servlet 參數
@WebServlet(value = {"/controller/bmr"})
public class BMRServlet extends HttpServlet {
	
	private BMRService bmrService = new BMRService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Controller: 取得 url 參數
		String height = req.getParameter("h");
		String weight = req.getParameter("w");
		String ageStr = req.getParameter("age");
		
		// Controller: 檢查參數的正確性
		Double h = null, w = null, manBMR = null, femaleBMR = null;
		Integer age = null;
		BMRArgs result = null;
		String manDiagnosis = null, femaleDiagnosis = null;
		
		try {
			h = Double.parseDouble(height);
			w = Double.parseDouble(weight);
			age = Integer.parseInt(ageStr);
			result = BMRArgs.OK;
		} catch (Exception e) {
			result = BMRArgs.Error;
		}
		
		// Model: 計算 BMR 與 診斷
		if(result.equals(BMRArgs.OK)) {
			// 計算 BMR
			manBMR = bmrService.calcBmr(h, w, age, "man");
			femaleBMR = bmrService.calcBmr(h, w, age, "female");
			// BMR 診斷
			manDiagnosis = bmrService.getDiagnosis(manBMR, "man");
			femaleDiagnosis = bmrService.getDiagnosis(femaleBMR, "female");
		}
		
		// View: 呈現 BMR 資料
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/bmr_result.jsp");
		// 準備要送的資料
		req.setAttribute("h", h);
		req.setAttribute("w", w);
		req.setAttribute("age", age);
		req.setAttribute("result", result);
		req.setAttribute("manBMR", manBMR);
		req.setAttribute("manDiagnosis", manDiagnosis);
		req.setAttribute("femaleBMR", femaleBMR);
		req.setAttribute("femaleDiagnosis", femaleDiagnosis);
		// 傳送到 view
		rd.forward(req, resp);
	}
	
}
