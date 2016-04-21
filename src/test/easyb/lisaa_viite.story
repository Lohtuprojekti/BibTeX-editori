import referenzixx.*
import referenzixx.refs.*
import referenzixx.ui.*

description 'Arto voi lisätä viitteen, jolla on viitteelle tyypilliset kentät.'

scenario "Lisääminen onnistuu kun kaikki pakolliset on annettu", {
    given 'Kaikki tiedot on annettu.'
    when 'Valitaan lisäys'
    then 'Lisäys onnistuu'
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

