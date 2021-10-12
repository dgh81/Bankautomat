package com.company;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File folder = new File ("C:\\Users\\Daniel\\IdeaProjects\\Bankautomat\\src\\resources\\");
        ArrayList<Brugere> mineKunder;
        mineKunder = KundeKatalog.listFilesForFolder(folder);
        System.out.println(KundeKatalog.listFilesForFolder(folder).get(1).brugernavn);
        // Login skærm her
            
        // Loop gennem brugere og tjek navn + pass
    }
}

// Brugere testBruger = Brugere.LoadBruger("Allan");

// Brugere testBruger = Brugere.LoadBruger("C:\\Users\\Daniel\\IdeaProjects\\Bankautomat\\src\\resources\\Allan");
// System.out.println(testBruger.getKontonummer());
// System.out.println(testBruger.getPinkode());
// System.out.println(testBruger.getSaldo());

// final File folder = new File("C:\\Users\\Daniel\\IdeaProjects\\Bankautomat\\src\\resources\\");

// KundeKatalog.loadAlleBrugere();



        /*long kontonummer = listFilesForFolder(folder)[0].kontonummer;
        System.out.println(kontonummer);

        System.out.println(listFilesForFolder(folder)[0].getBrugernavn());

        for (Brugere bruger : listFilesForFolder(folder)) {
            if (bruger.getBrugernavn().equalsIgnoreCase("allan")) {
                System.out.println("Fandt Allan!");
            }
        }*/

        // https://stackoverflow.com/questions/1844688/how-to-read-all-files-in-a-folder-from-java
        // for (file in )

/*        String brugernavn;
        System.out.println("LOGIN SCREEN");
        System.out.println("Indtast dit brugernavn og tryk på Enter");
        Scanner scanner = new Scanner(System.in);
        brugernavn = scanner.nextLine();

        String password;
        System.out.println("Indtast din kode og tryk på Enter");
        Scanner scanner1 = new Scanner(System.in);
        password = scanner1.nextLine();*/

// File myObj = new File("src/com/company/" + brugernavn);
// Scanner myReader = new Scanner(myObj);

/*String resultat;
        int i=0;
        String kontonummer="";
        String password_frafil="";
        String saldo="";
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            resultat = data.substring(data.lastIndexOf(": ")+2);
            //System.out.println(resultat);
            if (i==0) {
                kontonummer = resultat;
            } else if (i==1) {
                password_frafil = resultat;
            } else if (i==2) {
                saldo = resultat;
            }
            i++;
        }
        // System.out.println(kontonummer);
        // System.out.println(password_frafil);
        // System.out.println(password);
        // System.out.println(saldo);

        if (password.equalsIgnoreCase(password_frafil)) {
            System.out.println("Succes! Du er nu logget på.");
            //System.out.println(password.equalsIgnoreCase(password_frafil));
            System.out.println("Din saldo er på: " + saldo);
        } else {
            System.out.println("Forkert password. Prøv igen!");
        }*/