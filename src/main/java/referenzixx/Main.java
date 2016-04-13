package referenzixx;

import java.util.Collection;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Value;
import referenzixx.refs.Article;
import referenzixx.parser.BibtexReader;

public class Main {

    public static void main(String[] args) {
       
        

        BibtexReader reader = new BibtexReader("src/shortbibtexfile.bib");
        
//        Collection<BibTeXEntry> entries = reader.listReferences();
//
//        for (BibTeXEntry entry : entries) {
//            
//            Value value = entry.getField(BibTeXEntry.KEY_AUTHOR);
//            
//            if (value == null) {
//                continue;
//            }
//            // Do something with the value
//            System.out.println(value.toUserString());
//            
//        }
        
        reader.writeToFile(new Article("Kirjoittaja", "Artikkeli", "journal", 1, 0, 2016, 1, 200, "Julkaisija", "Osoite"));
    }
}
