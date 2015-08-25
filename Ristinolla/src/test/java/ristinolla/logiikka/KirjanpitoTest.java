package ristinolla.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KirjanpitoTest {
    Kirjanpito kirjanpito = new Kirjanpito();

    public KirjanpitoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void antaakoSiirrotOikein() {
        
        kirjanpito.annaSiirto(new Koordinaatti(1, 6), new Pelimerkki("X"));
        assertEquals(true, kirjanpito.getSiirrot().keySet().contains(new Koordinaatti(1, 6)));
    }
    
    @Test
    public void sisaltaaAvaimen(){
        Koordinaatti xy = new Koordinaatti (1, 1);
        kirjanpito.annaSiirto(xy, new Pelimerkki("X"));
        assertEquals(true, kirjanpito.sisaltaakoPelimerkkia(1, 1));
        
    }
    
    @Test
    public void eiSisallaAvainta(){
        Koordinaatti xy = new Koordinaatti (1, 1);
        kirjanpito.annaSiirto(xy, new Pelimerkki("X"));
        assertEquals(false, kirjanpito.sisaltaakoPelimerkkia(2, 2));
    }
}
