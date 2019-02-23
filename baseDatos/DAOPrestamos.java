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
    
    public java.util.List<Prestamo> consultarPrestamos(Integer idLibro, Integer idEjemplar){
        
        java.util.List<Prestamo> resultado = new java.util.ArrayList<Prestamo>();
        Prestamo prestamoActual;
        Connection con;
        PreparedStatement stmPrestamo=null;
        ResultSet rsPrestamo;
        
        con = this.getConexion();
        
        String consulta = "select usuario, libro, ejemplar, fecha_prestamo, fecha_ devolucion "+
                "from prestamo " +
                "where libro like ? and ejemplar like ?";
        
        try{
            stmPrestamo = con.prepareStatement(consulta);
            stmPrestamo.setInt(1, idLibro);
            stmPrestamo.setInt(2,idEjemplar);
            rsPrestamo = stmPrestamo.executeQuery();
            while(rsPrestamo.next()){
                prestamoActual = new Prestamo(rsPrestamo.getString("usuario"),idLibro,idEjemplar,rsPrestamo.getString("fecha_prestamo"),rsPrestamo.getString("fecha_devolucion"));
                resultado.add(prestamoActual);
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
