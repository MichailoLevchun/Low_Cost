package com.Low_Cost.serviceImpl;

import com.Low_Cost.dao.GenderDao;
import com.Low_Cost.dao.ShirtDao;
import com.Low_Cost.entity.Gender;
import com.Low_Cost.entity.Shirt;
import com.Low_Cost.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Study on 09.06.2017.
 */

@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    private GenderDao genderDao;
    @Autowired
    private ShirtDao shirtDao;

   public void save(Gender gender){

        genderDao.save(gender);

    }

    public List<Gender> findAll(){

        return genderDao.findAll();

    }

    public Gender findOne(int id){

        return genderDao.findOne(id);

    }

    public void delete(int id){

        Gender gender = genderDao.genderWithShirts(id);

        for (Shirt shirt: gender.getShirts()){

            shirt.setGender(null);
            shirtDao.saveAndFlush(shirt);

        }

        genderDao.delete(id);

    }

    public void update(Gender gender){
        genderDao.save(gender);
    }


}
