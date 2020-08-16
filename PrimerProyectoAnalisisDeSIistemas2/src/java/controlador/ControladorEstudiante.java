/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Estudiante;
import modelo.EstudianteDao;

/**
 *
 * @author jacob
 */
@WebServlet(name = "ControladorEstudiante", urlPatterns = {"/ControladorEstudiante"})
public class ControladorEstudiante extends HttpServlet {

    
    EstudianteDao dao= new  EstudianteDao();
Estudiante u=new Estudiante ();
    /**
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorEstudiante</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorEstudiante at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
    
        String accion =request.getParameter("accion");
      
           switch(accion){
               case "Listar":
    request.getRequestDispatcher("EstudianteListar.jsp").forward(request, response);
 
    break;
    case"Nuevo":
    request.getRequestDispatcher("IngresarEstudiante.jsp").forward(request, response);

    break;
    case "Guardar":
        
       // String id=request.getParameter("txtid");
                String nombre=request.getParameter("txtnombre");
                        String apellido=request.getParameter("txtapellido");
                                String pass=request.getParameter("txtpass");
                                        String correo=request.getParameter("txtcorreo");
                                                String usuario=request.getParameter("txtusuario");
                                                        String cargo=request.getParameter("txtcargo");
                                                      //  u.setId(id);
                                                        u.setNombre(nombre);
                                                        u.setApellido(apellido);
                                                        u.setPass(pass);
                                                           u.setCorreo(correo);
                                                        u.setUsuario(usuario);
                                                        u.setCargo(cargo);
                                                            
                                                            dao.agregar(u);
                                                            request.getRequestDispatcher("ControladorEstudiante?accion=Listar").forward(request, response);
        break;
        
    case "Editar":
        String ide=request.getParameter("id");
     
        Estudiante ue=dao.listarId(ide);
           request.setAttribute("usuario", ue);
        request.getRequestDispatcher("EditarEstudiante.jsp").forward(request, response);
        break;
        
    case "Actualizar":
        String id1=request.getParameter("txtid");
          String nom=request.getParameter("txtnombre");
            String ape=request.getParameter("txtapellido");
              String pas=request.getParameter("txtpass");
                String cor=request.getParameter("txtcorreo");
                  String us=request.getParameter("txtusuario");
                    String car=request.getParameter("txtcargo");
                    
                    u.setId(id1);
                    u.setNombre(nom);
                    u.setApellido(ape);
                    u.setPass(pas);
                    u.setCorreo(cor);
                    u.setUsuario(us);
                    u.setCargo(car);
                    
                    dao.actualizar(u);
                    request.getRequestDispatcher("ControladorEstudiante?accion=Listar").forward(request, response);
                    
                    
        
        break;
        
        
    case "Delete":
       String id3=request.getParameter("id");
      
                 dao.delete(id3);
                   request.getRequestDispatcher("ControladorEstudiante?accion=Listar").forward(request, response);
                    
       
        
        break;
    
default:
    throw new AssertionError();

}    
        
    
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
