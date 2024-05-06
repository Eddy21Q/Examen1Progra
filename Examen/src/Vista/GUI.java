package Vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controlador.Control;
import Modelo.DatosMascota;
import Modelo.Gato;
import Modelo.Perro;

public class GUI extends JFrame {
    private JPanel panelContenido;
    private ArrayList<DatosMascota> listaMascotas;

    public GUI() {
        setTitle("Aplicación Protectora de Animales");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        panelContenido = new JPanel();
        panelContenido.setLayout(new BorderLayout());
        panelContenido.setBackground(new Color(173, 216, 230)); // Color de fondo claro

        listaMascotas = new ArrayList<>();

        mostrarMenuPrincipal();

        getContentPane().add(panelContenido);
        // Agregar un borde vacío alrededor del panel principal para un mejor aspecto
        panelContenido.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        Control controlador = new Control(this);
    }

    public void mostrarPanelAdopcion() {
        panelContenido.removeAll();
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        // Crear el título del panel de adopción
        JLabel lblTitulo = new JLabel("DAR EN ADOPCIÓN", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24)); // Fuente y tamaño del título
        lblTitulo.setForeground(new Color(51, 102, 204)); // Color azul para el texto
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Espaciado alrededor del título

        // Crear el panel de formulario para ingresar los datos de la mascota
        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 10, 10)); // GridLayout para organizar los campos de
                                                                           // formulario
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50)); // Espaciado alrededor del formulario

        // Campos de texto para ingresar los datos de la mascota
        JTextField txtNombre = new JTextField();
        JTextField txtRaza = new JTextField();
        JTextField txtEdad = new JTextField();
        JCheckBox chkEsterilizada = new JCheckBox("Esterilizada");

        // Etiquetas para los campos de formulario
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblRaza = new JLabel("Raza:");
        JLabel lblEdad = new JLabel("Edad:");

        // Estilizar las etiquetas
        lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
        lblRaza.setFont(new Font("Arial", Font.BOLD, 16));
        lblEdad.setFont(new Font("Arial", Font.BOLD, 16));

        // Estilizar los campos de texto
        txtNombre.setFont(new Font("Arial", Font.PLAIN, 16));
        txtRaza.setFont(new Font("Arial", Font.PLAIN, 16));
        txtEdad.setFont(new Font("Arial", Font.PLAIN, 16));

        // Estilizar el checkbox
        chkEsterilizada.setFont(new Font("Arial", Font.PLAIN, 16));

        // Agregar los componentes al panel de formulario
        panelFormulario.add(lblNombre);
        panelFormulario.add(txtNombre);
        panelFormulario.add(lblRaza);
        panelFormulario.add(txtRaza);
        panelFormulario.add(lblEdad);
        panelFormulario.add(txtEdad);
        panelFormulario.add(new JLabel()); // Espacio vacío para alinear el checkbox
        panelFormulario.add(chkEsterilizada);

        // Crear el botón de guardar
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Arial", Font.BOLD, 16)); // Estilizar el botón
        btnGuardar.setBackground(new Color(102, 204, 102)); // Color de fondo verde claro
        btnGuardar.setForeground(Color.WHITE); // Color de texto blanco
        btnGuardar.setBorder(BorderFactory.createLineBorder(new Color(51, 102, 51))); // Borde del botón
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String raza = txtRaza.getText();
                int edad;
                boolean esterilizada = chkEsterilizada.isSelected();

                try {
                    edad = Integer.parseInt(txtEdad.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingresa una edad válida");
                    return;
                }

                // Crear una instancia de Perro o Gato según la raza ingresada
                DatosMascota nuevaMascota;
                if (raza.equalsIgnoreCase("perro")) {
                    nuevaMascota = new Perro(nombre, raza, edad, esterilizada);
                } else if (raza.equalsIgnoreCase("gato")) {
                    nuevaMascota = new Gato(nombre, raza, edad, esterilizada);
                } else {
                    JOptionPane.showMessageDialog(null, "Raza no válida (Perro o Gato)");
                    return;
                }

                // Agregar la nueva mascota a la lista
                listaMascotas.add(nuevaMascota);
                JOptionPane.showMessageDialog(null, "Mascota añadida correctamente");
                mostrarMenuPrincipal(); // Volver al menú principal después de guardar
            }
        });

        // Crear el botón para volver al Menú Principal
        JButton btnVolver = new JButton("Volver al Menú Principal");
        btnVolver.setFont(new Font("Arial", Font.BOLD, 16)); // Estilizar el botón
        btnVolver.setBackground(new Color(255, 153, 153)); // Color de fondo rosa claro
        btnVolver.setForeground(Color.WHITE); // Color de texto blanco
        btnVolver.setBorder(BorderFactory.createLineBorder(new Color(204, 0, 0))); // Borde del botón
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarMenuPrincipal();
            }
        });

        // Agregar los componentes al panel principal
        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);
        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotones.add(btnGuardar);
        panelBotones.add(btnVolver);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        // Agregar el panel principal al contenido principal
        panelContenido.add(panelPrincipal, BorderLayout.CENTER);
        panelContenido.revalidate();
        panelContenido.repaint();
    }

    public void mostrarInfoEsterilizacion() {
        panelContenido.removeAll();
        JPanel panelPrincipal = new JPanel(new BorderLayout());
    
        // Crear el título del panel de información sobre la esterilización
        JLabel lblTitulo = new JLabel("Información Importante sobre la Esterilización y el Bienestar Animal", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24)); // Fuente y tamaño del título
        lblTitulo.setForeground(new Color(51, 102, 204)); // Color azul para el texto
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Espaciado alrededor del título
    
        // Crear el panel de texto con la información sobre la esterilización
        JTextArea txtInfoEsterilizacion = new JTextArea();
        txtInfoEsterilizacion.setFont(new Font("Arial", Font.PLAIN, 16)); // Estilo del texto
        txtInfoEsterilizacion.setLineWrap(true); // Activar el ajuste de línea automático
        txtInfoEsterilizacion.setWrapStyleWord(true); // Activar el ajuste de palabra automático
        txtInfoEsterilizacion.setEditable(false); // No editable por el usuario
    
        // Aquí puedes agregar el texto con la información sobre la esterilización
        String info = "Según un reporte hecho por Mora (2023) donde expone un estudio realizado por Humane Society International que revela tendencias positivas con respecto al bienestar de los animales de compañía, él estudio asevera que \"Los programas de castración esterilización de perros y gatos callejeros parecen estar dando resultado en el objetivo de disminuir la sobrepoblación de estos animales en Costa Rica\"(parr.1).\n" +
                "La esterilización de nuestras mascotas es muy importante, ya que como se lee en la cita anterior disminuye la sobrepoblación de estos animalitos y mitiga la cantidad de estos en condición de calle.\n" + // " " +
                "Según señaló la directora ejecutiva de HSI Latinoamérica, Andrea Borel como se cito en Mora (2023): \"Estos son datos vitales que ayudarán a HSI a colaborar con los programas de bienestar animal existentes en Costa Rica para lograr un cambio sostenible, a través del manejo humanitario de la población de perros y gatos, la esterilización asequible y accesible, la atención veterinaria preventiva, la educación pública y una cultura fortalecida de tenencia responsable de mascotas”(parr.5).\n" +
                "Debemos ser mas humanos y entender que ningún ser merece afrontarse a situaciones tan adversas como vivir en condición de calle, se debe tener buenos valores y principios que nos hagan responsables y mas sensibles sobre el cuidado de nuestras mascotas.\n\n"+
                "A continuación se compartiran algunos puntos importantes que consideramos como fundación son imprencindibles en el bienestar animal:\n"+
                "1-Atención veterinaria adecuada: Todos los animales bajo el cuidado de la fundación deben recibir atención veterinaria regular, incluyendo chequeos de salud, vacunas, desparasitación y tratamiento para cualquier enfermedad o lesión.\n"+
                "2-Nutrición balanceada: Proporcionar una dieta adecuada y balanceada es esencial para mantener la salud y el bienestar de los animales. Esto implica ofrecer alimentos de alta calidad y en las cantidades adecuadas para cada etapa de la vida.\n"+
                "3-Espacio y ambiente adecuados: Los animales necesitan un espacio limpio y seguro donde puedan moverse libremente, descansar y jugar. Proporcionar un ambiente enriquecido con juguetes, áreas de descanso y estimulación mental es clave para su bienestar.\n"+
                "4-Socialización y ejercicio: Los perros y gatos son animales sociales que necesitan interacción con otros animales y personas. Es importante ofrecer oportunidades de socialización y ejercicio regular, como paseos, juegos y actividades en grupo.\n"+
                "5-Promoción de la adopción responsable: Fomentar la adopción responsable implica educar a los adoptantes potenciales sobre las necesidades y responsabilidades que implica tener una mascota, así como realizar procesos de selección cuidadosos para garantizar que los animales sean adoptados por familias adecuadas.\n"+
                "6-Programas de esterilización y castración: La esterilización y castración ayudan a controlar la población de animales sin hogar y a prevenir problemas de salud y comportamiento. Ofrecer programas de esterilización/castración a bajo costo o gratuitos puede ser una forma efectiva de promover el bienestar animal."
                
                ;
    
        txtInfoEsterilizacion.setText(info);
    
        // Crear el panel de scroll para el texto
        JScrollPane scrollPane = new JScrollPane(txtInfoEsterilizacion);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(100, 100)); // Reducir el tamaño del JScrollPane
    
        // Crear el panel para la imagen
        JPanel panelImagen = new JPanel(new BorderLayout());
        ImageIcon imagen = new ImageIcon("ruta/a/tu/imagen.jpg"); // Reemplaza con la ruta de tu imagen
        JLabel lblImagen = new JLabel(imagen);
        panelImagen.add(lblImagen, BorderLayout.CENTER);
    
        // Crear el botón para volver al Menú Principal
        JButton btnVolver = new JButton("Volver al Menú Principal");
        btnVolver.setFont(new Font("Arial", Font.BOLD, 16)); // Estilizar el botón
        btnVolver.setBackground(new Color(255, 153, 153)); // Color de fondo rosa claro
        btnVolver.setForeground(Color.WHITE); // Color de texto blanco
        btnVolver.setBorder(BorderFactory.createLineBorder(new Color(204, 0, 0))); // Borde del botón
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarMenuPrincipal();
            }
        });
    
        // Agregar los componentes al panel principal
        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelImagen, BorderLayout.SOUTH); // Agregar el panel de la imagen debajo del JTextArea
        panelPrincipal.add(btnVolver, BorderLayout.SOUTH); // Mover el botón al sur también
    
        // Agregar el panel principal al contenido principal
        panelContenido.add(panelPrincipal, BorderLayout.CENTER);
        panelContenido.revalidate();
        panelContenido.repaint();


}



