package com.Low_Cost.serviceImpl;

import com.Low_Cost.dao.ShirtDao;
import com.Low_Cost.dao.UserDao;
import com.Low_Cost.entity.Role;
import com.Low_Cost.entity.Shirt;
import com.Low_Cost.entity.User;
import com.Low_Cost.service.UserService;
import com.Low_Cost.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ShirtDao shirtDao;

    @Autowired
    @Qualifier("userValidator")
    private Validator validator;

    @Autowired
    private BCryptPasswordEncoder encoder;


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userDao.findByName(name);
    }

    public void save(User user) throws Exception {

       // validator.validate(user);

        user.setRole(Role.ROLE_USER);
        user.setEnable(true);
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.save(user);



    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findOne(int id) {
        return userDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);

    }

    @Override
    public void update(User user) {

        userDao.save(user);

    }

    @Override
    public User findUserWithOrders(int id) {
        return userDao.findUserWithOrders(id);
    }

    @Override
    public User findUserWithShirt(int id){
        User user = userDao.findUserWitShirts(id);

        User returnedUser = new User();

        returnedUser.setId(user.getId());
        returnedUser.setName(user.getName());

        for (int i = 0; i < user.getShirts().size() ; i++) {

            //returnedUser.getShirts().add(new Shirt(user.getShirts().get(i).getId(),(String) user.getShirts().get(i).getShirtName()));


        }

        return null;
    }

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public User findByUuid(String uuid) {
        return userDao.findByUuid(uuid);
    }



}

