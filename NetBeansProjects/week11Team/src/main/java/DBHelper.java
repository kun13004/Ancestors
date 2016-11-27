/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elgalad
 */
public class DBHelper {
    // JDBC driver name and database URL
   static final String JDBC_DRIVER = "org.postgresql.Driver";  
   //static final String DB_URL = "jdbc:postgresql://ec2-54-243-54-21.compute-1.amazonaws."
     //      + "com:5432/d1ci1fmm9irifj?user=hugtqfrjvkgjma&password=7dj1BOGitBNwtoO_b0dJzI9Jfg&sslmode=require";
   //static final String DB_URL = System.getenv("JDBC_DATABASE_URL");
   // Person table
   static final String T_PERSON = "person";
   static final String FIRST_NAME = "first_name";
   static final String LAST_NAME = "last_name";
   static final String BIRTH_DATE = "birth_date";
   static final String LOCAL_DATABASE_URL = "jdbc:postgresql://localhost:5432/ancestors?user=postgres&password=Deddinsed2";
   //Tim's local DB settings
   //static final String LOCAL_DATABASE_URL = "jdbc:postgresql://localhost:5432/ancestors?user=postgres&password=oumtg8k";

   
   // Relation table
   static final String T_RELATION = "relation";
   static final String FK_PARENT = "parent_id";
   static final String FK_CHILD = "child_id";
    
    public void createPersonTable() {
        Connection conn = null;
        Statement stmt = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            String DATABASE_URL = System.getenv("JDBC_DATABASE_URL");
            if (DATABASE_URL == null) {
                DATABASE_URL = LOCAL_DATABASE_URL;
                
            
            conn = DriverManager.getConnection(DATABASE_URL);
            stmt = conn.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS " + T_PERSON +
                   "(id SERIAL PRIMARY KEY, " +
                   FIRST_NAME + " VARCHAR(255) NOT NULL, " + 
                   LAST_NAME + " VARCHAR(255) NOT NULL, " + 
                   BIRTH_DATE + " VARCHAR(255) NOT NULL,"
                    + "UNIQUE (" + FIRST_NAME + ", " + LAST_NAME + ", " + BIRTH_DATE + "))";
            stmt.executeUpdate(sql);
            }
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void createRelationsTable() {
        Connection conn = null;
        Statement stmt = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            String DATABASE_URL = System.getenv("JDBC_DATABASE_URL");
            if (DATABASE_URL == null) {
                DATABASE_URL = LOCAL_DATABASE_URL;
            }
            conn = DriverManager.getConnection(DATABASE_URL);
            stmt = conn.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS" + T_RELATION +
                   "(id SERIAL PRIMARY KEY, " +
                   FK_PARENT + " INTEGER REFERENCES " + T_PERSON + " (id)," + 
                   FK_CHILD + " INTEGER REFERENCES " + T_PERSON + " (id))";
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
           Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    
    public void insertIntoPersonTable(String first_name, String last_name, String birth_date) {
        Connection conn = null;
        Statement stmt = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            String DATABASE_URL = System.getenv("JDBC_DATABASE_URL");
            if (DATABASE_URL == null) {
                DATABASE_URL = LOCAL_DATABASE_URL;
            }
            conn = DriverManager.getConnection(DATABASE_URL);
            stmt = conn.createStatement();
            
            String sql = "INSERT INTO " + T_PERSON +
                    "(" + FIRST_NAME + ", " + LAST_NAME + ", " + BIRTH_DATE + ") "
                    + "VALUES (" + first_name + ", " + last_name + ", " + birth_date;
            stmt.executeUpdate(sql);
            
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
           Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    
    public void insertIntoRelationTable(int fk_parent, int fk_child) {
        Connection conn = null;
        Statement stmt = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            String DATABASE_URL = System.getenv("JDBC_DATABASE_URL");
            if (DATABASE_URL == null) {
                DATABASE_URL = LOCAL_DATABASE_URL;
            }
            conn = DriverManager.getConnection(DATABASE_URL);
            stmt = conn.createStatement();
            
            String sql = "INSERT INTO " + T_PERSON +
                    "(" + FK_PARENT + ", " + FK_CHILD + ") VALUES (" + fk_parent + ", " + 
                    fk_child;
            stmt.executeUpdate(sql);
            
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
           Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    
    public ResultSet queryOnePerson(String first_name) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            String DATABASE_URL = System.getenv("JDBC_DATABASE_URL");
            if (DATABASE_URL == null) {
                DATABASE_URL = LOCAL_DATABASE_URL;
            }
            conn = DriverManager.getConnection(DATABASE_URL);
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM " + T_PERSON + " WHERE " + FIRST_NAME + " = " + first_name;
            rs = stmt.executeQuery(sql);
            
            stmt.executeUpdate(sql);
            
            return rs;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
           Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
       }
        return rs;
    }
    
    
    public ResultSet queryPersonTable() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            String DATABASE_URL = System.getenv("JDBC_DATABASE_URL");
            if (DATABASE_URL == null) {
                DATABASE_URL = LOCAL_DATABASE_URL;
            }
            conn = DriverManager.getConnection(DATABASE_URL);
            stmt = conn.createStatement();
            
            String sql = "SELECT * FROM " + T_PERSON;
            rs = stmt.executeQuery(sql);
            
            stmt.executeUpdate(sql);
            
            return rs;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
           Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
       }
        return rs;
    }
            
}
    
