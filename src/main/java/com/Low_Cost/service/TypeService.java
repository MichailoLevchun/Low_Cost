package com.Low_Cost.service;

import com.Low_Cost.entity.Shirt_Type;

import java.util.List;

/**
 * Created by Victor on 29.07.2017.
 */
public interface TypeService {



    void save(Shirt_Type shirt_type);

    List<Shirt_Type> findAll();

    Shirt_Type findOne(int id);

    void delete(int id);

    void update(Shirt_Type gender);
}
