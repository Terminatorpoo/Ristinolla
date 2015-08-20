package ristinolla.logiikka;

public class Tuomari {

    private Kirjanpito kirjanpito;
    private Ruudukko ruudukko;

    public Tuomari(Kirjanpito kirjanpito, Ruudukko ruudukko) {
        this.kirjanpito = kirjanpito;
        this.ruudukko = ruudukko;
    }

   
    
    public boolean jatkuukoPeli() {
        return !(onkoViisiPerakkain("vertikaalinen") || onkoViisiPerakkain("horisontaalinen") || onkoViisiPerakkain("nousevasti_viistoon") || onkoViisiPerakkain("laskevasti_viistoon"));
    }

    public boolean onkoViisiPerakkain(String suunta) {

        int montaPerakkain;
        Pelimerkki merkki = null;
        Pelimerkki uusiMerkki;

        for (int i = 0; i < ruudukko.getSivunPituus(); ++i) {
            montaPerakkain = 0;
            for (int j = 0; j < ruudukko.getSivunPituus(); j++) {

                if (suunta.equals("vertikaalinen")) {

                    if (kirjanpito.sisaltaakoAvainta(i, j)) {
                        uusiMerkki = kirjanpito.mikaMerkkiRuudussa(i, j);

                        if (merkki == null || uusiMerkki.getMerkki().equals(merkki.getMerkki())) {
                            montaPerakkain++;
                            merkki = uusiMerkki;
                        } 
                    } else {
                        montaPerakkain = 0;
                    }

                }

                if (suunta.equals("horisontaalinen")) {

                    if (kirjanpito.sisaltaakoAvainta(j, i)) {
                        uusiMerkki = kirjanpito.mikaMerkkiRuudussa(j, i);

                        if (merkki == null || uusiMerkki.getMerkki().equals(merkki.getMerkki())) {
                            montaPerakkain++;
                            merkki = uusiMerkki;
                        }
                    } else {
                        montaPerakkain = 0;
                    }
                }

                if (montaPerakkain == 5) {
                    return true;
                }

            }
        }

        if (suunta.equals("nousevasti_viistoon")) {
            for (int j = 4; j <= ruudukko.getSivunPituus(); j++) {
                montaPerakkain = 0;
                int c = j;
                for (int i = 0; i <= j; i++) {
                    if (kirjanpito.sisaltaakoAvainta(i, c)) {
                        
                        uusiMerkki = kirjanpito.mikaMerkkiRuudussa(i, c);
                        if (merkki == null || uusiMerkki.getMerkki().equals(merkki.getMerkki())) {
                            montaPerakkain++;
                            merkki = uusiMerkki;
                        }
                    } else {
                        montaPerakkain = 0;
                    }
                    if (montaPerakkain == 5) {
                        return true;
                    }
                    c--;
                }
            }

            for (int i = 0; i <= ruudukko.getSivunPituus() - 4; i++) {

                montaPerakkain = 0;
                int c = i;
                for (int j = ruudukko.getSivunPituus(); j >= i; j--) {

                    if (kirjanpito.sisaltaakoAvainta(c, j)) {
                        uusiMerkki = kirjanpito.mikaMerkkiRuudussa(c, j);
                        if (merkki == null || uusiMerkki.getMerkki().equals(merkki.getMerkki())) {
                            montaPerakkain++;
                            merkki = uusiMerkki;
                        }
                    } else {
                        montaPerakkain = 0;
                    }
                    if (montaPerakkain == 5) {
                        return true;
                    }
                    c++;
                }
            }
        }
        
        if (suunta.equals("laskevasti_viistoon")) {
            for (int j = 0; j < ruudukko.getSivunPituus(); j++) {
                montaPerakkain = 0;
                int c = j;
                for (int i = 0; i < ruudukko.getSivunPituus() - j; i++) {
                    
                    if (kirjanpito.sisaltaakoAvainta(i, c)) {
                        uusiMerkki = kirjanpito.mikaMerkkiRuudussa(i, c);
                        if (merkki == null || uusiMerkki.getMerkki().equals(merkki.getMerkki())) {
                            montaPerakkain++;
                            merkki = uusiMerkki;
                        }
                    } else {
                        montaPerakkain = 0;
                    }
                    if (montaPerakkain == 5) {
                        return true;
                    }
                    c++;
                }
            }
            
            for (int i = 1; i < ruudukko.getSivunPituus(); i++) {
                montaPerakkain = 0;
                int c = i;
                for (int j = 0; j < ruudukko.getSivunPituus() - i; j++) {
                    if (kirjanpito.sisaltaakoAvainta(c, j)) {
                        uusiMerkki = kirjanpito.mikaMerkkiRuudussa(c, j);
                        if (merkki == null || uusiMerkki.getMerkki().equals(merkki.getMerkki())) {
                            montaPerakkain++;
                            merkki = uusiMerkki;
                        }
                    } else {
                        montaPerakkain = 0;
                    }
                    if (montaPerakkain == 5) {
                        return true;
                    }
                    c++;
                }
            }
            
        }
        
        return false;
    }

}
