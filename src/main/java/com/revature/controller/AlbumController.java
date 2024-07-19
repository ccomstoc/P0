package com.revature.controller;

import com.revature.exceptions.AlbumAlreadyExistsException;
import com.revature.exceptions.CannotBeNullException;
import com.revature.exceptions.UnfoundIdException;
import com.revature.model.Album;
import com.revature.service.AlbumService;
import io.javalin.http.Handler;

import java.sql.Connection;
import java.sql.SQLException;

public class AlbumController extends Controller{

    private AlbumService albumService;

    public AlbumController(Connection con){
        albumService = new AlbumService(con);

    }

    public Handler getAlbumsHandler = ctx -> {

        //Cheap way of validating login
        if(AuthController.ses == null){
            ctx.status(401);
            return;
        }

        try {
            ctx.json(albumService.getAllAlbums());
            ctx.status(200);
        }catch(SQLException e){
            log.error("Get albums DAO failed");
            e.getMessage();
            ctx.status(500);
        }

    };

    public Handler getAlbumsByPersonIdHandler = ctx -> {

        if(AuthController.ses == null){
            ctx.status(401);
            return;
        }

        int person_id = Integer.parseInt(ctx.pathParam("id"));

        try {
            ctx.json(albumService.getAlbumsByPersonId(person_id));
            ctx.status(200);
        }catch(SQLException e){
            e.getMessage();
            ctx.status(500);
            log.error("Get albums by person ID, DAO failed");
        } catch (UnfoundIdException e){
            ctx.status(400);
            log.error(e.toString());

        }

    };

    public Handler insertAlbum = ctx -> {

        if(AuthController.ses == null){
            ctx.status(401);
            return;
        }

        Album album = ctx.bodyAsClass(Album.class);
        try{
            if(album.getAlbum_name() == null || album.getArtist_name() == null)
                throw new CannotBeNullException("Insufficient args given for insert album, must include artist and album name");
            ctx.json(albumService.insertAlbum(album));
            ctx.status(200);
        } catch(SQLException e) {
            e.getMessage();
            ctx.status(500);//Not necessarily, could be input error. Need to validate info still
            log.error("Issue inserting album in DAO");
        } catch(AlbumAlreadyExistsException e){
            log.warn(e.toString());
            ctx.status(409);
        } catch(CannotBeNullException e){
            ctx.status(400);
            log.warn(e.toString());
        }


    };

    public Handler deleteAlbumByIdHandler = ctx -> {

        if(AuthController.ses == null){
            ctx.status(401);
            return;
        }

        int album_id = Integer.parseInt(ctx.pathParam("id"));

        try {
            ctx.json(albumService.deleteAlbumById(album_id));
            ctx.status(200);
        }catch(SQLException e){
            e.getMessage();
            ctx.status(500);
            log.error("Issue deleting album in DAO");
        } catch(UnfoundIdException e){
            ctx.status(400);
            log.warn(e.toString());
        }

    };
}
