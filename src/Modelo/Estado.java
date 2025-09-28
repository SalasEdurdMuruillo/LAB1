/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Modelo;

/**
 *
 * @author Luisf
 */
public enum Estado {
    ACTIVA("Activa"),
    INACTIVA("Inactiva");
    
    private final String estado;
    
    Estado(String estado) {
        this.estado = "Activa";
    }
    
    public String getEstado() {
        return estado;
    } 
}
