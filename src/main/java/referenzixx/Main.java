package referenzixx;

import referenzixx.ui.MainUI;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Value;
import referenzixx.refs.Article;
import referenzixx.parser.BibtexReader;
import referenzixx.refs.Reference;

public class Main {

    public static void main(String[] args) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
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
        Map<Integer, Reference> references = new HashMap<Integer, Reference>();
        references.put(123, new Reference("123", "Jipii", "J. K. Rowling", "Studio", 1564));
        references.put(456, new Reference("456", "Programming in Java", "Matti Luukkainen", "HY", 1564));
        
        mainUI.setReferences(references);

//// Tällä voi testata tiedostoon kirjoittamista
//        BibtexReader reader = new BibtexReader("src/shortbibtexfile.bib");
//        reader.writeToFile(new Article("Kirjoittaja", "Artikkeli", "journal", 1, 0, 2016, 1, 200, "Julkaisija", "Osoite"));

    }
}
