package com.company;
import static com.company.Brugere.LoadBruger;
// import static com.company.Brugere;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class KundeKatalog extends Brugere {


    public KundeKatalog() {}
    public static void loadAlleBrugere() throws FileNotFoundException {
        // ArrayList<Brugere> alleKunder = new ArrayList<Brugere>();
        File folder = new File ("C:\\Users\\Daniel\\IdeaProjects\\Bankautomat\\src\\resources\\");
        listFilesForFolder(folder);
    }
    public static ArrayList<Brugere> listFilesForFolder(final File folder) throws FileNotFoundException {
        int i = 0;
        ArrayList<Brugere> alleKunder = new ArrayList<Brugere>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                Brugere bruger = LoadBruger(fileEntry.getName());
                alleKunder.add(i, bruger);
                i++;
            }
        }
        return alleKunder;
    }
}
