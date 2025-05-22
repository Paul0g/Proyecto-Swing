/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.io.*;

public class Nomina extends JFrame {

    private JButton btnMostrar;
    private JTable tablaNomina;
    private JScrollPane scrollTabla;
    private JTextField campoBusqueda;
    private JLabel etiquetaBusqueda;

    private DefaultTableModel modelo;
    private TableRowSorter<DefaultTableModel> sorter;

    public Nomina() {
        setTitle("Nómina de Empleados con Buscador");
        setSize(650, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Botón para mostrar la nómina
        btnMostrar = new JButton("Mostrar Nómina");
        btnMostrar.setBounds(240, 20, 150, 30);
        add(btnMostrar);

        // Campo de búsqueda
        etiquetaBusqueda = new JLabel("Buscar (ID o Nombre):");
        etiquetaBusqueda.setBounds(30, 60, 150, 25);
        add(etiquetaBusqueda);

        campoBusqueda = new JTextField();
        campoBusqueda.setBounds(180, 60, 250, 25);
        add(campoBusqueda);

        // Tabla vacía
        modelo = new DefaultTableModel();
        tablaNomina = new JTable(modelo);
        scrollTabla = new JScrollPane(tablaNomina);
        scrollTabla.setBounds(30, 100, 580, 280);
        add(scrollTabla);

        // Acción del botón
        btnMostrar.addActionListener(e -> cargarTablaDesdeArchivo("Empleados.txt"));

        // Filtrar mientras se escribe
        campoBusqueda.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                filtrarTabla();
            }
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                filtrarTabla();
            }
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                filtrarTabla();
            }
        });
    }

    private void cargarTablaDesdeArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean primeraLinea = true;

            modelo = new DefaultTableModel();
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (primeraLinea) {
                    modelo.setColumnIdentifiers(datos);
                    primeraLinea = false;
                } else {
                    modelo.addRow(datos);
                }
            }

            tablaNomina.setModel(modelo);
            sorter = new TableRowSorter<>(modelo);
            tablaNomina.setRowSorter(sorter);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage());
        }
    }

    private void filtrarTabla() {
        String texto = campoBusqueda.getText().trim();
        if (sorter != null) {
            if (texto.length() == 0) {
                sorter.setRowFilter(null);
            } else {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto)); // (?i) = ignorar mayúsculas/minúsculas
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Nomina().setVisible(true);
   });
 }
}
