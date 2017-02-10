package exercici1u2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Productes {

    File file = new File("C:\\Users\\Eric\\Desktop\\DAM\\M6\\UF1\\Ficheros\\Exercici2");

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

    public int cercarCodi() throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        raf.seek(0);
        int codi = raf.readInt();
        raf.seek(0);
        raf.writeInt(++codi);
        raf.close();
        return codi;
    }

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
            }
        } while (raf.getFilePointer() < file.length());
    }

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
            }
        } while (raf.getFilePointer() < file.length());
    }
    
    public void modificarProductes(double preu, int producte) throws FileNotFoundException{
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        
    }

}
