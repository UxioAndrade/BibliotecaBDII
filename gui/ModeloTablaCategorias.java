/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Categoria;
import javax.swing.table.*;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaCategorias extends AbstractTableModel{
    
    private java.util.List<Categoria> categorias;
    
    public ModeloTablaCategorias(){
        this.categorias = new java.util.ArrayList<Categoria>();
    }
    
    public int getColumnCount(){
        return 2;
    }
    
    public int getRowCount(){
        return this.categorias.size();
    }
    
    @Override
    public String getColumnName(int col){
        String nombre = "";
        
        switch(col){
            case 0: nombre = "nombre"; break;
            case 1: nombre = "descripcion"; break;
        }
        
        return nombre;
    }
    
    @Override
    public Class getColumnClass(int col){
        Class clase = null;
        
        switch(col){
            case 0: clase = java.lang.String.class;break;
            case 1: clase = java.lang.String.class;break;
        }
        
        return clase;
    }
    
    public Object getValueAt(int row, int col){
        Object resultado = null;
        
        switch (col){
            case 0: resultado = categorias.get(row).getNombre(); break;
            case 1: resultado = categorias.get(row).getDescripcion(); break;
        }
        
        return resultado;
    }
    
    public void setFilas(java.util.List<Categoria> categorias){
        this.categorias = categorias;
        fireTableDataChanged();
    }
    
    public Categoria obtenerCategoria(int i){
        return this.categorias.get(i);
    }
}
