package Controlador;
import Vista.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener{
    private GUI vista;

    public Control(GUI vista) {
        this.vista = vista;
        this.vista.addDarEnAdopcionListener(this);
        this.vista.addMostrarMascotasListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals("DarEnAdopcion")) {
            // Manejar la acción de dar en adopción
            vista.mostrarPanelAdopcion();
        } else if (comando.equals("MostrarMascotas")) {
            // Manejar la acción de mostrar mascotas
            vista.mostrarMascotas();
        }
    }
}
