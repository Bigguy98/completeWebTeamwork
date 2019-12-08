/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import dao.ItemDAO;
import dao.impl.ItemDaoImpl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Item;

/**
 *
 * @author QuaMin
 */
@WebServlet(urlPatterns = "/admin/editProduct")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
  maxFileSize = 1024 * 1024 * 20, 
  maxRequestSize = 1024 * 1024 * 20 * 20)
public class EditProductController extends  HttpServlet{
    private static String FOLDER = "E:\\Web_programming\\items\\";
    ItemDAO itemDAO = new ItemDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idProduct =Integer.parseInt(req.getParameter("idProduct"));
        req.setAttribute("idProduct", idProduct);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/admin/editProduct.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        Long price = Long.parseLong(req.getParameter("price"));
        String screen = req.getParameter("screen");
        String selfiecamera = req.getParameter("selfiecamera");
        String maincamera =req.getParameter("maincamera");
        String ram = req.getParameter("ram");
        String rom =req.getParameter("rom");
        String cpu = req.getParameter("cpu");
        String gpu = req.getParameter("gpu");
        String battery = req.getParameter("battery");
        String os = req.getParameter("os");
        String sim = req.getParameter("sim");
        
        System.out.println(name);
        Part part = req.getPart("image");
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = part.getInputStream();
       
        File targetFile = new File(FOLDER + "\\" + fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(targetFile);
        
        
        // write file
        int read;
        byte[] bytes = new byte[1024];
        
        while ((read = fileContent.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, read);
        }
        
        Item item = new Item(name, price, screen, selfiecamera, maincamera, ram, rom, gpu, cpu, battery, os, sim, fileName);
        item.setId(id);
        itemDAO.update(item);
        
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(item);
        printWriter.flush();
        printWriter.close();
    }
    
}
