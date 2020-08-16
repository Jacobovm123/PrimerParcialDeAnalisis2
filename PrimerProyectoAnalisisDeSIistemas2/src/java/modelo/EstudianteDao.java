/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacob
 */
public class EstudianteDao {
    
    PreparedStatement ps; 
    ResultSet rs;
    Conexion c= new Conexion ();
    Connection con ;
    
    public List listar (){
    List <Estudiante>lista =new ArrayList <>();
   String sql ="select *from usuario";
    
    try{
    con = c.conectar(); 
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while (rs.next()){
        Estudiante u= new Estudiante();
        u.setId(rs.getString(1));
          u.setNombre(rs.getString(2));
            u.setApellido(rs.getString(3));
              u.setPass(rs.getString(4));
                u.setCorreo(rs.getString(5));
                  u.setUsuario(rs.getString(6));
                    u.setCargo(rs.getString(7));
                    
                    lista.add(u);

    }
    
    }
    catch(Exception e){

    }
    return lista;
    }
     
    public int agregar(Estudiante p){
        int r=0;
    String sql ="insert into usuario (nombre,apellido,pass,correo,usuario,cargo)values(?,?,?,?,?,?)";
    try{
    con=c.conectar();
    ps=con.prepareStatement(sql);
   // ps.setString(1,p.getId());
      ps.setString(1,p.getNombre());
        ps.setString(2,p.getApellido());
    
      ps.setString(3,p.getPass());
    
      ps.setString(4,p.getCorreo());
    
      ps.setString(5,p.getUsuario());
    
      ps.setString(6,p.getCargo());
    
    
    
    
    
    
   r= ps.executeUpdate();
    if(r==1){
    r=1;
    }else{
    r=0;
    
    }
    }
    catch(Exception e){
    
    
    }
    return r;
    }
    


    
    
    
    public Estudiante listarId(String id){
        
    String sql ="select *from usuario where id_usuario="+id;
    Estudiante u =new Estudiante();
    try {
    con=c.conectar();
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while(rs.next()){
    
    u.setId(rs.getString(1));
       u.setNombre(rs.getString(2));
          u.setApellido(rs.getString(3));
             u.setPass(rs.getString(4));
                u.setCorreo(rs.getString(5));
                   u.setUsuario(rs.getString(6));
                      u.setCargo(rs.getString(7));
    
    
    }
    
    
    }
    catch(Exception e){
    
    
    }
    return u;
    }

    public Estudiante listarCorreo(String correo){
        
        System.out.println(correo);
    String sql ="select * from usuario where correo='"+correo+"'";
    Estudiante u = new Estudiante();
    try {
    con=c.conectar();
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while(rs.next()){
    
    u.setId(rs.getString(1));
       u.setNombre(rs.getString(2));
          u.setApellido(rs.getString(3));
             u.setPass(rs.getString(4));
                u.setCorreo(rs.getString(5));
                   u.setUsuario(rs.getString(6));
                      u.setCargo(rs.getString(7));
    
    
    }
    
    
    }
    catch(Exception e){
        System.out.println("Error del correo "+e);
    
    }
    return u;
    }
  public Estudiante listarCargo(String cargo){
        
        System.out.println(cargo);
    String sql ="select * from usuario where cargo='"+cargo+"'";
    Estudiante u = new Estudiante();
    try {
    con=c.conectar();
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while(rs.next()){
    
    u.setId(rs.getString(1));
       u.setNombre(rs.getString(2));
          u.setApellido(rs.getString(3));
             u.setPass(rs.getString(4));
                u.setCorreo(rs.getString(5));
                   u.setUsuario(rs.getString(6));
                      u.setCargo(rs.getString(7));
    
    
    }
    
    
    }
    catch(Exception e){
        System.out.println("Error del correo "+e);
    
    }
    return u;
    }

    
    public int actualizar (Estudiante u){
        int r=0;
    String  sql="update usuario set nombre=?,apellido=?,pass=?,correo=?,usuario=?,cargo=? where id_usuario=? ";
    try{   
        con=c.conectar();
    ps=con.prepareStatement(sql);
    
    ps.setString(1,u.getNombre());
        ps.setString(2,u.getApellido());
            ps.setString(3,u.getPass());
                ps.setString(4,u.getCorreo());
                    ps.setString(5,u.getUsuario());
                        ps.setString(6,u.getCargo());
                           ps.setInt(7,Integer.parseInt(u.getId()));
                        
                        
                           
  r=ps.executeUpdate();
    
    if(r==1){
    
    r=1;
    
    }else{
    r=0;
            
    
    }
    }
    catch(Exception e){
            
            }
    return r;
    }
    
    
    public void delete(String id)
    {
    
    String sql="delete from usuario where id_usuario=?";
    
    try{
        System.out.println("Codigo"+id);
        con=c.conectar();
        ps=con.prepareStatement(sql);
               ps.setInt(1,Integer.parseInt(id));
        ps.executeUpdate();
    }
    catch (Exception e){
    
        System.out.println("Error al eliminar"+e);
            
    
    }
    
    
    }    
}
