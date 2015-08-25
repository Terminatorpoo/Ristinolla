package ristinolla.logiikka;

import ristinolla.kayttoliittyma.Ruudukko;

public class Tuomari {

    private Kirjanpito kirjanpito;
    private Ruudukko ruudukko;

    public Tuomari(Kirjanpito kirjanpito, Ruudukko ruudukko) {
        this.kirjanpito = kirjanpito;
        this.ruudukko = ruudukko;

    }

    public boolean jatkuukoPeli() {
        return !(onkoViisiPerakkainVaakatasossa() || onkoViisiPerakkainPystytasossa() || onkoViisiPerakkainYlaviistoon() || onkoViisiPerakkainAlaviistoon());
    }

    public boolean onkoViisiPerakkainVaakatasossa() {
        for (int i = 0; i < ruudukko.getSivunPituus(); ++i) {
            int montaPerakkain = 0;
            Pelimerkki merkki = null;

            for (int j = 0; j < ruudukko.getSivunPituus(); j++) {
                if (kirjanpito.sisaltaakoPelimerkkia(j, i) && (merkki == null || merkki == kirjanpito.mikaMerkkiRuudussa(j, i))) {
                    merkki = kirjanpito.mikaMerkkiRuudussa(j, i);
                    montaPerakkain++;
                } else if (kirjanpito.sisaltaakoPelimerkkia(j, i) && merkki != kirjanpito.mikaMerkkiRuudussa(j, i)) {
                    merkki = kirjanpito.mikaMerkkiRuudussa(j, i);
                    montaPerakkain = 1;
                } else {
                    merkki = null;
                    montaPerakkain = 0;
                }

                if (montaPerakkain == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onkoViisiPerakkainPystytasossa() {
        for (int i = 0; i < ruudukko.getSivunPituus(); ++i) {
            int montaPerakkain = 0;
            Pelimerkki merkki = null;

            for (int j = 0; j < ruudukko.getSivunPituus(); j++) {
                if (kirjanpito.sisaltaakoPelimerkkia(i, j) && (merkki == null || merkki == kirjanpito.mikaMerkkiRuudussa(i, j))) {
                    merkki = kirjanpito.mikaMerkkiRuudussa(i, j);
                    montaPerakkain++;
                } else if (kirjanpito.sisaltaakoPelimerkkia(i, j) && merkki != kirjanpito.mikaMerkkiRuudussa(i, j)) {
                    merkki = kirjanpito.mikaMerkkiRuudussa(i, j);
                    montaPerakkain = 1;
                } else {
                    merkki = null;
                    montaPerakkain = 0;
                }

                if (montaPerakkain == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onkoViisiPerakkainYlaviistoon() {

        for (int j = 4; j <= ruudukko.getSivunPituus(); j++) {
            int montaPerakkain = 0;
            Pelimerkki merkki = null;
            int c = j;
            for (int i = 0; i <= j; i++) {
                if (kirjanpito.sisaltaakoPelimerkkia(i, c) && (merkki == null || merkki == kirjanpito.mikaMerkkiRuudussa(i, c))) {
                    merkki = kirjanpito.mikaMerkkiRuudussa(i, c);
                    montaPerakkain++;
                } else if (kirjanpito.sisaltaakoPelimerkkia(i, c) && merkki != kirjanpito.mikaMerkkiRuudussa(i, c)) {
                    merkki = kirjanpito.mikaMerkkiRuudussa(i, c);
                    montaPerakkain = 1;
                } else {
                    merkki = null;
                    montaPerakkain = 0;
                }
                if (montaPerakkain == 5) {
                    return true;
                }
                c--;
            }
        }

        for (int i = 0; i <= ruudukko.getSivunPituus() - 4; i++) {

            int montaPerakkain = 0;
            Pelimerkki merkki = null;
            int c = i;
            for (int j = ruudukko.getSivunPituus(); j >= i; j--) {

                if (kirjanpito.sisaltaakoPelimerkkia(c, j) && (merkki == null || merkki == kirjanpito.mikaMerkkiRuudussa(c, j))) {
                    merkki = kirjanpito.mikaMerkkiRuudussa(c, j);
                    montaPerakkain++;
                } else if (kirjanpito.sisaltaakoPelimerkkia(c, j) && merkki != kirjanpito.mikaMerkkiRuudussa(c, j)) {
                    merkki = kirjanpito.mikaMerkkiRuudussa(c, j);
                    montaPerakkain = 1;
                } else {
                    merkki = null;
                    montaPerakkain = 0;
                }
                if (montaPerakkain == 5) {
                    return true;
                }
                c++;

            }
        }
        return false;
    }

    public boolean onkoViisiPerakkainAlaviistoon() {

        for (int j = 0; j < ruudukko.getSivunPituus() - 4; j++) {
            int montaPerakkain = 0;
            Pelimerkki merkki = null;
            int c = j;
            for (int i = 0; i < ruudukko.getSivunPituus() - j; i++) {

                if (kirjanpito.sisaltaakoPelimerkkia(i, c) && (merkki == null || merkki == kirjanpito.mikaMerkkiRuudussa(i, c))) {
                    merkki = kirjanpito.mikaMerkkiRuudussa(i, c);
                    montaPerakkain++;
                } else if (kirjanpito.sisaltaakoPelimerkkia(i, c) && merkki != kirjanpito.mikaMerkkiRuudussa(i, c)) {
                    merkki = kirjanpito.mikaMerkkiRuudussa(i, c);
                    montaPerakkain = 1;
                } else {
                    merkki = null;
                    montaPerakkain = 0;
                }
                if (montaPerakkain == 5) {
                    return true;
                }
                c++;
            }
        }

        for (int i = 1; i < ruudukko.getSivunPituus(); i++) {
            int montaPerakkain = 0;
            Pelimerkki merkki = null;
            int c = i;
            for (int j = 0; j < ruudukko.getSivunPituus() - i; j++) {
                
                    if (kirjanpito.sisaltaakoPelimerkkia(c, j) && (merkki == null || merkki == kirjanpito.mikaMerkkiRuudussa(c, j))) {
                    merkki = kirjanpito.mikaMerkkiRuudussa(c, j);
                    montaPerakkain++;
                } else if (kirjanpito.sisaltaakoPelimerkkia(c, j) && merkki != kirjanpito.mikaMerkkiRuudussa(c, j)) {
                    merkki = kirjanpito.mikaMerkkiRuudussa(c, j);
                    montaPerakkain = 1;
                } else {
                    merkki = null;
                    montaPerakkain = 0;
                }
                if (montaPerakkain == 5) {
                    return true;
                }
                c++;
            }
        }
        return false;
    }
}



