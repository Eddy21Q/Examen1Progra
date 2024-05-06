package Modelo;

public class Gato extends DatosMascota {//herencia de la clase DatosMascota

    public Gato(String nombre, String raza, int edad, boolean esterilizada) {//constructor
        super(nombre, raza, edad, esterilizada);//llamada del contructor de la clase padre

    }

    @Override
    public String toString() {//metodo para mostrar los datos de los gatos ingresados
        return "Gato\n" +
                "nombre: " + getNombre() + "\n" +
                "raza: " + getRaza() + "\n" +
                "edad: " + getEdad() + "\n" +
                "esterilizada: " + isEsterilizada() + "\n";
    }
}
