package com.Low_Cost.serviceImpl;

import com.Low_Cost.dao.OrdersDao;
import com.Low_Cost.dao.ShirtDao;
import com.Low_Cost.dao.UserDao;
import com.Low_Cost.entity.Shirt;
import com.Low_Cost.entity.Shirt_Type;
import com.Low_Cost.service.ShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Study on 12.06.2017.
 */

@Service
public class ShirtServiceImpl implements ShirtService {

    @Autowired
    private ShirtDao shirtDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private OrdersDao ordersDao;




//    public Page<Shirt> shirtPage(Pageable pageable){
//
//        return shirtDao.shirtPages(pageable);
//    }

    @Override
    public void save(Shirt shirt,MultipartFile image) {


        String path = System.getProperty("catalina.home") + "/resources/Brands/"
                + shirt.getShirtName() + "/" + image.getOriginalFilename();

        shirt.setPathImage("/resources/Brands/" + shirt.getShirtName() + "/" + image.getOriginalFilename());

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }



        shirtDao.save(shirt);
    }

    @Override
    public Page<Shirt> shirtPages(Pageable pageable) {
        return null;
    }

    @Override
    public List<Shirt> findAll() {
        return shirtDao.findAll();
    }

    public Shirt findOne(int id){

        return shirtDao.findOne(id);

    }

    public void delete (int id){

        shirtDao.delete(id);
    }

    public void update(Shirt shirt){

        shirtDao.save(shirt);
    }

    public void updateShirt(int shirt_id){


    }

    @Override
    public List<Shirt> findShirtByType(int id) {
        return shirtDao.findShirtByType(id);
    }

    @Override
    public Shirt shirtWithAllInfo(int id) {
        return null;
    }

    @Override
    public List<Shirt> searchShirts(String search) {
        return null;
    }

    @Override
    public List<Shirt> filterByGender(String gend) {
        return null;
    }

    @Override
    public List<Shirt> filterByBrand(String bran) {
        return null;
    }

}
