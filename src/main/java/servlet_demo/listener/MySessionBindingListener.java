package servlet_demo.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MySessionBindingListener implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("bounded parameter with name="+event.getName()+" value="+event.getValue()+" to session with id="+event.getSession().getId());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("removed parameter with name="+event.getName()+" value="+event.getValue()+" to session with id="+event.getSession().getId());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("replaced parameter with name="+event.getName()+" value="+event.getValue()+" to session with id="+event.getSession().getId());
	}

}
