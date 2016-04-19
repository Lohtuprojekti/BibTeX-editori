/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package referenzixx.parser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.BibTeXFormatter;
import org.jbibtex.BibTeXObject;
import org.jbibtex.BibTeXParser;
import org.jbibtex.BibTeXString;
import org.jbibtex.Key;
import org.jbibtex.ParseException;
import referenzixx.refs.Reference;

/**
 *
 * @author lilkettu
 */
public class BibtexReader {

    private File input;
    private BibTeXDatabase database;

    public BibtexReader(String filename) {
        input = new File(filename);
    }

    // Palauttaa viitteet listana
    public Collection<BibTeXEntry> listReferences() {

        try {
            BibTeXParser parser = new BibTeXParser();
            database = parser.parse(new FileReader(input));

            Map<Key, BibTeXEntry> entryMap = database.getEntries();

            return entryMap.values();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // Kirjoittaa referenssi-olion .bib -tiedostoon
    public void writeToFile(Reference ref) {
        String bibtexEntry = ref.toString();
       
        try {
            FileWriter writer = new FileWriter(input, true);
            writer.write(bibtexEntry);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(BibtexReader.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    // Muuttaa artikkeli-olion bibtex-muotoon
    //private String formatToBibtex(Reference ref) {
    //    return ref.toString();
   //}
}
