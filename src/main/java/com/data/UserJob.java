package com.data;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class UserJob {
    private String id;
    private String createdAt;
    private final String name;
    private final String job;
    private String updatedAt;

    public UserJob(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public JsonObject toJsonObject() {
        return new JsonParser().parse(new Gson().toJson(this)).getAsJsonObject();
    }
}
