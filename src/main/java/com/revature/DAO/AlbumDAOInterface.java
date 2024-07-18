package com.revature.DAO;

import com.revature.model.Album;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AlbumDAOInterface {

    public ArrayList<Album> getAllAlbums() throws SQLException;
}
