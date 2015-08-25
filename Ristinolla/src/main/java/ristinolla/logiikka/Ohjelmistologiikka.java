package ristinolla.logiikka;

import ristinolla.kayttoliittyma.Ruudukko;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import ristinolla.kayttoliittyma.GraafinenKayttoliittyma;



public class Ohjelmistologiikka {
    private Pelimerkki X;
    private Pelimerkki O;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Ruudukko ruudukko;
    private boolean jatkuukoPeli;
    private Kirjanpito kirjanpito;
    private int ruudukonSivunPituus;
    
    private Tuomari tuomari;
    
    public Ohjelmistologiikka() {
        this.X = new Pelimerkki("X");
        this.O = new Pelimerkki("O");
        this.pelaaja1 = new Pelaaja("pelaaja1", X, true);
        this.pelaaja2 = new Pelaaja("pelaaja2", O, false);
        this.jatkuukoPeli = true;
        this.kirjanpito = new Kirjanpito();
        this.ruudukonSivunPituus = 0;
    }
    
    public void luoTuomari(Kirjanpito kirjanpito, Ruudukko ruudukko){
         this.tuomari = new Tuomari(kirjanpito, ruudukko);
    }

    public void luoRuudukko(int sivunPituus) {
        ruudukonSivunPituus = sivunPituus;
        this.ruudukko = new Ruudukko(sivunPituus);
    }
    
    public void uusiPeli(){
       kirjanpito.tyhjennaKirjanpito();
       ruudukko.tyhjennaRuudukko();
       
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
    
    public boolean teeSiirto(Pelaaja pelaaja, int xKoordinaatti, int yKoordinaatti) {
            if(!onkoSiirtoLaillinen(xKoordinaatti, yKoordinaatti)){
                System.out.println("Laiton siirto!");
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

    public boolean onkoSiirtoLaillinen(int xKoordinaatti, int yKoordinaatti) {
        return !kirjanpito.sisaltaakoPelimerkkia(xKoordinaatti, yKoordinaatti);
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

    public Pelimerkki getO() {
        return O;
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


