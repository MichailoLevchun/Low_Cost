package com.Low_Cost.dao;

import com.Low_Cost.entity.Brand;
import com.Low_Cost.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Study on 09.06.2017.
 */
public interface GenderDao extends JpaRepository<Gender,Integer> {

    @Query("select g from Gender g left join fetch g.shirts where g.id=:id ")
    Gender genderWithShirts(@Param("id") int id );

}
