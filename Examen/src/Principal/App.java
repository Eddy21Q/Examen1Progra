package Principal;

import Vista.GUI;

public class App {
    public static void main(String[] args) throws Exception {

        GUI pantalla = new GUI();

        pantalla.setVisible(true);

        pantalla.setSize(800, 800);

        pantalla.setResizable(false);
        pantalla.setLocationRelativeTo(null);

    }
}
