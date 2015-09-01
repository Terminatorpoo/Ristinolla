package ristinolla.kayttoliittyma;

import java.util.ArrayList;
import javax.swing.JButton;
import ristinolla.logiikka.Koordinaatti;
import ristinolla.logiikka.Nappi;

/**
 * Luokka tallentaa pelin ruudukot (JButtonit) ArrayListiin ja tarjoaa toiminnallisuutta
 * ruudukon muokkaamiseen.
 */
public class Ruudukko {


    private final ArrayList<Nappi> napit;

    
    public Ruudukko(int sivunPituus) {
        this.napit = new ArrayList<>();
        for (int rivi = 0; rivi < sivunPituus; rivi++) {
            for (int sarake = 0; sarake < sivunPituus; sarake++) {
                Nappi nappi = new Nappi(new JButton(), new Koordinaatti(sarake, rivi));
                napit.add(nappi);
            }
        }
    }

    /**
     *Metodi tyhjentää jokaisen ruudun tekstistä
     */
    public void tyhjennaRuudukko() {
        for (Nappi nappi1 : napit) {
            nappi1.getRuutu().setText("");
        }
    }

    public ArrayList<Nappi> getNapit() {
        return napit;
    }
    
    /**
     * Metodi poistaa jokaisen ruudun painamismahdollisuuden
     */
    public void jaadytaRuudukko() {
        for (Nappi nappi : napit) {
            nappi.getRuutu().setEnabled(false);
        }
    }
    
    /**
     * Metodi mahdollsitaa jokaisen ruudun painamismahdollisuuden. 
     * Käytetään vain jäädyttämisen jälkeen
     */
    public void sulataRUudukko() {
        for (Nappi nappi : napit) {
            nappi.getRuutu().setEnabled(true);
        }
    }

}
