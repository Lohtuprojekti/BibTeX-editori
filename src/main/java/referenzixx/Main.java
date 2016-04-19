package referenzixx;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileNotFoundException;
import referenzixx.ui.MainUI;
import java.util.Collection;

import org.jbibtex.BibTeXEntry;
import org.jbibtex.Value;
import referenzixx.refs.Article;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.KeyValue;
import org.jbibtex.Value;
import referenzixx.refs.*;

import referenzixx.parser.BibtexReader;
import referenzixx.refs.Reference;

public class Main {

    public static void main(String[] args) {
        
        /* Set the default look and feel */
        /*
//        <editor-fold defaultstate="collapsed" desc=" Look and feel setting code ">
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
////        //</editor-fold>
////
        //MainUI mainUI = new MainUI();
        //mainUI.setVisible(true);
//        
//        // Test references
//        Map<Integer, Article> articles = new HashMap<>();
//        articles.put(123, new Article("123", "J. K. Rowling", "Jipii", "Studio", 456, 1995));
//        articles.put(456, new Article("456", "Matti Luukkainen", "Programming in Java", "HY", 456, 2010));
//        
//        mainUI.addArticles(articles);
*/
/// Tällä voi testata tiedostoon kirjoittamista
               System.out.println("paska");
        BibtexReader reader = new BibtexReader( new File("src/bibtexfile.bib"));
        //Article artic = new Article("ABC541","Kirjoasdittaja", "Arasdatikkeli", "journsadal", 1, 2016);
        //Book b = new Book("B1015", "Authorisatan2", "666", "Hell", 1990);
        //Inproceedings impro = new Inproceedings("Impro1","Test666", "Mein Kampf","Allah", 0);
        //reader.writeToFile(artic);
        //reader.writeToFile(b);
        //reader.writeToFile(impro);


//        BibtexReader reader = new BibtexReader("src/shortbibtexfile.bib");
        
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


////Tässä esimerkki jbibtexin käytöstä tiedoston lukemisessa. 
        Collection<BibTeXEntry> c = reader.listReferences();
        System.out.println("paska");
        BibTeXEntry asd = new BibTeXEntry(new Key("Article"), new Key("ASDV"));
        asd.addField(new Key("Author"), new KeyValue("Mikko"));
        System.out.println(c.iterator().next().getFields().keySet().toString());
        
        System.out.println(c.iterator().next().getFields().keySet().toString());

        

    }
}
