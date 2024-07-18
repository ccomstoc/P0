package com.revature;

import com.revature.util.ConnectionSingleton;

import java.sql.*;

public class Driver {

    public static void main(String[] args){

        //Get Connection Singleton

            Connection con = ConnectionSingleton.establishConnection();






    }
}
