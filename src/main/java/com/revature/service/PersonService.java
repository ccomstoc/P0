package com.revature.service;

import com.revature.DAO.PersonDAO;
import com.revature.exceptions.CannotBeNullException;
import com.revature.exceptions.UnfoundIdException;
import com.revature.model.Person;
import com.revature.model.TimeListenedDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class PersonService {

    PersonDAO personDAO;

    public PersonService(Connection con) {
        personDAO = new PersonDAO(con);
    }

    public Person insertPerson(Person person) throws SQLException, CannotBeNullException {
        return personDAO.insertPerson(person);
    }
    public Person updatePerson(Person person) throws SQLException, UnfoundIdException {
        return personDAO.updatePerson(person);
    }
    public ArrayList<TimeListenedDTO> lengthOfCollections() throws SQLException {
        return personDAO.lengthOfCollections();
    }
}
