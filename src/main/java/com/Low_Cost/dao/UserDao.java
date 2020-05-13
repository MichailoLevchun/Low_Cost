package com.Low_Cost.dao;

import com.Low_Cost.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Study on 09.06.2017.
 */
public interface UserDao extends JpaRepository<User,Integer> {


    @Query("select u from User u left join fetch u.shirts where u.id=:id")
    User findUserWitShirts(@Param("id") int id);

    @Query("select u from User u left join fetch u.orders o left join fetch o.shirts where u.id=:id")
    User findUserWithOrders(@Param("id") int id);

    User findByName(String name);

    User findByEmail(String email);

//    @Query("select u from User u where u.name=: parameter or u.email =: parameter ")
//    User findByNameOrEmail(@Param("parameter")String parameter);

    @Query("select u from User u where u.uuid=:uuid ")
    User findByUuid(@Param("uuid") String uuid);
}
