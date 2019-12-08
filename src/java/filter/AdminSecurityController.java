/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;


import java.io.IOException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
/**
 *
 * @author QuaMin
 */
//@WebFilter(urlPatterns = "/admin/*")
public class AdminSecurityController implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		// SU DUNG SESSION DE CHECK LOGIN VA LOGOUT
		HttpSession session = req.getSession();

		Object obj = session.getAttribute("user");
		// get theo name set o logincontroller

		if (obj == null) {
			// da bi het thoi gian, logout
			resp.sendRedirect(req.getContextPath() + "/loginAdmin");
			return;
		} else {
			// van dang login
			Customer p = (Customer) obj;// ep xuong thang con de lay thong tin
			System.out.println(p.getName());

			if (p.getRole().equals("ADMIN")) {
				chain.doFilter(request, response);
			} else {
				// hien thi 1 trang access deny
				resp.sendRedirect(req.getContextPath() + "/loginAdmin");
                            
			}
		}
    }

    @Override
    public void destroy() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

  
    
}
