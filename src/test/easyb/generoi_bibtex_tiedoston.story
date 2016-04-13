import referenzixx.*
import referenzixx.refs.*
import referenzixx.ui.*
import referenzixx.parser.*
import java.io.File;
import java.io.PrintWriter;


description "Arto voi generoida bibtex-tiedoston"

scenario "Bibtexiin kirjoittaminen onnistuu oikeilla syötteillä.", {
    
        File file = new File("src/emptybibtexfile.bib")
        new PrintWriter(file).close()
        BibtexReader reader = new BibtexReader(file)
        Article artic = new Article("ABC54","Kirjoittaja", "Artikkeli", "journal", 1, 2016)

    when "Lisätään yksi uusi viite", {
        reader.writeToFile(artic)
    }
    then "Tiedoston pituus kasvaa", {
        file.length().shouldNotBe(0)
        new PrintWriter(file).close()
    }
}

scenario "Bibtexiin kirjoittaminen ei onnistu ilman syötettä.", {
    
        File file = new File("src/emptybibtexfile.bib")
        new PrintWriter(file).close()
        BibtexReader reader = new BibtexReader(file)
        Article artic = null

    when "Lisätään olematonta", {
        reader.writeToFile(artic) 
    }

    then "Tiedostossa ei tapahdu muutosta", {
        file.length().shouldBe(0)
        new PrintWriter(file).close()
    }
}

scenario "Bibtexin luonti onnistuu oikealla syötteellä", {

        File file = new File("src/olematon.bib")
        file.delete()
        BibtexReader reader = new BibtexReader(file)
        Article artic = new Article("ABC54","Kirjoittaja", "Artikkeli", "journal", 1, 2016)


    when "Lisätään artikkeli", {
        reader.writeToFile(artic)
    }
    then "Tiedosto luodaan ja siinä on sisältöä", {
        file.exists().shouldBe(true)
        file.length().shouldNotBe(0)
        file.delete()
    }
}

scenario "Bibtexin luonti ei onnistu ilman oikeaa syötettä", {
    
        File file = new File("src/olematon.bib")
        file.delete()
        BibtexReader reader = new BibtexReader(file)
        Article artic = null

    when "Lisätään olematonta", {
        reader.writeToFile(artic) 
    }
    then "Tiedostoa ei pitäisi ilmestyä", {
        file.exists().shouldBe(false)
    }
}