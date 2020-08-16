<%-- 
    Document   : IngresarEstudiante
    Created on : 15/08/2020, 06:45:20 PM
    Author     : jacob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
    <body>
    <center>
        
    
          
              <div class="page-header">
              
                  <h1> ingresar Estudiante</h1>              
          </div>
              
              
        <div class="form-group">
        
            <form align="left" action="ControladorEstudiante" method="POST">
             
          
                    

               <br>
               NOMBRE:
               <input   class="form-control"  placeholder="nombre" type="text" name="txtnombre">
               <br>
               APELLIDO:
               <input   class="form-control" placeholder="apellido" type="text" name="txtapellido">
               <br>
               PASS:
               <input  class="form-control"   placeholder="contraseña" type="text" name="txtpass">
               <br>
               CORREO:
               <input  class="form-control"  placeholder="mail" type="email" name="txtcorreo">
               <br>
               USUARIO:
               <input class="form-control"  placeholder="usuario" type="text" name="txtusuario">
               <br>
               CARGO:
               <input   class="form-control" placeholder="cargo" type="text" name="txtcargo">
               
               <input  class="btn btn-success"  type="submit" name="accion"  value="Guardar">
              
            </form>
               
        </div>
        
    </center>
        
        
   <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
