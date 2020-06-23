package com.controller;

import com.response.CreateUser;
import retrofit2.Response;
import java.io.IOException;

public interface ControllerInterface {
    Response<CreateUser> createUser(String name, String job) throws IOException;
    void getUserById(Integer id);
    void listUsers();
    void registerUser();
    void authUser();
    void listResources();
    void getResourceById(Integer id);
}
