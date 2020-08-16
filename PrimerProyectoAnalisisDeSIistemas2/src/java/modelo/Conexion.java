/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author jacob
 */
public class Conexion {
 
    
        Connection con;
 
String url="jdbc:oracle:thin:@localhost:1521:XE";
 String usuario="SEMINARIO";
 String clave="Abcd.12345";
  
 public Connection conectar(){
 
 try{
 Class.forName( "oracle.jdbc.driver.OracleDriver");
 
 con=DriverManager.getConnection(url, usuario, clave);
 }catch(Exception e){
     System.out.println("Errores "+e);
 }
 return con; 
 }
}
