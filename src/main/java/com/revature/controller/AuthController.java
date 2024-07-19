package com.revature.controller;


import com.revature.model.LoginDTO;
import com.revature.model.Person;
import com.revature.service.AuthService;
import io.javalin.http.Handler;
import jakarta.servlet.http.HttpSession;

public class AuthController {


    //Instantiate the AuthService to use the login() method
    AuthService authService = new AuthService();

    //uninitialized HttpSession object - to be filled upon successful login
    public static HttpSession ses;

    //login will be a POST request, since we're sending login creds in the HTTP Request body
    public Handler loginHandler = ctx -> {

        //extract the Request body authService a LoginDTO
        LoginDTO loginDTO = ctx.bodyAsClass(LoginDTO.class);

        //send the login credentials to the AuthService
        Person loggedInPerson = authService.login(loginDTO);

        //if the login was successful, return the Employee object
        if (loggedInPerson != null) {

            ses = ctx.req().getSession();

            ses.setAttribute("first_name", loggedInPerson.getFirst_name());
            ses.setAttribute("last_name", loggedInPerson.getLast_name());


            System.out.println(ses.getAttribute("first_name"));



            ctx.status(202); //accepted
            ctx.json(loggedInPerson);

        } else {
            ses = null;
        }
    };

    public Handler logoutHandler = ctx -> {

        ses.invalidate();

    };
}
