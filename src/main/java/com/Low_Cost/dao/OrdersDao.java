package com.Low_Cost.dao;

import com.Low_Cost.entity.Orders;
import com.Low_Cost.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Study on 09.06.2017.
 */
public interface OrdersDao extends JpaRepository<Orders,Integer> {

    List<Orders> findOrdersByUser(User user);

}
