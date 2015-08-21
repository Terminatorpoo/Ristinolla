package ristinolla.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import ristinolla.logiikka.Nappi;
import ristinolla.logiikka.Ohjelmistologiikka;

public class GraafinenKayttoliittyma implements Runnable {

    private JFrame frame;
    private Ohjelmistologiikka logic;
    private TapahtumanKuuntelija kuuntelija;

    public GraafinenKayttoliittyma(Ohjelmistologiikka logic) {
        this.logic = logic;
        this.kuuntelija = new TapahtumanKuuntelija(this);
    }
    
    

    @Override
    public void run() {
        frame = new JFrame("Otsikko");
        frame.setPreferredSize(new Dimension(1000, 1000));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(logic.getRuudukonSivunPituus(), logic.getRuudukonSivunPituus());
        container.setLayout(layout);
        for (Nappi nappi : logic.getRuudukko().getNapit()) {
            container.add(nappi.getRuutu());
            nappi.getRuutu().addActionListener(kuuntelija);
        }
        
        
    }

    public JFrame getFrame() {
        return frame;
    }

    public Ohjelmistologiikka getLogic() {
        return logic;
    }
    
    

}
