package ristinolla.logiikka;

public class Ruudukko {

    private int korkeus;
    private int leveys;
    private String[][] ruudukko;

    public Ruudukko(int korkeus, int leveys) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.ruudukko = new String[korkeus][leveys];
    }

    public void tulostaRuudukko(Kirjanpito kirjanpito) {
        
        
        for (int rivi = 0; rivi < ruudukko.length; rivi++) {
            for (int sarake = 0; sarake < ruudukko[rivi].length; sarake++) {

                ruudukko[rivi][sarake] = "[ ]";
            }
       
        }
               
        for(Koordinaatti koordinaatti : kirjanpito.getSiirrot().keySet()) {
            ruudukko[koordinaatti.getX()][koordinaatti.getY()] = "[" + kirjanpito.getSiirrot().get(koordinaatti).getMerkki() + "]";
        }
        
        for (int rivi = 0; rivi < ruudukko.length; rivi++) {
            for (int sarake = 0; sarake < ruudukko[rivi].length; sarake++) {

                System.out.print(ruudukko[sarake][rivi]);
            }
            System.out.println("");
       
        }
        
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }
    
    
    
    
}


