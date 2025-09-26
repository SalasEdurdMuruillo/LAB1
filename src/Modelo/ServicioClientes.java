/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.Cliente;
import Modelo.IGestorClientes;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 *
 * @author jprod
 */
public class ServicioClientes {
    private final IGestorClientes gestor;
    private static final Pattern EMAIL = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

    public ServicioClientes(IGestorClientes gestor) {
        this.gestor = gestor;
    }
    
    public void guardar(String id, String nombre, String correo, String telefono, boolean preferente) {
        validarRequeridos(id, nombre, correo, telefono);
        if (gestor.existe(id)) throw new IllegalArgumentException("Ya existe un registro con id=" + id);
        if (!EMAIL.matcher(correo).matches()) throw new IllegalArgumentException("Formato de correo inválido");
        String nombreFormateado = formatoNombrePropio(nombre);
        gestor.guardar(new Cliente(id, nombre, correo, telefono, preferente));
    }
    
    public void actualizar(String id, String correo, String telefono, boolean preferente) {
        Objects.requireNonNull(ultimoRegistro(), "No se ha cargado ningun registro");
        validarRequeridos(id, correo, telefono);
        if(!hayCambios(id, correo, telefono,preferente)) return;
        if (!gestor.existe(id)) throw new IllegalArgumentException("No existe un registro con id=" + id);
        if (!EMAIL.matcher(correo).matches()) throw new IllegalArgumentException("Formato de correo inválido");
        Cliente cliente=gestor.buscar(id);
        cliente.setCorreo(correo);
        cliente.setTelefono(telefono);
        cliente.setPreferente(preferente);
        gestor.actualizar(cliente);
    }
    
    public void eliminar(String id) {
        if (!gestor.existe(id)) throw new IllegalArgumentException("No existe ningun registro con id=" + id);
        gestor.eliminar(id);
    }
    
    public Cliente buscar(String id) {
        validarRequeridos(id);
        if(!gestor.existe(id)) throw new IllegalArgumentException("No existe ningun registro con id=" + id);
        return gestor.buscar(id);
    }
    
    public Cliente ultimoRegistro() {
        Cliente cliente = gestor.ultimoRegistro();
        Objects.requireNonNull(cliente, "No se ha cargado ningun registro");
        return cliente;
    }
    
    public boolean validarIdDisponible(String id){
        if(id==null||id.isBlank()) throw new IllegalArgumentException("Faltan datos requeridos");
        return !gestor.existe(id);
    }
    
    public List<Cliente> listar() {
        return gestor.listar();
    }
    
    private void validarRequeridos(String... datos){
        for(String dato:datos){
            if (dato==null || dato.isBlank())
                throw new IllegalArgumentException("Faltan datos requeridos");
        }
    }
    
    private String formatoNombrePropio(String nombre) {
        if (nombre == null || nombre.isBlank()) return nombre;
        String[] palabras = nombre.toLowerCase().trim().split("\\s+");
        StringBuilder nombreFormateado = new StringBuilder();
        for (String palabra : palabras) {
            if (palabra.length() > 0) {
                nombreFormateado.append(Character.toUpperCase(palabra.charAt(0))).append(palabra.substring(1)).append(" ");
            }
        }
        return nombreFormateado.toString().trim();
    }
    
    private boolean hayCambios(String id,String correo,String telefono,boolean preferente){
        Cliente cliente = gestor.buscar(id);
        Objects.requireNonNull(cliente, "No se ha cargado ningun registro");
        validarRequeridos(correo,telefono);
        return !(cliente.getCorreo().equals(correo) && cliente.getTelefono().equals(telefono)&& cliente.getPreferente()==preferente);
    }
}
