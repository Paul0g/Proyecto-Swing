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
public class ColEmpleado {
    private Nodo frente;
    private Nodo fin;

    // Clase Nodo interna
    public class Nodo {
        private Empleado empleado;
        private Nodo siguiente;

        public Nodo(Empleado empleado) {
            this.empleado = empleado;
            this.siguiente = null;
        }

        public Empleado getEmpleado() {
            return empleado;
        }

        public void setEmpleado(Empleado empleado) {
            this.empleado = empleado;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

        @Override
        public String toString() {
            return "Nodo{" +
                    "empleado=" + empleado +
                    ", siguiente=" + (siguiente != null ? "->" : "null") +
                    '}';
        }
    }
    
    public ColEmpleado() {
        this.frente = null;
        this.fin = null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void encolar(Empleado empleado) {
        Nodo nuevoNodo = new Nodo(empleado);

        if (estaVacia()) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
        }
    }

    public Empleado desencolar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía. No se puede desencolar.");
            return null;
        }

        Empleado empleadoDesencolado = frente.getEmpleado();
        frente = frente.getSiguiente();

        if (frente == null) {
            fin = null;
        }

        return empleadoDesencolado;
    }
    
    // Método adicional para ver el frente sin desencolar
    public Empleado verFrente() {
        if (estaVacia()) {
            return null;
        }
        return frente.getEmpleado();
    }
    
    
    
    
    
    
    // Método para obtener el tamaño de la cola
    public int tamanio() {
        int contador = 0;
        Nodo actual = frente;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }
    
    // Método para imprimir la cola (útil para debugging)
    public void imprimirCola() {
        Nodo actual = frente;
        System.out.println("Contenido de la cola:");
        while (actual != null) {
            System.out.println(actual.getEmpleado());
            actual = actual.getSiguiente();
        }
    }
}
