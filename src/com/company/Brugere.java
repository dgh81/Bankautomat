package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Brugere {
    String brugernavn;
    int saldo;
    int pinkode;
    long kontonummer;

    public Brugere() {}

    public Brugere(String brugernavn, int saldo, int pinkode, long kontonummer) {
        this.brugernavn = brugernavn;
        this.saldo = saldo;
        this.pinkode = pinkode;
        this.kontonummer = kontonummer;
    }

    public static Brugere LoadBruger(String brugernavn) throws FileNotFoundException {
        File myObj = new File("C:\\Users\\Daniel\\IdeaProjects\\Bankautomat\\src\\resources\\" + brugernavn);
        // File myObj = new File(brugernavn);
        Scanner myReader = new Scanner(myObj);
        long kontonummer = 0;
        int pinkode = 0;
        int saldo=0;

        kontonummer = myReader.nextLong();
        myReader.nextLine();
        pinkode = myReader.nextInt();
        myReader.nextLine();
        saldo = myReader.nextInt();
        Brugere nyBruger = new Brugere(brugernavn,saldo,pinkode,kontonummer);
        return nyBruger;
    }
    // Burde den her returnere et katalog i stedet?
/*    public static Brugere LoadAlleBrugere() {
        File folder = new File();

    }*/
        // Opret ny bruger funktion. Skal kunne oprette txt-filer.
        // Slet bruger funktion. Skal kunne slette txt-filer.
        // Udskriv alle brugernavne.
        // Ændre password.
        // Tror måske ikke vi har brug for kontonummer? Eller måske til når man skal overføre til anden person?

/*    public static void listFilesForFolder(final File folder) throws FileNotFoundException {
        int i = 0;
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                // code here
                i++;
            }
        }
    }*/




    public String getBrugernavn() {
        return brugernavn;
    }

    public void setBrugernavn(String brugernavn) {
        this.brugernavn = brugernavn;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getPinkode() {
        return pinkode;
    }

    public void setPassword(String password) {
        this.pinkode = pinkode;
    }

    public long getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(long kontonummer) {
        this.kontonummer = kontonummer;
    }

}
