/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;
import aplicacion.Categoria;
import java.sql.*;
/**
 *
 * @author basesdatos
 */
public class DAOCategorias extends AbstractDAO {
   
    
    public DAOCategorias (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public java.util.List<Categoria> consultarCategorias(){
        java.util.List<Categoria> resultado = new java.util.ArrayList<Categoria>();
        Categoria categoriaActual;
        Connection con;
        PreparedStatement stmCategorias=null;
        ResultSet rsCategorias;

        con=this.getConexion();

        try  {
        stmCategorias=con.prepareStatement("select nombre, descripcion from categoria");
        rsCategorias=stmCategorias.executeQuery();
        while (rsCategorias.next())
        {
            categoriaActual = new Categoria(rsCategorias.getString("nombre"), rsCategorias.getString("descripcion"));
            resultado.add(categoriaActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmCategorias.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public void insertarCategoria(Categoria categoria){
        Connection con;
        PreparedStatement stmCategoria = null;
        ResultSet rsNombreCategoria;
        
        con = super.getConexion();
        
        try{
            stmCategoria = con.prepareStatement("insert into categoria(nombre,descripcion) values(?,?)");
            stmCategoria.setString(1,categoria.getNombre());
            stmCategoria.setString(2,categoria.getDescripcion());
            stmCategoria.executeUpdate();
        }catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmCategoria.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }

    }

    public void borrarCategoria(String nombre){
        Connection con;
        PreparedStatement stmCategoria = null;
        
        con = super.getConexion();
        
        try{
            stmCategoria = con.prepareStatement("delete from categoria where nombre = ?");
            stmCategoria.setString(1,nombre);
            stmCategoria.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try{stmCategoria.close();}catch(SQLException e){
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
   

}
