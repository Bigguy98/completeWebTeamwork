/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import dao.CartDAO;
import dao.ItemDAO;
import dao.impl.CartDaoImpl;
import dao.impl.ItemDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CartItem;
import model.Item;

/**
 *
 * @author vutha
 */
@WebServlet(urlPatterns = "/cart/addItem")
public class AddItemToCartServlet extends HttpServlet{
    private ItemDAO itemDao;
    private CartDAO cartDao;
    public AddItemToCartServlet() {
        itemDao = new ItemDaoImpl();
        cartDao = new CartDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer itemId = Integer.valueOf(req.getParameter("itemId"));
        Integer cartId = Integer.valueOf(req.getParameter("cartId"));
        Integer number = Integer.valueOf(req.getParameter("number"));
        
        
        if(itemId != null && number != null) {
            Item item = itemDao.getItemById(itemId);
            CartItem cartItem = new CartItem(item, number);
            
            cartDao.createCartItem(cartItem, cartId);
        }
    }
    
    
    
}
