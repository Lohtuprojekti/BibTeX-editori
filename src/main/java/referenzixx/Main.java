package referenzixx;

import java.util.Collection;
import referenzixx.parser.Article;
import referenzixx.parser.BibtexReader;

public class Main {

    public static void main(String[] args) {
       
        

        BibtexReader reader = new BibtexReader("src/shortbibtexfile.bib");
//        Collection<org.jbibtex.BibTeXEntry> entries = reader.listReferences();
//
//        for (org.jbibtex.BibTeXEntry entry : entries) {
//            
//            org.jbibtex.Value value = entry.getField(org.jbibtex.BibTeXEntry.KEY_AUTHOR);
//
//            if (value == null) {
//                continue;
//            }
//            // Do something with the value
//            System.out.println(value.toUserString());
//        }
        
        reader.writeToFile(new Article("Kirjoittaja", "Artikkeli", "journal", 1, 0, 2016, 1, 200, "Julkaisija", "Osoite"));
    }
}
