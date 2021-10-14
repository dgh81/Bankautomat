// Ønskeliste:
// 1. Slette (og oprette brugere) = OK
// 2. Login og logout = OK
// 3. Interface/menu = Struktur OK
// 4. Penge overfør og modtage = OK
// 5. Hæv penge = OK
// 6. Valuta = OK
// 7. Se saldo = OK
// 8. Sæt ind = OK
// 9. fejlmeddelelse
// 10. Ingen overtræk
// Nice to have:
// 1. Veksling.
// 2. Aktiespil
// 3. opretBruger = OK
// 4. Lav tests for brugerinput - man skal ikke kunne skrive bogstaver hvis den spørger om pinkode etc.
// 5. Bedre navngivning af variable
// 6. Skjul pinkode
// 7. Underskud på kontoen låser sletning af den
package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import static com.company.Interface.interface2;
// import java.io.PrintStream;

// ****************** SPØRGSMÅL TIL ANDRAS: *********************************
// 1. hvordan kalder man main() fra en anden klasse?
// 2. hvordan clearer man terminal/run-window eller hvad det hedder?
// 3.
public class Main {
    public static void main(String[] args) throws IOException {
        //Login skærm:
        // System.out.flush();

        // Runtime.getRuntime().exec("clear");
        // System.out.print("\033[H\033[2J");
        // System.out.flush();

        Bruger bruger = new Bruger();
        bruger = Login();
        // Hvis der nu findes en bruger skal vi køre nedenstående:

        if (bruger != null) {
            interface2(bruger);
        } else {
            main(null);
        }
        main(null);
    }
    public static void pengeoverførsel(Bruger bruger) throws IOException {
        int kontonummer = 0;
        int beløb = 0;
        System.out.println("Hvilket kontonummer vil du overføre til: ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            kontonummer = scanner.nextInt();
        } else {
            System.out.println("Du SKAL indtaste et heltal! Prøv igen.");
            // pengeoverførsel(bruger);
        }

        Bruger targetBruger = new Bruger();
        targetBruger = findBrugerViaKontonummer(kontonummer);
        boolean harBeløb = false;
        myLABEL: while(!harBeløb) {
            System.out.println("Hvor mange penge vil du overføre?:");
            Scanner scan_beløb = new Scanner(System.in);

            if (scan_beløb.hasNextInt()) {
                harBeløb = true;
                beløb = scan_beløb.nextInt();
                beløb = Math.abs(beløb);
                targetBruger.saldo = targetBruger.saldo + beløb;
                bruger.saldo = bruger.saldo - beløb;

                // Save til fil
                String nyTXTfil_target_bruger = targetBruger.getKontonummer() + "\n" + targetBruger.getPinkode() + "\n" + targetBruger.getSaldo();
                String nyTXTfil_bruger = bruger.getKontonummer() + "\n" + bruger.getPinkode() + "\n" + bruger.getSaldo();
                String bruger_fil_adresse = "src/resources/" + bruger.getBrugernavn();
                String targetbruger_fil_adresse = "src/resources/" + targetBruger.getBrugernavn();

                FileWriter myWriter = new FileWriter(bruger_fil_adresse);
                myWriter.write(nyTXTfil_bruger);
                myWriter.close();
                FileWriter myWriter2 = new FileWriter(targetbruger_fil_adresse);
                myWriter2.write(nyTXTfil_target_bruger);
                myWriter2.close();
            } else {
                System.out.println("Du SKAL indtaste et heltal! Prøv igen.");
                // pengeoverførsel(bruger);
                harBeløb = false;
                continue myLABEL;
            }
            // System.out.println("target_bruger saldo: " + targetBruger.saldo + "\n" + "bruger.saldo: " + bruger.saldo);
            System.out.println("Din saldo er nu på: " + bruger.getSaldo());
        }
    }
    public static Bruger findBrugerViaKontonummer(int kontonummer) throws FileNotFoundException {
        File folder = new File ("src/resources/");
        ArrayList<Bruger> mineKunder;
        mineKunder = KundeKatalog.listFilesForFolder(folder);

        for (Bruger bruger : mineKunder) {
            if (bruger.getKontonummer() == kontonummer) {
                // System.out.println(bruger.getBrugernavn());
                return bruger;
            }
        }
        return null;
    }
    public static void hæv(Bruger bruger) throws IOException {
        int beløb=0;
        Scanner scanner_beløb = new Scanner(System.in);
        if (scanner_beløb.hasNextInt()) {
            beløb = Math.abs(scanner_beløb.nextInt());
            bruger.setSaldo(bruger.getSaldo() - beløb);
            System.out.println("Du har hævet: " + beløb + "\nDin saldo er nu: " + bruger.getSaldo());
        } else {
            System.out.println("Du SKAL indtaste et heltal! Prøv igen.");
            hæv(bruger);
        }
        interface2(bruger);
    }

    public static void indsæt(Bruger bruger) throws IOException {

        int beløb=0;
        Scanner scanner_beløb_tilføj = new Scanner(System.in);
        if (scanner_beløb_tilføj.hasNextInt()) {
            beløb = Math.abs(scanner_beløb_tilføj.nextInt());
            bruger.setSaldo(bruger.getSaldo() + beløb);
            System.out.println("Du har indsat: " + beløb + "\nDin saldo er nu: " + bruger.getSaldo());
        } else {
            System.out.println("Du SKAL indtaste et heltal! Prøv igen.");
            indsæt(bruger);
        }
        interface2(bruger);
    }

