package ristinolla.logiikka;

import javax.swing.JButton;

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

    public void muutaNapinTekstia(String teksti) {
        ruutu.setText(teksti);
    }

}
