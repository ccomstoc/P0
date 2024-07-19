package com.revature.service;

import com.revature.model.LoginDTO;
import com.revature.model.Person;
import org.eclipse.jetty.util.log.Log;

public class AuthService {




    //Rudimentary function to simulate login
    public Person login(LoginDTO loginDTO){
        if(loginDTO.getLast_name().equals("Smith") && loginDTO.getFirst_name().equals("Stan")){
            return new Person("Stan","Smith");
        }

        return null;

    }

}
