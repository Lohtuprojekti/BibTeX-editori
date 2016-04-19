import referenzixx.*
import referenzixx.refs.*
import referenzixx.ui.*
import referenzixx.parser.*

description "Arto voi helposti kopioida koko bibtexin leikepoydalle"

scenario "Bibtex on juuri avattu ja kopioidaan sisältö leikepoydalle", {
	given "Valittu bibtex on muokkaamaton"
	when "Kopioidaan leikepoydalle"
	then "Leikepoydalla on sama sisaltö kuin bibtexissa"
}

scenario "Bibtexiin kopioidaan leikepöydälle lisäyksen jälkeen", {
	given "Valittuun bibtexiin lisattiin juuri viite"
	when "Kopioidaan leikepoydalle"
	then "Leikepoydalla on sama sisalto kuin bibtexissa"
}
