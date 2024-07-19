package com.revature.service;

import com.revature.DAO.AlbumDAO;
import com.revature.exceptions.AlbumAlreadyExistsException;
import com.revature.model.Album;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlbumService {

    private final AlbumDAO albumDAO;

    public AlbumService(Connection con){
        albumDAO = new AlbumDAO(con);
    }

    public ArrayList<Album> getAllAlbums() throws SQLException {
        return albumDAO.getAllAlbums();
    }
    public ArrayList<Album> getAlbumsByPersonId(int userId) throws SQLException {
        return albumDAO.getAlbumsByPersonId(userId);
    }
    public Album insertAlbum(Album album) throws SQLException, AlbumAlreadyExistsException {
        return albumDAO.insertAlbum(album);
    }

    public Album deleteAlbumById(int id) throws SQLException {
        return albumDAO.deleteAlbumById(id);
    }

}
