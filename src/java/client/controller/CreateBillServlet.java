/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import dao.BillDAO;
import dao.CartDAO;
import dao.impl.BillDaoImpl;
import dao.impl.CartDaoImpl;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bill;

/**
 *
 * @author vutha
 */
@WebServlet(urlPatterns = "/bill/create")
public class CreateBillServlet extends HttpServlet{

    private BillDAO billDao;
    private CartDAO cartDAO;
    public CreateBillServlet() {
        billDao = new BillDaoImpl();
        cartDAO = new CartDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer cartId = Integer.valueOf(req.getParameter("cartId"));
        Long payment = Long.valueOf(req.getParameter("payment"));
        
        Bill bill = new Bill(cartId, new Date(System.currentTimeMillis()), payment);
        billDao.createBill(bill);
        cartDAO.updateCartPayment(cartId);
    }
    
    
    
    
    
}
