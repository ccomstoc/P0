package com.revature.controller;

import com.revature.DAO.PersonDAO;
import com.revature.model.Person;
import com.revature.service.PersonService;
import io.javalin.http.Handler;

import java.sql.Connection;
import java.sql.SQLException;

public class PersonController {
    private PersonService personService;

    public PersonController(Connection con){
        personService = new PersonService(con);
    }

    public Handler insertPersonHandler = ctx-> {

        try {
            Person person = ctx.bodyAsClass(Person.class);
            ctx.json(personService.insertPerson(person));
        } catch(SQLException e){
            ctx.status(500);//Not certain, input validation needed
            e.printStackTrace();
            System.out.println("Insert person sql failed");
        }

    };

    public Handler updatePersonHandler = ctx ->{
        try {
            Person person = ctx.bodyAsClass(Person.class);
            ctx.json(personService.updatePerson(person));
        } catch(SQLException e){
            ctx.status(500);//Not certain, input validation needed
            e.printStackTrace();
            System.out.println("Update person sql failed");
        }
    };

    public Handler lengthOfCollectionsHandler = ctx -> {

        try {
            ctx.json(personService.lengthOfCollections());
        } catch(SQLException e){
            ctx.status(500);
            e.printStackTrace();
            System.out.println("Length of collections failed");
        }

    };
}
