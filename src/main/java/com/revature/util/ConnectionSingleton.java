package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {


    private static final String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=p0schema";
    private static final String username = "postgres";
    private static final String password = "password";

    //Private default constructor prevents instantiation of object
    private ConnectionSingleton(){

    }

    public static Connection establishConnection(){

        try {
            Class.forName("org.postgresql.Driver");//Locate postgres driver
            return DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            System.out.println("Exception occurred when getting db connection");
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch(ClassNotFoundException e){
            System.out.println("Exception occurred when loading postgresql driver");
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }
}
