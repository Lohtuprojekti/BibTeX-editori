import referenzixx.*
import referenzixx.refs.*
import referenzixx.ui.*
import referenzixx.parser.*
import java.io.File;
import java.io.PrintWriter;
import java.io.*

description 'Arto voi lisätä artikkelin, jolla on artikkelille tyypilliset kentät.'

scenario "Lisääminen onnistuu kun kaikki pakolliset on annettu", {

        File file = new File("src/emptybibtexfile.bib")
        BibtexReader reader = new BibtexReader(file)
        new PrintWriter(file).close()
        Article artic = new Article("ABC54","Kirjoittaja", "Artikkeli", "journal", 1, 2016)

    when "Lisätään yksi uusi viite", {
        reader.writeToFile(artic)
    }
    then "Tiedoston pituus kasvaa", {
        file.length().shouldNotBe(0)
        new PrintWriter(file).close()
    }
    
}

scenario "Lisääminen epäonnistuu jos kaikki pakolliset ovat tyhjänä", {
    given 'Kaikki tiedot puuttuvat'
    when 'Valitaan lisäys'
    then 'Lisäys epäonnistuu'
}

scenario "Lisääminen epäonnistuu kun jotakin pakollista ei ole annettu", {
    given 'Kaikki paitsi yksi tieto on annettu'
    when 'Valitaan lisäys'
    then 'Lisäys epäonnistuu'
}

