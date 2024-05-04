package Principal;

import Q.Calculo;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");


        int numero1 = 5;
        int numero2 = 7;

        // Llamar al método sumar de la clase Sumadora
        int resultado = Calculo.sumar(numero1, numero2);

        // Presentar el resultado
        System.out.println("La suma de " + numero1 + " y " + numero2 + " es: " + resultado);





    }
}
