package servlet_demo;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(
		value="/deep",
		loadOnStartup = 1
	)
public class DeepServlet implements Servlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("deep servlet initialized");
		
		
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String message = "<h1>Hello Deep Servlet!!!</h1>";
		OutputStream outStream = res.getOutputStream();
		outStream.write(message.getBytes(Charset.forName("UTF-8")));
		outStream.flush();
		outStream.close();
	}

	@Override
	public String getServletInfo() {
		return "deep servlet";
	}
	
	/**
	 * chiamato solo in 
	 * undeploy del pacchetto
	 */

	@Override
	public void destroy() {
		System.out.println("deep servlet destroyed");
	}

	@Override
	public ServletConfig getServletConfig() {
		
		return new ServletConfig() {

			@Override
			public String getServletName() {
				

				System.out.println("getting servlet name...");
				return "deep-servlet";
				
			}

			@Override
			public ServletContext getServletContext() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getInitParameter(String name) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Enumeration<String> getInitParameterNames() {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
		
	}

}
