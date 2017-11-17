/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection getConnection() throws Tratamentos{
        Connection conn = null;
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/agendadb", "SA", "");
            
        } catch (SQLException e) {
            System.out.println("Connection1");
            throw  new Tratamentos("Problemas ao conectar no banco de dados 1111");
        } catch (ClassNotFoundException e) {
            System.out.println("Connection2");
            throw  new Tratamentos("Problemas ao conectar no banco de dados 22222");
        }

        return conn;
    }
}
