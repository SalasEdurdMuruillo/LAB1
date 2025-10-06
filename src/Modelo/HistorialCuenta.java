/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Stack;

/**
 *
 * @author Eduard Salas Murillo
 */
public class HistorialCuenta {
     private Stack<CuentaMemento> historial = new Stack<>();

    public void guardarMemento(CuentaMemento memento) {
        historial.push(memento);
    }

    public CuentaMemento deshacer() {
        if (!historial.isEmpty()) {
            return historial.pop();
        }
        return null;
    }
}
