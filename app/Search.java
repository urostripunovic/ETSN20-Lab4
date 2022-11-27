package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Search {
    public static void main(String[] args) {
        new Search().run(args);
    }

    void run(String[] args) {
        try {
            var pattern = args[1];
            var file = args[2];
            searchPattern(pattern, file);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Prints the sentences that have the pattern keyword in them
     * @param pattern
     * @param file
     * @throws FileNotFoundException
     */
    public void searchPattern(String pattern, String file) throws FileNotFoundException {
        if (!file.endsWith(".txt"))
            file = file + ".txt";

        File myObj = new File(file);
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();

            int index = data.toLowerCase().indexOf(pattern.toLowerCase());
            String check = index != -1 ? data.substring(index).split(" ")[0] : "";
            //Regex so that sentences with either of these are still valid patterns.
            check = check.replaceAll("[.,;:?!]", "");

            if (check.length() == pattern.length()) 
                System.out.println(data);
        }
    }
}
