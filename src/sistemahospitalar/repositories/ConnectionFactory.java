/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemahospitalar.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author victo
 */
public class ConnectionFactory {
    
    private String drive = "com.mysql.cj.jdbc.Driver";
    private String url  = "jdbc:mysql://localhost:3306/jvadm?useTimezone=true&serverTimezone=UTC";
    private String user = "root";
    private String psw  = "123456";
        
    public Connection getConnection()  {
	try {
            Class.forName(drive);  
            return DriverManager.getConnection(url, user, psw);
	}catch(SQLException e) {
            throw new RuntimeException("1- Erro ao conectar com o banco: " + e);
	} catch (ClassNotFoundException e) {
            throw new RuntimeException("2- Erro ao conectar com o banco: " + e);
        }
    }
}
