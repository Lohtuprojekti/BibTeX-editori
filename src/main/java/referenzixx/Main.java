package referenzixx;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import referenzixx.ui.MainUI;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import org.jbibtex.*;
import referenzixx.refs.*;
import referenzixx.parser.BibtexReader;
import referenzixx.refs.Reference;

public class Main {

    public static void main(String[] args) {

        /* Set the default look and feel */
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
        MainUI mainUI = new MainUI();
        mainUI.setVisible(true);
//        
//        // Test references
//        Map<Integer, Article> articles = new HashMap<>();
//        articles.put(123, new Article("123", "J. K. Rowling", "Jipii", "Studio", 456, 1995));
//        articles.put(456, new Article("456", "Matti Luukkainen", "Programming in Java", "HY", 456, 2010));
//        
//        mainUI.addArticles(articles);

/// Tällä voi testata tiedostoon kirjoittamista
//               System.out.println("paska");
//        BibtexReader reader = new BibtexReader( new File("src/bibtexfile.bib"));
//        Article artic = new Article("ABC541","Kirjoasdittaja", "Arasdatikkeli", "journsadal", 1, 2016);
//        Book b = new Book("B1015", "Authorisatan2", "666", "Hell", 1990);
//        Inproceedings impro = new Inproceedings("Impro1","Test666", "Mein Kampf","Allah", 0);
//        reader.writeToFile(artic);
//        reader.writeToFile(b);
//        reader.writeToFile(impro);
////Tässä esimerkki jbibtexin käytöstä tiedoston lukemisessa. 
//        BibTeXDatabase database = new BibTeXDatabase();
//     
//        Collection<BibTeXEntry> c = reader.listReferences();
//        System.out.println("paska");
//            BibTeXEntry asd = new BibTeXEntry(new Key("Article"), new Key("ASDV"));
//            asd.addField(new Key("Author"), new KeyValue("Mikko"));
//        System.out.println(c.iterator().next().getFields().keySet().toString());
//        database.addObject(asd);
//        System.out.println(database.getEntries().isEmpty());
//        database.getEntries().entrySet().stream().forEach((object) -> {
//     		if(args.length < 1 || args.length > 2){
//			System.err.println("Usage: java " + " <Input file> <BibTeX entry field key>?");
//
//			System.exit(-1);
//		}
    }
}
