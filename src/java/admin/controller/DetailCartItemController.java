/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

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
@WebServlet(urlPatterns = "/admin/cartItem")
public class DetailCartItemController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_cart = Integer.parseInt(req.getParameter("idCart"));
        System.out.println(id_cart);
        req.setAttribute("idCart", id_cart);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/admin/cartProduct.jsp");
        requestDispatcher.forward(req, resp);
        //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
}
