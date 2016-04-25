package referenzixx.parser;

import java.io.File;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import referenzixx.database.DatabaseUtils;

public class BibtexWriterTest {

    public BibtexWriterTest() {
    }

    @Test
    public void writesAnEntryToAFile() {
        BibtexWriter writer = new BibtexWriter();
        BibTeXEntry entry = new BibTeXEntry(new Key("article"), new Key("ABC"));

        // Luodaan tiedosto ja haetaan sen database
        File file = new File("src/test/emtpy.bib");
        DatabaseUtils dbu = new DatabaseUtils(file.getPath());
        BibtexReader reader = new BibtexReader();
        reader.openNewFile(file, dbu.getDatabase());

        writer.writeToBibtex(entry, file, dbu.getDatabase());

        assertNotEquals(0, file.length());
        file.delete();
    }
  

}
