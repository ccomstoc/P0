package com.revature.service;
import com.revature.exceptions.UnfoundIdException;
import com.revature.model.Owns;

import com.revature.DAO.OwnsDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class OwnsService {

    private OwnsDAO ownsDAO;

    public OwnsService(Connection con){
        ownsDAO = new OwnsDAO(con);
    }

    public Owns insertOwnsRelationship(Owns owns) throws SQLException, UnfoundIdException {

        return ownsDAO.insertOwnsRelationship(owns);

    }

}
