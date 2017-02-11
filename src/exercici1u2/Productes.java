package exercici1u2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Productes {

    File file = new File("C:\\Users\\Eric.DESKTOP-O4VLD9F\\Prueba.txt");
    /**
     * Metode que insereix un producte a partir dels diferents parametres que li arriben i amb el codi corresponent
     * @param nom
     * @param preu
     * @param unitat
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void insertarProducte(String nom, double preu, int unitat) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        int codi = cercarCodi();
        raf.seek(file.length());
        raf.writeInt(codi);
        raf.writeUTF(nom);
        raf.writeDouble(preu);
        raf.writeInt(unitat);

        raf.close();
    }
    /**
     * Metode que cerca el codi actual, si no hi ha en crea un començant per el numero 1, en cas de haver-hi anteriorirs aumenta +1 i el torna
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public int cercarCodi() throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        int codi = 0;
        if(file.length() > 0){
            raf.seek(0);
        codi = raf.readInt();
        raf.seek(0);
        raf.writeInt(++codi);
        raf.close();
        return codi;
        } else {
            raf.seek(0);
            raf.writeInt(++codi);
            raf.close();
            return ++codi;
        }
    }
    /**
     * Metode que li arriba un nom de producte i el cerca per imprimir el producte
     * @param producte
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void cercarPerNom(String producte) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        raf.seek(4);
        int codi, unitat;
        String nom;
        double preu;
        do {
            codi = raf.readInt();
            nom = raf.readUTF();
            preu = raf.readDouble();
            unitat = raf.readInt();
            if (nom.equals(producte)) {
                System.out.println("Producte trobat:\n"
                        + "Codi: " + codi + "\n"
                        + "Nom: " + nom + "\n"
                        + "Preu:" + preu + "\n"
                        + "Unitat: " + unitat);
                break;
            }
        } while (raf.getFilePointer() < file.length());
        raf.close();
    }
    /**
     * Metode que li arriba el codi del producte i el cerca per imprimir-lo
     * @param producte
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void cercarPerNumero(int producte) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        raf.seek(4);
        int codi, unitat;
        String nom;
        double preu;
        do {
            codi = raf.readInt();
            nom = raf.readUTF();
            preu = raf.readDouble();
            unitat = raf.readInt();
            if (codi == producte) {
                System.out.println("Producte trobat:\n"
                        + "Codi: " + codi + "\n"
                        + "Nom: " + nom + "\n"
                        + "Preu:" + preu + "\n"
                        + "Unitat: " + unitat);
                break;
            }
        } while (raf.getFilePointer() < file.length());
        raf.close();
    }
    /**
     * Metode que li arriba un preu i el codi del producte per modificar-ho
     * @param preu
     * @param producte
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void modificarProductes(double preu, int producte) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.seek(4);
        int codi;
        do {
            codi = raf.readInt();
            if (codi == producte) {
                raf.readUTF();
                raf.writeDouble(preu);
                break;
            }
        } while (true);
        raf.close();
    }
    /**
     * Metode que imprimeix les dades de tots els productes
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void imprimirDades() throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.seek(4);
        do {
            System.out.println("Codi producte: " + raf.readInt() + "\n"
                    + "Nom: " + raf.readUTF() + "\n"
                    + "Preu: " + raf.readDouble() + "\n"
                    + "Unitat: " + raf.readInt() + "\n"
                    + "-----------------------------------------");
        } while (raf.getFilePointer() < file.length());
        raf.close();
    }
}
