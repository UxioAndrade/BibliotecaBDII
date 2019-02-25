/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import java.sql.*;
import aplicacion.Usuario;
import aplicacion.Ejemplar;
import aplicacion.Prestamo;

/**
 *
 * @author alumnogreibd
 */
public class DAOPrestamos extends AbstractDAO{
    
    private aplicacion.FachadaAplicacion fa;
    
    public DAOPrestamos (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
        this.fa = fa;
    }
    
    public boolean insertarPrestamo(Ejemplar e, Usuario u){
        Connection con;
        PreparedStatement stmPrestamo = null;
        
        con=this.getConexion();
        
        try{
            
            if(this.fa.calcularPrestamosPendientes(u.getIdUsuario()) > 0){
                return false;
            }
            
            stmPrestamo = con.prepareStatement("insert into prestamo(usuario,libro,ejemplar,fecha_prestamo,fecha_devolucion)"+
                                    "values (?,?,?,?,?)");
            stmPrestamo.setString(1, u.getIdUsuario());
            stmPrestamo.setInt(2, e.getLibro().getIdLibro());
            stmPrestamo.setInt(3,e.getNumEjemplar());
            stmPrestamo.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            stmPrestamo.setNull(5, java.sql.Types.DATE);
            stmPrestamo.executeUpdate();
        }catch (SQLException ex){
          System.out.println(ex.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(ex.getMessage());
        }finally{
          try {stmPrestamo.close();} catch (SQLException ex){System.out.println("Imposible cerrar cursores");}
        }
        return true;
    }
    
    public void devolverPrestamo(Integer idLibro, Integer idEjemplar){
        
        Connection con;
        PreparedStatement stmPrestamo = null;
        
        
        con = super.getConexion();
        
        try{
            stmPrestamo = con.prepareStatement("update prestamo " +
                                                "set fecha_devolucion = ? " +
                                                "where libro = ? and ejemplar = ? and fecha_devolucion IS NULL");
            stmPrestamo.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            stmPrestamo.setInt(2,idLibro);
            stmPrestamo.setInt(3,idEjemplar);
            stmPrestamo.executeUpdate();
        }catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmPrestamo.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
    }
    
    public Prestamo consultarPrestamos(Integer idLibro, Integer idEjemplar){
        
        Prestamo resultado = null;
        Prestamo prestamoActual;
        Connection con;
        PreparedStatement stmPrestamo=null;
        ResultSet rsPrestamo;
        
        con = this.getConexion();
        
        String consulta = "select usuario, libro, ejemplar, fecha_prestamo, fecha_devolucion "+
                "from prestamo " +
                "where libro = ? and ejemplar = ? and fecha_devolucion is null";
        
        try{
            stmPrestamo = con.prepareStatement(consulta);
            stmPrestamo.setInt(1, idLibro);
            stmPrestamo.setInt(2, idEjemplar);
            rsPrestamo = stmPrestamo.executeQuery();
            while(rsPrestamo.next()){
                prestamoActual = new Prestamo(rsPrestamo.getString("usuario"),idLibro,idEjemplar,rsPrestamo.getString("fecha_prestamo"),rsPrestamo.getString("fecha_devolucion"));
                resultado = prestamoActual;
            }
        }catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmPrestamo.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
}
