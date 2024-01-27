package servlet_demo.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println("servlet context initialized");
		ServletContext ctx = sce.getServletContext();
		ctx.setInitParameter("PARAM1", "MARIO");
		ctx.setInitParameter("PARAM2", "ROSSI");
		ctx.setSessionTimeout(1);
		ctx.setAttribute("ATTR1", "ALBERTO");
		ctx.setAttribute("ATTR2", "BIANCHI");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("servlet context destroyed");
	}

}