public void mostrarMenuPrincipal() {
    panelContenido.removeAll();
    JPanel panelPrincipal = new JPanel(new BorderLayout());

    // Crear el título de la fundación
    JLabel lblTitulo = new JLabel("FUNDACIÓN DE ADOPCIÓN DE MASCOTAS", SwingConstants.CENTER);
    lblTitulo.setFont(new Font("Arial", Font.BOLD, 28)); // Fuente y tamaño del título
    lblTitulo.setForeground(new Color(51, 102, 204)); // Color azul para el texto
    lblTitulo.setBorder(BorderFactory.createEmptyBorder(40, 0, 20, 0)); // Espaciado alrededor del título

    // Crear el panel de botones
    JPanel panelBotones = new JPanel();
    panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); // Usar FlowLayout para botones en una línea horizontal
    panelBotones.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0)); // Espaciado abajo

    // Crear botones con estilo
    JButton btnDarEnAdopcion = new JButton("Dar mascota en adopción");
    JButton btnMostrarMascotas = new JButton("Mostrar mascotas disponibles para adoptar");
    JButton btnAdoptar = new JButton("Adoptar"); // Nuevo botón para adoptar mascotas
    JButton btnOtroBoton = new JButton("Información importante sobre la esterilización"); // Texto del botón modificado
    btnDarEnAdopcion.setFont(new Font("Arial", Font.BOLD, 20)); // Fuente y tamaño de botones
    btnMostrarMascotas.setFont(new Font("Arial", Font.BOLD, 20));
    btnAdoptar.setFont(new Font("Arial", Font.BOLD, 20));
    btnOtroBoton.setFont(new Font("Arial", Font.BOLD, 20));
    btnDarEnAdopcion.setBackground(new Color(255, 204, 204)); // Color de fondo rosa claro
    btnMostrarMascotas.setBackground(new Color(255, 204, 204));
    btnAdoptar.setBackground(new Color(255, 204, 204)); // Color de fondo rosa claro
    btnOtroBoton.setBackground(new Color(255, 204, 204));
    btnDarEnAdopcion.setForeground(Color.DARK_GRAY); // Color de texto oscuro
    btnMostrarMascotas.setForeground(Color.DARK_GRAY);
    btnAdoptar.setForeground(Color.DARK_GRAY); // Color de texto oscuro
    btnOtroBoton.setForeground(Color.DARK_GRAY);
    btnDarEnAdopcion.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)); // Borde del botón
    btnMostrarMascotas.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
    btnAdoptar.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)); // Borde del botón
    btnOtroBoton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

    // Agregar acciones a los botones
    btnDarEnAdopcion.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            mostrarPanelAdopcion();
        }
    });
    btnMostrarMascotas.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            mostrarMascotas();
        }
    });
    btnAdoptar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Aquí puedes llamar a un método para mostrar un panel de adopción y manejar la adopción de mascotas
            mostrarPanelAdoptarMascota();
        }
    });
    
    btnOtroBoton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            mostrarInfoEsterilizacion(); // Acción para mostrar la información sobre la esterilización
        }
    });

    // Ajustar el tamaño de los botones
    Dimension btnSize = new Dimension(600, 50);
    btnDarEnAdopcion.setPreferredSize(btnSize);
    btnMostrarMascotas.setPreferredSize(btnSize);
    btnAdoptar.setPreferredSize(btnSize);
    btnOtroBoton.setPreferredSize(btnSize);

    // Agregar botones al panel de botones
    panelBotones.add(btnDarEnAdopcion);
    panelBotones.add(btnMostrarMascotas);
    panelBotones.add(btnAdoptar);
    panelBotones.add(btnOtroBoton);

    // Agregar el título y los botones al panel principal
    panelPrincipal.add(lblTitulo, BorderLayout.NORTH);
    panelPrincipal.add(panelBotones, BorderLayout.CENTER);

    // Espacio para las imágenes
    JPanel panelImagenes = new JPanel(new FlowLayout(FlowLayout.CENTER));
    panelImagenes.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Espaciado arriba y abajo

    // Cargar la imagen y ajustar su tamaño
    ImageIcon imagenIcono = new ImageIcon("C:/Users/demia/Documents/Examen1Progra/Examen/Imagenes/menu.jpg"); // Reemplaza // imagen
    Image imagen = imagenIcono.getImage();
    Image imagenEscalada = imagen.getScaledInstance(600, -1, Image.SCALE_SMOOTH); // Ajusta el ancho a 400 y escala

    ImageIcon imagenEscaladaIcono = new ImageIcon(imagenEscalada);

    // Crear un JLabel con la imagen escalada
    JLabel lblImagen = new JLabel(imagenEscaladaIcono);
    panelImagenes.add(lblImagen);

    // Agregar el panel de imágenes al contenido principal
    panelContenido.add(panelPrincipal, BorderLayout.CENTER);
    panelContenido.add(panelImagenes, BorderLayout.SOUTH);
    

    panelContenido.revalidate();
    panelContenido.repaint();
}

