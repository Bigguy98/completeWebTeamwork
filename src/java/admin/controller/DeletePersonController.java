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
@WebServlet(urlPatterns = "/admin/deletePerson")
public class DeletePersonController extends HttpServlet{
    CustomerDAO customerDAO = new CustomerDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        String id_customer = req.getParameter("idPerson");
        customerDAO.delete(Integer.parseInt(id_customer));
        
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(Integer.parseInt(id_customer));
        printWriter.flush();
        printWriter.close();
    }
    
    
   
}
