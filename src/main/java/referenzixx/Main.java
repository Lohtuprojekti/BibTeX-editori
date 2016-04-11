package referenzixx;

import java.util.Collection;
import referenzixx.parser.BibtexReader;

public class Main {

    public static void main(String[] args) {
        System.out.println("Testi");

        BibtexReader reader = new BibtexReader("src/bibtexfile.bib");
        Collection<org.jbibtex.BibTeXEntry> entries = reader.listReferences();

        for (org.jbibtex.BibTeXEntry entry : entries) {
            
            org.jbibtex.Value value = entry.getField(org.jbibtex.BibTeXEntry.KEY_AUTHOR);

            if (value == null) {
                continue;
            }
            // Do something with the value
            System.out.println(value.toUserString());
        }
    }
}
