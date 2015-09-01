package ristinolla.logiikka;

/**
 * Luokka määrittää mitä tarkoitetaan koordinaatilla.
 */
public class Koordinaatti {

    private int X;
    private int Y;

    
    public Koordinaatti(int xKoordinaatti, int yKoordinaatti) {
        this.X = xKoordinaatti;
        this.Y = yKoordinaatti;
    }

    
    public int getX() {
        return X;
    }

    
    public int getY() {
        return Y;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.X;
        hash = 97 * hash + this.Y;
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
        final Koordinaatti other = (Koordinaatti) obj;
        if (this.X != other.X) {
            return false;
        }
        if (this.Y != other.Y) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Koordinaatti{" + "X=" + X + ", Y=" + Y + '}';
    }

}
