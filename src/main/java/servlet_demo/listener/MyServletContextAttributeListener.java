package servlet_demo.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextAttributeListener implements ServletContextAttributeListener{
	
	/**
	 * TODO: finire test
	 */

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("added to context parameter with name="+event.getName()+" value="+event.getValue()+" to context path="+event.getServletContext().getContextPath());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("removed to context parameter with name="+event.getName()+" value="+event.getValue()+" to context path="+event.getServletContext().getContextPath());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("replaced to context parameter with name="+event.getName()+" value="+event.getValue()+" to context path="+event.getServletContext().getContextPath());
	}

}
