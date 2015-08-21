package ristinolla.logiikka;

import java.util.ArrayList;
import javax.swing.JButton;

public class Ruudukko {

    private int sivunPituus;
    private String[][] ruudukko;
    private ArrayList<Nappi> napit;

    public Ruudukko(int sivunPituus) {
        this.sivunPituus = sivunPituus;
        this.ruudukko = new String[sivunPituus][sivunPituus];
        this.napit = new ArrayList<>();
    }

    public void tulostaRuudukko(Kirjanpito kirjanpito) {
        tyhjanRuudukonMuodostaminen();
        merkkienLisaaminen(kirjanpito);
        ruudukonTulostaminenMerkeilla();
    }

    private void ruudukonTulostaminenMerkeilla() {
        for (int rivi = 0; rivi < ruudukko.length; rivi++) {
            for (int sarake = 0; sarake < ruudukko[rivi].length; sarake++) {
                System.out.print(ruudukko[sarake][rivi]);
                
            }
            System.out.println("");
        }
    }

    private void merkkienLisaaminen(Kirjanpito kirjanpito) {
        for(Koordinaatti koordinaatti : kirjanpito.getSiirrot().keySet()) {
            //lisätään merkki tekstikäyttöliitymään
            ruudukko[koordinaatti.getX()][koordinaatti.getY()] = "[" + kirjanpito.getSiirrot().get(koordinaatti).getMerkki() + "]";
            //lisätään merkki graaffiseen käyttöliittymään
            for (Nappi nappi : napit) {
                if(nappi.getX() == koordinaatti.getX() && nappi.getY() == koordinaatti.getY()){
                    nappi.muutaNapinTekstia(kirjanpito.getSiirrot().get(koordinaatti).getMerkki());
                }
            }
            
        }
    }

    private void tyhjanRuudukonMuodostaminen() {
        for (int rivi = 0; rivi < ruudukko.length; rivi++) {
            for (int sarake = 0; sarake < ruudukko[rivi].length; sarake++) {
                ruudukko[rivi][sarake] = "[ ]";
                Nappi nappi = new Nappi(new JButton(), new Koordinaatti(sarake, rivi));
                napit.add(nappi);
            }
        }
    }

    public int getSivunPituus() {
        return sivunPituus;
    }

    public ArrayList<Nappi> getNapit() {
        return napit;
    }
    
    

    
    
    
}


