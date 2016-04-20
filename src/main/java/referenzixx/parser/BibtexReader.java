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
        bibfile = file;
    }

    /**
     * Muuttaa BibTexEntryt tyyppiään vastaaviksi olioiksi ja palauttaa ne
     * listana nimi pitää muuttaa
     *
     * @param entries
     * @return
     */
    public Collection<IReference> listArticles(Collection<BibTeXEntry> entries) {
        Collection<IReference> refs = new ArrayList<>();

        for (BibTeXEntry entry : entries) {

            IReference ref = null;
            String type = entry.getType().toString().toLowerCase();

            if (type.equals("article")) {
                ref = new Article(entry);
            } else if (type.equals("book")) {
                ref = new Book(entry);
            } else if (type.equals("inproceedings")) {
                ref = new Inproceedings(entry);
            }
            refs.add(ref);
        }
        return refs;
    }

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

    // Kirjoittaa referenssi-olion .bib -tiedostoon
    public void writeToFile(IReference ref) {

        if (ref == null) {
            return;
        }

        String bibtexEntry = ref.toString();

        try {
            FileWriter writer = new FileWriter(bibfile, true);
            writer.write(bibtexEntry);
            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(BibtexReader.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        //// Allaoleva lisää bibtexEntryn bibtexDatabaseen ja kirjoittaa tiedostoon, EI TOIMI
//        BibTeXEntry bibtexEntry = formatToBibtex(article);
//        database.addObject(bibtexEntry);
//        
//        try {
//            FileWriter writer = new FileWriter(bibfile);
//            BibTeXFormatter f = new BibTeXFormatter();
//            f.format(database, writer);
//            writer.close();
//
//        } catch (IOException ex) {
//            Logger.getLogger(BibtexReader.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    // Muuttaa artikkeli-olion bibtex-muotoon
    //private String formatToBibtex(Reference ref) {
    //    return ref.toString();
    //}
    /**
     * Muuttaa artikkeli-olion bibtex-muotoon
     *
     * @param art
     * @return
     */
    /*private String formatToBibtex(Article art) {
     if (art == null) {
     return null;
     }
     return "\n@article{" + art.getRefNum() + ",\n"
     + "author = {" + art.getAuthor() + "},\n"
     + "title = {" + art.getTitle() + "},\n"
     + "journal = {" + art.getJournal() + "},\n"
     + "year = {" + art.getYear() + "},\n"
     + "volume = {" + art.getVolume() + "},\n}";
     //// Luo bibtexEntryn artikkelista
     //        BibTeXEntry entry = new BibTeXEntry(BibTeXEntry.TYPE_ARTICLE, new Key(art.refNum));
     //        entry.addField(BibTeXEntry.KEY_AUTHOR, new KeyValue(art.getAuthor()));
     //        entry.addField(BibTeXEntry.KEY_TITLE, new KeyValue(art.getTitle()));
     //        entry.addField(BibTeXEntry.KEY_JOURNAL, new KeyValue(art.getJournal()));
     //        entry.addField(BibTeXEntry.KEY_YEAR, new KeyValue(Integer.toString(art.getYear())));
     //        entry.addField(BibTeXEntry.KEY_VOLUME, new KeyValue(Integer.toString(art.getVolume())));
     //        return entry;
     }
     */
}
