package com.revature.DAO;

import com.revature.model.Album;

import java.sql.*;
import java.util.ArrayList;

public class AlbumDAO implements AlbumDAOInterface {

    private final Connection con;

    public AlbumDAO(Connection con){
        this.con = con;
    }

    @Override
    public ArrayList<Album> getAllAlbums() throws SQLException {

        ArrayList<Album> albumArray = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("Select * from album");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            //album_id_pk, String album_name, String artist_name, int year_released, String duration
            Album a = new Album(
                    rs.getInt("album_id_pk"),
                    rs.getString("album_name"),
                    rs.getString("artist_name"),
                    rs.getInt("year_released"),
                    rs.getString("duration")
            );
            albumArray.add(a);
        }

    return albumArray;
    }

    public ArrayList<Album> getAlbumsByPersonId(int userId) throws SQLException {

        ArrayList<Album> albumArray = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("select album_id_pk,album_name,artist_name,year_released,duration \n" +
                "from person,owns,album \n" +
                "where person.person_id_pk = ? " +
                "and person.person_id_pk = owns.person_id_fk " +
                "and album.album_id_pk = owns.album_id_fk;");
        ps.setInt(1,userId);
        ResultSet rs = ps.executeQuery();

            while(rs.next()){
            //album_id_pk, String album_name, String artist_name, int year_released, String duration
            Album a = new Album(
                    rs.getInt("album_id_pk"),
                    rs.getString("album_name"),
                    rs.getString("artist_name"),
                    rs.getInt("year_released"),
                    rs.getString("duration")
            );
            albumArray.add(a);
        }

        return albumArray;
    }

}
