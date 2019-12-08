/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import dao.CustomerDAO;
import dao.impl.CustomerDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import utils.SecurityUtil;

/**
 *
 * @author QuaMin
 */
@WebServlet(urlPatterns = "/admin/addPerson")
public class AddPersonController extends HttpServlet{
    
    CustomerDAO customerDAO = new CustomerDaoImpl();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        RequestDispatcher requestDispatcher =req.getRequestDispatcher("/view/admin/addPerson.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
        String name =req.getParameter("name");
        String age = req.getParameter("age");
        String address = req.getParameter("address");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role =req.getParameter("role");
        Customer customer = new Customer(name, Integer.parseInt(age), address, username, SecurityUtil.encode(password),role);
        customerDAO.create(customer);
        
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(customer);
        printWriter.flush();
        printWriter.close();
        
    }
    
            
}
