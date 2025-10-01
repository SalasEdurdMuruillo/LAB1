/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Luisf
 */
public class ClienteRegular implements FabricaCliente {
    @Override
    public Cliente crearCliente(String id, String nombre, String correo, String Telefono) {
        return new Cliente(id, nombre, correo, Telefono, false);
    }
}
