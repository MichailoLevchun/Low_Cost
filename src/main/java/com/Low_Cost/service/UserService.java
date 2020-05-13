package com.Low_Cost.service;

import com.Low_Cost.entity.User;

import java.util.List;

/**
 * Created by Study on 09.06.2017.
 */
public interface UserService {

    void save(User user) throws Exception;

    List<User> findAll();

    User findOne(int id);

    void delete(int id);

    void update(User user);

    User findUserWithOrders(int id);

    User findUserWithShirt(int id);

    User findByName(String name);

    User findByUuid(String uuid);
}
