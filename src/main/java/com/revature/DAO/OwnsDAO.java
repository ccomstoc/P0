package com.revature.DAO;

import com.revature.exceptions.UnfoundIdException;
import com.revature.model.Owns;
import com.revature.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OwnsDAO {

    private final Connection con;

    public OwnsDAO(Connection con){
        this.con = con;
    }

    public Owns insertOwnsRelationship(Owns owns) throws SQLException, UnfoundIdException {

        PersonDAO personDAO = new PersonDAO(con);
        AlbumDAO albumDAO = new AlbumDAO(con);

        if(personDAO.getPersonById(owns.getPerson_id_fk()) == null || albumDAO.getAlbumById(owns.getAlbum_id_fk()) == null)
            throw new UnfoundIdException("Either the Person id or Album id could not be found");


        PreparedStatement ps = con.prepareStatement("insert into owns(person_id_fk,album_id_fk) values(?,?);");
        ps.setInt(1,owns.getPerson_id_fk());
        ps.setInt(2,owns.getAlbum_id_fk());
        ps.executeUpdate();

        return owns;

    }

}
