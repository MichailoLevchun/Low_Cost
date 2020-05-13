package com.Low_Cost.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Study on 07.06.2017.
 */

@Entity
public class Brand {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brandName;

    @OneToMany(mappedBy = "brand")
    private List<Shirt> shirts = new ArrayList<Shirt>();

    public Brand() {
    }
    public Brand(String brandName) {
        this.brandName=brandName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String name) {
        this.brandName = brandName;
    }

    public List<Shirt> getShirts() {
        return shirts;
    }

    public void setShirts(List<Shirt> shirts) {
        this.shirts = shirts;
    }
}
