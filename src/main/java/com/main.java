package com;

import com.controller.api.ControllerAPI;
import com.controller.ControllerInterface;
import com.controller.ControllerStub;
import com.response.CreateUser;
import retrofit2.Response;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        // Create user using STUB
        ControllerInterface controller = new ControllerStub();
        Response<CreateUser> newUser = controller.createUser("Teste", "teste");
        System.out.println(newUser.body().getName()+'\n'+newUser.body().getJob()+'\n'+newUser.body().getId()+'\n'+newUser.body().getCreatedAt());

        // Create user using reqresAPI
        ControllerInterface controller1 = new ControllerAPI();
        Response<CreateUser> newUser1 = controller1.createUser("Teste", "teste");
        System.out.println(newUser1.body().getName()+'\n'+newUser1.body().getJob()+'\n'+newUser1.body().getId()+'\n'+newUser1.body().getCreatedAt());
    }
}
