/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import dao.CartDAO;
import dao.CustomerDAO;
import dao.impl.CartDaoImpl;
import dao.impl.CustomerDaoImpl;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cart;
import model.Customer;

/**
 *
 * @author vutha
 */
@WebServlet(urlPatterns = "/cart/create")
public class CreateCartServlet extends HttpServlet{

    private CartDAO cartDao;
    private CustomerDAO customerDao;
    public CreateCartServlet() {
        cartDao = new CartDaoImpl();
        customerDao = new CustomerDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Integer customerId = Integer.valueOf(req.getParameter("customerId"));
        Customer customer = customerDao.getCustomer(customerId);
        Cart cart = new Cart(customer, new Date(System.currentTimeMillis()));
        int nextId = cartDao.create(cart);
    }
    
    
    
    
    
}
