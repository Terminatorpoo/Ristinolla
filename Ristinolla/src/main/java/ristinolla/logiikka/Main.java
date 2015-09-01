


package ristinolla.logiikka;

import ristinolla.kayttoliittyma.*;

/**
 * Kaksinpelattava ristinolla-peli.
 *
 * @author mmalehto
 * @version 1.0
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Ohjelmistologiikka logic = new Ohjelmistologiikka();
        GraafinenKayttoliittyma kayttis = new GraafinenKayttoliittyma(logic);
        kayttis.kaynnista();
    }
}
