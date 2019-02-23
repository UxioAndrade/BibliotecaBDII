/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

/**
 *
 * @author alumnogreibd
 */
public class GestionPrestamos {
    
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
    public GestionPrestamos(FachadaGui fgui, FachadaBaseDatos fbd){
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
   public void nuevoPrestamo(Prestamo p){
       fbd.nuevoPrestamo(p);
   }
    
   public void nuevoPrestamo(Ejemplar e){
       this.fgui.nuevoPrestamo(e);
   }
   
   public boolean anhadirPrestamo(Ejemplar e, Usuario u){
       return fbd.anhadirPrestamo(e,u);
   }
}
