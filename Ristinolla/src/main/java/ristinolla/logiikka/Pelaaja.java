
package ristinolla.logiikka;



public class Pelaaja {
    private String nimi;
    private Pelimerkki merkki;
    private boolean onkoMinunVuoro;
    
    public Pelaaja(String nimi, Pelimerkki merkki, boolean onkoMinunVuoro){
        this. nimi = nimi;
        this.merkki = merkki;
        this.onkoMinunVuoro = onkoMinunVuoro;
    }

    public void vuoroVaihtuu(){
        onkoMinunVuoro = !onkoMinunVuoro;
    }

    public boolean isOnkoMinunVuoro() {
        return onkoMinunVuoro;
    }

    public String getNimi() {
        return nimi;
    }

    public Pelimerkki getMerkki() {
        return merkki;
    }
    
    
    
    
    
}
