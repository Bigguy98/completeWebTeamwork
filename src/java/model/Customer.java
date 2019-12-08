/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author hoaiphat
 */
public class Customer implements Serializable{
    private int id;
    private String name;
    private int age;
    private String address;
    private String username;
    private String password;
    private String role;


    public Customer() {
    }

    public Customer(String name, int age, String address, String username, String password) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public Customer(int id, String name, int age, String address, String username, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public Customer(int id, String name, int age,String address, String username, String password,String role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.username = username;
        this.password = password;
        this.role=role;
    }

    public Customer(String name, int age, String address, String username, String password, String role) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.username = username;
        this.password = password;
        this.role=role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
}   
