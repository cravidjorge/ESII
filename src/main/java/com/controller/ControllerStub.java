package com.controller;

import com.response.CreateUser;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Response;

public class ControllerStub implements ControllerInterface {
    private final Integer maxLength = 50;

    public Response<CreateUser> createUser(String name, String job) {
        if (name.isBlank() || job.isBlank() || name.length() > maxLength || job.length() > maxLength) {
            return Response.error(422, ResponseBody.create(MediaType.parse("application/json"), "Invalid Arguments"));
        }
        return Response.success(201, new CreateUser("14", "morpheus", "leader", "2020-06-23T03:22:48.471Z"));
    }

    public void getUserById(Integer id) {

    }

    public void listUsers() {

    }

    public void registerUser() {

    }

    public void authUser() {

    }

    public void listResources() {

    }

    public void getResourceById(Integer id) {

    }
}
