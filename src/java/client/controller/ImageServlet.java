/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vutha
 */
@WebServlet(urlPatterns = "/image")
public class ImageServlet extends HttpServlet{
    private static final String imageFolder = "E:\\Web_programming\\items\\";

    public ImageServlet() {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {        
        String imageName = req.getParameter("image");
        
        FileInputStream in = new FileInputStream(imageFolder + imageName);
        OutputStream out = resp.getOutputStream();
        
        if(in != null) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            resp.setContentType("image/jpg");
            while((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            } 
        
        }
        in.close();
        out.close();
        
    }
    
    
    
    
}
