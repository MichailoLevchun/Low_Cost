package com.Low_Cost.dao;

import com.Low_Cost.entity.Shirt_Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Victor on 29.07.2017.
 */
public interface TypeDao  extends JpaRepository<Shirt_Type,Integer> {


}
