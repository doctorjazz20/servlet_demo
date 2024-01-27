package servlet_demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
		name="SESSSION_SERVLET",
		value ="/session"
	)
public class SessionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
        if (session == null) {
        	
            System.out.println("-- creating new session in the servlet --");
            
            session = request.getSession(true);
            session.setMaxInactiveInterval(10);
            
            System.out.println("-- session created in the servlet --");
            
        }
        
        if(session!=null) {
        	
        	session.setAttribute("ses_par_1", "ses_val_1");
        	session.setAttribute("ses_par_2", "ses_val_2");
        	session.setAttribute("ses_par_3", "ses_val_3");
        	
        	session.setAttribute("ses_par_3", null);
        	session.setAttribute("ses_par_2", "*ses_val_2");
        	
        }
		
		response
			.getWriter()
			.append("<h1>Session Servlet!!</h1><br> Served at: ")
			.append(request.getContextPath());
		
	}

}
