/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Eduard Salas Murillo
 */
public class CuentaMemento {
  private final String nombreCliente;
    private final double saldo;

    public CuentaMemento(String nombreCliente, double saldo) {
        this.nombreCliente = nombreCliente;
        this.saldo = saldo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public double getSaldo() {
        return saldo;
    }  
}
