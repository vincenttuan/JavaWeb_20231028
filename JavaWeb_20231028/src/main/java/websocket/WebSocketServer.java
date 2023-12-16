package websocket;

import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket_server")
public class WebSocketServer {
	
	// 用來存放已連接的客戶端 Socket Session 資訊
	private static CopyOnWriteArrayList<Session> sessions = new CopyOnWriteArrayList<>();
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("Client 已連線, session id: " + session.getId());
		sessions.add(session);
		System.out.println("目前連線數量: " + sessions.size());
	}
	
	@OnClose
	public void Close(Session session) {
		System.out.println("Client 已離線, session id: " + session.getId());
		sessions.remove(session);
		System.out.println("目前連線數量: " + sessions.size());
	}
	
	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.printf("Client 發送訊息, message: %s 來自 session id: %s%n", message, session.getId());
		
		// 進行廣播
		sessions.forEach(s -> {  // s 指的就是 session
			if(s.isOpen()) {
				s.getAsyncRemote().sendText(message);
			}
		});
	}
	
}
