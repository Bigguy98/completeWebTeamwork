/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import model.Customer;
import dao.BillDAO;
import dao.CartDAO;
import dao.CustomerDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.JDBCConnection;
import model.Bill;

/**
 *
 * @author vutha
 */
public class BillDaoImpl extends JDBCConnection implements BillDAO{
    
    CustomerDAO customerDAO = new CustomerDaoImpl();
    CartDAO cartDAO= new CartDaoImpl();
    public BillDaoImpl() {
        super();
    }
    
    

    @Override
    public int createBill(Bill b) {
        try {
            String sql = "insert into bill(cartID,total,creation_time) values(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, b.getCartId());
            ps.setLong(2, b.getTotal());
            ps.setDate(3, b.getCreationTime());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(BillDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Bill getBillById(int id) {
        String sql = "SELECT bill.id, bill.createtion_time, bill.total, cart.name,cart.id AS cart_id "
		+ "FROM bill INNER JOIN cart " 
                + "ON bill.cartID = cart.id WHERE bill.cartID=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
                            Bill bill = new Bill();
                            bill.setId(rs.getInt("id"));
                            bill.setCartId(rs.getInt("cart_id"));
                            bill.setCreationTime(rs.getDate("createtion_time"));
                            bill.setTotal(rs.getLong("total"));

			return bill;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public Bill getBillByIdClient(int id_Client) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Bill> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
