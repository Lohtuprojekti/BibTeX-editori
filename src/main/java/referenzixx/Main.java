package referenzixx;

import java.io.File;
import referenzixx.ui.MainUI;
import javax.swing.UIManager;
import org.jbibtex.BibTeXDatabase;
import referenzixx.database.DatabaseUtils;

public class Main {

    public static void main(String[] args) {

        /* Set the default look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code ">
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        // </editor-fold>
        MainUI mainUI = new MainUI();
        mainUI.setVisible(true);

        //Siivosin kun mikään vanhoista ei enää ole relevantti
        
    }
}
