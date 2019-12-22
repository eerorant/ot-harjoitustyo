### Arkkitehtuurikuvaus

# Rakenne
Ohjelmassa on neljä pakkausta: battleship, control, dao, ja ui.

battleship-pakkaus sisältää main-luokan ja metodin joka vain käynnistää ohjelman. control-pakkaus sisältää Board-luokan, joka on vastuussa kunkin pelaajan pelilaudan kontrollista. dao-pakkaus sisältää yksinkertaisen StatsDAO-luokan, joka vastaa pelihistorian tallentamisesta. ui-pakkaus sisältää JavaFX-käyttöliittymästä vastaavan UI-luokan.


# Käyttöliittymä

Käyttöliittymässä on 

* Aloitusmenu
* Laivojen asetus
* Itse peli

Jokainen näistä on oma Scene-olionsa. Yksi scene kerrallaan on kiinnitetty sovelluksen Stageen. Aloitusmenussa näkyy edellisen pelin voittaja ja häviäjä, jos on pelattu jo peli. Aloitusmenusta siirrytään laivojen asetukseen, ja laivojen asetuksesta siirrytään itse peliin. Pelistä siirrytään haluttaessa takaisin aloitusmenuun. Käyttöliittymä on rakennetty JavaFX:llä.


# Sovelluslogiikka

Logiikasta vastaa Board-luokka.


# Tietojen tallennus

Tieto voittajasta ja häviäjästä tallennetaan tekstitiedostoon, josta nämä tiedot haetaan aloitusmenun infotauluun.

## Luokkakaavio


