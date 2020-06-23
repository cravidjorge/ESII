package com.controller;

import com.controller.api.ControllerAPI;
import com.response.CreateUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalTest {
    ControllerInterface controller = null;

    @BeforeEach
    void setUp() {
        controller = new ControllerAPI();
    }

    @Test
    void createUserNullName() throws IOException {
        Response<CreateUser> response = controller.createUser("", "leader");
        assertEquals(422, response.code());
        assert response.errorBody() != null;
        assertEquals("Invalid Arguments", response.errorBody().string());
    }

    @Test
    void createUserNullJob() throws IOException {
        Response<CreateUser> response = controller.createUser("morpheus", "");
        assertEquals(422, response.code());
        assert response.errorBody() != null;
        assertEquals("Invalid Arguments", response.errorBody().string());
    }

    @Test
    void createUserNameLengthToBig() throws IOException {
        Response<CreateUser> response = controller.createUser("João Antonio Sousa Filipe Morais Carvalhais Antunes", "leader");
        assertEquals(422, response.code());
        assert response.errorBody() != null;
        assertEquals("Invalid Arguments", response.errorBody().string());
    }

    @Test
    void createUserJobLengthToBig() throws IOException {
        Response<CreateUser> response = controller.createUser("morpheus", "carpinteirooooooooooooooooooooooooooooooooooooooooo");
        assertEquals(422, response.code());
        assert response.errorBody() != null;
        assertEquals("Invalid Arguments", response.errorBody().string());
    }

    @Test
    void createUserSuccessful() throws IOException {
        Response<CreateUser> response = controller.createUser("morpheus", "leader");
        assertEquals(201, response.code());
        assert response.body() != null;
        assertEquals(CreateUser.class, response.body().getClass());
    }
}