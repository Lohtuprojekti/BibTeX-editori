package referenzixx.parser;

import java.io.File;
import java.io.FileWriter;
import java.util.Map;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.Value;

public class BibtexWriter {

    //Kirjoittaa annetun BibTeXEntryn fileen
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

    //Muokkaa BibTeXEntryn stringiksi siististi tabulaattoreita ja rivinvaihtoja
    //käyttäen täsmälleen mallin mukaisesti.
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

    //Databasenhallintaan
    private void addToDatabase(BibTeXEntry entry, BibTeXDatabase database) {
        database.addObject(entry);
    }

    private boolean isRefnumUnique(Key refnum, BibTeXDatabase database) {
        if (database.getEntries().containsKey(refnum)) {
            return false;
        }
        return true;
    }
}
