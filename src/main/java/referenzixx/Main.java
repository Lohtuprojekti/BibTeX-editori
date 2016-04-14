package referenzixx;

import java.io.File;
import java.io.FileNotFoundException;
import referenzixx.ui.MainUI;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Value;
import referenzixx.refs.Article;
import referenzixx.parser.BibtexReader;
import referenzixx.refs.Reference;

public class Main {

    public static void main(String[] args) {

        /* Set the default look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code ">
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        MainUI mainUI = new MainUI();
        mainUI.setVisible(true);
        
        // Test references
        Map<Integer, Article> articles = new HashMap<Integer, Article>();
        articles.put(123, new Article("123", "J. K. Rowling", "Jipii", "Studio", 456, 1995));
        articles.put(456, new Article("456", "Matti Luukkainen", "Programming in Java", "HY", 456, 2010));
        
        mainUI.setArticles(articles);
         
//// Tällä voi testata tiedostoon kirjoittamista
        //File file = new File("src/shortbibtexfile.bib");
        //BibtexReader reader = new BibtexReader(file);
        //        Article artic = new Article("ABC54","Kirjoittaja", "Artikkeli", "journal", 1, 2016);
        //        reader.writeToFile(artic);
        
////Tässä esimerkki jbibtexin käytöstä tiedoston lukemisessa. 
        //Collection<org.jbibtex.BibTeXEntry> c = reader.listReferences();
        //System.out.println(c.iterator().next().getFields().keySet().toString());

    }
}
