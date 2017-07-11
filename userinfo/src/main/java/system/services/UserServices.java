package system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.UserDao;
import system.model.User;

import java.util.List;

@Service
public class UserServices {
    private final UserDao userDao;

    @Autowired
    public UserServices(UserDao userDao) {this.userDao = userDao;}

    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }
}
