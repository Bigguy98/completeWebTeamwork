/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import dao.ItemDAO;
import dao.impl.ItemDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vutha
 */

@WebServlet(urlPatterns = "/item/count")
public class CountItemServlet extends HttpServlet{
    private ItemDAO itemDAO;
    
    public CountItemServlet() {
        itemDAO = new ItemDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        PrintWriter writer = resp.getWriter();
//        Gson gson = new Gson();
        
        Integer total = itemDAO.countAll();
        writer.print(total);
        writer.flush();
        writer.close();
    }
    
    
    
}
