package com.revature.DAO;

import com.revature.exceptions.AlbumAlreadyExistsException;
import com.revature.exceptions.UnfoundIdException;
import com.revature.model.Album;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AlbumDAOInterface {

    public ArrayList<Album> getAllAlbums() throws SQLException;
    public ArrayList<Album> getAlbumsByPersonId(int userId) throws SQLException, UnfoundIdException;
    public Album getAlbumByNameAndArtist(String albumName, String artistName) throws SQLException;
    public Album insertAlbum(Album album) throws SQLException, AlbumAlreadyExistsException;

}
