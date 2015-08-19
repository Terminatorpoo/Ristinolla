package ristinolla.logiikka;

public class Ruudukko {

    private int sivunPituus;
    private String[][] ruudukko;

    public Ruudukko(int sivunPituus) {
        this.sivunPituus = sivunPituus;
        this.ruudukko = new String[sivunPituus][sivunPituus];
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
            ruudukko[koordinaatti.getX()][koordinaatti.getY()] = "[" + kirjanpito.getSiirrot().get(koordinaatti).getMerkki() + "]";
        }
    }

    private void tyhjanRuudukonMuodostaminen() {
        for (int rivi = 0; rivi < ruudukko.length; rivi++) {
            for (int sarake = 0; sarake < ruudukko[rivi].length; sarake++) {
                ruudukko[rivi][sarake] = "[ ]";
            }
        }
    }

    public int getSivunPituus() {
        return sivunPituus;
    }

    
    
    
}


