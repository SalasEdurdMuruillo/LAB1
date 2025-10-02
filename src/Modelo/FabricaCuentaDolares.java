/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Sebastian
 */
public class FabricaCuentaDolares implements FabricaCuenta {

    @Override
    public Cuenta crearCuenta(String numero, Cliente titular) {
        return new Cuenta(numero, titular, Moneda.DOLARES);
    }
    
}
