package model;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.Map;

public class ScoreService {
	
	public Map<String, Number> getScoreMap(String[] scores) {
		IntSummaryStatistics stat = Arrays.stream(scores).mapToInt(Integer::parseInt).summaryStatistics();
		// 將 總分, 平均, 個數, 最高分, 最低分 放到一個 Map 集合中
		Map<String, Number> scoreMap = new LinkedHashMap<>();
		scoreMap.put("count", stat.getCount());
		scoreMap.put("sum", stat.getSum());
		scoreMap.put("avg", stat.getAverage());
		scoreMap.put("max", stat.getMax());
		scoreMap.put("min", stat.getMin());
		return scoreMap;
	}
	
}
