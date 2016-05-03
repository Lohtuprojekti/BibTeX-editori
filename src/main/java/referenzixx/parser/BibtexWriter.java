package referenzixx.parser;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Map;
import org.jbibtex.*;

/**
 * Writes BibtexEntry objects to .bib files.
 *
 */
public class BibtexWriter {

    /**
     * Writes reference to a .bib file.
     *
     * @param entry
     * @param kirjoitettava
     * @param file
     * @return
     */
    public boolean writeToBibtex(BibTeXEntry entry, File file) {
        if (entry == null) {
            return false; //Testejä varten
        }
        String kirjoitettava = bibtexBuilder(entry);
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(kirjoitettava);
            writer.close();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * Rewrites the whole database to a file. Used when removing a reference.
     *
     * @param database
     * @param file
     * @return
     */
    public boolean rewriteDatabaseToBibtex(BibTeXDatabase database, File file) {
        try {
            new PrintWriter(file).close();
            for (BibTeXEntry entry : database.getEntries().values()) {
                writeToBibtex(entry, file);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Outputs BibTeXEntry in a clean and easily readable form.
     *
     * @param entry Entry that is edited to string
     * @return
     */
    private String bibtexBuilder(BibTeXEntry entry) {
        return "@" + entry.getType().getValue() + "{"
                + entry.getKey().getValue() + ",\r\n"
                + iterateReferenceToString(entry) + "}\r\n\r\n";
    }

    /**
     * Iterates through the key-value pairs in BibTeXEntry and converts them to
     * String.
     *
     * @param entry
     * @return
     */
    private String iterateReferenceToString(BibTeXEntry entry) {
        String entryString = "";
        for (Map.Entry<Key, Value> valuepair : entry.getFields().entrySet()) {
            entryString += valuePairToBibTeXString(valuepair);
        }
        return entryString;
    }
    
    private String valuePairToBibTeXString(Map.Entry<Key, Value> valuepair) {
        if (valuepair.getValue().toUserString().isEmpty()) return "";
               
        return "\t" + valuepair.getKey().toString() + " = {"
                    + valuepair.getValue().toUserString() + "},\r\n";
    }
   
}
