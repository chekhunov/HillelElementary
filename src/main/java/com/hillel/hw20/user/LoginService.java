package com.hillel.hw20.user;

import com.hillel.hw20.dbUtils.DBWork;
import com.hillel.hw20.person.User;

public class LoginService {
    DBWork dbWork = new DBWork();

    public User login(String username, String password) {
        User user = dbWork.findUserForBD(username, password);

        if (user != null) {
            return user;
        } else {
            return new User("Anonimous", "");
        }

    }
}
