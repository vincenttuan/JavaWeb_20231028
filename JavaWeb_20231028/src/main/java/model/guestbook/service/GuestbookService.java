package model.guestbook.service;

import java.util.List;

import model.guestbook.dao.GuestbookDao;
import model.guestbook.entity.Guestbook;
import model.guestbook.entity.PageInfo;

public class GuestbookService {
	
	private GuestbookDao dao = GuestbookDao.getGuestbookDao();
	
	// 分頁查詢
	public List<Guestbook> queryAllGuestbooksByPage(String pageNo, String recordsOfPage) {
		// 若沒有 pageNo 或 recordsOfPage 就當成是第一頁
		if(pageNo == null || recordsOfPage == null) {
			pageNo = "1";
			recordsOfPage = "10";
		}
		
		int intPageNo = Integer.parseInt(pageNo);
		int limit = Integer.parseInt(recordsOfPage); // 10
		int offset = (intPageNo - 1) * limit; 
		
		List<Guestbook> guestbooks = dao.findAllGuestbooksByPage(limit, offset);
		return guestbooks;
	}
	
	// 全部查詢(不分頁)
	public List<Guestbook> queryAllGuestbooks() {
		// 跟 dao 索要所有的留言紀錄
		return dao.findAllGuestbooks();
	}
	
	public PageInfo getPageInfo() {
		return dao.getGuestbookPageInfo();
	}
	
}
