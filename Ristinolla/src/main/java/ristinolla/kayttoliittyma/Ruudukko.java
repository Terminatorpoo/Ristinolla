package ristinolla.kayttoliittyma;

import java.util.ArrayList;
import javax.swing.JButton;
import ristinolla.logiikka.Koordinaatti;
import ristinolla.logiikka.Nappi;

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

    public void tyhjennaRuudukko() {
        for (Nappi nappi1 : napit) {
            nappi1.getRuutu().setText("");
        }
    }

    public ArrayList<Nappi> getNapit() {
        return napit;
    }
    
    public void jaadytaRuudukko() {
        for (Nappi nappi : napit) {
            nappi.getRuutu().setEnabled(false);
        }
    }
    
    public void sulataRUudukko() {
        for (Nappi nappi : napit) {
            nappi.getRuutu().setEnabled(true);
        }
    }

}
