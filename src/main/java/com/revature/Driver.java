package com.revature;

import com.revature.controller.AlbumController;
import com.revature.controller.AuthController;
import com.revature.controller.OwnsController;
import com.revature.controller.PersonController;
import com.revature.util.ConnectionSingleton;
import io.javalin.Javalin;

import java.sql.*;

public class Driver {

    public static void main(String[] args){

        //Get Connection Singleton

        Connection con = ConnectionSingleton.establishConnection();

        AlbumController albumController = new AlbumController(con);
        PersonController personController = new PersonController(con);
        OwnsController ownsController = new OwnsController(con);
        AuthController authController = new AuthController();


        var app = Javalin.create(/*any extra configs would go here*/)
                .start(3000)
                .get("/", ctx -> ctx.result("Hello Postman!"));


            app.put("/login", authController.loginHandler);


            app.get("/albums", albumController.getAlbumsHandler);

            app.get("/albums/{id}", albumController.getAlbumsByPersonIdHandler);

            app.post("/albums", albumController.insertAlbum);

            app.delete("/albums/{id}", albumController.deleteAlbumByIdHandler);


            app.post("/person", personController.insertPersonHandler);

            app.put("/person", personController.updatePersonHandler);

            app.get("/lengthLeaderboard", personController.lengthOfCollectionsHandler);

            app.post("/owns", ownsController.insertOwnsRelationshipHandler);

            app.put("/logout", authController.logoutHandler);



    }





}
