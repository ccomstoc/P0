package com.revature.DAO;

import com.revature.exceptions.AlbumAlreadyExistsException;
import com.revature.model.Album;
import org.postgresql.util.PGInterval;

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

    @Override
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
    @Override
    public Album getAlbumByNameAndArtist(String albumName, String artistName) throws SQLException{
        PreparedStatement ps = con.prepareStatement("select * from album where album_name = ? and artist_name = ?");
        ps.setString(1,albumName);
        ps.setString(2,artistName);
        ResultSet rs = ps.executeQuery();
        Album album = null;
        while(rs.next()) {
            album = new Album(
                    rs.getInt("album_id_pk"),
                    rs.getString("album_name"),
                    rs.getString("artist_name"),
                    rs.getInt("year_released"),
                    rs.getString("duration")
            );
        }
        return album;
    }

    @Override
    public Album insertAlbum(Album album) throws SQLException, AlbumAlreadyExistsException {

        //check if album already exsists
        if(getAlbumByNameAndArtist(album.getAlbum_name(),album.getArtist_name()) != null){
            throw new AlbumAlreadyExistsException("The Album you are trying to insert already exsits!");

        }

        PreparedStatement ps = con.prepareStatement("insert into album(album_name,artist_name,year_released,duration) values(?,?,?,?) RETURNING album_id_pk;");
        ps.setString(1,album.getAlbum_name());
        ps.setString(2, album.getArtist_name());
        ps.setInt(3,album.getYear_released());
        ps.setObject(4,new PGInterval(album.getDuration()));
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("album_id_pk");
            album.setAlbum_id_pk(id); // Assuming Album class has a setId method
        }
        return album;
    }

    public Album deleteAlbumById(int id) throws SQLException {
        Album beingDeleted = getAlbumById(id);
        //Removes entry's in owns, if an album doesn't exist, you cant own it
        PreparedStatement ps = con.prepareStatement("delete from owns where album_id_fk = ?");
        ps.setInt(1,id);
        ps.executeUpdate();
        //Remove the album
        ps = con.prepareStatement("delete from album where album_id_pk = ?");
        ps.setInt(1,id);
        ps.executeUpdate();
        return beingDeleted;
    }

    public Album getAlbumById(int id) throws SQLException {
        PreparedStatement ps = con.prepareStatement("select * from album where album_id_pk = ?");
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        Album album = null;
        while(rs.next()) {
            album = new Album(
                    rs.getInt("album_id_pk"),
                    rs.getString("album_name"),
                    rs.getString("artist_name"),
                    rs.getInt("year_released"),
                    rs.getString("duration")
            );
        }
        return album;

    }


}
