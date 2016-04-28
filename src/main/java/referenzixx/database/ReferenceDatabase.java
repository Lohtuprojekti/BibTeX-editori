package referenzixx.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jbibtex.BibTeXEntry;

public interface ReferenceDatabase {
    
    
    public List<BibTeXEntry> getReferences();
    
    public List<BibTeXEntry> getReferences(ArrayList<String> searchTerms);
        
}