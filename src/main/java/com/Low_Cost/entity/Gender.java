package com.Low_Cost.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Study on 24.05.2017.
 */

@Entity
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String genderName;

    @OneToMany(mappedBy = "gender", fetch = FetchType.EAGER)
    private List<Shirt> shirts = new ArrayList<Shirt>();

    public Gender() {
    }

    public Gender(String genderName) {
        this.genderName = genderName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public List<Shirt> getShirts() {
        return shirts;
    }

    public void setShirts(List<Shirt> shirts) {
        this.shirts = shirts;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "id=" + id +
                ", genderName='" + genderName + '\'' +
                ", shirts=" + shirts +
                '}';
    }
}
