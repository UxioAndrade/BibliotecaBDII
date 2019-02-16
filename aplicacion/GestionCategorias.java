/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;
import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

/**
 *
 * @author alumnogreibd
 */
public class GestionCategorias {
    
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
    public GestionCategorias(FachadaGui fgui, FachadaBaseDatos fbd){
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    public java.util.List<Categoria> obtenerCategorias(){
        return fbd.consultarCategorias();
    }
    
    public void nuevaCategoria(Categoria categoria){
        fbd.nuevaCategoria(categoria);
    }
    
    public void borrarCategoria(String nombre){
        fbd.borrarCategoria(nombre);
    }
    
}
