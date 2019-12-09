/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.CartDAO;
import dao.CustomerDAO;
import dao.ItemDAO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.JDBCConnection;
import model.Cart;
import model.CartItem;
import model.Customer;
import model.Item;

/**
 *
 * @author vutha
 */
public class CartDaoImpl extends JDBCConnection implements CartDAO{
    private CustomerDAO customerDAO;
    private ItemDAO itemDAO;
    
    public CartDaoImpl() {
        super();
        customerDAO = new CustomerDaoImpl();
        itemDAO = new ItemDaoImpl();
    }
    
    
    

    @Override
    public int create(Cart cart) {
        Integer nextId = 0;
        try {
            String sql = "insert into cart(customerID,isPaid,createtion_time) values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cart.getOwner().getId());
            ps.setBoolean(2, false);
            ps.setDate(3, (Date) cart.getCreationTime());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) nextId = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(CartDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nextId;
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Cart cart) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cart getCartByUserId(Integer userId) {
        Cart cart = new Cart();
        try {
            String sql = "select * from cart where customerID = ? and isPaid = 0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Integer cartId = rs.getInt("id");
                Integer customerId = rs.getInt("customerID");
                Date creationTime = rs.getDate("createtion_time");
                Customer customer = customerDAO.getCustomer(customerId);
                
                cart.setId(cartId);
                cart.setCreationTime(creationTime);
                cart.setOwner(customer);
                cart.setItems(getCartItems(cartId));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cart;
    }

    @Override
    public int createCartItem(CartItem cartItem, Integer cartId) {
        int nextId = 0;
        try {           
            
            String sql  = "insert into item_cart(price,number,itemID,cartID) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, cartItem.getItem().getPrice());
            ps.setInt(2, cartItem.getNumber());
            ps.setInt(3, cartItem.getItem().getId());
            ps.setInt(4, cartId);
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) nextId = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(CartDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nextId;
    }

    @Override
    public void removeCartItem(CartItem cartItem, Integer cartId) {
        try {
            String sql = "delete from item_cart where itemID = ? and cartID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cartItem.getItem().getId());
            ps.setInt(2, cartId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public List<CartItem> getCartItems(Integer cartId) {
        List<CartItem> items = new ArrayList<>();
        try {
            String sql = "select * from item_cart where cartID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cartId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Integer number = rs.getInt("number");
                Integer itemId = rs.getInt("itemID");
                Item item = itemDAO.getItemById(itemId);
                CartItem cartItem = new CartItem(item, number);
                
                items.add(cartItem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
    }
    
    @Override
    public void updateCartPayment(Integer cartId) {
        try {
            String sql = "update cart set isPaid = 1 where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cartId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Cart getCartById(Integer cartId) {
        Cart cart = new Cart();
        try {
            String sql = "select * from cart where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cartId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Integer id = rs.getInt("id");
                Integer customerId = rs.getInt("customerID");
                Date creationTime = rs.getDate("createtion_time");
                Customer customer = customerDAO.getCustomer(customerId);
                
                cart.setId(id);
                cart.setCreationTime(creationTime);
                cart.setOwner(customer);
                cart.setItems(getCartItems(cartId));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cart;
    }

    @Override
    public void updateCartItem(Integer cartId, Integer itemId, Integer number) {
        try {
            String sql = "update item_cart set number = ? where cartID = ? and itemID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, number);
            ps.setInt(2, cartId);
            ps.setInt(3, itemId);            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int countCart() {
       int count = 0;
        try {
            String sql = "select count(*) from cart";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                count = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cart> getCartPage(int pageSize, int currentPage) {
       List<Cart> carts = new ArrayList<>();
        try {
            
            String sql = "select * from cart limit ? offset ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pageSize);
            ps.setInt(2, currentPage);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Integer id = rs.getInt("id");
                Integer customerId = rs.getInt("customerID");
                java.util.Date creationTime = rs.getDate("createtion_time");
                Customer customer = customerDAO.getCustomer(customerId);
                Cart cart = new Cart(id,customer, creationTime);
                carts.add(cart);          
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return carts;
    }

    @Override
    public void delete(int cartId, int itemId) {
        try {
            String sql = "delete from item_cart where cartID  = ? and itemID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cartId);
            ps.setInt(2, itemId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
