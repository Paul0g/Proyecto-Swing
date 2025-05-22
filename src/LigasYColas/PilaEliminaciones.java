/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LigasYColas;

import GUI.Empleado;

/**
 *
 * @author Papolo4
 */
public class PilaEliminaciones {

    private class Nodo {
        Empleado empleado;
        Nodo siguiente;

        public Nodo(Empleado empleado) {
            this.empleado = empleado;
            this.siguiente = null;
        }
    }

    private Nodo cima;

    public PilaEliminaciones() {
        this.cima = null;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public void apilar(Empleado empleado) {
        Nodo nuevoNodo = new Nodo(empleado);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
    }

    public Empleado desapilar() {
        if (estaVacia()) {
            System.out.println("La pila está vacía. No se puede desapilar.");
            return null;
        }
        Empleado eliminado = cima.empleado;
        cima = cima.siguiente;
        return eliminado;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La pila está vacía.");
            return;
        }
        Nodo actual = cima;
        System.out.println("Empleados eliminados:");
        while (actual != null) {
            System.out.println(actual.empleado.getId() + " - " + actual.empleado.getNombre());
            actual = actual.siguiente;
        }
    }
}