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
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = "/cart/getByCustomerId")
public class GetCartIDServlet extends HttpServlet{
    
    private CustomerDAO customerDAO;
    private CartDAO cartDAO;
    public GetCartIDServlet() {
        customerDAO = new CustomerDaoImpl();
        cartDAO = new CartDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Integer cartID;
        
        Integer customerId = Integer.valueOf(req.getParameter("customerId"));
        Cart cart = cartDAO.getCartByUserId(customerId);
        if(cart == null || cart.getId() == null) {
            Customer customer = customerDAO.getCustomer(customerId);
            Cart nCart = new Cart(customer, new Date(System.currentTimeMillis()));
            cartID = cartDAO.create(nCart);            
        }
        else cartID = cart.getId();
        
        writer.print(cartID);
        writer.flush();
        writer.close();
    }

    
    
    
}
