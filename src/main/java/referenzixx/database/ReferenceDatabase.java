package referenzixx.database;

import java.util.List;
import org.jbibtex.BibTeXEntry;

public interface ReferenceDatabase {
    
    
    public List<BibTeXEntry> getReferences();
    
    public List<BibTeXEntry> getReferences(List<String> searchTerms);
        
}