package ristinolla.logiikka;



public class Ohjelmistologiikka {
    private Pelimerkki X;
    private Pelimerkki Y;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Ruudukko ruudukko;
    private boolean jatkuukoPeli;
    private Kirjanpito kirjanpito;
    private int ruudukonKorkeus;
    private int ruudukonLeveys;
    
    


    public Ohjelmistologiikka() {
        this.X = new Pelimerkki("X");
        this.Y = new Pelimerkki("Y");
        this.pelaaja1 = new Pelaaja("pelaaja1", new Pelimerkki("X"), true);
        this.pelaaja2 = new Pelaaja("pelaaja2", new Pelimerkki("O"), false);
        this.jatkuukoPeli = true;
        this.kirjanpito = new Kirjanpito();
        this.ruudukonKorkeus = 0;
        this.ruudukonLeveys = 0;
    }

    public int getRuudukonKorkeus() {
        return ruudukonKorkeus;
    }

    public Pelimerkki getX() {
        return X;
    }

    public Pelaaja getPelaaja1() {
        return pelaaja1;
    }

    public Pelaaja getPelaaja2() {
        return pelaaja2;
    }

    public Kirjanpito getKirjanpito() {
        return kirjanpito;
    }
    
    

    public int getRuudukonLeveys() {
        return ruudukonLeveys;
    }
    


    public void luoRuudukko(int korkeus, int leveys) {
        ruudukonKorkeus = korkeus;
        ruudukonLeveys = leveys;
        ruudukko = new Ruudukko(korkeus, leveys);
    }
    
    public void tulostaRuudukko() {
        ruudukko.tulostaRuudukko(kirjanpito);
    }
    
    public void vuoroVaihtuu(){
        pelaaja1.vuoroVaihtuu();
        pelaaja2.vuoroVaihtuu();
    }
    
    public Pelaaja kenenVuoro(){
        if(pelaaja1.isOnkoMinunVuoro()){
            return pelaaja1;
        }else{
            return pelaaja2;
        }
    }
    
    public void teeSiirto(Pelaaja pelaaja, int xKoordinaatti, int yKoordinaatti) {
            if(!onkoSiirtoLaillinen(xKoordinaatti, yKoordinaatti)){
                System.out.println("Laiton siirto!");
                return;
            }
            Koordinaatti koordinaatti = new Koordinaatti(xKoordinaatti, yKoordinaatti);
            kirjanpito.annaSiirto(koordinaatti, pelaaja.getMerkki());
            vuoroVaihtuu();

        }
    
//    TÄMÄ METODI VIIMEISTELLÄÄN MYÖHEMMIN
    public boolean jatkuukoPeli() {
        System.out.println(kenenVuoro().getNimi() + ":n vuoro");
        return jatkuukoPeli;
    }

    public boolean onkoSiirtoLaillinen(int xKoordinaatti, int yKoordinaatti) {
        return !kirjanpito.sisaltaakoAvainta(xKoordinaatti, yKoordinaatti);
    }
    }


