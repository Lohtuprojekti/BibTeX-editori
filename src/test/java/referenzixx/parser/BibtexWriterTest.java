package referenzixx.parser;

import java.io.File;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BibtexWriterTest {

    private BibtexWriter writer;

    @Before
    public void setUp() {
        writer = new BibtexWriter();
    }

    @Test
    public void writesAnEntryToAFile() {
        BibTeXEntry entry = new BibTeXEntry(new Key("article"), new Key("ABC"));

        File file = new File("src/test/testfile.bib");

        writer.writeToBibtex(entry, file);

        BibtexReader reader = new BibtexReader();
        String filecontents = reader.getBibFileAsString(file);

        assertTrue(filecontents.contains("ABC"));
        file.delete();
    }

    @Test
    public void doesNotWriteToFileIfEntryIsNull() {
        File file = new File("src/test/veryshort.bib");
        Boolean written = writer.writeToBibtex(null, file);
        
        assertEquals(false, written);
    }
}
