/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import com.google.gson.Gson;
import dao.CustomerDAO;
import dao.impl.CustomerDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;

/**
 *
 * @author QuaMin
 */
@WebServlet(urlPatterns = "/admin/getPersonPage")
public class GetPersonPageController extends HttpServlet{
    CustomerDAO customerDAO = new CustomerDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int limitPage = Integer.parseInt(req.getParameter("pageSize"));
        int startPage = Integer.parseInt(req.getParameter("currentPage"));
        
        List<Customer> customers = customerDAO.getCustomerByPage(limitPage, (startPage-1)*limitPage);
        
        PrintWriter printWriter = resp.getWriter();
        Gson gson = new Gson();
        printWriter.print(gson.toJson(customers));
        printWriter.flush();
        printWriter.close();
        //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
