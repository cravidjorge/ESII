package com.controller.api;

import com.controller.ControllerInterface;
import com.data.UserJob;
import com.response.CreateUser;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class ControllerAPI implements ControllerInterface {
    private final Integer maxLength = 50;

    public Response<CreateUser> createUser(String name, String job) throws IOException {
        if (name.isBlank() || job.isBlank() || name.length() > maxLength || job.length() > maxLength) {
            return Response.error(422, ResponseBody.create(MediaType.parse("application/json"), "Invalid Arguments"));
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
