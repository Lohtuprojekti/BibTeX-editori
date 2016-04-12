package referenzixx;

import referenzixx.ui.MainUI;
import java.util.Collection;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Value;
import referenzixx.refs.Article;
import referenzixx.parser.BibtexReader;

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

        new MainUI().setVisible(true);

//// Tällä voi testata tiedostoon kirjoittamista
//        BibtexReader reader = new BibtexReader("src/shortbibtexfile.bib");
//        reader.writeToFile(new Article("Kirjoittaja", "Artikkeli", "journal", 1, 0, 2016, 1, 200, "Julkaisija", "Osoite"));

    }
}
