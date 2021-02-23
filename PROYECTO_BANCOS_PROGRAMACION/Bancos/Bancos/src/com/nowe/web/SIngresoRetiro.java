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
 * Servlet implementation class SIngresoRetiro
 */
@WebServlet("/singresoretiro")
public class SIngresoRetiro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SIngresoRetiro() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	
	request.setAttribute("respuesta", "");
	request.getRequestDispatcher("/ingreso_retiro.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	// Creo variable (AcessoBBDD) para acceder a la clase de persistencia (AcessoCuentasBancarias)
	AccesoCuentasBancarias AccesoBBDD = new AccesoCuentasBancarias();
	
	// Recojo el valor de los INPUT RADIO (typeradio), de ingresoRetiro.jsp
	String tipo = "";
	if(request.getParameter("tipo_gestionIR") != null){
		tipo = request.getParameter("tipo_gestionIR");
	}
	
	//Recojo el valor de los input , a través del request, los parametros de consulta_saldo.jsp,  lo añado a la variable cuenta
	String cuenta = request.getParameter("cuenta");
	String monto = request.getParameter("monto");
	String res = "";
	
	if(tipo.equals("ingresar")) {
		double saldoI;
        double montoDouble;
        double saldoAnterior;
        boolean exito;
        //1.1 Recoger los datos de los controles
        try {
            
            montoDouble = Double.parseDouble(monto);

        //Recojo el saldo de la BBDD y le sumo el ingreso
        saldoAnterior= (AccesoBBDD.consultaSaldoTotal(cuenta));
        saldoI = montoDouble+saldoAnterior;
        exito=saldoAnterior<saldoI;
                        
            if (exito) {
                res= "Se ha realizado su ingreso correctamente, el saldo actual es: "+ saldoI;
            } else {
                res="ERROR: no se realizó el ingreso correctamente";
            }

        } catch (ClassNotFoundException | SQLException ex) {
            
        	res="ERROR INTERNO: "+ ex.toString();
        	

        } catch (NumberFormatException ex) {
            res="Los datos deben ser numéricos";
        }

    }

    //2. Identificar si es la acción de retirar saldo
    if (tipo.equals("retirar")) {
    	double saldoI;
        double montoDouble;
        double saldoAnterior;
        boolean exito;
        //1.1 Recoger los datos de los controles
        try {
            
            montoDouble = Double.parseDouble(monto);

        //
        saldoAnterior= (AccesoBBDD.consultaSaldoTotal(cuenta));
        saldoI = montoDouble-saldoAnterior;
        exito=saldoAnterior>saldoI;
            
            
            if (exito) {
                res= "Se ha realizado su retirada correctamente, el saldo actual es: "+ saldoI;
            } else {
                res="ERROR: no se realizó la retirada correctamente, no hay suficiente saldo";
            }

        } catch (ClassNotFoundException | SQLException ex) {
            
        	res="ERROR INTERNO: "+ ex.toString();
        	

        } catch (NumberFormatException ex) {
            res="Los datos deben ser numéricos";
        }

    }
			
	request.setAttribute("respuesta", res);
	request.getRequestDispatcher("/ingreso_retiro.jsp").forward(request, response);
}
	
	}


