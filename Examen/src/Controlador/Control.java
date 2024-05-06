package Controlador;
import Vista.GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener{
    private GUI vista;//creacion de instancia de la clase GUI

    public Control(GUI vista) {//constructor donde se instancian las acciones de los botones de GUI
        this.vista = vista;
        this.vista.addDarEnAdopcionListener(this);
        this.vista.addMostrarMascotasListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {//metodo que controla las acciones de los botones importantes de GUI
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