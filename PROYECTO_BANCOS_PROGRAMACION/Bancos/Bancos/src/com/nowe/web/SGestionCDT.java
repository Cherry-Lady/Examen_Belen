package com.nowe.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nowe.modelo.CDT;
import com.nowe.persistencia.AccesoCuentasBancarias;

/**
 * Servlet implementation class SGestionCDT
 */
@WebServlet("/sgestioncdt")
public class SGestionCDT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SGestionCDT() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("respuesta", "");
		request.getRequestDispatcher("/CDT.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		// Creo variable (AcessoBBDD) para acceder a la clase de persistencia (AcessoCuentasBancarias)
		AccesoCuentasBancarias AccesoBBDD = new AccesoCuentasBancarias();
		
		// Recojo el valor de los INPUT RADIO (typeradio), de CDT.jsp
		String tipo = "";
		if(request.getParameter("tipo_gestion") != null){
			tipo = request.getParameter("tipo_gestion");
		}
		
		//Recojo el valor de los INPUT TEXT, de CDT.jsp
		String cuenta = request.getParameter("cuenta");
		String interes = request.getParameter("interes");
		String monto = request.getParameter("monto");
		String cdt = request.getParameter("cdt");
		String res = "";
		
		
		// Se traslada la lógica de com.nowe.presentacion.gestionCDT.java ---> btnAccionActionPerformed
		
			
		if(tipo.equals("crear")) {
            int cuentaInt;
            double interesDouble, montoDouble;
            CDT inversion;
            boolean exito;
            //1.1 Recoger los datos de los controles
            try {
                cuentaInt = Integer.parseInt(cuenta);
                interesDouble = Double.parseDouble(interes);
                montoDouble = Double.parseDouble(monto);

                //1.2 Instanciar un objeto CDT
                inversion = new CDT(cuentaInt, interesDouble, montoDouble);

                //1.3 Llamar a creación del CDT
                exito = AccesoBBDD.crearInversion(inversion);
                
                if (exito) {
                    res= "Se ha realizado el alta de su CDT correctamente";
                } else {
                    res="ERROR: no se realizó la acción correctamente";
                }

            } catch (ClassNotFoundException | SQLException ex) {
                
            	res="ERROR INTERNO: "+ ex.toString();
            	

            } catch (NumberFormatException ex) {
                res="Los datos deben ser numéricos";
            }

        }

        //2. Identificar si es la acción de eliminar un CDT
        if (tipo.equals("cerrar")) {
            //1. Declarar variables
            int CDT;
            boolean exito;
            try {
                //2. Recoger los datos de los controles
                CDT = Integer.parseInt(cdt);
                //3 . Llamar al método correspondiente para cerrarla
                exito = AccesoBBDD.cerrarInversion(CDT);
                
                if (exito) {
                    res="Se ha realizado el cierre de su CDT correctamente";
                } else {
                    res="Se ha producido un error, no se realizó la acción correctamente";
                }
                
            } catch (ClassNotFoundException | SQLException ex) {
            	res="Se ha producido un error en la BBDD, no se realizó la acción correctamente";
            	
            } catch (NumberFormatException ex) {
            	res="Error: los datos deben ser numéricos";
            }
        }
		
		request.setAttribute("respuesta", res);
		request.getRequestDispatcher("/CDT.jsp").forward(request, response);
	} 
}


