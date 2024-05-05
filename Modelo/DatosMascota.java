package Modelo;

public abstract class DatosMascota {


    private String nombre;
    private String raza;
    private int edad;
   

    // Constructor
    public DatosMascota(String nombre,String raza, int edad, boolean esterilizada) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
 
    }
    
     


}
