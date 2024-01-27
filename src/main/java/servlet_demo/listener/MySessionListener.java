package servlet_demo.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MySessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		
		System.out.println("[L] session created with id="+sessionEvent.getSession().getId());
		System.out.println("[L] is this session new: "+sessionEvent.getSession().isNew());
		System.out.println("[L] this session has max inactive interval: "+sessionEvent.getSession().getMaxInactiveInterval());
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		
		HttpSession session = sessionEvent.getSession();
		System.out.println("[L] is the destroyed session null? "+sessionEvent.getSession()==null);
		if(session!=null) {
			System.out.println("[L] session destroyed with id="+sessionEvent.getSession().getId());
		}
	}

}
