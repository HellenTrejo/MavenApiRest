package com.example.rest.util;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Instructor
 */
public class ConectaDB {

        public Connection getAcceso() throws Exception {
        	Class.forName("com.mysql.jdbc.Driver");
        	
        	//Connection conn = DriverManager.getConnection("jdbc:mysql://node226524-env-9216254.j.layershift.co.uk/bd_colegio_damii","root","BIXxbb83692");
        	//
        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_colegio_damii","root","mysql");
           	
        return conn;
    }
}
