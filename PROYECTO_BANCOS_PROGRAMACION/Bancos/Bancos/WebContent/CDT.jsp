<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Gestión de CDT</title>
	<%@ include file="parciales/cabecera.html" %>
</head>
<body>
<div class="contenedor">
	<h1>Gestión de CDT</h1>
            
            <div class="div_form">
                
                <form method="post" action="sgestioncdt">
	                
	                <div class="div_radios div_radiosmitad">
	                        <label for="radio_crear"><input id="radio_crear" type="radio" name="tipo_gestion" value="crear" > Crear CDT </label>
	                        <label for="radio_cerrar"><input id="radio_cerrar" type="radio" name="tipo_gestion" value="cerrar" > Cerrar CDT</label>
	            	</div>
	                
	                <div class="columna_mitad">
	                        <label for="textcuenta">Cuenta:</label><input id="textcuenta" type="text" name="cuenta"><br>
	                        <label for="textinteres">Interés:</label><input id="textinteres" type="text" name="interes"><br>
	                        <label for="textmonto">Monto:</label><input id="textmonto" type="text" name="monto">
	                </div>
	                <div class="columna_mitad columna_cdt">
	                        <label for="textcdt">CDT:</label><input id="textcdt" type="text" name="cdt">
	                </div>
                
                    <div class="div_boton">
                        <input type="submit" value="Realizar accion">
                    </div>
                	
                	<div class="res_form"><%= request.getAttribute("respuesta") %></div> 
                
                	<%@ include file="parciales/footer.html" %>
                                    
                </form>
                
            </div>
</div>
</body>
</html>