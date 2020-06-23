package com.response;

public class CreateUser {
    private final String id;
    private final String name;
    private final String job;
    private final String createdAt;

    public CreateUser(String id, String name, String job, String createdAt) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
