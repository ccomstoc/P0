package com.revature;

import com.revature.controller.AlbumController;
import com.revature.util.ConnectionSingleton;
import io.javalin.Javalin;

import java.sql.*;

public class Driver {

    public static void main(String[] args){

        //Get Connection Singleton

        Connection con = ConnectionSingleton.establishConnection();

        AlbumController albumController = new AlbumController(con);


        var app = Javalin.create(/*any extra configs would go here*/)
                .start(3000)
                .get("/", ctx -> ctx.result("Hello Postman!"));


       app.get("/albums",albumController.getAlbumsHandler);

        app.get("/albums/{id}",albumController.getAlbumsByPersonIdHandler);


    }
}
