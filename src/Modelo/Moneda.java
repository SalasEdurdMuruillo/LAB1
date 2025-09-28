/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Modelo;

/**
 *
 * @author Sebastian
 */
public enum Moneda {
    COLONES("Colones"),
    DOLARES("Dolares");
    
    private final String moneda;
    
    Moneda(String moneda) {
        this.moneda = moneda;
    }
    
    public String getMoneda() {
        return moneda;
    }

    @Override
    public String toString() {
        return this.moneda; // Esto asegura que el JComboBox muestre solo "Colones" o "Dolares"
    }
}
