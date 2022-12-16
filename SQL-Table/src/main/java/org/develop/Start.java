package org.develop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Start {

    public static void main(String[] args) {

        Connection con = null;

        try{
            String url = "jdbc:mysql://localhost:3306/newdb";
            String user = "root";
            String password = "PinoDaniele03";

            con = DriverManager.getConnection(url, user, password);

            Statement s = con.createStatement();

            String sql = "CREATE TABLE student " +
                         "(student_id INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                         " last_name VARCHAR(30), " +
                         " first_name VARCHAR(30))";

            s.executeUpdate(sql);

            s.executeUpdate("INSERT INTO newdb.student (last_name, first_name) VALUES('De Fenzo', 'Marco');");
            s.executeUpdate("INSERT INTO newdb.student (last_name, first_name) VALUES('Vassarotti', 'Vittoria');");
            s.executeUpdate("INSERT INTO newdb.student (last_name, first_name) VALUES('Di Leo', 'Luca');");
            s.executeUpdate("INSERT INTO newdb.student (last_name, first_name) VALUES('Mustata', 'Alina Elena');");


        }catch(SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            try{
                if(con != null){
                    con.close();
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}

