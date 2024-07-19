package com.revature.controller;

import com.revature.exceptions.UnfoundIdException;
import com.revature.model.Owns;
import com.revature.service.OwnsService;
import io.javalin.http.Handler;

import java.sql.Connection;
import java.sql.SQLException;

public class OwnsController extends Controller{

    private OwnsService ownsService;

    public OwnsController(Connection con){
        ownsService = new OwnsService(con);
    }

    public Handler insertOwnsRelationshipHandler = ctx ->{

        if(AuthController.ses == null){
            ctx.status(401);
            return;
        }

        try {
            Owns owns = ctx.bodyAsClass(Owns.class);
            ctx.json(ownsService.insertOwnsRelationship(owns));
        } catch(SQLException e){
            ctx.status(500);//Could be input error
            e.getMessage();
            log.warn("Issue with inserting owns relationship");
        } catch(UnfoundIdException e){
            ctx.status(400);
            log.warn(e.toString());
        }



    };
}
