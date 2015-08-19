package ristinolla.kayttoliittyma;

import java.util.Scanner;
import ristinolla.logiikka.*;

public class Käyttöliittymä {

    Scanner lukija;
    Ohjelmistologiikka logic;

    public Käyttöliittymä() {
        this.lukija = new Scanner(System.in);
        this.logic = new Ohjelmistologiikka();
    }

    public void kaynnista() {
        alkuteksti();
        luoRuudukko();
        logic.luoTuomari(logic.getKirjanpito(), logic.getRuudukko());
        while (logic.jatkuukoPeli()) {
            int xKoordinaatti = kysyKokonaisluku("Anna X koordinaatti: ", 0, logic.getRuudukonSivunPituus() - 1);
            int yKoordinaatti = kysyKokonaisluku("Anna Y koordinaatti: ", 0, logic.getRuudukonSivunPituus() - 1);
            logic.teeSiirto(logic.kenenVuoro(), xKoordinaatti, yKoordinaatti);
            logic.tulostaRuudukko();
        }
        System.out.println("GAME OVER. WINNER IS " + logic.kenenVuoro());
    }

    private void luoRuudukko() {
        int sivunPituus = kysyKokonaisluku("Anna ruudukon sivun pituus: ", 20, 100);
        logic.luoRuudukko(sivunPituus);
    }

    private void alkuteksti() {
        System.out.println("Tervetuloa ristinolla-peliin.");
        System.out.println("Luodaan uusi peliruudukko.");
    }

    public int kysyKokonaisluku(String viesti, int min, int max) {

        int luku = 0;
        while (true) {
            System.out.print(viesti);
            luku = Integer.parseInt(lukija.nextLine());
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
