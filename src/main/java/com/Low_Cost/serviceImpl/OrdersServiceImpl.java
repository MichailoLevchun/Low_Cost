package com.Low_Cost.serviceImpl;

import com.Low_Cost.dao.OrdersDao;
import com.Low_Cost.dao.ShirtDao;
import com.Low_Cost.dao.UserDao;
import com.Low_Cost.entity.Orders;
import com.Low_Cost.entity.Shirt;
import com.Low_Cost.entity.User;

import com.Low_Cost.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Study on 12.06.2017.
 */

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private ShirtDao shirtDao;
    @Autowired
    private UserDao userDao;


    public List<Orders> findAll(){
        return ordersDao.findAll();

    }
    public Orders findOne(int id){
        return ordersDao.findOne(id);
    }

    public void delete(int id){
        ordersDao.delete(id);

    }
    public void update(Orders orders){
        ordersDao.save(orders);

    }

    @Override
    public List<Orders> findOrdersByUser(User user) {
        return ordersDao.findOrdersByUser(user);
    }

    public void addIntoBasket(Principal principal, int id){

        User user =  userDao.findUserWitShirts(Integer.parseInt(principal.getName()));

        Shirt shirt =  shirtDao.findOne(id);

        user.getShirts().add(shirt);

        userDao.save(user);


    }

    @Transactional
    public void deleteFromBasket(int userid, int shirtid){

        User user = userDao.findUserWitShirts(userid);

        Shirt shirt = shirtDao.shirtWithUsers(shirtid);

        user.getShirts().remove(shirt);

        userDao.save(user);

    }

    @Transactional
    public void buy(int userid){

        Orders orders = new Orders(LocalDate.now());

        ordersDao.saveAndFlush(orders);

        User user = userDao.findUserWitShirts(userid);

        orders.setUser(user);

        for (Shirt shirt : user.getShirts()) {

            orders.getShirts().add(shirt);

            ordersDao.save(orders);


            
        }

        user.getShirts().clear();

        userDao.save(user);



    }






}
