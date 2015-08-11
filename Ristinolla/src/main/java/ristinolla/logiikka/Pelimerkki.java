
package ristinolla.logiikka;

import java.util.Objects;


public class Pelimerkki {
    
    private String merkki;
    
    public Pelimerkki(String merkki) {
        this.merkki = merkki;
    }

    public String getMerkki() {
        return merkki;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.merkki);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelimerkki other = (Pelimerkki) obj;
        if (!Objects.equals(this.merkki, other.merkki)) {
            return false;
        }
        return true;
    }
    
    
    
}
