package com.Low_Cost.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;

    private boolean open;

    @ManyToOne
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "orders_shirt", joinColumns = @JoinColumn(name = "orders_id"), inverseJoinColumns = @JoinColumn(name = "shirt_id"))
    private Set<Shirt> shirts = new HashSet<Shirt>();

    public Orders() {
        open=true;
        // TODO Auto-generated constructor stub
    }

    public Orders(LocalDate date) {
        super();
        this.date = date;
        open=true;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Shirt> getDrinks() {
        return shirts;
    }

    public void setShirts(Set<Shirt> shirts) {
        this.shirts = shirts;
    }

    public Set<Shirt> getShirts() {
        return shirts;
    }
}
