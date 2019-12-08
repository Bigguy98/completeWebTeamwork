/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import com.google.gson.Gson;
import dao.CartDAO;
import dao.impl.CartDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cart;

/**
 *
 * @author vutha
 */
@WebServlet(urlPatterns = "/cart/getById")
public class GetCartServlet extends HttpServlet{
    private CartDAO cartDao;
    public GetCartServlet() {
        cartDao = new CartDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Gson gson = new Gson();
        
        Integer cartId = Integer.valueOf(req.getParameter("cartId"));
        Cart cart = cartDao.getCartById(cartId);
        
        writer.print(gson.toJson(cart));
        writer.flush();
        writer.close();
    }
   
}
