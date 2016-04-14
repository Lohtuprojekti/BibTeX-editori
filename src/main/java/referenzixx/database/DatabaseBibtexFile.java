package referenzixx.database;

import java.util.Map;
import referenzixx.refs.Article;

public class DatabaseBibtexFile implements ReferenceDatabase {

    // TODO: 
    // read bibtex file to an internal hashmap, within constructor
    // file location can be specified in a constructor parameter
    // implement interface methods for filtering out unwanted articles.
    
    @Override
    public Map<Integer, Article> getArticles() {
        return null;
    }

    @Override
    public Map<Integer, Article> getArticles(String refNum, String title, String author, String publisher, Integer year) {
        return null;
    }
    
    

    
}
