package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class GuestbookService {
	
	// 留言資料集合
	private static List<Map<String, String>> records = new CopyOnWriteArrayList<>();
	
	// 設定預設留言紀錄
	static {
		// 預設第一筆留言資料
		Map<String, String> record1 = new LinkedHashMap<>();
		record1.put("name", "Helen");
		record1.put("message", "Hello !");
		record1.put("datetime", "2023-11-04 09:00:01");
		
		// 預設第二筆留言資料
		Map<String, String> record2 = new LinkedHashMap<>();
		record1.put("name", "Mary");
		record1.put("message", "哈囉 !");
		record1.put("datetime", "2023-11-04 10:02:03");
		
		records.add(record1);
		records.add(record2);
	}
	
	// 取得最新留言紀錄
	public List<Map<String, String>> getRecords() {
		return records;
	}
	
	// 加入留言紀錄
	public void addRecord(String name, String message) {
		Map<String, String> record = new LinkedHashMap<>();
		record.put("name", name);
		record.put("message", message);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
		String datetime = sdf.format(new Date()); // 將現在時間格式化
		record.put("datetime", datetime);
		
		records.add(record);
	}
	
}
