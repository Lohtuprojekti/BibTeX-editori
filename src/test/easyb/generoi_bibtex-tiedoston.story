import referenzixx.*
import referenzixx.refs.*
import referenzixx.ui.*

description 'Arto voi generoida bibtex-tiedoston'

scenario "Bibtexiin kirjoittaminen onnistuu oikeilla syötteillä.", {
    given 'Bibtex tiedostossa on sisältöä'
    when 'Lisätään yksi uusi viite'
    then 'Tiedoston pituus kasvaa'
}

scenario "Bibtexiin kirjoittaminen ei onnistu ilman syötettä.", {
    given 'Bibtex tiedostossa on sisältöä'
    when 'Lisätään tyhjää'
    then 'Tiedostossa ei tapahdu muutosta'
}
