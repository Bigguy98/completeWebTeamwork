/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.CustomerDAO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import jdbc.JDBCConnection;
/**
 *
 * @author hoaiphat
 */
public class CustomerDaoImpl extends JDBCConnection implements CustomerDAO{

    public CustomerDaoImpl() {
        super();
    }
    
    
    

    @Override
    public int create(Customer customer) {       
        try {
            java.util.Date date = new java.util.Date();
            String Sql="INSERT INTO customer(name,age,address,username,password,role,createtion_time)"
                + "VALUES(?,?,?,?,?,?,?)";
            
            PreparedStatement statement= conn.prepareStatement(Sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, customer.getName());
            statement.setInt(2, customer.getAge());
            statement.setString(3, customer.getAddress());
            statement.setString(4, customer.getUsername());
            statement.setString(5, customer.getPassword());
            statement.setString(6, customer.getRole());
            statement.setDate(7, new java.sql.Date(date.getTime()));
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next()){
                return rs.getInt(1);            
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return 0;
    }

    @Override
    public void edit(Customer customer) {
        try {
            String sql = "UPDATE customer SET name = ?, age = ?, address = ?, username = ?, password = ?"
			+ " WHERE (id = ?) ";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, customer.getName());
            statement.setInt(2, customer.getAge());
            statement.setString(3, customer.getAddress());
            statement.setString(4, customer.getUsername());
            statement.setString(5, customer.getPassword());
            statement.setInt(6, customer.getId());

            statement.executeUpdate();
		
        } catch (Exception e) {
            System.out.println("Loi CSDL: " + e);
	} 
        
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM customer WHERE id = ? ";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            statement.executeUpdate();
	} catch (Exception e) {
            System.out.println("Loi CSDL: " + e);
	}
    }

    @Override
    public Customer getCustomer(int customerId) {
        try {
            String sql = "select * from customer where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String address = rs.getString("address");
                Integer age = rs.getInt("age");
                Customer c = new Customer(id, name, age, address, username, password);
                return c;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }

    @Override
    public Customer getByUserName(String keyword) {
        try {
            String sql = "select * from customer where username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, keyword);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String address = rs.getString("address");
                Integer age = rs.getInt("age");
                String role = rs.getString("role");
                Customer c = new Customer(id, name, age, address, username, password,role);
                return c;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        try {
            String sql = "select * from customer";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String address = rs.getString("address");
                String role = rs.getString("role");
                Integer age = rs.getInt("age");
                Customer c = new Customer(id, name, age, address, username, password,role);
                customers.add(c);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }

    @Override
    public List<Customer> searchName(String nameCustomer) {
        List<Customer> customers = new ArrayList<>();
        try {
            String sql = "select * from customer where customer.name = ?";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nameCustomer);
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String address = rs.getString("address");
                Integer age = rs.getInt("age");
                Customer c = new Customer(id, name, age, address, username, password);
                customers.add(c);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }

    @Override
    public int countPerson() {
        int count = 0;
        try {
            String sql = "select count(*) from customer";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                count = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    
    }

    @Override
    public List<Customer> getCustomerByPage(int limitPage, int startPage) {
        List<Customer> customers = new ArrayList<>();
        try {
            
            String sql = "select * from customer limit ? offset ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, limitPage);
            ps.setInt(2, startPage);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                Integer age  = rs.getInt("age");
                String address = rs.getString("address");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");
                
                Customer customer = new Customer(id, name, age, address, username, password,role );
                customers.add(customer);          
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }
    
}
