/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package LigasYColas;
/**
 *
 * @author Papolo4
 */
public class Global {
    public static ListaLigada listaEmpleados = new ListaLigada();
    private static PilaEliminaciones pilaEliminaciones = new PilaEliminaciones();
    private static ColEmpleado colaIDs = new ColEmpleado();
    
    public static PilaEliminaciones getPilaEliminaciones() {
        return pilaEliminaciones;
    }
    
    

    public static ColEmpleado getColaIDs() {
        return colaIDs;
    }
}