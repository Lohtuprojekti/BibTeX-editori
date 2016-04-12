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

/**
 *
 * @author lilkettu
 */
public class BibtexReader {

    private File input;
    BibTeXDatabase database;

    public BibtexReader(String filename) {
        input = new File(filename);
    }

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

    public void writeToFile(Article article) {
        String bibtexEntry = formatToBibtex(article);
       
        try {
            FileWriter writer = new FileWriter(input, true);
            writer.write(bibtexEntry);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(BibtexReader.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    private String formatToBibtex(Article art) {
        return "\n@article{" + art.getRefNum() + ",\n"
                + "author = {" + art.getAuthor() + "},\n"
                + "title = {" + art.getTitle() + "},\n"
                + "journal = {" + art.getJournal() + "},\n"
                + "year = {" + art.getYear() + "},\n"
                + "volume = {" + art.getVolume() + "},\n}";      
    }
}
