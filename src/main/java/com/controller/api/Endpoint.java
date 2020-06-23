package com.controller.api;

import com.google.gson.JsonObject;
import com.response.CreateUser;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Endpoint {
    @POST("api/users")
    Call<CreateUser> create(@Body JsonObject user);
}
