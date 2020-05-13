package com.Low_Cost.service;

import com.Low_Cost.entity.Gender;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Study on 09.06.2017.
 */
public interface GenderService {

    void save(Gender gender);

    List<Gender> findAll();

    Gender findOne(int id);

    void delete(int id);

    void update(Gender gender);


}
