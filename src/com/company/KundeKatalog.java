package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class KundeKatalog extends Bruger {
    public KundeKatalog() {}
    public static void loadAlleBrugere() throws FileNotFoundException {
        // ArrayList<Brugere> alleKunder = new ArrayList<Brugere>();
        File folder = new File ("C:\\Users\\Daniel\\IdeaProjects\\Bankautomat\\src\\resources\\");
        listFilesForFolder(folder);
    }
    public static ArrayList<Bruger> listFilesForFolder(final File folder) throws FileNotFoundException {
        int i = 0;
        ArrayList<Bruger> alleKunder = new ArrayList<Bruger>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                Bruger bruger = LoadBruger(fileEntry.getName());
                alleKunder.add(i, bruger);
                i++;
            }
        }
        return alleKunder;
    }
}
