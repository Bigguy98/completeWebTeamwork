/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vutha
 */
public class Cart {
    private Integer id;
    private Customer owner;
    private boolean isPaid = false;
    private Date creationTime;
    private List<CartItem> items = new ArrayList<>();

    public Cart() {     
    }

    public Cart(Integer id, Customer owner, Date creationTime) {
        this.id = id;
        this.owner = owner;
        this.creationTime = creationTime;
    }
    
    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public Cart(Customer owner, Date creationTime) {
        this.owner = owner;
        this.creationTime = creationTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public boolean isIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    
    
    
    
}
