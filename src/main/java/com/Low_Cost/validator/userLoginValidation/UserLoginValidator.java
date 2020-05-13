package com.Low_Cost.validator.userLoginValidation;

import com.Low_Cost.dao.UserDao;
import com.Low_Cost.entity.User;
import com.Low_Cost.validator.Validator;
import com.Low_Cost.validator.user.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by Study on 10.06.2017.
 */

@Component
public class UserLoginValidator implements Validator {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;



    @Override
    public void validate(Object o) throws Exception {

        User user = (User) o;

        if (user.getName().isEmpty()) {
            throw new UserException(UserLoginValidationMessage.EMPTY_USERNAME_FIELD);
        } else if (userDao.findByName(user.getName()) == null) {
            throw new UserException(UserLoginValidationMessage.WRONG_USERNAME_OR_PASSWORD);
        } else if (encoder.matches(user.getPassword(),
                userDao.findByName(user.getName()).getPassword())){
            throw new UserException(UserLoginValidationMessage.WRONG_USERNAME_OR_PASSWORD);
        }


    }
}
