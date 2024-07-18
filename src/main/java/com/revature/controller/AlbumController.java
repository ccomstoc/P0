package com.revature.controller;

import com.revature.service.AlbumService;
import io.javalin.http.Handler;

import java.sql.Connection;
import java.sql.SQLException;

public class AlbumController {

    private AlbumService albumService;

    public AlbumController(Connection con){
        albumService = new AlbumService(con);

    }

    public Handler getAlbumsHandler = ctx -> {

        try {
            ctx.json(albumService.getAllAlbums());
            ctx.status(200);
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Issue with SQL quire");
        }

    };

    public Handler getAlbumsByPersonIdHandler = ctx -> {

        int person_id = Integer.parseInt(ctx.pathParam("id"));

        try {
            ctx.json(albumService.getAlbumsByPersonId(person_id));
            ctx.status(200);
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Issue with SQL quire");
        }

    };
}
