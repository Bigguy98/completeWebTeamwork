/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Item;

/**
 *
 * @author vutha
 */
public interface ItemDAO {
    int create(Item item);
    
    void deleteById(Integer id);
    
    void update(Item item);
    
    List<Item> getAll();
    
    List<Item> getAllPagination(Integer limit, Integer offset);
    
    Item getItemById(Integer id);
    
    int countAll();
    
    List<Item> searchItem(String name);
    
    int countSearch(String name);
    
    
}
