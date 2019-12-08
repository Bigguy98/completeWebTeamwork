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

/**
 *
 * @author QuaMin
 */
@WebServlet(urlPatterns = "/admin/listPerson")
public class ListPersonController extends HttpServlet{

    public ListPersonController() {
    }
    
    
    
    CustomerDAO customerDAO =new CustomerDaoImpl();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
       
       
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/admin/listPerson.jsp");
        
        requestDispatcher.forward(req,resp);
    }
    
}
