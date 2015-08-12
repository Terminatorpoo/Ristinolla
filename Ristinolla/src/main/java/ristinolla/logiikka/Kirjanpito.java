package ristinolla.logiikka;


import java.util.HashMap;

public class Kirjanpito {

    
    private HashMap<Koordinaatti, Pelimerkki> siirrot;

    public Kirjanpito() {
        this.siirrot = new HashMap<>();
    }
    
    
    public void annaSiirto(Koordinaatti koordinaatti, Pelimerkki merkki){
        siirrot.put(koordinaatti, merkki);
    }

    public HashMap<Koordinaatti, Pelimerkki> getSiirrot() {
        return siirrot;
    }
    
    public boolean sisaltaakoAvainta(int X, int Y){
        for (Koordinaatti xy : siirrot.keySet()) {
            if(xy.getX() == X && xy.getY() == Y) {
                return true;
            }
        }
        return false;
    }
    
    
    public Pelimerkki mikaMerkkiRuudussa(int X, int Y) {
        for (Koordinaatti xy : siirrot.keySet()) {
            if(xy.getX() == X && xy.getY() == Y) {
                return siirrot.get(xy);
            }
        }
        return null;
    }
    
}
