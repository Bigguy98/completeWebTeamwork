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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Item;

/**
 *
 * @author vutha
 */
@WebServlet(urlPatterns = "/item/getById")
public class GetItemByIdServlet extends HttpServlet{

    private ItemDAO itemDAO;
    
    public GetItemByIdServlet() {
        itemDAO = new ItemDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        
        Gson gson = new Gson();
        Integer itemId = Integer.valueOf(req.getParameter("itemId"));
        
        Item item = itemDAO.getItemById(itemId);
        
        writer.print(gson.toJson(item));
        writer.flush();
        writer.close();
        
    }
    
    
    
    
}
