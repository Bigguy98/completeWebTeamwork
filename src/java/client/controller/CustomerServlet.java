/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import com.google.gson.Gson;
import dao.CustomerDAO;
import dao.impl.CustomerDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;

/**
 *
 * @author vutha
 */
@WebServlet(urlPatterns = "/customer/getAll")
public class CustomerServlet extends HttpServlet{
    
    private CustomerDAO customerDAO;

    public CustomerServlet() {
        customerDAO = new CustomerDaoImpl();
    }
    
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        
        PrintWriter writer = resp.getWriter();
        List<Customer> customers = customerDAO.getAll();
       
        writer.print(gson.toJson(customers));
        writer.flush();
        writer.close();
    }
    
    
    
}
