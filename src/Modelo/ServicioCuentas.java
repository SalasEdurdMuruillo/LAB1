/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.List;

/**
 *
 * @author Luisf
 */
public class ServicioCuentas {
    private static final String PrefijoBanco = "123";
    private static long consecutivo = 1L;
    private final IGestorCuentas gestor;
    private final FabricaCuenta fabrica;
    
    public ServicioCuentas(IGestorCuentas gestor, FabricaCuenta fabrica) {
        this.gestor = gestor;
        this.fabrica = fabrica;
    }
    
    private String generarNumeroCuenta() {
        String consecutivoStr = String.format("%014d", consecutivo++);
        return PrefijoBanco + consecutivoStr;
    }
    
    public Cuenta crearCuenta(Cliente titular) {
        String numero = generarNumeroCuenta();
        Cuenta cuenta = fabrica.crearCuenta(numero, titular);
        gestor.guardar(cuenta);
        return cuenta;
    }
    
    public void depositar(String numeroCuenta, double monto) {
        if (monto <= 0) throw new IllegalArgumentException("Monto Invalido");
        Cuenta cuenta = gestor.buscar(numeroCuenta);
        if (cuenta == null) throw new IllegalArgumentException("Cuenta no encontrada");
        if (!cuenta.isActiva()) throw new IllegalStateException("Cuenta inactiva");

        cuenta.setSaldo(cuenta.getSaldo() + monto);
        gestor.actualizar(cuenta);
    }
    
    public void retirar(String numeroCuenta, double monto) {
        if (monto <= 0) throw new IllegalArgumentException("Monto Invalido");
        Cuenta cuenta = gestor.buscar(numeroCuenta);
        if (cuenta == null) throw new IllegalArgumentException("Cuenta no encontrada");
        if (!cuenta.isActiva()) throw new IllegalStateException("Cuenta inactiva");
        if (cuenta.getSaldo() < monto) throw new IllegalStateException("Saldo insuficiente");

        cuenta.setSaldo(cuenta.getSaldo() - monto);
        gestor.actualizar(cuenta);
    }
    
    public void tranferir(String origen, String destino, double monto) {
        if (origen.equals(destino)) throw new IllegalArgumentException("Las cuentas deben ser distintas");
        retirar(origen, monto);
        depositar(destino, monto);
    }
    
    public List<Cuenta> listar() {
        return gestor.listar();
    }
    
    public Cuenta buscar(String numeroCuenta) {
        return gestor.buscar(numeroCuenta);
    }

    public void crearCuenta(Cliente titular, String numeroCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
