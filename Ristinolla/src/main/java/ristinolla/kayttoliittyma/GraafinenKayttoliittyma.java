package ristinolla.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import ristinolla.logiikka.Nappi;
import ristinolla.logiikka.Ohjelmistologiikka;

/**
 * Luokka toimii Ristinolla-pelin graafisena käyttöliittymänä
 */
public class GraafinenKayttoliittyma implements Runnable {

    private JFrame frame;
    private final Ohjelmistologiikka logic;
    private RuudukonKuuntelija kuuntelija1;
    private ValikkorivinKuuntelija kuuntelija2;
    private Ruudukko ruudukko;
    private int sivunPituus;
    private String teksti;
    private JTextField palaute;
    
    
    public GraafinenKayttoliittyma(Ohjelmistologiikka logic) {
        this.logic = logic;
        this.teksti = "Tervetuloa Ristinolla-peliin. Pelin aloittaa pelaaja1 pelimerkillä O.";
        
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
        JPanel panel3 = new JPanel();
        luoTekstirivi(panel3, teksti);
        frame.getContentPane().add(panel1, BorderLayout.CENTER);

        frame.getContentPane().add(panel2, BorderLayout.NORTH);
        frame.getContentPane().add(panel3, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    private void luoRuudukko(Container container) {
        GridLayout layout = new GridLayout(sivunPituus, sivunPituus);
        container.setLayout(layout);

        for (Nappi nappi : ruudukko.getNapit()) {
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
    
    private void luoTekstirivi(Container container, String teksti){
        container.setLayout(new FlowLayout());
        this.palaute = new JTextField(teksti);
        container.add(palaute);
    }

    public JFrame getFrame() {
        return frame;
    }

    /**
     * Metodi luo uuden ruudukon, käskee ohjelmistologiikkaa luomaan uuden pelin
     * parametrina ruudukon sivun pituus jonka jälkeen annetaan graafinen
     * käyttöliittymä näkyväksi.
     */
    public void kaynnista() {
        this.sivunPituus = 25;
        this.ruudukko = new Ruudukko(sivunPituus);
        logic.uusiPeli(sivunPituus);
        SwingUtilities.invokeLater(this);

    }

    public Ohjelmistologiikka getLogic() {
        return logic;
    }

    /**
     *Metodi käskee Ohjelmistologiikkaa tekemään siirron parametrina annettuihin
     * koordinaattiin.
     * @param xKoordinaatti annetun siirron X-koordinaatti
     * @param yKoordinaatti annetun siirron Y-koordinaatti
     * @return onnistuiko siirto
     */
    public boolean teeSiirto(int xKoordinaatti, int yKoordinaatti) {
        return logic.teeSiirto(logic.kenenVuoro(), xKoordinaatti, yKoordinaatti);
    }

    /**
     * Metodi muuttaa tekstipalautteen tekstiä kertomaan pelin voittajan
     * ja 'jäädyttää' ruudukon ja näin tekee lisäsiirtojen tekemisen mahdottomaksi.
     */
    public void lopetaPeli() {
        muutaTekstiRivia("Peli ohi! Voittaja on " + logic.kenenVuoroEiOle() + ".");
        ruudukko.jaadytaRuudukko();
    }

    /**
     *Metodin avulla voidaan sulkea ohjelma
     */
    public void suljeOhjelma() {
        System.exit(0);
    }

    /**
     *Metodi käskee Ohjelmistologiikkaa luomaan uuden pelin 25 sivuisella 
     * ruudukolla, tyhjentää vanhan ruudukon, 'sulattaa' ruudukon (eli tekee
     * sirtojen tekemisen jälleen mahdolliseksi) ja muuttaa tekstipalautteen
     * tekstiä kertomaan, että uusi peli alkaa.
     */
    public void uusiPeli() {
        logic.uusiPeli(25);
        ruudukko.tyhjennaRuudukko();
        ruudukko.sulataRUudukko();
        muutaTekstiRivia("Tervetuloa Ristinolla-peliin. Pelin aloittaa pelaaja1 pelimerkillä O.");

    }
    
    /**
     * Metodin avulla voidaan muuttaa tekstipalautteen tekstiä parametrina
     * annetun tekstin mukaiseksi
     * @param teksti haluttu teksti
     */
    public void muutaTekstiRivia(String teksti) {
        palaute.setText(teksti);
    }
    
}
