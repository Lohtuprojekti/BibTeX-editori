import referenzixx.*
import referenzixx.refs.*
import referenzixx.ui.*
import referenzixx.parser.*
import org.fest.swing.fixture.*
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;

description "Arto voi helposti kopioida koko bibtexin leikepoydalle"

scenario "Bibtex on juuri avattu ja kopioidaan sisältö leikepoydalle", {
    given "Valittu bibtex on muokkaamaton", {
        ui = new MainUI()
        ui.setVisible(true)
        window = new FrameFixture(ui)
    }
    when "Kopioidaan leikepoydalle", {
        window.button("copyButton").click()
    }
    then "Leikepoydalla on sama sisaltö kuin bibtexissa", {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String cb = (String) clipboard.getData(DataFlavor.stringFlavor);

        new BibtexReader().getBibFileAsString(new File("referenzixx.bib")).shouldBe cb
        window.cleanUp()
    }
}

scenario "Bibtexiin kopioidaan leikepöydälle lisäyksen jälkeen", {
    given "Valittuun bibtexiin lisattiin juuri viite"
    when "Kopioidaan leikepoydalle"
    then "Leikepoydalla on sama sisalto kuin bibtexissa"
}
