<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Consultar saldo</title>
	<%@ include file="parciales/cabecera.html" %>
</head>
<body>
<div class="contenedor">
	<h1>Consultar los diferentes tipos de saldo</h1>
            
        <div class="div_form">
                
        	<form method="post" action="sconsultasaldo">
	                
	     	   <div class="div_radios columna_mitad">
	       	   		<label for="radio_cuenta"><input id="radio_cuenta" type="radio" name="tipo_saldo" value="cuenta" > Saldo cuenta</label><br>
	           		<label for="radio_cdt"><input id="radio_cdt" type="radio" name="tipo_saldo" value="cdt" > Saldo CDT</label><br>
	           		<label for="radio_cliente"><input id="radio_cliente" type="radio" name="tipo_saldo" value="cliente" > Saldo cliente</label>
	           </div>
	                
	                <div class="columna_mitad">
	                        <label for="text">Cuenta:</label><input id="text" type="text" name="cuenta">
	                    
	                </div>
                
                    <div class="div_boton">
                        <input type="submit" value="Consultar saldo">
                    </div>
                	
                	<div class="res_form"><%= request.getAttribute("respuesta") %></div> 
                
                	<%@ include file="parciales/footer.html" %>
                                    
                </form>
                
            </div>
</div>
</body>
</html>