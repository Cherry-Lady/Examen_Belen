<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Simulación</title>
	<%@include file="parciales/cabecera.html" %>
</head>
<body>
	<div class="contenedor">
		<h1>Simulacion</h1>
			<div class="div_form">
				<form method="post" action="ssimulacion">
					<div class="div_nif">
	       	   			<label for="text">NIF:</label><input id="text" type="text" name="nif">
	           		</div>
	           		<div class="div_boton">
                        <input type="submit" value="Simular avanzando un mes">
                	</div>
                	<div class="res_form"><%= request.getAttribute("respuesta") %></div> 
                	<%@ include file="parciales/footer.html" %>
                </form>
			</div>
	</div>
</body>
</html>