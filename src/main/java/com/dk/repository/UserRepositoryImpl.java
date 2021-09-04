package com.dk.repository;

import com.dk.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements com.dk.repository.UserRepository {

    @Override
    public List<User> findAll(){

        List<User> userList = new ArrayList<User>();

        User user1 = new User("Test", "User1",1111);
        userList.add(user1);
        return userList;
    }
}
