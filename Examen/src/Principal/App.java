package Principal;

import Vista.GUI;

public class App {
    public static void main(String[] args) throws Exception {
       System.out.println("HOLA");
        GUI pantalla = new GUI();

        pantalla.setVisible(true);

        pantalla.setSize(1000, 800);

        pantalla.setResizable(false);
        pantalla.setLocationRelativeTo(null);

    }
}
