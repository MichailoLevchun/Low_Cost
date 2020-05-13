package com.Low_Cost.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Study on 24.05.2017.
 */

@Entity
@Table(name = "shirt", indexes = @Index(columnList = "shirtName",  name = "shirtName_index"))
public class Shirt {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String shirtName;

    private String pathImage;

    private  int price;
    private int size;

    @ManyToOne
    private Shirt_Type type;

    @ManyToOne
    private Gender gender;

    @ManyToOne
    private Brand brand;

    @ManyToMany
    @JoinTable(name = "orders_shirt", joinColumns = @JoinColumn(name = "shirt_id"), inverseJoinColumns = @JoinColumn(name = "orders_id"))
    private List<Orders> orders = new ArrayList<Orders>();

    @ManyToMany
    @JoinTable(name = "shirt_user", joinColumns = @JoinColumn(name = "id_shirt"), inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<User> users = new ArrayList<User>();

    public Shirt() {
    }

    public Shirt(String shirtName, int size) {
        this.shirtName = shirtName;
        this.size = size;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getShirtName() {
        return shirtName;
    }

    public void setShirtName(String shirtName) {
        this.shirtName = shirtName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public Shirt_Type getType() {
        return type;
    }

    public void setType(Shirt_Type type) {
        this.type = type;
    }


}
