package referenzixx.parser;

import java.io.File;
import java.io.FileWriter;
import java.util.Map;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.Value;

/**
 * Writes BibtexEntry objects to .bib files.
 * 
 * @author lilkettu
 */
public class BibtexWriter {

    /**
     * Prepares BibTexEntry to be written to a file.
     * 
     * @param entry
     * @param file
     * @param database
     * @return 
     */
    
    public boolean writeToBibtex(BibTeXEntry entry, File file, BibTeXDatabase database) {
        if (entry == null) {
            return false;
        }
        Key refnum = entry.getKey();

        //Tarkista viimeistään tässä onko refnum jo databasessa
        if (!isRefnumUnique(refnum, database)) {
            System.out.println("Refnum ei ollut uniikki, kirjoitusta ei tapahtunut");
            return false;
        }

        String kirjoitettava = bibtexBuilder(entry);
        addToDatabase(entry, database);

        return addToBibtex(kirjoitettava, file);
    }

    /**
     * Writes reference to a .bib file.
     * 
     * @param kirjoitettava
     * @param file
     * @return 
     */
    private boolean addToBibtex(String kirjoitettava, File file) {
        try {
            FileWriter kirjoittaja = new FileWriter(file, true);
            kirjoittaja.write(kirjoitettava);
            kirjoittaja.close();
            return true;
        } catch (Exception e) {
        }

        return false;
    }

    /**
     * Muokkaa BibTeXEntryn stringiksi siististi tabulaattoreita ja rivinvaihtoja 
     * käyttäen täsmälleen mallin mukaisesti.
     * 
     * @param entry
     * @return 
     */
   
    private String bibtexBuilder(BibTeXEntry entry) {
        String kirjoitettava = "@";
        kirjoitettava += (entry.getType().getValue() + "{");
        kirjoitettava += (entry.getKey().getValue() + ",\r\n");
        for (Map.Entry<Key, Value> valuepair : entry.getFields().entrySet()) {
            if (!valuepair.getValue().toUserString().isEmpty()) {
                kirjoitettava += ("\t" + valuepair.getKey().toString() + " = {");
                kirjoitettava += (valuepair.getValue().toUserString() + "},\r\n");
            }
        }
        kirjoitettava += "}\r\n\r\n";
        return kirjoitettava;
    }

    /**
     * Adds BibTexEntry to the database
     * 
     * @param entry
     * @param database 
     */
    private void addToDatabase(BibTeXEntry entry, BibTeXDatabase database) {
        database.addObject(entry);
    }

    /**
     * Checks if the reference number of the BibTexEntry is unique
     * 
     * @param refnum
     * @param database
     * @return 
     */
    private boolean isRefnumUnique(Key refnum, BibTeXDatabase database) {
        if (database.getEntries().containsKey(refnum)) {
            return false;
        }
        return true;
    }
}
