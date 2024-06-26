/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete2;

/**
 *
 * @author reroes
 */
public abstract class Arriendo {
    
    protected String nombreArrendatario;
    protected double arriendoMensual;
    protected double cuotaBase;
    
    public Arriendo(String nombre, double cuotaB){
        // nombreArrendatario = nombre;
        establecerNombreArrendatario(nombre);
        cuotaBase = cuotaB;
    }
    
    public void establecerNombreArrendatario(String nombre){
        nombreArrendatario = nombre;
    }
    
    public void establecerCuotaBase(double x){
        cuotaBase = x;
    }
    
    public abstract void establecerArriendoMensual();
    
    public String obtenerNombreArrendatario(){
        return nombreArrendatario;
    }
    
    public double obtenerCuotaBase(){
        return cuotaBase;
    }
    
    public double obtenerArriendoMensual(){
        return arriendoMensual;
    }
    
    
}
