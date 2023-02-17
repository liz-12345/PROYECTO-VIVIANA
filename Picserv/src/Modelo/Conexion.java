package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private String bd="Picserv_Proyect1";
    private String url="jdbc:mysql://localhost:3306/"+bd;
    private String user="root";
    private String pass="";
    Connection connec=null;

    public Connection conecta(){

        try {
            connec= DriverManager.getConnection(url,user,pass);
            System.out.println("Conexion exitosa...");

        }catch (SQLException e){
            System.out.println("Conexion fallida."+e);

        }
        return connec;
    }

}