    public static void sletBruger(Bruger bruger) {
        // Vi har åbnet scannerne igen. Kan være de skal lukkes inden vi sletter brugerne!
        File myFile = new File("src/resources/" + bruger.getBrugernavn());
        // System.out.println(myFile.getAbsolutePath());
        if (bruger.getSaldo() >= 0) {
            try {
                // myFile.deleteOnExit();
                if (myFile.delete()) {
                    System.out.println("Slettede filen: " + myFile.getName());
                } else {
                    System.out.println("Kunne ikke slette filen.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Du kan ikke slette din konto, sålænge saldoen er negativ! FY!");
        }
    }
        public static Bruger Login () throws FileNotFoundException {
            // Login skærm her

            System.out.println("BANKEN DAT");
            System.out.println("LOGIN SCREEN");
            System.out.println("Indtast dit brugernavn og tryk på Enter");
            Scanner scanner = new Scanner(System.in);
            String brugernavn = scanner.nextLine();

            System.out.println("Indtast din kode og tryk på Enter");
            Scanner scanner1 = new Scanner(System.in);
            int pinkode = scanner1.nextInt();
            scanner1.nextLine();
            File folder = new File("src/resources/");
            ArrayList<Bruger> mineKunder;
            mineKunder = KundeKatalog.listFilesForFolder(folder);

            for (Bruger bruger : mineKunder) {
                if (bruger.getBrugernavn().equals(brugernavn) && bruger.getPinkode() == pinkode) {
                    System.out.println("Succes! Du er nu logget på som: " + brugernavn + ".\n"); // + "Din pinkode er: " + pinkode);
//                scanner.close();
//                scanner1.close();
                    return bruger;
                }
            }
            System.out.println("Noget gik galt. Prøv igen");
//        scanner.close();
//        scanner1.close();
            return null;
        }

/*    public static void interface2(Bruger bruger) throws IOException {
        Scanner scanInter = new Scanner(System.in);
        System.out.printf("%3s%25s%25s\n%3s%19s%29s\n%3s%23s\n","1==saldo",
                "2==hæv penge","3==sæt penge","4==overføre","5==valuta","6==ny bruger","7==slet bruger","afslut==gem og afslut"*//*,"help==commandlist"*//*);
        System.out.println("Vælg et nummer og tryk på Enter");
        String command= scanInter.nextLine();

        //saldo
        if ("1".equals(command)) {
            System.out.println("Din saldo er på: " + bruger.getSaldo());
            interface2(bruger);
        }

        //hæv penge
        else if ("2".equals(command)) {
            System.out.println("Hvor mange penge vil du hæve?");
            hæv(bruger);
        }

        //sæt penge ind
        else if ("3".equals(command)) {
            System.out.println("Hvor meget vil du indsætte?");
            indsæt(bruger);
        }
        //overføre penge
        else if ("4".equals(command)) {
            pengeoverførsel(bruger);
            interface2(bruger);
        }
        //valuta
        else if ("5".equals(command)) {
            int beløb_dollar = 0;
            beløb_dollar = bruger.getSaldo() * 7;
            System.out.println("Beløb i dollars: " + beløb_dollar);
            interface2(bruger);
        }
        //new bruger
        else if ("6".equals(command)) {
            System.out.println("Du kan desværre ikke oprette en ny bruger ved automaten. \nGå ind i banken, så hjælper vi dig gerne.");
            interface2(bruger);
        }
        //delete bruger
        else if ("7".equals(command)) {
            System.out.println("Er du sikker på du vil slette? ja eller nej");
            String command7 = scanInter.nextLine();
            if ("ja".equals(command)) {
                sletBruger(bruger);
            }
            else if ("nej".equals(command)) {
                interface2(bruger);
            }
            else {
                System.out.println("fejl");
                interface2(bruger);
            }
        }
        //save and close
        else if ("afslut".equals(command)) {
            System.out.println("er du sikker på vil afslutte\n ja eller nej");
            //mangler link to log in
            String command9 = scanInter.nextLine();
            if ("ja".equals(command)) {
                // Nedenstående virker ikke ?
                // main(null);
                System.out.println("Du vil nu logge af.");
                // Bruger bruger2 = new Bruger();
                // bruger2 = Login();
                // main(null);

            } else if("nej".equals(command)) {
                interface2(bruger);
            }
        } else {
            System.out.println("Kommandoen " + command + " findes ikke!");
            interface2(bruger);
        }
    }*/

}

/*
String[] arguments = new String[] {"123"};
        main(arguments);
 */


/*        try {
            Files.deleteIfExists(Paths.get("C:\\Users\\Daniel\\IdeaProjects\\Bankautomat\\src\\resources\\Test"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/

/*
  import java.io.Console;
    public class Main {

        public void passwordExample() {
            Console console = System.console();
            if (console == null) {
                System.out.println("Couldn't get Console instance");
                System.exit(0);
            }

            console.printf("Testing password%n");
            char[] passwordArray = console.readPassword("Enter your secret password: ");
            console.printf("Password entered was: %s%n", new String(passwordArray));

        }

        public static void main(String[] args) {
            new Main().passwordExample();
        }
    }
*/
/*    public ArrayList<Brugere> findUsingStream(String search, ArrayList<Brugere> list) {
        ArrayList<String> matchingElements = list.stream().filter(str -> str.trim().contains(search));
        return matchingElements;
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