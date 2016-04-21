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
 * Parseroi bibtex -muodossa olevat viitteet ja kirjoittaa ne oikeassa muodossa
 * .bib -tiedostoon
 *
 * @author lilkettu
 */
public class BibtexReader {

    private File bibfile;
    private BibTeXDatabase database;

    /**
     *
     * @param file
     */
    public BibtexReader(File file) {
        this.bibfile = file;
        this.database = new BibTeXDatabase();
    }

    public BibtexReader(File file, BibTeXDatabase database) {
        this.bibfile = file;
        this.database = database;
    }

    public BibTeXDatabase getDatabase() {
        return this.database;
    }
    
    public File getFile() {
        return this.bibfile;
    }

    /**
     * Muuttaa BibTexEntryt tyyppiään vastaaviksi olioiksi ja palauttaa ne
     * listana nimi pitää muuttaa
     *
     * @param entries
     * @return
     */
//    public Collection<IReference> listArticles(Collection<BibTeXEntry> entries) {
//        Collection<IReference> refs = new ArrayList<>();
//
//        for (BibTeXEntry entry : entries) {
//
//            IReference ref = null;
//            String type = entry.getType().toString().toLowerCase();
//
//            if (type.equals("article")) {
//                ref = new Article(entry);
//            } else if (type.equals("book")) {
//                ref = new Book(entry);
//            } else if (type.equals("inproceedings")) {
//                ref = new Inproceedings(entry);
//            }
//            refs.add(ref);
//        }
//        return refs;
//    }
    /**
     * Palauttaa viitteet bibtexEntry-olioiden listana
     *
     * @return
     */
    public Collection<BibTeXEntry> listReferences() {

        try {
            BibTeXParser parser = new BibTeXParser();
            database = parser.parse(new FileReader(bibfile));

            Map<Key, BibTeXEntry> entryMap = database.getEntries();

            return entryMap.values();

        } catch (Exception e) {
        }

        return null;
    }
    
    /**
     * Lukee tiedoston databaseen, asettaa tiedoston käytetyksi tiedostoksi ja palauttaa databasen
     * 
     * @return 
     */
    public boolean openNewFile(File file) {
        try {
            this.bibfile = file;
            BibTeXParser parser = new BibTeXParser();
            database = parser.parse(new FileReader(bibfile));

            return true;

        } catch (Exception e) {
        }

        return false;
    }

    /**
     * Palauttaa bibtiedoston Stringinä
     *
     * @return
     */
    public String getBibFileAsString() {
        String bibString = "";
        try {
            Scanner scanner = new Scanner(bibfile);
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
