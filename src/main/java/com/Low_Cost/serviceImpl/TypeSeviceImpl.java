package com.Low_Cost.serviceImpl;

import com.Low_Cost.dao.ShirtDao;
import com.Low_Cost.dao.TypeDao;
import com.Low_Cost.entity.Shirt_Type;
import com.Low_Cost.service.ShirtService;
import com.Low_Cost.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Victor on 29.07.2017.
 */

@Service
public class TypeSeviceImpl implements TypeService {

    @Autowired
    TypeDao typeDao;

    @Override
    public void save(Shirt_Type shirt_type) {
        typeDao.save(shirt_type);
    }

    @Override
    public List<Shirt_Type> findAll() {
        return typeDao.findAll();
    }

    @Override
    public Shirt_Type findOne(int id) {
        return typeDao.findOne(id);
    }

    @Override
    public void delete(int id) {

        typeDao.delete(id);
    }

    @Override
    public void update(Shirt_Type shirt_type) {

        typeDao.save(shirt_type);
    }
}

