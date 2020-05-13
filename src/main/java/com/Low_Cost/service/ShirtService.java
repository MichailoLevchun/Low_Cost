package com.Low_Cost.service;

import com.Low_Cost.entity.Shirt;
import com.Low_Cost.entity.Shirt_Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Study on 09.06.2017.
 */
public interface ShirtService {


    void save(Shirt shirt,MultipartFile image);


    Page <Shirt> shirtPages(Pageable pageable);

    List<Shirt> findAll();

    Shirt findOne(int id);

    void delete(int id);

    void update(Shirt shirt);

    void updateShirt(int shirt_id);

    Shirt shirtWithAllInfo(int id);


    List<Shirt> findShirtByType(int id);

    List<Shirt> searchShirts(String search);
    List<Shirt> filterByGender(String gend);
    List<Shirt> filterByBrand(String bran);

}
