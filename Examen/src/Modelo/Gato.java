package Modelo;

public class Gato extends DatosMascota {

    public Gato(String nombre, String raza, int edad, boolean esterilizada) {
        super(nombre, raza, edad, esterilizada);

    }

    @Override
    public String toString() {
        return "Gato\n" +
                "nombre: " + getNombre() + "\n" +
                "raza: " + getRaza() + "\n" +
                "edad: " + getEdad() + "\n" +
                "esterilizada: " + isEsterilizada() + "\n";
    }
}
