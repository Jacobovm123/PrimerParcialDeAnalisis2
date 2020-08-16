<%@page import="modelo.ProcesoPaso"%>
<%@page import="java.util.List"%>
<%@page import="modelo.ProcesoPasoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
    <body    >
<div class="container">
    <div class="row">
        <h3 class="text-center" class="text-warning">Menú  admin </h3>
    
    
        <div class="col-md-12">
            <div class="text-center">
                  <div class="btn-group">
                    <button class="btn btn-success dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"> Usuario <span class="caret"></span></button>
                    <ul class="dropdown-menu">
                     
                        <li><a href="usuario.jsp">Listar Usuario</a></li>
                    
                  
                    </ul>
                </div>
               
                <div class="btn-group">
                    <button class="btn btn-success dropdown-toggle" data-toggle="dropdown" data-hover="dropdown">listar plantillas <span class="caret"></span></button>
                    <ul class="dropdown-menu">
                        <li><a href="ListarPlantilla2.jsp">Listar plantillas</a></li>
                  
                        <li class="divider"></li>
                     
                    </ul>
                    
                    
               
                </div>
                <div class="btn-group">
                    <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" data-hover="dropdown">Listar plantilla campo <span class="caret"></span></button>
                    <ul class="dropdown-menu">
                        <li><a href="ListarPlantillaCampo.jsp">listar plantilla campo</a></li>
                   
                   
                        <li class="divider"></li>
                  
                    </ul>
                </div>
                <div class="btn-group">
                    <button class="btn btn-warning dropdown-toggle" data-toggle="dropdown" data-hover="dropdown">Listar plantilla paso <span class="caret"></span></button>
                    <ul class="dropdown-menu">
                        <li><a href="ListarPlantillaPaso.jsp"> Listar plantilla paso</a></li>
             
                        <li class="divider"></li>
              
                    </ul>
                </div>
       
              
                <div class="btn-group">
                    <button class="btn btn-info dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"> Listar paso campo comportammiento <span class="caret"></span></button>
                    <ul class="dropdown-menu">
                        <li><a href="ListarPasoCampoComportamiento.jsp"> Listar Paso comportamiento </a></li>
                       
                        <li class="divider"></li>
                    
                    </ul>
                </div>
                
                   <div class="btn-group">
                    <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" data-hover="dropdown">listar proceso <span class="caret"></span></button>
                    <ul class="dropdown-menu">
                        <li><a href="ListarProceso.jsp">listar proceso</a></li>
                        <li class="divider"></li>
                    </ul>
                </div>
                
                   <div class="btn-group">
                    <button class="btn btn-warning dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"> lista de proceso pasos<span class="caret"></span></button>
                    <ul class="dropdown-menu">
           
                          <li><a href="ListarProcesoPaso.jsp">lista de proceso paso</a></li>
                   
                        <li class="divider"></li>
             
                    </ul>
                </div>
       
                  <div class="btn-group">
                    <button class="btn btn-warning dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"> lista de proceso campo <span class="caret"></span></button>
                    <ul class="dropdown-menu">
                   
                          <li><a href="ListarProcesoCampo.jsp">lista de proceso campo</a></li>
                   
                        <li class="divider"></li>
             
                    </ul>
                </div>
       
                  <div class="btn-group">
                    <button class="btn btn-warning dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"> lista campo comportamiento procesos <span class="caret"></span></button>
                    <ul class="dropdown-menu">
                        <li><a href="ListarCampoComportamiento.jsp">lista campo comportamieno procesos<a></li>
                       
                   
                        <li class="divider"></li>
             
                    </ul>
                </div>
                
                
                   
    <center>
      
                
            <div lass="form-group">
            <table class="table table-striped"  id="display-table" >
                <thead>
                    
                    <tr>
                      <th>ID PASO</th>
                        <th>ID PROCESO</th>
                   
                         <th>NOMBRE PASO PROCESO </th>
                             <th> PASO ESTADO</th>
                             <th> PASOS</th>
                                     <th>FECHA </th>
                         
                                 <th>APROBADORES </th>
                    
                         
                         
                        
                        
                    </tr>
                </thead>   
                <tbody>
                       
                    
                    <%
                    ProcesoPasoDAO dao = new ProcesoPasoDAO();
                    String idusuario = (String)session.getAttribute("id_usuario");
                    List<ProcesoPaso>datos=dao.listarpasot(idusuario);
                    
for (int i = 0; i < datos.size(); i++) {
       
        %>
                
        <tr>
            
                <td><%=datos.get(i).getId() %></td>
                <td><%=datos.get(i).getId_proceso()%></td>
                <td><%=datos.get(i).getNombre_paso_proceso()%></td> 
                <td><%=datos.get(i).getPaso_estado()%></td>
                <td><%=datos.get(i).getPasos()%></td>
           
                      <td><%=datos.get(i).getFecha()%></td>
                            <td><%=datos.get(i).getAprobadores()%></td>
                          
                
                       <td>
                                        
                
              
                </tr>           
                
        <%
    }
                    %>
                    
                    
                    
                </tbody>
                
            </table>
            
            
        </div>        
        
        
    </center>
                
                
    <script>
highlight_row();
function highlight_row() {
    var table = document.getElementById('display-table');
    var cells = table.getElementsByTagName('td');

    for (var i = 0; i < cells.length; i++) {
        // Take each cell
        var cell = cells[i];
        // do something on onclick event for cell
        cell.onclick = function () {
            // Get the row id where the cell exists
            var rowId = this.parentNode.rowIndex;

            var rowsNotSelected = table.getElementsByTagName('tr');
            for (var row = 0; row < rowsNotSelected.length; row++) {
                rowsNotSelected[row].style.backgroundColor = "";
                rowsNotSelected[row].classList.remove('selected');
            }
            var rowSelected = table.getElementsByTagName('tr')[rowId];
            rowSelected.style.backgroundColor = "#00FFFF";
            rowSelected.className += " selected";

       var url ="http://localhost:8084/webDinamica/procesopaso.jsp?idpro=";
       url += rowSelected.cells[0].innerText;
       url +="&idpas=";
       url +=rowSelected.cells[1].innerText;
       window.location.replace(url);
       
        }
    }

}
</script>   
                
                
                
            </div>
        </div>
    </div>
</div>
        
  

    </body>

    
    
 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>