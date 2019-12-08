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
 * @author vutha
 */

@WebServlet(urlPatterns = "/item/getAll")
public class GetAllItemServlet extends HttpServlet{
    private ItemDAO itemDAO;

    public GetAllItemServlet() {
        itemDAO = new ItemDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Integer pageSize = Integer.valueOf(req.getParameter("pageSize"));
        Integer currentPage = Integer.valueOf(req.getParameter("currentPage"));
        
        
        
        PrintWriter writer = resp.getWriter();
        Gson gson = new Gson();
        
        List<Item> items = itemDAO.getAllPagination(pageSize, (currentPage-1)*pageSize);
        
        writer.print(gson.toJson(items));
        writer.flush();
        writer.close();
        
    }
    
    
    
}
