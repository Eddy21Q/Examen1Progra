package Vista;
import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame {

    public GUI() {
        setTitle("Aplicación Protectora de Animales");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null); // Centrar la ventana

        JPanel panel = new JPanel(null); // Layout nulo para configurar manualmente el tamaño y la posición

        // Botones
        JButton btnDarEnAdopcion = new JButton("Dar mascota en adopción");
        JButton btnMostrarMascotas = new JButton("Mostrar mascotas disponibles");
        JButton btnEsterilizacion = new JButton("¿Qué es la esterilización?");

        Color colorCeleste = new Color(255, 153, 153); // Celeste claro
        btnDarEnAdopcion.setBackground(colorCeleste);
        btnMostrarMascotas.setBackground(colorCeleste);
        btnEsterilizacion.setBackground(colorCeleste);

        Font nuevaFuente = new Font("Arial", Font.BOLD, 12); // Fuente más pequeña
        btnDarEnAdopcion.setFont(nuevaFuente);
        btnMostrarMascotas.setFont(nuevaFuente);
        btnEsterilizacion.setFont(nuevaFuente);


        Font fontTitulo = new Font("Arial", Font.BOLD, 24);
JLabel lblTitulo = new JLabel("Fundacion Protectora de Animales");
lblTitulo.setFont(fontTitulo);
lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
getContentPane().add(lblTitulo, BorderLayout.NORTH);

        // Tamaño y posición manual de los botones
        int buttonWidth = 350;
        int buttonHeight = 70;
        btnDarEnAdopcion.setBounds(200, 300, buttonWidth, buttonHeight);
        btnMostrarMascotas.setBounds(200, 400, buttonWidth, buttonHeight);
        btnEsterilizacion.setBounds(200, 500, buttonWidth, buttonHeight);

        // Añadir botones al panel
        panel.add(btnDarEnAdopcion);
        panel.add(btnMostrarMascotas);
        panel.add(btnEsterilizacion);

        // Añadir panel al JFrame
        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI();
            gui.setVisible(true);
        });
    }
}