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
@WebServlet (urlPatterns = "/admin/editPerson")
public class EditPersonController extends HttpServlet{
    CustomerDAO customerDAO = new CustomerDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        String id = req.getParameter("idPerson");
        req.setAttribute("idPerson", Integer.parseInt(id));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/admin/editPerson.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
             
        String id = req.getParameter("id");
        System.out.println(id);
        String name = req.getParameter("name");
        System.out.println(name);
        String age = req.getParameter("age");
        System.out.println(age);
        String address = req.getParameter("address");
        System.out.println(address);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        Customer customer = customerDAO.getCustomer(Integer.parseInt(id));
        Customer customer1 ;
        if(customer.getPassword().equals(password)){
            customer1 = new Customer(Integer.parseInt(id), name, Integer.parseInt(age), address, username, password);
            customerDAO.edit(customer1);
        }else{
            customer1 = new Customer(Integer.parseInt(id), name, Integer.parseInt(age), address, username,SecurityUtil.encode(password));
            customerDAO.edit(customer1);
        }
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(customer1);
        printWriter.flush();
        printWriter.close();
    }
    
    
    
}
