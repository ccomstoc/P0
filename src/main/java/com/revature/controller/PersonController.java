package com.revature.controller;

import com.revature.DAO.PersonDAO;
import com.revature.exceptions.CannotBeNullException;
import com.revature.exceptions.UnfoundIdException;
import com.revature.model.Person;
import com.revature.service.PersonService;
import io.javalin.http.Handler;

import java.sql.Connection;
import java.sql.SQLException;

public class PersonController extends Controller{
    private PersonService personService;

    public PersonController(Connection con){
        personService = new PersonService(con);
    }

    public Handler insertPersonHandler = ctx-> {

        if(AuthController.ses == null){
            ctx.status(401);
            return;
        }

        try {
            Person person = ctx.bodyAsClass(Person.class);
            ctx.json(personService.insertPerson(person));
        } catch(SQLException e){
            ctx.status(500);//Not certain, input validation needed
            e.getMessage();
            log.error("Insert person sql failed");
        } catch(CannotBeNullException e){
            ctx.status(400);
            log.warn(e.toString());
        }

    };

    public Handler updatePersonHandler = ctx ->{

        if(AuthController.ses == null){
            ctx.status(401);
            return;
        }
        try {
            Person person = ctx.bodyAsClass(Person.class);
            ctx.json(personService.updatePerson(person));
        } catch(SQLException e){
            ctx.status(500);//Not certain, input validation needed
            e.getMessage();
            log.warn("Update person sql failed");
        } catch(UnfoundIdException e){
            ctx.status(400);
            log.warn(e.toString());
        }
    };

    public Handler lengthOfCollectionsHandler = ctx -> {

        if(AuthController.ses == null){
            ctx.status(401);
            return;
        }

        try {
            ctx.json(personService.lengthOfCollections());
        } catch(SQLException e){
            ctx.status(500);
            e.printStackTrace();
            System.out.println("Length of collections failed");
        }

    };
}
