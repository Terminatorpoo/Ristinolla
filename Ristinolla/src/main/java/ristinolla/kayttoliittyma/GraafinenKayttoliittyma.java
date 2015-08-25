package ristinolla.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import ristinolla.logiikka.Nappi;
import ristinolla.logiikka.Ohjelmistologiikka;

public class GraafinenKayttoliittyma implements Runnable {

    private JFrame frame;
    private Ohjelmistologiikka logic;
    private RuudukonKuuntelija kuuntelija1;
    private ValikkorivinKuuntelija kuuntelija2; 
    private int x;
    private int y;

    public GraafinenKayttoliittyma(Ohjelmistologiikka logic) {
        this.logic = logic;

    }

    @Override
    public void run() {
        frame = new JFrame("Ristinolla");
        frame.setPreferredSize(new Dimension(1150, 1150));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());
        
        JPanel panel1 = new JPanel();
        luoRuudukko(panel1);
        JPanel panel2 = new JPanel();
        luoValikkorivi(panel2);
        frame.getContentPane().add(panel1, BorderLayout.CENTER);
        
        frame.getContentPane().add(panel2, BorderLayout.NORTH);
        
        frame.pack();
        frame.setVisible(true);
    }

    private void luoRuudukko(Container container) {
        GridLayout layout = new GridLayout(logic.getRuudukonSivunPituus(), logic.getRuudukonSivunPituus());
        container.setLayout(layout);

        for (Nappi nappi : logic.getRuudukko().getNapit()) {
            container.add(nappi.getRuutu());
            this.kuuntelija1 = new RuudukonKuuntelija(this, nappi);
            nappi.getRuutu().addActionListener(kuuntelija1);
        }

    }
    
    private void luoValikkorivi(Container container) {
        container.setLayout(new FlowLayout());
        
        JButton lopeta = new JButton("Lopeta");
        JButton uusiPeli = new JButton("Uusi peli");
        this.kuuntelija2 = new ValikkorivinKuuntelija(this, lopeta, uusiPeli);
        lopeta.addActionListener(kuuntelija2);
        uusiPeli.addActionListener(kuuntelija2);
        container.add(uusiPeli);
        container.add(lopeta);
        
    }

    public JFrame getFrame() {
        return frame;
    }

    public void kaynnista() {
        logic.luoRuudukko(25);
        logic.luoTuomari(logic.getKirjanpito(), logic.getRuudukko());
        SwingUtilities.invokeLater(this);

    }

    public Ohjelmistologiikka getLogic() {
        return logic;
    }

    public boolean teeSiirto(int xKoordinaatti, int yKoordinaatti) {
        return logic.teeSiirto(logic.kenenVuoro(), xKoordinaatti, yKoordinaatti);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void lopetaPeli() {
        System.out.println("Peli loppu. Voittaja on " + logic.kenenVuoro());

        for (Nappi nappi : logic.getRuudukko().getNapit()) {
            nappi.getRuutu().setEnabled(false);
        }
    }
    
    public void suljeOhjelma() {
        System.exit(0);
    }

    void uusiPeli() {
        logic.uusiPeli();
        for (Nappi nappi : logic.getRuudukko().getNapit()) {
            nappi.getRuutu().setEnabled(true);
        }
        
    }

}
