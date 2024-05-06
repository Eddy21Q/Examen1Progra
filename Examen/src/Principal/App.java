package Principal;

import Vista.GUI;

public class App {
    public static void main(String[] args) throws Exception {// Main

        GUI pantalla = new GUI();// instancia de la clase GUI para visualizar la interfaz grafica
        pantalla.setVisible(true);//para que se muestre la pantalla o interfaz
        pantalla.setSize(1000, 800);// se le define un tamaño
        pantalla.setResizable(false);//esto evita que el usuario modifique el tamaño de la ventana
        pantalla.setLocationRelativeTo(null);//para que aprezca la interfaz centrada en la pantalla

    }
}
