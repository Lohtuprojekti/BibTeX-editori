
package referenzixx.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jbibtex.BibTeXEntry;
import referenzixx.refs.Article;


public class BibtexConverter {
    
        public List<Article> convertBibtexEntriesToArticles(Collection<BibTeXEntry> entries) {
        List<Article> articles = new ArrayList<>();
        
        for (BibTeXEntry entry : entries) {
            Article a = new Article(entry);
            articles.add(a);
        }
        return articles;
    }
}
