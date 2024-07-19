package com.revature.controller;

import com.revature.exceptions.AlbumAlreadyExistsException;
import com.revature.model.Album;
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
            ctx.status(500);
            System.out.println("Issue with geting all albums SQL quire");
        }

    };

    public Handler getAlbumsByPersonIdHandler = ctx -> {

        int person_id = Integer.parseInt(ctx.pathParam("id"));

        try {
            ctx.json(albumService.getAlbumsByPersonId(person_id));
            ctx.status(200);
        }catch(SQLException e){
            e.printStackTrace();
            ctx.status(500);
            System.out.println("Issue with getting persons albums SQL quire");
        }

    };

    public Handler insertAlbum = ctx -> {

        Album album = ctx.bodyAsClass(Album.class);
        try{
            ctx.json(albumService.insertAlbum(album));
            ctx.status(200);
        } catch(SQLException e) {
            e.printStackTrace();
            ctx.status(500);//Not necessarily, could be input error. Need to validate info still
            System.out.println("Issue inserting album");
        } catch(AlbumAlreadyExistsException e){
            e.printStackTrace();
            ctx.status(409);
            System.out.println("Album already exists");
        }



    };
}
