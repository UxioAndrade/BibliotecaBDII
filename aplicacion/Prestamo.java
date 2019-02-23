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
    private Integer libro;
    private Integer ejemplar;
    private String fecha_prestamo;
    private String fecha_devolucion;
    
    public Prestamo(String usuario, Integer libro, Integer ejemplar, String fecha_prestamo, String fecha_devolucion){
        this.usuario = usuario;
        this.libro = libro;
        this.ejemplar = ejemplar;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
    }
    
    public String getUsuario(){
        return this.usuario;
    }
    
    public Integer getLibro(){
        return this.libro;
    }
    
    public Integer getEjemplar(){
        return this.ejemplar;
    }
    
    public String getFechaPrestamo(){
        return this.fecha_prestamo;
    }
    
    public String getFechaDevolucion(){
        return this.fecha_devolucion;
    }
}
