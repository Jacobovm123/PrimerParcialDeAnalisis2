/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jacob
 */
public class Estudiante {
    
    String id;
     String nombre;
      String apellido;
       String pass;
        String correo;
         String usuario;
         String cargo;

    public Estudiante() {
        
    }
        public Estudiante (String id,String nombre,String apellido,String pass,String correo,String usuario,String  cargo){
        
        this.id=id;
        this.nombre=nombre;
        this.apellido=apellido;
        this.pass=pass;
        this.correo=correo;
        this.usuario=usuario;
        this.cargo=cargo;
        
        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
        
        
        
}
