package Modelo;

public class Perro extends DatosMascota {//herencia de la clase DatosMascota

    public Perro(String nombre, String raza, int edad, boolean esterilizada) {//constructor
        super(nombre, raza, edad, esterilizada);//llamado al constructor de la clase padre

    }

    @Override
    public String toString() {//metodo para mostrar los datos de los perros ingresados
        return "Perro\n" +
                "nombre: " + getNombre() + "\n" +
                "raza: " + getRaza() + "\n" +
                "edad: " + getEdad() + "\n" +
                "esterilizada: " + isEsterilizada() + "\n";
    }

}
