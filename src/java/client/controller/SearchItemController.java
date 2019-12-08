/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import com.google.gson.Gson;
import dao.ItemDAO;
import dao.impl.ItemDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Item;

/**
 *
 * @author QuaMin
 */
@WebServlet(urlPatterns = "/customer/searchItem")
public class SearchItemController extends HttpServlet{
    ItemDAO itemDAO = new ItemDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        
        List<Item> items = itemDAO.searchItem(name);
        
        PrintWriter printWriter = resp.getWriter();
        Gson gson = new Gson();
        printWriter.print(gson.toJson(items));
        printWriter.flush();
        printWriter.close();
    }
    
}
