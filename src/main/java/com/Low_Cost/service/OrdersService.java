package com.Low_Cost.service;

import com.Low_Cost.entity.Orders;
import com.Low_Cost.entity.User;

import java.security.Principal;
import java.util.List;

/**
 * Created by Study on 09.06.2017.
 */
public interface OrdersService {



    List<Orders> findAll();

    Orders findOne(int id);

    void delete(int id);

    void update(Orders orders);


    List<Orders> findOrdersByUser(User user);

    void addIntoBasket(Principal principal, int id);

    void deleteFromBasket(int userId, int shirtId);

    void buy(int userId);
}
