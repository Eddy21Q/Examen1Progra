
package Modelo;




public class DatosMascota {

    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private boolean esterilizada;

    // Constructor
    public DatosMascota (String nombre, String especie, String raza, int edad, boolean esterilizada) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.esterilizada = esterilizada;
    }
    
}
