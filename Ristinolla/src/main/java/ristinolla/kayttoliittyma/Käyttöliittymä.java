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
        while (logic.jatkuukoPeli()) {
            int xKoordinaatti = kysyKokonaisluku("Anna X koordinaatti: ", 0, logic.getRuudukonLeveys() - 1);
            int yKoordinaatti = kysyKokonaisluku("Anna Y koordinaatti: ", 0, logic.getRuudukonKorkeus() - 1);
            logic.teeSiirto(logic.kenenVuoro(), xKoordinaatti, yKoordinaatti);
            logic.tulostaRuudukko();

        }

    }

    private void luoRuudukko() {
        int korkeus = kysyKokonaisluku("Anna korkeus (min 20): ", 20, 100);
        int leveys = kysyKokonaisluku("Anna leveys (min 20): ", 20, 100);
        logic.luoRuudukko(korkeus, leveys);
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
                System.out.println("Luku minimissään " + min + "!");
            } else if (luku > max) {
                System.out.println("Luku maksimissaan " + max + "!");
            }
        }

        return luku;
    }
}
