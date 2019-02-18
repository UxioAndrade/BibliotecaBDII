/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;


/**
 *
 * @author basesdatos
 */
public class FachadaAplicacion {
    gui.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;
    GestionLibros cl;
    GestionUsuarios cu;
    GestionCategorias cc;
    
    
 public FachadaAplicacion(){
    //Necesitase primeiro inicializar a fbd para poder ter a informacion
     //Das categorias na fgui
   fbd= new baseDatos.FachadaBaseDatos(this);
   fgui=new gui.FachadaGui(this); 
   cl= new GestionLibros(fgui, fbd);
   cu= new GestionUsuarios(fgui, fbd);
   cc = new GestionCategorias(fgui,fbd);
 }

 public static void main(String args[]) {
     FachadaAplicacion fa;
     
     fa= new FachadaAplicacion();
     fa.iniciaInterfazUsuario();
 }
 
 public void iniciaInterfazUsuario(){
     fgui.iniciaVista();
 }
 
 public void nuevoPrestamo(){
     fgui.nuevoPrestamo();
 }

 public void muestraExcepcion(String e){
     fgui.muestraExcepcion(e);
 }
 
public java.util.List<Libro> obtenerLibros(Integer id, String titulo, String isbn, String autor){
  return cl.obtenerLibros(id, titulo,  isbn,  autor);
};

public void visualizarLibro(Integer idLibro){
 cl.visualizarLibro(idLibro);
}

public void nuevoLibro(){
 cl.nuevoLibro();
}

public void nuevoUsuario(Usuario u){
    cu.nuevoUsuario(u);
}

public java.util.List<Usuario> obtenerUsuarios(String id, String nombre){
    return cu.obtenerUsuarios(id,nombre);
}

public Integer actualizarLibro(Libro l){
  return cl.actualizarLibro(l);
}

public void borrarLibro(Integer idLibro){
   cl.borrarLibro(idLibro);
}

public void actualizarCategoriasLibro(Integer idLibro, java.util.List<String> categorias){
 cl.actualizarCategoriasLibro(idLibro, categorias);
}

public java.util.List<Ejemplar> actualizarEjemplaresLibro(Integer idLibro, java.util.List<Ejemplar> ejemplares, java.util.List<Integer> borrar){
  return cl.actualizarEjemplaresLibro(idLibro, ejemplares, borrar);
}


public Boolean comprobarAutentificacion(String idUsuario, String clave){
  return cu.comprobarAutentificacion(idUsuario, clave);
}

public boolean borrarUsuario(String idUsuario){
   return cu.borrarUsuario(idUsuario);
}
 

public void nuevaCategoria(Categoria categoria){
    cc.nuevaCategoria(categoria);
}

public void borrarCategoria(String nombre){
    cc.borrarCategoria(nombre);
}

public baseDatos.FachadaBaseDatos getFachadaBaseDatos(){
    return this.fbd;
}

public gui.FachadaGui getFachadaGui(){
    return this.fgui;
}
}
