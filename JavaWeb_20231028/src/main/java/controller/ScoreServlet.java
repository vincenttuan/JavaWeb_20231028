package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.IntSummaryStatistics;

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
		
		
		// Model: 計算 scores 的總分, 平均, 個數, 最高分, 最低分
		IntSummaryStatistics stat = Arrays.stream(scores).mapToInt(Integer::parseInt).summaryStatistics();
		
		// View:
		out.println(Arrays.toString(scores));
		out.println("count: " + stat.getCount());
		out.println("sum: " + stat.getSum());
		out.println("avg: " + stat.getAverage());
		out.println("max: " + stat.getMax());
		out.println("min: " + stat.getMin());
	}
	
}
