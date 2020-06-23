package com.controller.api;

import com.controller.ControllerInterface;
import com.exceptions.InvalidArgumentException;
import com.response.CreateUser;
import retrofit2.Response;

public class ControllerAPI implements ControllerInterface {
    private final Integer maxLength = 50;

    public Response<CreateUser> createUser(String name, String job) throws InvalidArgumentException {
        if (name == null || job == null) {
            throw new NullPointerException("Null Arguments");
        }
        if (name.isBlank() || job.isBlank() || name.length() > maxLength || job.length() > maxLength) {
            throw new InvalidArgumentException("Invalid Arguments");
        }
        return Response.success(201, new CreateUser("14", "morpheus", "leader", "2020-06-23T03:22:48.471Z"));
    }

    public void singleUser(Integer id) {

    }

    public void listUsers() {

    }

    public void register() {

    }

    public void login() {

    }

    public void listResources() {

    }

    public void singleResource(Integer id) {

    }
}
