/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowe.negocio;

import com.nowe.persistencia.AccesoCuentasBancarias;
import java.sql.SQLException;

/**
 *
 * @author Programacion
 */
public class Cajero {
    
    public double consultaSaldo(int idCuenta) throws ClassNotFoundException, SQLException 
    {
        AccesoCuentasBancarias acb1 = new AccesoCuentasBancarias();
        return acb1.consultaSaldo(idCuenta);
    }
    
    //Consultar saldo CDT
     public double consultaSaldoCDT(int idInversion) throws ClassNotFoundException, SQLException 
    {
        AccesoCuentasBancarias acb1 = new AccesoCuentasBancarias();
        return acb1.consultaSaldoCDT(idInversion);
    }
     
     //Consulta saldo total
      public double consultaSaldoTotal(String nif) throws ClassNotFoundException, SQLException 
    {
        AccesoCuentasBancarias acb1 = new AccesoCuentasBancarias();
        return acb1.consultaSaldoTotal(nif);
    }
    
}
