package com.controller;

import com.controller.api.APIClient;
import com.controller.api.Endpoint;
import com.data.UserJob;
import com.exceptions.InvalidArgumentException;
import com.response.CreateUser;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class ControllerStub implements ControllerInterface {
    private final Integer maxLength = 50;

    public Response<CreateUser> createUser(String name, String job) throws IOException, InvalidArgumentException {
        if (name == null || job == null) {
            throw new NullPointerException("Null Arguments");
        }
        if (name.isBlank() || job.isBlank() || name.length() > maxLength || job.length() > maxLength) {
            throw new InvalidArgumentException("Invalid Arguments");
        }
        Endpoint endpoint = APIClient.getClient().create(Endpoint.class);
        UserJob userJob = new UserJob("morpheus", "leader");
        Call<CreateUser> request = endpoint.create(userJob.toJsonObject());
        return request.execute();
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
