package com.Low_Cost.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 29.07.2017.
 */

@Entity
public class Shirt_Type {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String Type;

    public Shirt_Type() {

    }
    @OneToMany(mappedBy = "type")
    private List<Shirt> shirts= new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public List<Shirt> getShirts() {
        return shirts;
    }

    public void setShirts(List<Shirt> shirts) {
        this.shirts = shirts;
    }

    public Shirt_Type(String type) {
        Type = type;
    }
}
