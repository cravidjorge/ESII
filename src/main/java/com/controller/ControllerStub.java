package com.controller;

import com.response.CreateUser;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Response;
import java.io.IOException;


public class ControllerStub implements ControllerInterface {
    public Response<CreateUser> createUser(String name, String job) throws IOException {
        if (name.isBlank() || job.isBlank()) {
            return Response.error(422, ResponseBody.create(MediaType.parse("application/json"), "Invalid Arguments"));
        }
        Response<CreateUser> response = Response.success(201, new CreateUser("14", "morpheus", "leader", "2020-06-23T03:22:48.471Z"));
        return response;
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
