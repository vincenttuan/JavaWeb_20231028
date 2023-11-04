package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet(value = {"/controller/score", "/controller/score_list", "/controller/scores"})
@WebServlet("/controller/score")
public class ScoreServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
				
		// Controller: 取得多筆 score 參數資料
		String[] scores = req.getParameterValues("score");
		
		if(scores == null) {
			out.println("No score !");
			return;
		}
		
		// Model: 計算 scores 的 總分, 平均, 個數, 最高分, 最低分
		IntSummaryStatistics stat = Arrays.stream(scores).mapToInt(Integer::parseInt).summaryStatistics();
		// 將 總分, 平均, 個數, 最高分, 最低分 放到一個 Map 集合中
		Map<String, Number> scoreMap = new LinkedHashMap<>();
		scoreMap.put("count", stat.getCount());
		scoreMap.put("sum", stat.getSum());
		scoreMap.put("avg", stat.getAverage());
		scoreMap.put("max", stat.getMax());
		scoreMap.put("min", stat.getMin());
		
		// View:
		out.println("scores: " + Arrays.toString(scores));
		// 從 scoreMap 中取得所要的資訊
		out.println("count: " + scoreMap.get("count"));
		out.println("sum: " + scoreMap.get("sum"));
		out.println("avg: " + scoreMap.get("avg"));
		out.println("max: " + scoreMap.get("max"));
		out.println("min: " + scoreMap.get("min"));
		
	}
	
}
