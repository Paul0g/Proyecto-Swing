package GUI;

import javax.swing.*;
import java.awt.*;

public class Menu {

    private JPanel panelMenu;

    private JButton cerrarSesiónButton;
    private JButton colaDeSolicitudesDeButton;
    private JButton registrarNuevoEmpleadoButton;
    private JButton historialDeEliminacionesButton;
    private JButton consultarInformaciónDeUnButton;
    private JButton eliminarUnEmpleadoButton;
    private JButton mostrarNóminaDeEmpleadosButton;
    private JButton actualizarDatosDeUnButton;

    public Menu(){
        panelMenu = new JPanel(null);

        JLabel titulo = new JLabel("MENÚ DE ADMINISTRADOR", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(50, 10, 400, 30);
        panelMenu.add(titulo);

        // Botones (puedes ajustar posiciones)
        registrarNuevoEmpleadoButton = new JButton("Registrar Nuevo Empleado");
        registrarNuevoEmpleadoButton.setBounds(130, 60, 250, 30);
        panelMenu.add(registrarNuevoEmpleadoButton);

        consultarInformaciónDeUnButton = new JButton("Consultar Información");
        consultarInformaciónDeUnButton.setBounds(130, 100, 250, 30);
        panelMenu.add(consultarInformaciónDeUnButton);

        actualizarDatosDeUnButton = new JButton("Actualizar Datos");
        actualizarDatosDeUnButton.setBounds(130, 140, 250, 30);
        panelMenu.add(actualizarDatosDeUnButton);

        eliminarUnEmpleadoButton = new JButton("Eliminar Empleado");
        eliminarUnEmpleadoButton.setBounds(130, 180, 250, 30);
        panelMenu.add(eliminarUnEmpleadoButton);

        mostrarNóminaDeEmpleadosButton = new JButton("Mostrar Nómina");
        mostrarNóminaDeEmpleadosButton.setBounds(130, 220, 250, 30);
        panelMenu.add(mostrarNóminaDeEmpleadosButton);

        historialDeEliminacionesButton = new JButton("Historial de Eliminaciones");
        historialDeEliminacionesButton.setBounds(130, 260, 250, 30);
        panelMenu.add(historialDeEliminacionesButton);

        colaDeSolicitudesDeButton = new JButton("Cola de Solicitudes");
        colaDeSolicitudesDeButton.setBounds(130, 300, 250, 30);
        panelMenu.add(colaDeSolicitudesDeButton);

        cerrarSesiónButton = new JButton("Cerrar Sesión");
        cerrarSesiónButton.setBounds(130, 340, 250, 30);
        panelMenu.add(cerrarSesiónButton);


        cerrarSesiónButton.addActionListener(e -> {
            JFrame ventana = (JFrame) SwingUtilities.getWindowAncestor(panelMenu);
            ventana.dispose();
            JOptionPane.showMessageDialog(null, "Sesión cerrada.");
        });

    }

    public JPanel getPanel() {
        return panelMenu;
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
