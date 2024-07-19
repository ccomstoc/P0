package com.revature.controller;

import com.revature.model.Owns;
import com.revature.service.OwnsService;
import io.javalin.http.Handler;

import java.sql.Connection;
import java.sql.SQLException;

public class OwnsController {

    private OwnsService ownsService;

    public OwnsController(Connection con){
        ownsService = new OwnsService(con);
    }

    public Handler insertOwnsRelationshipHandler = ctx ->{

        try {
            Owns owns = ctx.bodyAsClass(Owns.class);
            ownsService.insertOwnsRelationship(owns);
        } catch(SQLException e){
            ctx.status(500);//Could be input error
            e.printStackTrace();
            System.out.println("Issue with inserting owns relationship");

        }



    };
}
