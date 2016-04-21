import referenzixx.*
import referenzixx.refs.*
import referenzixx.ui.*
import referenzixx.parser.*
import java.io.File;
import java.io.PrintWriter;
import java.io.*

description 'Arto voi lisätä artikkelin, jolla on artikkelille tyypilliset kentät.'

scenario "Lisääminen onnistuu kun kaikki pakolliset on annettu", {
    given 'Kaikki tiedot annettu'
    when "Lisätään yksi uusi viite"
    then "Tiedoston pituus kasvaa"
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

