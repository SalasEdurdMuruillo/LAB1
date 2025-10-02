/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Objects;

/**
 *
 * @author Sebastian
 */
public class Cuenta {
    private final String numeroCuenta;
    private final Cliente titular;
    private double saldo;
    private boolean activa;
    private final Moneda moneda;
    
    public Cuenta(String numeroCuenta, Cliente titular, Moneda moneda){
        this.numeroCuenta = numeroCuenta;
        this.titular = Objects.requireNonNull(titular, "Titular requerido");
        this.moneda = Objects.requireNonNull(moneda, "Moneda requerida");
        this.saldo = 0.0;
        this.activa = true;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public Cliente getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
    public boolean isActiva(){
        return activa;
    }

    public void setEstado(String estado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
