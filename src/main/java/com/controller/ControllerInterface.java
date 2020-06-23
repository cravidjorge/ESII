package com.controller;

import com.exceptions.InvalidArgumentException;
import com.response.CreateUser;
import retrofit2.Response;

import java.io.IOException;

public interface ControllerInterface {
    Response<CreateUser> createUser(String name, String job) throws IOException, InvalidArgumentException;

    void singleUser(Integer id);

    void listUsers();

    void register();

    void login();

    void listResources();

    void singleResource(Integer id);
}
