package com.nowe.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nowe.persistencia.AccesoCuentasBancarias;

/**
 * Servlet implementation class SConsultaSaldo
 */
@WebServlet("/sconsultasaldo")
public class SConsultaSaldo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SConsultaSaldo() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("respuesta", "");
		request.getRequestDispatcher("/consulta_saldo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Creo variable (AcessoBBDD) para acceder a la clase de persistencia (AcessoCuentasBancarias)
		AccesoCuentasBancarias AccesoBBDD = new AccesoCuentasBancarias();
		
		// Recojo el valor de los INPUT RADIO (typeradio), de consulta_saldo.jsp
		String tipo = "";
		if(request.getParameter("tipo_saldo") != null){
			tipo = request.getParameter("tipo_saldo");
		}
		
		//Recojo el valor del input "cuenta", a través del request, los parametros de consulta_saldo.jsp,  lo añado a la variable cuenta
		String cuenta = request.getParameter("cuenta");
		String res = "";
		
		switch(tipo)
		{
			case "cliente":
	
				try
					{	
						res = "El saldo del cliente " + cuenta + " es: " + Double.toString(AccesoBBDD.consultaSaldoTotal(cuenta));
					}
					catch (Exception e) //Genérico: recoge todas las posibles excepciones
					{
						res = "Error: " + e.toString();
					}
				
				
				break;
			case "cdt":
				
				try
				{
					int id = Integer.parseInt(cuenta);
					
					res = "El saldo del CDT " + id + " es: " + Double.toString(AccesoBBDD.consultaSaldoCDT(id));
					
				}
				catch (Exception e)
				{
					res = "Debe introducir un número entero para esta operación";
				}
				break;
			case "cuenta":
				
				try
				{
					int id = Integer.parseInt(cuenta);

					res = "El saldo de la cuenta " + id + " es: " + Double.toString(AccesoBBDD.consultaSaldo(id));
				}
				catch (Exception e)
				{
					//res = "Debe introducir un número entero para esta operación";
					res = e.toString();
				}
				break;
			default:
				res = "Error: no se ha especificado el tipo de saldo";			
		}
		
				
		request.setAttribute("respuesta", res);
		request.getRequestDispatcher("/consulta_saldo.jsp").forward(request, response);
	}

}
