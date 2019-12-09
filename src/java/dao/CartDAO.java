/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Cart;
import model.CartItem;

/**
 *
 * @author vutha
 */
public interface CartDAO {
    
    int create(Cart cart);
    
    void deleteById(Integer id);
    
    void update(Cart cart);
    
    Cart getCartById(Integer cartId);
    
    Cart getCartByUserId(Integer userId);
    
    int createCartItem(CartItem cartItem, Integer cartId);
    
    void removeCartItem(CartItem cartItem, Integer cartId);
    
    void updateCartItem(Integer cartId, Integer itemId, Integer number);
    
    void updateCartPayment(Integer cartId);
    public List<CartItem> getCartItems(Integer cartId);
    int countCart();
    
    List<Cart> getCartPage(int pageSize,int currentPage);
    
    void delete(int cartId, int itemId);
}
