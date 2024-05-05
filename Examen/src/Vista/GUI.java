package Vista;

import java.awt.Color;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame{
  
    public GUI() {

 setTitle("Aplicación Protectora de Animales");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null); // Centrar la ventana

        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN); // Fondo verde

        // Layout vertical
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Espaciador vertical
        panel.add(Box.createVerticalStrut(20)); // Agrega un espacio vertical de 20 píxeles

        // Botones
        JButton btnDarEnAdopcion = new JButton("Dar mascota en adopción");
        JButton btnMostrarMascotas = new JButton("Mostrar mascotas disponibles para adoptar");
        JButton btnEsterilizacion = new JButton("¿Qué es la esterilización y cómo cuidar nuestras mascotas?");

        // Añadir botones al panel
        panel.add(btnDarEnAdopcion);
        panel.add(Box.createVerticalStrut(20)); // Agrega un espacio vertical de 10 píxeles entre los botones
        panel.add(btnMostrarMascotas);
        panel.add(Box.createVerticalStrut(20)); // Agrega otro espacio vertical de 10 píxeles entre los botones
        panel.add(btnEsterilizacion);

        // Añadir panel al JFrame
        getContentPane().add(panel);

        
        
    }

}
