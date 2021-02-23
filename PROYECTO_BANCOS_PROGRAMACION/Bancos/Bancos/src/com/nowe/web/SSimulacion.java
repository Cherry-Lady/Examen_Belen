package com.nowe.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.nowe.persistencia.AccesoCuentasBancarias;

/**
 * Servlet implementation class SSimulacion
 */
@WebServlet("/ssimulacion")
public class SSimulacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SSimulacion() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("respuesta", "");
		request.getRequestDispatcher("/Simulacion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Creo variable (AcessoBBDD) para acceder a la clase de persistencia (AcessoCuentasBancarias)
				AccesoCuentasBancarias AccesoBBDD = new AccesoCuentasBancarias();
				
		//Recojo el valor de los INPUT TEXT, de Simulacion.jsp
				String nif = request.getParameter("nif");
				String res = "";
				String saldo;
		        
				
		// Se traslada la lógica de com.nowe.presentacion.Simulacion.java ---> btnAccionActionPerformed
				
		        try {
		        	saldo = String.format("Su saldo es %.2f", AccesoBBDD.simulacion(nif));
		        	res = "El saldo del cliente " + nif + " es: " + saldo;
					System.out.println(res);
				
				
		            
		        } catch (ClassNotFoundException | SQLException ex) {//Genérico: recoge todas las posibles excepciones
				
					res = "Error: introduzca DNI correcto";
				}
		     
				
				request.setAttribute("respuesta", res);
				request.getRequestDispatcher("/Simulacion.jsp").forward(request, response);
			
	}

}
