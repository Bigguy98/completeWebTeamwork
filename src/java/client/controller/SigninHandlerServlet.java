/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import dao.impl.CustomerDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import utils.SecurityUtil;

/**
 *
 * @author vutha
 */
@WebServlet(urlPatterns = "/handlerSignin")
public class SigninHandlerServlet extends HttpServlet{
    private CustomerDaoImpl customerDao;
    
    public SigninHandlerServlet() {
        customerDao = new CustomerDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        int nextId = createCustomerFromRequest(req);
        if( nextId != 0) {
            writer.print(nextId);
        }
        else {
            resp.setStatus(404);
            writer.print("Invalid info!");
        }
        writer.flush();
        writer.close();
    }
    
    private int createCustomerFromRequest(HttpServletRequest req) {
        String name = req.getParameter("name");
        Integer age = Integer.valueOf(req.getParameter("age"));
        String address = req.getParameter("address");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        if(!name.equals("") && !address.equals("") && !username.equals("") && !password.equals("")) {
            Customer c = new Customer(name, age, address, username, SecurityUtil.encode(password));
            int nextId = customerDao.create(c);
            if(nextId != 0) System.out.println("created new customer: " + nextId);
            return nextId;
        }
        return 0;
    }
    
    
    
}
