package ristinolla.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import ristinolla.logiikka.Nappi;
import ristinolla.logiikka.Ohjelmistologiikka;

public class RuudukonKuuntelija implements ActionListener {

    private Nappi nappi;
    private GraafinenKayttoliittyma kayttis;

    public RuudukonKuuntelija(GraafinenKayttoliittyma kayttis, Nappi nappi) {
        this.kayttis = kayttis;
        this.nappi = nappi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (kayttis.teeSiirto(nappi.getX(), nappi.getY())) {
            nappi.getRuutu().setText(kayttis.getLogic().kenenVuoro().getMerkki().toString());
        }

        if (!kayttis.getLogic().jatkuukoPeli()) {
            kayttis.lopetaPeli();
        }
    }

}
