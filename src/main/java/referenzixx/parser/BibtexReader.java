/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package referenzixx.parser;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import org.jbibtex.*;

/**
 * Parses the Bibtex file to a database of objects
 *
 * @author lilkettu
 */
public class BibtexReader {
    
    /**
     * Parses the contents of a Bibtex file and returns the entries as a database
     * @param file File that is opened.
     * @return 
     */
    public BibTeXDatabase openNewFile(File file) {
        BibTeXDatabase database = new BibTeXDatabase();
        try {
            BibTeXParser parser = new BibTeXParser();
            database = parser.parse(new FileReader(file));
        } catch (Exception e) {
        }

        return database;
    }

    /**
     * Returns the contents of BibTex file as a string
     * Usage: Copy to clipboard
     * 
     * @param file
     * @return
     */
    public String getBibFileAsString(File file) {
        String bibString = "";
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                bibString += scanner.nextLine() + "\n";
            }
        } catch (Exception e) {
        }
        return bibString;

    }
}
