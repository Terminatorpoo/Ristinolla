package ristinolla.logiikka;

/**
 * Metodi määrittää Ristinolla-pelin pelaajan ominaisuuksia.
 */
public class Pelaaja {

    private String nimi;
    private Pelimerkki merkki;
    private boolean onkoMinunVuoro;

    
    public Pelaaja(String nimi, Pelimerkki merkki, boolean onkoMinunVuoro) {
        this.nimi = nimi;
        this.merkki = merkki;
        this.onkoMinunVuoro = onkoMinunVuoro;
    }

    /**
     * Metodi vaihtaa pelaajan vuoroa
     */
    public void vuoroVaihtuu() {
        onkoMinunVuoro = !onkoMinunVuoro;
    }

    /**
     * Metodi kertoo onko pelaajan vuoro
     * @return onko minun vuoro
     */
    public boolean isOnkoMinunVuoro() {
        return onkoMinunVuoro;
    }

    public String getNimi() {
        return nimi;
    }

    public Pelimerkki getMerkki() {
        return merkki;
    }

    @Override
    public String toString() {
        return nimi;
    }

}
