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
import model.Cart;

/**
 *
 * @author QuaMin
 */
@WebServlet(urlPatterns = "/admin/getCartPage")
public class GetCartPageController extends HttpServlet{
    CartDAO cartDAO =new CartDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageSize = req.getParameter("pageSize");
        String currentPage = req.getParameter("currentPage");
        
        List<Cart> carts= cartDAO.getCartPage(Integer.parseInt(pageSize),( Integer.parseInt(currentPage)-1)*Integer.parseInt(pageSize));
        Gson gson = new Gson();
        
        PrintWriter printWriter= resp.getWriter();
        printWriter.print(gson.toJson(carts));
        printWriter.flush();
        printWriter.close();
    }
    
}
