package ristinolla.logiikka;

import java.util.HashMap;

/**
 * Luokka pitää kirjaa pelissä tehdyistä siirroista käyttäen HashMappia.
 */
public class Kirjanpito {

    private HashMap<Koordinaatti, Pelimerkki> siirrot;

    
    public Kirjanpito() {
        this.siirrot = new HashMap<>();
    }

    /**
     *Metodi antaa kirjanpidolle uuden siirron, eli kooridaatin sekä pelimerkin.
     * @param koordinaatti tehty siirto
     * @param merkki pelaajan pelimerkki
     */
    public void annaSiirto(Koordinaatti koordinaatti, Pelimerkki merkki) {
        siirrot.put(koordinaatti, merkki);
    }

    /**
     *
     * @return palauttaa listan tehdyistä siirroista
     */
    public HashMap<Koordinaatti, Pelimerkki> getSiirrot() {
        return siirrot;
    }

    /**
     * Metodin avulla voidaan tarkistaa, onko tietyssä ruudussa pelimerkkiä
     * @param X tutkittavan ruudun X-koordinaatti
     * @param Y tutkittavan ruudun Y-koordinaatti
     * @return Onko ruudussa pelimerkkiä
     */
    public boolean sisaltaakoPelimerkkia(int X, int Y) {
        for (Koordinaatti xy : siirrot.keySet()) {
            if (xy.getX() == X && xy.getY() == Y) {
                return true;
            }
        }
        return false;
    }
//        Metodi sovelluskehityksen helpottamiseksi
//    public String tulostaSiirrot() {
//        String tehdytSiirrot = "";
//        for (Koordinaatti xy : siirrot.keySet()) {
//            tehdytSiirrot += "X: " + xy.getX() + " Y: " + xy.getY() + "\n";
//        }
//        return tehdytSiirrot;
//    }

    /**
     *Metodi kertoo mikä merkki on tietyssä ruudussa.
     * @param X haetun merkin X-koordinaatti
     * @param Y haetun merkin Y-koordinaatti
     * @return Ruudussa oleva merkki tai null viittaus (jos ruudussa ei ole merkkiä).
     */
    public Pelimerkki mikaMerkkiRuudussa(int X, int Y) {
        for (Koordinaatti xy : siirrot.keySet()) {
            if (xy.getX() == X && xy.getY() == Y) {
                return siirrot.get(xy);
            }
        }
        return null;
    }

    /**
     *Metodi tyhjentää kirjanpidon
     */
    public void tyhjennaKirjanpito() {
        siirrot.clear();
    }

}
