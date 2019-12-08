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

@WebServlet("/handlerLogin")
public class LoginHandlerServlet extends HttpServlet{
    private CustomerDaoImpl customerDao;

    public LoginHandlerServlet() {
        customerDao = new CustomerDaoImpl();
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Customer c = customerDao.getByUserName(username);
        if(c!= null && c.getPassword().equals(SecurityUtil.encode(password))) {            
            writer.print(c.getId());    
        }
        else {
            resp.setStatus(400);
            writer.print("Wrong account!");
        }
        writer.flush();
        writer.close(); 
    }    
    
}
