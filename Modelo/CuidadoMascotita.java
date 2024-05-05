package Modelo;

public class CuidadoMascotita extends DatosMascota {
    
public CuidadoMascotita(String nombre, String especie, String raza, int edad, boolean esterilizada, int calculoEdad,
            int valor) {
        super(nombre, especie, raza, edad, esterilizada);
        this.calculoEdad = calculoEdad;
        this.valor = valor;
    }
    
int calculoEdad;
int valor;






    
}
