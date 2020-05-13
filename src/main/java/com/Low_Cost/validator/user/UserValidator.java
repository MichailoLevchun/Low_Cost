package com.Low_Cost.validator.user;

import com.Low_Cost.dao.UserDao;
import com.Low_Cost.entity.User;
import com.Low_Cost.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Study on 10.06.2017.
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    private UserDao userDao;

    @Override
    public void validate(Object o) throws Exception {

        User user = (User) o;

        if(user.getName().isEmpty()){
            throw new UserException(UserValidationMessage.EMPTY_USERNAME_FIELD);
        }else if(userDao.findByName(user.getName()) != null){
            throw new UserException(UserValidationMessage.USERNAME_ALREADY_EXIST);
        }else if(user.getEmail().isEmpty()){
            throw new UserException(UserValidationMessage.EMPTY_EMAIL_FIELD);
        }else if(!user.getEmail().contains("@")){
            throw new UserException(UserValidationMessage.WRONG_EMAIL);
        }else if(userDao.findByEmail(user.getEmail()) != null){
            throw new UserException(UserValidationMessage.EMAIL_ALREADY_EXIST);
        }else if(user.getPassword().isEmpty()){
            throw new UserException(UserValidationMessage.EMPTY_PASSWORD_FIELD);
        }

    }
}
