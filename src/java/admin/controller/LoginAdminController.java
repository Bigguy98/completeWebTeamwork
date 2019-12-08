/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import dao.CustomerDAO;
import dao.impl.CustomerDaoImpl;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import utils.SecurityUtil;

/**
 *
 * @author QuaMin
 */
@WebServlet(urlPatterns = "/loginAdmin")
public class LoginAdminController extends  HttpServlet{
    CustomerDAO customerDAO= new CustomerDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/admin/loginAdmin.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
       String username = req.getParameter("username");
       String password = req.getParameter("password");
        System.out.println(SecurityUtil.encode(password));
        Customer customer = customerDAO.getByUserName(username);
        if(customer==null){
            resp.sendRedirect(req.getContextPath()+"/loginAdmin");
            
        }else{
            if(customer.getPassword().equals(SecurityUtil.encode(password))&&customer.getRole().equals("ADMIN")){
                HttpSession session= req.getSession();
                session.setAttribute("user", customer);
                resp.sendRedirect(req.getContextPath()+"/admin/welcome");
            }else{
                resp.sendRedirect(req.getContextPath()+"/loginAdmin");
            }
        }
    }
    
}
