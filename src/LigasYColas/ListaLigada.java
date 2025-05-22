/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LigasYColas;

import GUI.Empleado;
import GUI.MenuAdministrador;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
/**
 *
 * @author Papolo4
 */

    class Nodo {
    Empleado empleado;
    Nodo siguiente;
    Nodo anterior;

    public Nodo(Empleado empleado){
        this.empleado = empleado;
        this.siguiente = null;
        this.anterior = null;
    }
}

public class ListaLigada{
     private Nodo raiz;

    public ListaLigada() {
        raiz = null;
    }
    
    public boolean esVacia() {
        return raiz == null;
    }
    
    
    
        
    public void insertarOrdenado(Empleado empleado) {
        Nodo nuevo = new Nodo(empleado);

        if (esVacia()) {
            raiz = nuevo;
            return;
        }


        if (empleado.getNombre().compareToIgnoreCase(raiz.empleado.getNombre()) < 0) {
            nuevo.siguiente = raiz;
            raiz.anterior = nuevo;
            raiz = nuevo;
            return;
        }

        Nodo actual = raiz;
        while (actual.siguiente != null && actual.siguiente.empleado.getNombre().compareToIgnoreCase(empleado.getNombre()) >= 0) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente.anterior = nuevo;
        }

        actual.siguiente = nuevo;
    }
    
    public boolean actualizarEmpleado(String id, Empleado actualizado) {
    Nodo actual = raiz;
    while (actual != null) {
        if (actual.empleado.getId().trim().equals(id.trim())) {
            actual.empleado = actualizado;
            return true;
        }
        actual = actual.siguiente;
    }
    return false;
    }
    
    
     public Empleado eliminarPorID(String id) {
        if (esVacia()) {
            System.out.println("Lista vacía.");
            return null;
        }

        Nodo actual = raiz;
        while (actual != null && !actual.empleado.getId().equals(id)) {
            actual = actual.siguiente;
        }

        if (actual == null) {
            System.out.println("Empleado no encontrado.");
            return null;
        }
 Empleado eliminado = actual.empleado;

        if (actual == raiz) {
            raiz = actual.siguiente;
            if (raiz != null) {
                raiz.anterior = null;
            }
            return null;
        }

        if (actual.siguiente != null) {
            actual.siguiente.anterior = actual.anterior;
        }
        if (actual.anterior != null) {
            actual.anterior.siguiente = actual.siguiente;
        }
        return eliminado;
    }
    // Opcional: método para recorrer la lista y guardarla
        public void guardarArchivo(String nombreArchivo) {
    try (FileWriter fw = new FileWriter(nombreArchivo, true)) { // false para sobrescribir
        Nodo actual = raiz;
        while (actual != null) {
            fw.write(actual.empleado.toCSV() + "\n");
            actual = actual.siguiente;
        }
        System.out.println("Empleados guardados correctamente.");
    } catch (IOException e) {
        System.out.println("Error al guardar la lista: " + e.getMessage());
    }
}
     
    public void reesEmpleado(String nombreArchivo){
        
        try (FileWriter fw = new FileWriter(nombreArchivo, false)) { // false para sobrescribir
        Nodo actual = raiz;
        while (actual != null) {
            fw.write(actual.empleado.toCSV() + "\n");
            actual = actual.siguiente;
        }
        System.out.println("Empleados guardados correctamente.");
    } catch (IOException e) {
        System.out.println("Error al guardar la lista: " + e.getMessage());
    }
        
    }    
        
        
            
        public void cargarDesdeArchivo(String ruta) {
    raiz = null;
    try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            Empleado emp = Empleado.fromCSV(linea); // Asegúrate de tener este método en Empleado
            insertarOrdenado(emp);
        }
    } catch (IOException e) {
        System.out.println("Error al cargar archivo: " + e.getMessage());
    }
}
}

