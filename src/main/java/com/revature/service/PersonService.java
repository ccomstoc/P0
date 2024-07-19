package com.revature.service;

import com.revature.DAO.PersonDAO;
import com.revature.model.Person;

import java.sql.Connection;
import java.sql.SQLException;

public class PersonService {

    PersonDAO personDAO;

    public PersonService(Connection con) {
        personDAO = new PersonDAO(con);
    }

    public Person insertPerson(Person person) throws SQLException {
        return personDAO.insertPerson(person);
    }
    public Person updatePerson(Person person) throws SQLException{
        return personDAO.updatePerson(person);
    }
}
