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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame{
  
    public GUI() {
  

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
            
            // Crea un JLabel con la imagen y lo centra horizontalmente
            JLabel labelImagen = new JLabel(icono);
            labelImagen.setHorizontalAlignment(SwingConstants.CENTER);
            
            // Agrega el JLabel al panel
            panel.add(labelImagen, BorderLayout.CENTER);

            labelImagen.setBorder(new EmptyBorder(0, 0, 0, 110)); 

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
    
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
    
        // Añadir botones al panel de botones
        panelBotones.add(btnDarEnAdopcion);
        panelBotones.add(Box.createVerticalStrut(20)); // Espacio entre botones
        panelBotones.add(btnMostrarMascotas);
        panelBotones.add(Box.createVerticalStrut(20)); // Espacio entre botones
        panelBotones.add(btnEsterilizacion);
    
        // Agregar el panel de botones al panel principal en el este
        panel.add(panelBotones, BorderLayout.EAST);
    
        // Añadir panel al JFrame
        getContentPane().add(panel);

        
        
    }

}
