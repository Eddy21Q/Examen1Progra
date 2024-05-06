package Modelo;

public abstract class DatosMascota {// Creacion de clase padre y abstracta de los datos de las mascotas
    // instancia de variables
    private String nombre;
    private String raza;
    private int edad;
    private boolean esterilizada;

    public DatosMascota(String nombre, String raza, int edad, boolean esterilizada) {// constructor
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.esterilizada = esterilizada;
    }

    // sets y gets
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isEsterilizada() {
        return esterilizada;
    }

    public void setEsterilizada(boolean esterilizada) {
        this.esterilizada = esterilizada;
    }

}
