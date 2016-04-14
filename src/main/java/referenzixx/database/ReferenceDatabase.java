package referenzixx.database;

import java.util.Map;
import referenzixx.refs.Article;

public interface ReferenceDatabase {
    
    
    public Map<Integer, Article> getArticles();
    
    public Map<Integer, Article> getArticles(String refNum, String title, String author, String publisher, Integer year);
        
}
