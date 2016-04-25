/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package referenzixx.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import referenzixx.refs.*;
import org.jbibtex.*;

/**
 * Parses the Bibtex file to a database of objects
 *
 * @author lilkettu
 */
public class BibtexReader {

    /**
     * Palauttaa viitteet bibtexEntry-olioiden listana
     *
     * @return
     */
    public Collection<BibTeXEntry> listReferences(File file, BibTeXDatabase database) {

        try {
            BibTeXParser parser = new BibTeXParser();
            database = parser.parse(new FileReader(file));

            Map<Key, BibTeXEntry> entryMap = database.getEntries();

            return entryMap.values();

        } catch (Exception e) {
        }

        return null;
    }
    
    /**
     * Lukee tiedoston databaseen, asettaa tiedoston käytetyksi tiedostoksi ja palauttaa databasen
     * Parses the contents of a Bibtex file and adds the entries in a database
     * @return 
     */
    public BibTeXDatabase openNewFile(File file, BibTeXDatabase database) {
        try {
            BibTeXParser parser = new BibTeXParser();
            database = parser.parse(new FileReader(file));

//            return database;

        } catch (Exception e) {
        }

        return database;
    }

    /**
     * Returns the contents of BibTex file as a string
     * Usage: Copy to clipboard
     * 
     * @return
     */
    public String getBibFileAsString(File file) {
        String bibString = "";
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                bibString += scanner.nextLine() + "\n";

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BibtexReader.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return bibString;

    }
}
