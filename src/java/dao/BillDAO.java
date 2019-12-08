/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Bill;

/**
 *
 * @author vutha
 */
public interface BillDAO {
    int createBill(Bill b);
    Bill getBillById(int id);
    Bill getBillByIdClient(int id_Client);
    List<Bill> getAll();
            
}
