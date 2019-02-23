/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;
/**
 *
 * @author basesdatos
 */
public class GestionUsuarios {
     
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
   
    public GestionUsuarios(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }  
    
  
    public void nuevoUsuario(Usuario u){
        this.fbd.insertarUsuario(u);
    }
    
    public Boolean comprobarAutentificacion(String idUsuario, String clave){
      Usuario u;

      u=fbd.validarUsuario(idUsuario, clave);
      if (u!=null){
          return u.getTipoUsuario()==TipoUsuario.Administrador;
      } else return false;
    }
  
    public java.util.List<Usuario> obtenerUsuarios(String id, String nombre){
        return fbd.consultarUsuarios(id,nombre);
    }
    
    public Usuario consultarUsuario(String id){
        return fbd.consultarUsuario(id);
    }
    
    public int calcularPrestamosPendientes(String idUsuario){
        return this.fbd.calcularPrestamosPendientes(idUsuario);
    }
     
    public void editarUsuario(String id,Usuario u){
        this.fbd.editarUsuario(id,u);
    }
  
    public boolean borrarUsuario(String idUsuario){
        return this.fbd.borrarUsuario(idUsuario);
    }
    
}
