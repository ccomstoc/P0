package com.revature.DAO;

import com.revature.exceptions.UnfoundIdException;
import com.revature.model.Person;

import java.sql.SQLException;

public interface PersonDAOInterface {

    //Requires a person object supplied must have an id
    public Person updatePerson(Person person) throws SQLException, UnfoundIdException;

}
