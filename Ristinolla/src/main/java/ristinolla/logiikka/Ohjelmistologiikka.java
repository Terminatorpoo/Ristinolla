package ristinolla.logiikka;

public class Ohjelmistologiikka {
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private boolean jatkuukoPeli;
    private Kirjanpito kirjanpito;
    private int ruudukonSivunPituus;
    private Tuomari tuomari;

    public Ohjelmistologiikka() {
        this.pelaaja1 = new Pelaaja("pelaaja1", Pelimerkki.X, true);
        this.pelaaja2 = new Pelaaja("pelaaja2", Pelimerkki.O, false);
        this.jatkuukoPeli = true;
        this.kirjanpito = new Kirjanpito();
        this.ruudukonSivunPituus = 0;
    }
    
    public void uusiPeli(int sivunPituus) {
        ruudukonSivunPituus = sivunPituus;
        
        this.tuomari = new Tuomari(kirjanpito, ruudukonSivunPituus);
        kirjanpito.tyhjennaKirjanpito();
        
    }

    private void vuoroVaihtuu() {
        pelaaja1.vuoroVaihtuu();
        pelaaja2.vuoroVaihtuu();
    }

    public Pelaaja kenenVuoro() {
        if (pelaaja1.isOnkoMinunVuoro()) {
            return pelaaja1;
        } else {
            return pelaaja2;
        }
    }
    
    public Pelaaja kenenVuoroEiOle() {
        if (pelaaja1.isOnkoMinunVuoro()) {
            return pelaaja2;
        } else {
            return pelaaja1;
        }
    }

    public boolean teeSiirto(Pelaaja pelaaja, int xKoordinaatti, int yKoordinaatti) {
        if (!onkoSiirtoLaillinen(xKoordinaatti, yKoordinaatti)) {
            return false;
        }
        Koordinaatti koordinaatti = new Koordinaatti(xKoordinaatti, yKoordinaatti);
        kirjanpito.annaSiirto(koordinaatti, pelaaja.getMerkki());
        vuoroVaihtuu();
        return true;
    }

    public boolean jatkuukoPeli() {
        return tuomari.jatkuukoPeli();
    }

    private boolean onkoSiirtoLaillinen(int xKoordinaatti, int yKoordinaatti) {
        return !kirjanpito.sisaltaakoPelimerkkia(xKoordinaatti, yKoordinaatti);
    }

    
//    GetX() ja Get0() metodit testejä varten (getX() ja getY() metodit löytyvät myös pelaaja luokasta).
//    public Pelimerkki getX() {
//        return X;
//    }
//
//    public Pelimerkki getO() {
//        return O;
//    }

    public Pelaaja getPelaaja1() {
        return pelaaja1;
    }

    public Pelaaja getPelaaja2() {
        return pelaaja2;
    }

    public Kirjanpito getKirjanpito() {
        return kirjanpito;
    }

}
