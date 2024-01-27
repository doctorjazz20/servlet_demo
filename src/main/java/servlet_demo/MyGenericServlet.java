package servlet_demo;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(
		name="GENERIC_SERVLET",
		value ="/generic",
		initParams = {
			@WebInitParam(name="_matricola", value = "54321"),
			@WebInitParam(name="_professione", value="impiegato")
		}
	)
public class MyGenericServlet extends GenericServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String message = "<h1>Hello Generic!!!</h1>";
		
		Enumeration<String> e=getServletConfig().getInitParameterNames();  
        
	    String str="";  
	    while(e.hasMoreElements()){  
		    str=e.nextElement();  
		    message+="<br>Name: "+str;  
		    message+=" value: "+getServletConfig().getInitParameter(str);  
	    }  
		
		OutputStream outStream = res.getOutputStream();
		outStream.write(message.getBytes(Charset.forName("UTF-8")));
		outStream.flush();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		
		ServletConfig config = getServletConfig();
		
		System.out.println("generic servlet initialized");
		System.out.println("name="+config.getServletName());
		System.out.println("_matricola="+config.getInitParameter("_matricola"));
		System.out.println("_professione="+config.getInitParameter("_professione"));
		
		ServletContext ctx=this.getServletContext();
		System.out.println("context path="+ctx.getContextPath());
		System.out.println("major version="+ctx.getEffectiveMajorVersion());
		System.out.println("minor version="+ctx.getEffectiveMinorVersion());
		System.out.println("server info="+ctx.getServerInfo());
		System.out.println("session timeout="+ctx.getSessionTimeout());
		
		System.out.println("PARAM1="+ctx.getInitParameter("PARAM1"));
		System.out.println("PARAM2="+ctx.getInitParameter("PARAM2"));
		System.out.println("ATTR1="+ctx.getAttribute("ATTR1"));
		System.out.println("ATTR2="+ctx.getAttribute("ATTR2"));
		
	}

}
