/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author vutha
 */
public class Bill {
    private Integer id;
    private Integer cartId;
    private Date creationTime;
    private Long total;

    public Bill() {
    }
    
    public Bill(Integer cartId, Date creationTime, Long total) {
        this.cartId = cartId;
        this.creationTime = creationTime;
        this.total = total;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getCartId() {
        return cartId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public Long getTotal() {
        return total;
    }
    
    
    
}
