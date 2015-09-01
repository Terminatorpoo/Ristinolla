package ristinolla.logiikka;

import javax.swing.JButton;

/**
 * Luokka yhdistää JButtonin tiettyyn koordinaattiin.
 */
public class Nappi {

    JButton ruutu;
    Koordinaatti koordinaatti;

    
    public Nappi(JButton ruutu, Koordinaatti koordinaatti) {
        this.ruutu = ruutu;
        this.koordinaatti = koordinaatti;
    }

    public Koordinaatti getKoordinaatti() {
        return koordinaatti;
    }

    public int getX() {
        return koordinaatti.getX();
    }

    public int getY() {
        return koordinaatti.getY();
    }

    public JButton getRuutu() {
        return ruutu;
    }

    /**
     *Metodi muuttaa JButtonin sisältämää tekstiä
     * @param teksti JButtonin haluttu teksti
     */
    public void muutaNapinTekstia(String teksti) {
        ruutu.setText(teksti);
    }

}
