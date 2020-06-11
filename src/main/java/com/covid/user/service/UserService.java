package com.covid.user.service;

import com.covid.user.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
