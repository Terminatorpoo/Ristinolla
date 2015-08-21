package ristinolla.kayttoliittyma;

import java.util.Scanner;
import javax.swing.SwingUtilities;
import ristinolla.logiikka.*;


public class Käyttöliittymä {

    private Scanner lukija;
    private Ohjelmistologiikka logic;
    private GraafinenKayttoliittyma gui;
    

    public Käyttöliittymä() {
        this.lukija = new Scanner(System.in);
        this.logic = new Ohjelmistologiikka();
        this.gui = new GraafinenKayttoliittyma(logic);
        
    }
    
    
    
    public void kaynnista() {
        
        alkuteksti();
        logic.luoRuudukko(25);
        logic.luoTuomari(logic.getKirjanpito(), logic.getRuudukko());
        logic.tulostaRuudukko();
        
        
        SwingUtilities.invokeLater(gui);
        
        while (logic.jatkuukoPeli()) {
            int xKoordinaatti = kysyKokonaisluku("Anna X koordinaatti: ", 0, logic.getRuudukonSivunPituus() - 1);
            int yKoordinaatti = kysyKokonaisluku("Anna Y koordinaatti: ", 0, logic.getRuudukonSivunPituus() - 1);
            logic.teeSiirto(logic.kenenVuoro(), xKoordinaatti, yKoordinaatti);
            logic.tulostaRuudukko();
        }
        System.out.println("GAME OVER. WINNER IS " + logic.kenenVuoro());
    }

//    private void luoRuudukko() {
//        Tähän jätetään mahdollisuus kysyä käyttäjältä ruudukon kokoa.
//        int sivunPituus = kysyKokonaisluku("Anna ruudukon sivun pituus: ", 20, 100);
//        logic.luoRuudukko(sivunPituus);
//    }

    private void alkuteksti() {
        System.out.println("Tervetuloa ristinolla-peliin.");
        System.out.println("Luodaan uusi peliruudukko.");
    }

    public int kysyKokonaisluku(String viesti, int min, int max) {

        int luku = 0;
        while (true) {
            System.out.print(viesti);
            try {
            luku = Integer.parseInt(lukija.nextLine());
            } catch (Exception e){
                System.out.println("Et syöttänyt kunnollista lukua. Apina.");
                continue;
            }
            if (luku >= min && luku <= max) {
                break;
            } else if (luku < min) {
                System.out.println("Syötettävä luku minimissään " + min + "!");
            } else if (luku > max) {
                System.out.println("Syötettävä luku maksimissaan " + max + "!");
            }
        }

        return luku;
    }
    
    

    
    
    
    
    
}
