/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;
import model.Customer;

/**
 *
 * @author hoaiphat
 */
public interface CustomerDAO {
    
    int create(Customer customer);
    
    void edit(Customer customer);
    
    void delete(int id);
    
    Customer getCustomer(int id);
    
    Customer getByUserName(String username);
    
    List<Customer> getAll();
    
    List<Customer> searchName(String nameCustomer);
            
    int countPerson();
    
    List<Customer> getCustomerByPage(int limitPage,int startPage);
}
