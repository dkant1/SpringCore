package com.dk.repository;

import com.dk.model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
}
