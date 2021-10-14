// Opret ny bruger funktion. Skal kunne oprette txt-filer. (Ikke implementeret)
// Slet bruger funktion. Skal kunne slette txt-filer. = OK
// Udskriv alle brugernavne.
// Ændre password. (Ikke implementeret)
// Vi har brug for kontonumre til når man skal overføre til andre? Ja - OK
package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bruger {
    String brugernavn;
    int saldo;
    int pinkode;
    int kontonummer;

    public Bruger() {}
    public Bruger(String brugernavn, int saldo, int pinkode, int kontonummer) {
        this.brugernavn = brugernavn;
        this.saldo = saldo;
        this.pinkode = pinkode;
        this.kontonummer = kontonummer;
    }

    public static Bruger LoadBruger(String brugernavn) throws FileNotFoundException {
        // Opret bruger-objekt udfra bruger-fil-path:
        File myObj = new File("src/resources/" + brugernavn);
        Scanner myReader = new Scanner(myObj);
        int kontonummer = 0;
        int pinkode = 0;
        int saldo=0;

        // Sæt bruger-objektets properties udfra bruger-fil:
        kontonummer = myReader.nextInt();
        myReader.nextLine();
        pinkode = myReader.nextInt();
        myReader.nextLine();
        saldo = myReader.nextInt();
        myReader.close();
        Bruger nyBruger = new Bruger(brugernavn,saldo,pinkode,kontonummer);
        return nyBruger;
    }


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

    public void setKontonummer(int kontonummer) {
        this.kontonummer = kontonummer;
    }

}
