package ristinolla.kayttoliittyma;

import java.util.ArrayList;
import javax.swing.JButton;
import ristinolla.logiikka.Kirjanpito;
import ristinolla.logiikka.Koordinaatti;
import ristinolla.logiikka.Nappi;

public class Ruudukko {

    private int sivunPituus;
    private String[][] ruudukko;
    private ArrayList<Nappi> napit;

    public Ruudukko(int sivunPituus) {
        this.sivunPituus = sivunPituus;
        this.ruudukko = new String[sivunPituus][sivunPituus];
        this.napit = new ArrayList<>();
        //luodaan ruudukko graafiseen käyttöliittymään:
        for (int rivi = 0; rivi < ruudukko.length; rivi++) {
            for (int sarake = 0; sarake < ruudukko[rivi].length; sarake++) {
                Nappi nappi = new Nappi(new JButton(), new Koordinaatti(sarake, rivi));
                napit.add(nappi);
            }
        }
    }
    
    
    public void tyhjennaRuudukko(){
        for (Nappi nappi1 : napit) {
            nappi1.getRuutu().setText("");
        }
    }


//    private void merkkienLisaaminen(Kirjanpito kirjanpito) {
//        for(Koordinaatti koordinaatti : kirjanpito.getSiirrot().keySet()) {
//            //lisätään merkki tekstikäyttöliitymään
//            ruudukko[koordinaatti.getX()][koordinaatti.getY()] = "[" + kirjanpito.getSiirrot().get(koordinaatti).getMerkki() + "]";
//            //lisätään merkki graaffiseen käyttöliittymään
//            for (Nappi nappi : napit) {
//                if(nappi.getX() == koordinaatti.getX() && nappi.getY() == koordinaatti.getY()){
//                    nappi.muutaNapinTekstia(kirjanpito.getSiirrot().get(koordinaatti).getMerkki());
//                }
//            }
//            
//        }
//    }

    

    public int getSivunPituus() {
        return sivunPituus;
    }

    public ArrayList<Nappi> getNapit() {
        return napit;
    }
    
    

    
    
    
}


