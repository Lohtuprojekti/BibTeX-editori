import referenzixx.*
import referenzixx.refs.*
import referenzixx.ui.*

description "Arto voi generoida bibtex-tiedoston"

scenario "Bibtexiin kirjoittaminen onnistuu oikeilla syötteillä.", {
    given "Bibtex tiedostossa on sisältöä"
    when "Lisätään yksi uusi viite"
    then "Tiedoston pituus kasvaa"
}

scenario "Bibtexiin kirjoittaminen ei onnistu ilman syötettä.", {
    given "Bibtex tiedostossa on sisältöä"
    when "Lisätään tyhjää"
    then "Tiedostossa ei tapahdu muutosta"
}

scenario "Bibtexin luonti onnistuu oikealla syötteellä", {
    given "Bibtexiä ei ole olemassa"
    when "Lisätään artikkeli"
    then "Tiedosto luodaan ja siinä on sisältöä"
}

scenario "Bibtexin luonti ei onnistu ilman oikeaa syötettä", {
    given "Bibtexiä ei ole olemassa"
    when "Lisätään tyhjää"
    then "Tiedostoa ei ole olemassa"
}