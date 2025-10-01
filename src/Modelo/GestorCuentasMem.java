/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Luisf
 */
public class GestorCuentasMem implements IGestorCuentas {
    private static GestorCuentasMem instancia;
    
    private final Map<String, Cuenta> cuentas = new HashMap<>();

    public GestorCuentasMem() {
        
    }
    
    public static GestorCuentasMem getInstancia() {
        if (instancia == null) {
            instancia = new GestorCuentasMem();
        }
        return instancia;
    }
    
    @Override
    public void guardar(Cuenta cuenta) {
        if (cuentas.containsKey(cuenta.getNumeroCuenta())) {
            throw new IllegalArgumentException("Cuenta existente con ese numero");
        }
        cuentas.put(cuenta.getNumeroCuenta(), cuenta);
    }

    @Override
    public void actualizar(Cuenta cuenta) {
        if (!cuentas.containsKey(cuenta.getNumeroCuenta())) {
            throw new IllegalArgumentException("No existe la cuenta");
        }
        cuentas.put(cuenta.getNumeroCuenta(), cuenta);
    }

    @Override
    public void eliminar(String numeroCuenta) {
        Cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta == null) throw new IllegalArgumentException ("Cuenta no existente");
        if (cuenta.getSaldo() != 0) throw new IllegalArgumentException ("No se puede eliminar una cuenta con saldo");
        cuentas.remove(numeroCuenta);
    }

    @Override
    public Cuenta buscar(String numeroCuenta) {
        return cuentas.get(numeroCuenta);
    }

    @Override
    public boolean existe(String numeroCuenta) {
        return cuentas.containsKey(numeroCuenta);
    }

    @Override
    public List<Cuenta> listar() {
        return new ArrayList<>(cuentas.values());
    }
}
