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

    public BibtexReader(String filename) {
        input = new File(filename);
    }

    public Collection<org.jbibtex.BibTeXEntry> listReferences() {

        try {
            BibTeXParser parser = new BibTeXParser();
            BibTeXDatabase database = parser.parse(new FileReader(input));

            Map<org.jbibtex.Key, org.jbibtex.BibTeXEntry> entryMap = database.getEntries();

            return entryMap.values();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
