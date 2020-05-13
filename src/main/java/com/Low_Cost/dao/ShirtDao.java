package com.Low_Cost.dao;

import com.Low_Cost.entity.Shirt;
import com.Low_Cost.entity.Shirt_Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Study on 09.06.2017.
 */
public interface ShirtDao extends JpaRepository<Shirt,Integer> {


    @Query("select distinct s from Shirt s left join fetch s.users where s.id =:id ")
    Shirt shirtWithUsers(@Param("id")int id );
//    @Query(value = "select distinct s from  Shirt s left join fetch s.id", countQuery = "select count(s.id) from Shirt shirt")
//    Page<Shirt> shirtPages(Pageable pageable);

    @Query("select  s from  Shirt  s where s.type.id =:id")
    List<Shirt> findShirtByType(@Param("id") int id);


}
