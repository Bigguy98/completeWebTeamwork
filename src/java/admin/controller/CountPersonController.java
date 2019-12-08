/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import dao.CustomerDAO;
import dao.impl.CustomerDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author QuaMin
 */
@WebServlet( urlPatterns = "/admin/countPerson")
public class CountPersonController extends HttpServlet{

    CustomerDAO customerDAO= new CustomerDaoImpl();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count = customerDAO.countPerson();
     
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(count);
        printWriter.flush();
        printWriter.close();
    }
    
}
