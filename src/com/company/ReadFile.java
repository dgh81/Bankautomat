package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    // String brugernavn;

    public ReadFile() {
    }

    public ReadFile(String brugernavn) {
    }

    public String ReadFile(String brugernavn) throws FileNotFoundException {
        File myObj = new File("src/com/company/Allan.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
            return data.toString();
        }
        return null;
    }
}
/*    File myObj = new File(brugernavn + ".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);*/
