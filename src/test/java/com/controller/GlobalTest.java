package com.controller;

import com.controller.api.ControllerAPI;
import com.exceptions.InvalidArgumentException;
import com.response.CreateUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GlobalTest {
    ControllerInterface controller = null;

    @BeforeEach
    void setUp() {
        controller = new ControllerAPI();
    }

    @Test
    void createUserNullName() {
        assertThrows(NullPointerException.class, () -> controller.createUser(null, "leader"));
    }

    @Test
    void createUserNullJob() {
        assertThrows(NullPointerException.class, () ->
                controller.createUser("morpheus", null)
        );
    }

    @Test
    void createUserBlankName() {
        assertThrows(InvalidArgumentException.class, () ->
                controller.createUser("", "leader")
        );
    }

    @Test
    void createUserBlankJob() {
        assertThrows(InvalidArgumentException.class, () ->
                controller.createUser("morpheus", "")
        );
    }

    @Test
    void createUserNameLengthToBig() {
        assertThrows(InvalidArgumentException.class, () ->
                controller.createUser("João Antonio Sousa Filipe Morais Carvalhais Antunes", "leader")
        );
    }

    @Test
    void createUserJobLengthToBig() {
        assertThrows(InvalidArgumentException.class, () ->
                controller.createUser("morpheus", "carpinteirooooooooooooooooooooooooooooooooooooooooo")
        );
    }

    @Test
    void createUserSuccessful() throws IOException, InvalidArgumentException {
        Response<CreateUser> response = controller.createUser("morpheus", "leader");
        assertEquals(201, response.code());
        assert response.body() != null;
        assertEquals(CreateUser.class, response.body().getClass());
    }
}