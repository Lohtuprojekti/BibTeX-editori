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
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import org.jbibtex.*;
import referenzixx.refs.*;
import referenzixx.parser.BibtexReader;
import referenzixx.parser.BibtexWriter;
import referenzixx.refs.Reference;

public class Main {

 public static void main(String[] args) {

//        /* Set the default look and feel */
//          <editor-fold defaultstate="collapsed" desc=" Look and feel setting code ">
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
//          </editor-fold>
        MainUI mainUI = new MainUI();
        mainUI.setVisible(true);


/// Tällä voi testata tiedostoon kirjoittamista
//        File file = new File("src/kirjoitustesti2.bib");
//        BibtexReader reader = new BibtexReader(file);
//        Article artic = new Article("ABC541","Kirjoasdittaja", "Arasdatikkeli", "journsadal", 1, 2016);
        //Book b = new Book("B1015", "Authorisatan2", "666", "Hell", 1990);
        //Inproceedings impro = new Inproceedings("Impro1","Test666", "Mein Kampf","Allah", 0);
        //reader.writeToFile(artic);
        //reader.writeToFile(b);
        //reader.writeToFile(impro);

////Tässä esimerkki jbibtexin käytöstä tiedoston lukemisessa. 
//        Collection<BibTeXEntry> c = reader.listReferences();
//        BibTeXEntry asd = new BibTeXEntry(new Key("Article"), new Key("ASDV"));
//        asd.addField(new Key("Author"), new KeyValue("Mikko"));

//        File file = new File("src/kirjoitustesti2.bib");
//        BibtexReader reader = new BibtexReader(file);
//        BibtexWriter b = new BibtexWriter(file, reader.getDatabase());
//        Set k = b.getDatabase().getEntries().keySet();
//        System.out.println(k);
//        Collection<BibTeXEntry> col = reader.listReferences();
//        BibTeXEntry entry = col.iterator().next();
//        b = new BibtexWriter(file, reader.getDatabase());
//        k = b.getDatabase().getEntries().keySet();
//        System.out.println(k);
//        b.writeToBibtex(entry);

//        System.out.println("asd");
//        System.out.println("asd");
//        System.out.println("asd");
//        System.out.println("asd");
//        System.out.println("asd");
//        System.out.println("asd");
//        System.out.println("asd");
//        System.out.println("asd");
//        Book b = new Book("A123", "sad", "feiwf", "asda", 5);
//        b.setAddress("Kotikatu");
//        b.setSeries("Serial killer");
//        b.setVolume(3);
//        System.out.println(b.toString());
//        
//        artic.setPages(12, 400);
//        artic.setNumber(3);
//        artic.setAddress("asd");
//        artic.setPublisher("Vittu");
//        System.out.println(artic.toString());
//        
//        Inproceedings i = new Inproceedings("I1", "Lordi", "Hard rock halleluja", 
//                                            "Uranus", 4);
//        i.setBooktitle("EUROVIISU");
//        i.setMonth(4);
//        i.setPublisher("Joku");
//        System.out.println(i.toString());
//        reader.writeToFile(i);
//        reader.writeToFile(artic);
//        reader.writeToFile(b);
 }
}
