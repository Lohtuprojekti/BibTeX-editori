//package referenzixx.database;
//
//import java.io.File;
//import java.util.Map;
//import referenzixx.parser.BibtexReader;
//import referenzixx.refs.Article;
//
//public class DatabaseBibtexFile implements ReferenceDatabase {
//
//    // TODO: 
//    // read bibtex file to an internal hashmap, within constructor
//    // file location can be specified in a constructor parameter
//    // implement interface methods for filtering out unwanted articles.
//    
//    private BibtexReader bibtexEntries;
//
//    public DatabaseBibtexFile(BibtexReader bibtexEntries) {
//        this.bibtexEntries = bibtexEntries;    
//    }
//        
//    
//    
//    @Override
//    public Map<Integer, Article> getArticles() {
//        return null;
//    }
//
//    @Override
//    public Map<Integer, Article> getArticles(String refNum, String title, String author, String publisher, Integer year) {
//        return null;
//    }
//    
//    private void readBibtexFile() {
//        
//        // bibtexEntries.listReferences().stream().
//        
//    }
//
//    
//}
