/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import com.google.gson.Gson;
import dao.CartDAO;
import dao.impl.CartDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CartItem;

/**
 *
 * @author QuaMin
 */
@WebServlet(urlPatterns = "/admin/getItemByCart")
public class GetItemByCartController extends HttpServlet{
    CartDAO cartDAO = new CartDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idCart = Integer.parseInt(req.getParameter("idCart"));
        List<CartItem> cartItems= cartDAO.getCartItems(idCart);
        
        PrintWriter printWriter = resp.getWriter();
        Gson gson = new Gson();
        printWriter.print(gson.toJson(cartItems));
        printWriter.flush();
        printWriter.close();
    }
    
}
