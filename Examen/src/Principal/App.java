package Principal;

import Vista.GUI;

public class App {
    public static void main(String[] args) throws Exception {// Main

        GUI pantalla = new GUI();// instancia de la clase GUI para visualizar la interfaz grafica
        pantalla.setVisible(true);
        pantalla.setSize(1000, 800);
        pantalla.setResizable(false);
        pantalla.setLocationRelativeTo(null);

    }
}
