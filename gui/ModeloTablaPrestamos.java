/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import javax.swing.table.*;
import aplicacion.Prestamo;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaPrestamos extends AbstractTableModel{
    
    private java.util.HashMap<String,Integer> usuariosPrestamos;
    
    public ModeloTablaPrestamos(){
        this.usuariosPrestamos = new java.util.HashMap();
    }
    
    public int getColumnCount(){
        return 4;
    }
    
    public int getRowCount(){
        return this.usuariosPrestamos.size();
    }
    
    @Override
    public String getColumnName(int col){
        String nombre="";
        
        switch(col){
            case 0: nombre = "Id";break;
            case 1: nombre = "Nombre";break;
            case 2: nombre = "Email";break;
            case 3: nombre = "Prestamos vencidos";break;
        }
        return nombre;
    }
    
    @Override
    public Class getColumnClass(int col){
        Class clase = null;
        
        switch (col){
            case 0: clase = java.lang.String.class; break;
            case 1: clase = java.lang.String.class; break;
            case 2: clase=java.lang.String.class; break;
            case 3: clase=java.lang.Integer.class; break;    
        }
        return clase;
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }
    
    public Object getValueAt(int row, int col){
        Object resultado=null;

        switch (col){
            //case 0: resultado= usuariosPrestamos.get(row).getIdUsuario(); break;
            //case 1: resultado= usuarios.get(row).getNombre(); break;
            //case 2: resultado= usuarios.get(row).getEmail();break;
            //case 3: resultado= usuarios.get(row).getDireccion(); break;
        }
        return resultado;
    }
    
    public void setFilas(java.util.HashMap<String,Integer> usuariosPrestamos){
        this.usuariosPrestamos = usuariosPrestamos;
        fireTableDataChanged();
    }
    
}
