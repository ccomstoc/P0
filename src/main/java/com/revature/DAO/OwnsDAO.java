package com.revature.DAO;

import com.revature.model.Owns;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OwnsDAO {

    private final Connection con;

    public OwnsDAO(Connection con){
        this.con = con;
    }

    public Owns insertOwnsRelationship(Owns owns) throws SQLException {

        PreparedStatement ps = con.prepareStatement("insert into owns(person_id_fk,album_id_fk) values(?,?);");
        ps.setInt(1,owns.getPerson_id_fk());
        ps.setInt(2,owns.getAlbum_id_fk());
        ps.executeUpdate();

        return owns;

    }

}
