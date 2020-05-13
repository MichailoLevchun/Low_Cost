package com.Low_Cost.serviceImpl;

import com.Low_Cost.dao.BrandDao;
import com.Low_Cost.dao.ShirtDao;
import com.Low_Cost.entity.Brand;
import com.Low_Cost.entity.Shirt;
import com.Low_Cost.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Study on 09.06.2017.
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;
    @Autowired
    private ShirtDao shirtDao;

    public void save(Brand brand){


        brandDao.save(brand);

    }

    public List<Brand> findAll(){

        return brandDao.findAll();

    }

    public Brand findOne(int id){

        return brandDao.findOne(id);

    }

    public void delete(int id){

        Brand brand = brandDao.brandWithShirts(id);

        for (Shirt shirt: brand.getShirts()){

            shirt.setBrand(null);
            shirtDao.saveAndFlush(shirt);

        }

        brandDao.delete(id);

    }

    public void update(Brand brand){
        brandDao.save(brand);
        }

    @Override
    public Page<Brand> findAllPages(Pageable pageable) {
        return brandDao.findAll(pageable);
    }
}
