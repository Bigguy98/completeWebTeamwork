/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import dao.CartDAO;
import dao.impl.CartDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vutha
 */
@WebServlet(urlPatterns = "/cart/update")
public class UpdateCartItemServlet extends HttpServlet{
    private CartDAO cartDao;
    public UpdateCartItemServlet() {
        cartDao = new CartDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer cartId = Integer.valueOf(req.getParameter("cartId"));
        Integer itemId = Integer.valueOf(req.getParameter("itemId"));
        Integer number = Integer.valueOf(req.getParameter("number"));
        
        if(number == 0) cartDao.delete(cartId, itemId);
        cartDao.updateCartItem(cartId, itemId, number);
        
        
    }
    
    
    
    
}
