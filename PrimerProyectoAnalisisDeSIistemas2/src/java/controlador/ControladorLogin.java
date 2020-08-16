/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Estudiante;
import modelo.EstudianteDao;
import modelo.Google_Token_Claims_Model;
import modelo.JWTDecoder;
import modelo.Tokens_Model;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author jacob
 */
@WebServlet(name = "ControladorLogin", urlPatterns = {"/ControladorLogin"})
public class ControladorLogin extends HttpServlet {
   private String redirectURI="http://localhost:8084/webDinamica/ControladorLogin";
    private String client_ID="27541583904-heskbclek74h13abqe3cqurmvpanv71n.apps.googleusercontent.com";
    private String client_secret="AH_o-NfWHsSp77m85l7n4sPp";

    
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
        
        if(request.getParameter("code")==null){
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        }
        
        HttpClient client = HttpClientBuilder.create().build();
	HttpPost post = new HttpPost("https://www.googleapis.com/oauth2/v4/token?code="+request.getParameter("code")+"&client_id="+this.client_ID+"&client_secret="+this.client_secret+"&redirect_uri="+this.redirectURI+"&grant_type=authorization_code");

	// add header
	post.setHeader("Content-Type", "application/x-www-form-urlencoded");


        HttpResponse response2=client.execute(post);

	    BufferedReader rd = new BufferedReader(
	        new InputStreamReader(response2.getEntity().getContent()));

        StringBuilder result = new StringBuilder();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        Tokens_Model tokens= new Gson().fromJson(result.toString(),Tokens_Model.class);

        Google_Token_Claims_Model claimsGoogle=new Gson().fromJson(JWTDecoder.getClaims(tokens.id_token),Google_Token_Claims_Model.class);


        EstudianteDao nue = new EstudianteDao();
        Estudiante ab = new Estudiante();
        //String cargo = null;
       
       // ab =nue.listarCargo(cargo);
        ab = nue.listarCorreo(claimsGoogle.email);
        
        System.out.println(ab.getCorreo());
        
        if(ab.getCorreo()!=null && ab.getCargo()!=null){
          
            Cookie cookie=new Cookie("token_de_sesion",tokens.id_token);
            response.addCookie(cookie);
            
                   if(ab.getCargo().equals("admin")){
                
                       HttpSession session = request.getSession();
                       session.setAttribute("cargo",ab.getCargo());
                        session.setAttribute("correo",ab.getCorreo());
                         session.setAttribute("id_usuario",ab.getId());
                        
                        
                       
                       response.sendRedirect("MenuAdmin.jsp");
                   }
                   else
                        if(ab.getCargo().equals("user")){
                
                            
                            
                            
                            response.sendRedirect("MenuUser.jsp");
        
                   }

                        
                   else
                   {
                   // if(ab.getCargo().equals("userjjj")){
                response.sendRedirect("error.jsp");
                   }
                //   }

            } 
        
        
        else {
            System.out.println("Invalid ID token.");
            response.sendRedirect("error.jsp");
            
        }
        
        
        
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
        processRequest(request, response);
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
