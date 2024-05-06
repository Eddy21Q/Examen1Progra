package Modelo;

public class Perro extends DatosMascota {

    public Perro(String nombre, String raza, int edad, boolean esterilizada) {
        super(nombre, raza, edad, esterilizada);

    }

    @Override
    public String toString() {
        return "Perro\n" +
                "nombre:'" + getNombre() + '\'' + "\n" +
                "raza: " + getRaza() + "\n" +
                "edad: " + getEdad() + "\n" +
                "esterilizada: " + isEsterilizada() + "\n";
    }

}
