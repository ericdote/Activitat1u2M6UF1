package exercici1u2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercici1u2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Productes p = new Productes();
        
        p.insertarProducte("Hola", 1, 2);
        p.cercarPerNom("Hola");
        p.cercarPerNumero(1);
        p.modificarProductes(189, 1);
        p.cercarPerNumero(1);
        p.imprimirDades();

    }

}
