<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Ingresar/Retirar</title>
	<%@ include file="parciales/cabecera.html" %>
</head>
<body>
<div class="contenedor">
	<h1>Ingreso / Retiro a una cuenta</h1>
            
            <div class="div_form">
                
                <form method="post" action="singresoretiro">
	                
	                <div class="div_radios div_radiosmitad">
	                        <label for="radio_ingresar"><input id="radio_ingresar" type="radio" name="tipo_gestionIR" value="ingresar" > Ingresar</label>
	                        <label for="radio_retirar"><input id="radio_retirar" type="radio" name="tipo_gestionIR" value="retirar" > Retirar</label>
	                </div>
	                
	                <div class="columna_centro">
	                    <label for="text">Cuenta:</label><input id="text" type="text" name="cuenta"><br>
	                   	<label for="textmonto">Monto:</label><input id="textmonto" type="text" name="monto">
	                </div>
                
                    <div class="div_boton">
                        <input type="submit" value="Realizar acción">
                    </div>
                	
                	<div class="res_form"><%= request.getAttribute("respuesta") %></div> 
                
                	<%@ include file="parciales/footer.html" %>
                                    
                </form>
                
            </div>
</div>
</body>
</html>