public void mostrarPanelAdoptarMascota() {
    panelContenido.removeAll();
    JPanel panelPrincipal = new JPanel(new BorderLayout());

    // Crear el título del panel de adopción de mascotas
    JLabel lblTitulo = new JLabel("Adoptar una mascota", SwingConstants.CENTER);
    lblTitulo.setFont(new Font("Arial", Font.BOLD, 24)); // Fuente y tamaño del título
    lblTitulo.setForeground(new Color(51, 102, 204)); // Color azul para el texto
    lblTitulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Espaciado alrededor del título

    // Crear un campo de texto para ingresar el nombre de la mascota a adoptar
    JTextField txtNombreMascota = new JTextField(20);
    txtNombreMascota.setFont(new Font("Arial", Font.PLAIN, 16)); // Fuente y tamaño del texto

    // Crear un botón para confirmar la adopción
    JButton btnConfirmarAdopcion = new JButton("Adoptar");
    btnConfirmarAdopcion.setFont(new Font("Arial", Font.BOLD, 16)); // Fuente y tamaño del botón

    // Acción del botón para confirmar la adopción
    btnConfirmarAdopcion.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Capturar el nombre de la mascota ingresado
            String nombreMascota = txtNombreMascota.getText();
            // Verificar si el nombre de la mascota está en la lista de mascotas disponibles
            boolean mascotaDisponible = false;
            DatosMascota mascotaAdoptada = null;
            for (DatosMascota mascota : listaMascotas) {
                if (mascota.getNombre().equalsIgnoreCase(nombreMascota)) {
                    mascotaDisponible = true;
                    mascotaAdoptada = mascota;
                    break;
                }
            }
            // Mostrar un JOptionPane si la mascota no está disponible
            if (!mascotaDisponible) {
                JOptionPane.showMessageDialog(null, "La mascota no está disponible para adopción.", "Mascota No Disponible", JOptionPane.WARNING_MESSAGE);
            } else {
                // Eliminar la mascota del ArrayList
                listaMascotas.remove(mascotaAdoptada);
                // Mostrar un JOptionPane con los datos de la mascota adoptada
                String mensaje = "Mascota adoptada con éxito:\n" +
                                 "Nombre: " + mascotaAdoptada.getNombre() + "\n" +
                                 "Raza: " + mascotaAdoptada.getRaza() + "\n" +
                                 "Edad: " + mascotaAdoptada.getEdad() + "\n" +
                                 "Esterilizada: " + (mascotaAdoptada.isEsterilizada() ? "Sí" : "No");
                JOptionPane.showMessageDialog(null, mensaje, "Adopción Exitosa", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    });
    
    JButton btnVolverMenuPrincipal = new JButton("Volver al Menú Principal");
    btnVolverMenuPrincipal.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            mostrarMenuPrincipal(); // Volver al menú principal al presionar este botón
        }
    });
    panelPrincipal.add(btnVolverMenuPrincipal, BorderLayout.SOUTH);
    // Crear un panel para organizar los componentes
    JPanel panelFormulario = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
    panelFormulario.add(new JLabel("Nombre de la mascota: "));
    panelFormulario.add(txtNombreMascota);
    panelFormulario.add(btnConfirmarAdopcion);

    // Agregar el título y el panel de adopción al panel principal
    panelPrincipal.add(lblTitulo, BorderLayout.NORTH);
    panelPrincipal.add(panelFormulario, BorderLayout.CENTER);

    // Agregar el panel principal al contenido
    panelContenido.add(panelPrincipal, BorderLayout.CENTER);

    panelContenido.revalidate();
    panelContenido.repaint();
}
 
    public void addDarEnAdopcionListener(ActionListener listener) {
        // Obtener el botón Dar mascota en adopción
        Component[] components = ((JPanel) panelContenido.getComponent(0)).getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton btnDarEnAdopcion = (JButton) component;
                if (btnDarEnAdopcion.getText().equals("Dar mascota en adopción")) {
                    btnDarEnAdopcion.addActionListener(listener);
                    break;
                }
            }
        }
    }

    public void addMostrarMascotasListener(ActionListener listener) {
        // Obtener el botón Mostrar mascotas disponibles para adoptar
        Component[] components = ((JPanel) panelContenido.getComponent(0)).getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton btnMostrarMascotas = (JButton) component;
                if (btnMostrarMascotas.getText().equals("Mostrar mascotas disponibles para adoptar")) {
                    btnMostrarMascotas.addActionListener(listener);
                    break;
                }
            }
        }
    }

    public void mostrarMascotas() {
        panelContenido.removeAll();
        JTextArea areaMascotas = new JTextArea();
        for (DatosMascota mascota : listaMascotas) {
            areaMascotas.append(mascota.toString() + "\n");
        }
        panelContenido.add(new JScrollPane(areaMascotas), BorderLayout.CENTER);

        JButton btnVolver = new JButton("Volver al Menú Principal");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarMenuPrincipal();
            }
        });

        panelContenido.add(btnVolver, BorderLayout.SOUTH);

        panelContenido.revalidate();
        panelContenido.repaint();
    }
}
