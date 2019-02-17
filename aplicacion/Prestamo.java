/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Prestamo {
    
    private String usuario;
    private String libro;
    private String ejemplar;
    private String fecha_prestamo;
    private String fecha_devolucion;
    
    public Prestamo(String usuario, String libro, String ejemplar, String fecha_prestamo, String fecha_devolucion){
        this.usuario = usuario;
        this.libro = libro;
        this.ejemplar = ejemplar;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
    }
    
    public String getUsuario(){
        return this.usuario;
    }
    
    public String getLibro(){
        return this.libro;
    }
    
    public String getEjemplar(){
        return this.ejemplar;
    }
    
    public String getFechaPrestamo(){
        return this.fecha_prestamo;
    }
    
    public String getFechaDevolucion(){
        return this.fecha_devolucion;
    }
}
