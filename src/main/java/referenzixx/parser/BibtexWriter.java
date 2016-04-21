package referenzixx.parser;

import java.io.File;
import java.io.FileWriter;
import java.util.Map;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.Value;

public class BibtexWriter {

    private File file;
    private BibTeXDatabase database;

    public BibtexWriter(File file, BibtexReader reader) {
        this.file = file;
        this.database = reader.getDatabase();
    }

    public BibtexWriter(File file, BibTeXDatabase database) {
        this.file = file;
        this.database = database;
    }

    public BibTeXDatabase getDatabase() {
        if (this.database != null) {
            return this.database;
        }
        return null;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return this.file;
    }

    //Kirjoittaa annetun BibTeXEntryn fileen
    public boolean writeToBibtex(BibTeXEntry entry) {
        Key refnum = entry.getKey();

        //Tarkista viimeistään tässä onko refnum jo databasessa
        if (!isRefnumUnique(refnum)) {
            System.out.println("Refnum ei ollut uniikki, kirjoitusta ei tapahtunut");
            return false;
        }

        String kirjoitettava = bibtexBuilder(entry);
        addToDatabase(entry);

        try {
            FileWriter kirjoittaja = new FileWriter(file, true);
            kirjoittaja.write(kirjoitettava);
            kirjoittaja.close();
            return true;
        } catch (Exception e) {
        }

        return false;
    }

    //Muokkaa BibTeXEntryn stringiksi
    private String bibtexBuilder(BibTeXEntry entry) {
        String kirjoitettava = "@";
        kirjoitettava += (entry.getType().getValue() + "{");
        kirjoitettava += (entry.getKey().getValue() + ",\n");
        for (Map.Entry<Key, Value> valuepair : entry.getFields().entrySet()) {
            if (!valuepair.getValue().toUserString().isEmpty()) {
                kirjoitettava += (valuepair.getKey().toString() + " = {");
                kirjoitettava += (valuepair.getValue().toUserString() + "},\n");
            }
        }
        kirjoitettava += "}\n";
        return kirjoitettava;
    }

    //Databasenhallintaan
    private void addToDatabase(BibTeXEntry entry) {
        database.addObject(entry);
    }

    public boolean isRefnumUnique(Key refnum) {
        if (database.getEntries().containsKey(refnum)) {
            return false;
        }
        return true;
    }
}
