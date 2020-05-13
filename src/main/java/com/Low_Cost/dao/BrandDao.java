package com.Low_Cost.dao;

import com.Low_Cost.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Study on 09.06.2017.
 */
public interface BrandDao extends JpaRepository<Brand,Integer>
{

    @Query("select b from Brand b left join fetch b.shirts where b.id=:id ")
    Brand brandWithShirts(@Param("id") int id );


}
