package com.chep.client.service;

import com.chep.client.entity.User;
import com.chep.client.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
