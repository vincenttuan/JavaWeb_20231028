package model.guestbook.service;

import java.util.List;

import model.guestbook.dao.GuestbookDao;
import model.guestbook.entity.Guestbook;
import model.guestbook.entity.PageInfo;

public class GuestbookService {
	
	private GuestbookDao dao = GuestbookDao.getGuestbookDao();
	
	public List<Guestbook> queryAllGuestbooks() {
		// 跟 dao 索要所有的留言紀錄
		return dao.findAllGuestbooks();
	}
	
	public PageInfo getPageInfo() {
		return dao.getGuestbookPageInfo();
	}
	
}
