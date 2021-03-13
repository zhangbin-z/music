package com.zl.music.service.impl;



import com.zl.music.dao.UserMapper;
import com.zl.music.pojo.User;
import com.zl.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper um;

    public void setUm(UserMapper um) {
        this.um = um;
    }

    @Override
    public User login(User user) {
        return um.getUser(user);
    }


}
