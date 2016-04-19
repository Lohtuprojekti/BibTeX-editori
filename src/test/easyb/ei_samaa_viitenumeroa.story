import referenzixx.*
import referenzixx.refs.*
import referenzixx.ui.*
import referenzixx.parser.*


description "Arto ei voi vahingossa luoda toista viitettä, jolla on sama viitenumero"

scenario "Arto yrittaa lisätä samalla viitenumerolla", {
	given "Tiedostossa on viite jolla on viitenumero ABC123"
	when "Tiedostoon lisataan viite jolla on viitenumero ABC123"
	then "Tiedostoon ei kirjoiteta lisää"
}
