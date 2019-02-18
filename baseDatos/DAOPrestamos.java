/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import java.sql.Connection;
import aplicacion.Prestamo;

/**
 *
 * @author alumnogreibd
 */
public class DAOPrestamos extends AbstractDAO{
    
    public DAOPrestamos (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public void insertarPrestamo(Prestamo p){
        
    }
    
}
