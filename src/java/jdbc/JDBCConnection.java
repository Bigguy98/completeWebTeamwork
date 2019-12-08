/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoaiphat
 */
public class JDBCConnection {
    protected Connection conn;

    public JDBCConnection() {
        String url = "jdbc:mysql://localhost:3306/ltweb?serverTimezone=UTC";
        String username = "root";
	String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
	} catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, e);
	}
    }
    
    
}
