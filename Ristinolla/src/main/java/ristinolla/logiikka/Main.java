package ristinolla.logiikka;

import ristinolla.kayttoliittyma.*;

public class Main {

    public static void main(String[] args) {
        Ohjelmistologiikka logic = new Ohjelmistologiikka();
        GraafinenKayttoliittyma kayttis = new GraafinenKayttoliittyma(logic);
        kayttis.kaynnista();
    }
}
