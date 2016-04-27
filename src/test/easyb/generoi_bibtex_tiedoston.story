import referenzixx.*
import referenzixx.refs.*
import referenzixx.ui.*
import referenzixx.parser.*
import java.io.File;
import java.io.PrintWriter;
import java.io.*
import org.jbibtex.*

description "Arto voi generoida bibtex-tiedoston"

scenario "Bibtexiin kirjoittaminen onnistuu oikeilla syötteillä.", {

        File file = new File("src/test/emptybibtexfile.bib")
        new PrintWriter(file).close()
        BibtexWriter writer = new BibtexWriter()
        BibTeXDatabase database = new BibTeXDatabase();
        BibTeXEntry entry = new BibTeXEntry(new Key("Tyyppi"), new Key("refID"));
        

    when "Lisätään yksi uusi viite", {
        writer.writeToBibtex(entry, file)
    }
    then "Tiedoston pituus kasvaa", {
        file.length().shouldNotBe(0)
        new PrintWriter(file).close()
    }
}

scenario "Bibtexiin kirjoittaminen ei onnistu ilman syötettä.", {
    
        File file = new File("src/test/emptybibtexfile.bib")
        new PrintWriter(file).close()
        
        BibtexWriter writer = new BibtexWriter()
        BibTeXDatabase database = new BibTeXDatabase();
        BibTeXEntry entry = null

    when "Lisätään olematonta", {
        writer.writeToBibtex(entry, file)
    }

    then "Tiedostossa ei tapahdu muutosta", {
        file.length().shouldBe(0)
        new PrintWriter(file).close()
    }
}

scenario "Bibtexin luonti onnistuu oikealla syötteellä", {

        File file = new File("src/test/olematon.bib")
        file.delete()
        BibtexWriter writer = new BibtexWriter()
        BibTeXDatabase database = new BibTeXDatabase();
        BibTeXEntry entry = new BibTeXEntry(new Key("Tyyppi"), new Key("refID"));


    when "Lisätään artikkeli", {
        writer.writeToBibtex(entry, file)
    }
    then "Tiedosto luodaan ja siinä on sisältöä", {
        file.exists().shouldBe(true)
        file.length().shouldNotBe(0)
        file.delete()
    }
}

scenario "Bibtexin luonti ei onnistu ilman oikeaa syötettä", {
    
        File file = new File("src/test/olematon.bib")
        file.delete()
        BibtexWriter writer = new BibtexWriter()
        BibTeXDatabase database = new BibTeXDatabase();
        BibTeXEntry entry = null

    when "Lisätään olematonta", {
        writer.writeToBibtex(entry, file)
    }
    then "Tiedostoa ei pitäisi ilmestyä", {
        file.exists().shouldBe(false)
    }
}