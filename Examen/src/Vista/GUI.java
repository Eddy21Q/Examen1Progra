package Vista;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JFrame{
  
    public GUI() {
        System.out.println("hhhhghfhfh");
        System.out.println("kjlkkjkljk");

 setTitle("Aplicación Protectora de Animales");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null); // Centrar la ventana
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN); // Fondo verde


 try {
            // Lee la imagen del archivo
            Image imagenOriginal = ImageIO.read(new File("C:\\Users\\josue\\Documents\\Examen1Progra\\Examen\\Imagenes\\image.png"));
            
            // Escala la imagen al tamaño deseado
            Image imagenEscalada = imagenOriginal.getScaledInstance(300, 200, Image.SCALE_SMOOTH); // Cambia los valores según el tamaño deseado
            
            // Crea un ImageIcon con la imagen escalada
            ImageIcon icono = new ImageIcon(imagenEscalada);
            
            // Crea un JLabel con la imagen
            JLabel labelImagen = new JLabel(icono);
            
            // Agrega el JLabel al panel en el centro
            panel.add(labelImagen, BorderLayout.CENTER);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        // Layout vertical
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Espaciador vertical
        panel.add(Box.createVerticalStrut(20)); // Agrega un espacio vertical de 20 píxeles

        // Botones
        JButton btnDarEnAdopcion = new JButton("Dar mascota en adopción");
        JButton btnMostrarMascotas = new JButton("Mostrar mascotas disponibles para adoptar");
        JButton btnEsterilizacion = new JButton("¿Qué es la esterilización y cómo cuidar nuestras mascotas?");



        Color colorCeleste = new Color(255, 153, 153); // Celeste claro
        btnDarEnAdopcion.setBackground(colorCeleste);
        btnMostrarMascotas.setBackground(colorCeleste);
        btnEsterilizacion.setBackground(colorCeleste);


        Font nuevaFuente = new Font("Arial", Font.BOLD, 16);
        btnDarEnAdopcion.setFont(nuevaFuente);
        btnMostrarMascotas.setFont(nuevaFuente);
        btnEsterilizacion.setFont(nuevaFuente);



        btnDarEnAdopcion.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnMostrarMascotas.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEsterilizacion.setAlignmentX(Component.CENTER_ALIGNMENT);


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
