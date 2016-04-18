import referenzixx.*
import referenzixx.refs.*
import referenzixx.ui.*
import referenzixx.parser.*


description "Tiedot säilyvät vaikka Arton kone sammuisi"

scenario "Uuden tiedoston generointi lisayksessa.", {
	given "Bibtex-tiedostoa ei ole olemassa"
	when "Luodaan bibtex ja lisataan sinne yksi viite, ja ohjelma yllattaen sammuu."
	then "Bibtex-tiedosto on olemassa ja sisältää yhden artikkelin."
}

scenario "Olemassaolevaan tiedostoon kirjoitettu ei katoa", {
	given "Bibtex-tiedosto on olemassa"
	when "Lisataan bibtexiin artikkeli, ja ohjelma yllattaen sammuu."
	then "Bibtex-tiedostossa on lisätty artikkeli"
}
