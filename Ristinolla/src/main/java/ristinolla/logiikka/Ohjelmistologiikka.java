package ristinolla.logiikka;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import ristinolla.kayttoliittyma.GraafinenKayttoliittyma;



public class Ohjelmistologiikka {
    private Pelimerkki X;
    private Pelimerkki Y;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Ruudukko ruudukko;
    private boolean jatkuukoPeli;
    private Kirjanpito kirjanpito;
    private int ruudukonSivunPituus;
    
    private Tuomari tuomari;
    
    public Ohjelmistologiikka() {
        this.X = new Pelimerkki("X");
        this.Y = new Pelimerkki("Y");
        this.pelaaja1 = new Pelaaja("pelaaja1", new Pelimerkki("X"), true);
        this.pelaaja2 = new Pelaaja("pelaaja2", new Pelimerkki("O"), false);
        this.jatkuukoPeli = true;
        this.kirjanpito = new Kirjanpito();
        this.ruudukonSivunPituus = 0;
    }
    
    public void luoTuomari(Kirjanpito kirjanpito, Ruudukko ruudukko){
         this.tuomari = new Tuomari(kirjanpito, ruudukko);
    }

    public void luoRuudukko(int sivunPituus) {
        ruudukonSivunPituus = sivunPituus;
        ruudukko = new Ruudukko(sivunPituus);
    }
    
    public void tulostaRuudukko() {
        ruudukko.tulostaRuudukko(kirjanpito);
    }
    
    public void vuoroVaihtuu(){
        pelaaja1.vuoroVaihtuu();
        pelaaja2.vuoroVaihtuu();
    }
    
    public Pelaaja kenenVuoro(){
        if(pelaaja1.isOnkoMinunVuoro()){
            return pelaaja1;
        }else{
            return pelaaja2;
        }
    }
    
    public void teeSiirto(Pelaaja pelaaja, int xKoordinaatti, int yKoordinaatti) {
            if(!onkoSiirtoLaillinen(xKoordinaatti, yKoordinaatti)){
                System.out.println("Laiton siirto!");
                return;
            }
            Koordinaatti koordinaatti = new Koordinaatti(xKoordinaatti, yKoordinaatti);
            kirjanpito.annaSiirto(koordinaatti, pelaaja.getMerkki());
            vuoroVaihtuu();

        }
    

    public boolean jatkuukoPeli() {
        System.out.println(kenenVuoro().getNimi() + ":n vuoro");
        return tuomari.jatkuukoPeli();
    }

    public boolean onkoSiirtoLaillinen(int xKoordinaatti, int yKoordinaatti) {
        return !kirjanpito.sisaltaakoAvainta(xKoordinaatti, yKoordinaatti);
    }
    
    
    
    
    //GETTERIT SETTERIT SUN MUUT HÖPÖ HÖPÖ JUTUT
    public Tuomari getTuomari() {
        return tuomari;
    }
    
    public int getRuudukonSivunPituus() {
        return ruudukonSivunPituus;
    }

    public Pelimerkki getX() {
        return X;
    }

    public Pelimerkki getY() {
        return Y;
    }
    
    

    public Pelaaja getPelaaja1() {
        return pelaaja1;
    }

    public Pelaaja getPelaaja2() {
        return pelaaja2;
    }

    public Kirjanpito getKirjanpito() {
        return kirjanpito;
    }

    public Ruudukko getRuudukko() {
        return ruudukko;
    }

    
    
    }


