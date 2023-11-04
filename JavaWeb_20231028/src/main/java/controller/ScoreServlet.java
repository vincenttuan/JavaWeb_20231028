package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ScoreService;

//@WebServlet(value = {"/controller/score", "/controller/score_list", "/controller/scores"})
@WebServlet("/controller/score")
public class ScoreServlet extends HttpServlet {
	
	private ScoreService scoreService = new ScoreService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
				
		// Controller: 取得多筆 score 參數資料
		String[] scores = req.getParameterValues("score");
		
		// 驗證參數
		if(scores == null) {
			out.println("No score !");
			return; // 方法結束
		}
		
		// Model: 計算 scores 的 總分, 平均, 個數, 最高分, 最低分
		Map<String, Number> scoreMap = scoreService.getScoreMap(scores);
		
		// View:
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/score_result.jsp"); // EL + JSTL 版
		//RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/score_result2.jsp"); // 傳統 jsp 版
		req.setAttribute("scores", scores);
		req.setAttribute("scoreMap", scoreMap);
		rd.forward(req, resp);
	}
	
}
