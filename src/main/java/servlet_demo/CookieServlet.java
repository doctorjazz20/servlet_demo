package servlet_demo;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name="COOKIE_SERVLET",
		value ="/cookie"
	)
public class CookieServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private Cookie getCookieByName(String name, Cookie[] cookies) {
		
		if(cookies==null || cookies.length == 0) {
			return null;
		}else {
			
			for(int index=0; index<cookies.length; index++) {
				if(cookies[index].getName().equals(name)) {
					return cookies[index];
				}
			}
			
			return null;
		}
		
	}
       
    public CookieServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		Cookie nameCookie = getCookieByName("uname", cookies);
		
		System.out.println("new request incoming ...");
		if(cookies!=null) {
			for(int index=0; index<cookies.length; index++) {
				System.out.println("NAME="+cookies[index].getName()+" VALUE="+cookies[index].getValue()+" PATH="+cookies[index].getPath()+" EXP="+cookies[index].getMaxAge());
			}
		}else {
			System.out.println("no cookies!!!");
		}
		
		if(nameCookie==null) {
			
			StringBuilder formBuilder = new StringBuilder();
			formBuilder.append("<form action=\"cookie\" method=\"post\"> ");
			formBuilder.append("Name:<input type=\"text\" name=\"userName\"/><br/>");
			formBuilder.append("<input type=\"submit\" value=\"go\"/>");
			formBuilder.append("</form>");
			String form = formBuilder.toString();
			
			response.setContentType("text/html");  
			OutputStream outStream = response.getOutputStream(); 
			outStream.write(form.getBytes(Charset.forName("UTF-8")));
			outStream.flush();
			outStream.close();
			
		}else {
			
			Cookie cookie = getCookieByName("uname", cookies);
			response.setContentType("text/html");  
			OutputStream outStream = response.getOutputStream(); 
			          
			String name= cookie.getValue();
			outStream.write(("Welcome "+name).getBytes(Charset.forName("UTF-8"))); 
			outStream.flush();
			outStream.close();
			 			
		}
		
		response.flushBuffer();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				  
		String name=request.getParameter("userName");   
		
		Cookie cookie=new Cookie("uname",name);
		response.addCookie(cookie);
		
		OutputStream outStream = response.getOutputStream();
		outStream.write(("Welcome "+name).getBytes(Charset.forName("UTF-8"))); 
		outStream.flush();
		outStream.close();
		response.flushBuffer();
		
	}

}
