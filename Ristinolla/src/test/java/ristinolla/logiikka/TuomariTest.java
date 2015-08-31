
package ristinolla.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static ristinolla.logiikka.Pelimerkki.O;
import static ristinolla.logiikka.Pelimerkki.X;


public class TuomariTest {
    //Ohjelmistologiikka logic = new Ohjelmistologiikka();
    Tuomari tuomari;
    Kirjanpito kirjanpito;
    
    public TuomariTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kirjanpito = new Kirjanpito();
        tuomari = new Tuomari(kirjanpito, 25);
    }
    
    @After
    public void tearDown() {
    }

    @Test
     public void viidensuoraVasemmastaYlakulmastaOikealle() {
         Koordinaatti a = new Koordinaatti (0, 0);
         Koordinaatti b = new Koordinaatti (1, 0);
         Koordinaatti c = new Koordinaatti (2, 0);
         Koordinaatti d = new Koordinaatti (3, 0);
         Koordinaatti e = new Koordinaatti (4, 0);
         kirjanpito.annaSiirto(a, X);
         kirjanpito.annaSiirto(b, X);
         kirjanpito.annaSiirto(c, X);
         kirjanpito.annaSiirto(d, X);
         kirjanpito.annaSiirto(e, X);
         assertEquals(false, tuomari.jatkuukoPeli());
     }
     
     
     
     @Test
     public void viidensuoraOikeastaAlakulmastaVasemmalle(){
         Koordinaatti a = new Koordinaatti (19, 19);
         Koordinaatti b = new Koordinaatti (18, 19);
         Koordinaatti c = new Koordinaatti (17, 19);
         Koordinaatti d = new Koordinaatti (16, 19);
         Koordinaatti e = new Koordinaatti (15, 19);
         kirjanpito.annaSiirto(a, X);
         kirjanpito.annaSiirto(b, X);
         kirjanpito.annaSiirto(c, X);
         kirjanpito.annaSiirto(d, X);
         kirjanpito.annaSiirto(e, X);
         assertEquals(false, tuomari.jatkuukoPeli());
     }
     
     @Test
     public void viidensuoraVasemmastaYlakulmastaAlaspain() {
         Koordinaatti a = new Koordinaatti (0, 0);
         Koordinaatti b = new Koordinaatti (0, 1);
         Koordinaatti c = new Koordinaatti (0, 2);
         Koordinaatti d = new Koordinaatti (0, 3);
         Koordinaatti e = new Koordinaatti (0, 4);
         kirjanpito.annaSiirto(a, X);
         kirjanpito.annaSiirto(b, X);
         kirjanpito.annaSiirto(c, X);
         kirjanpito.annaSiirto(d, X);
         kirjanpito.annaSiirto(e, X);
         assertEquals(false, tuomari.jatkuukoPeli());
     }
     
     @Test
     public void viidensuoraOikeastaAlakulmastaYlospain() {
         Koordinaatti a = new Koordinaatti (19, 19);
         Koordinaatti b = new Koordinaatti (19, 18);
         Koordinaatti c = new Koordinaatti (19, 17);
         Koordinaatti d = new Koordinaatti (19, 16);
         Koordinaatti e = new Koordinaatti (19, 15);
         kirjanpito.annaSiirto(a, X);
         kirjanpito.annaSiirto(b, X);
         kirjanpito.annaSiirto(c, X);
         kirjanpito.annaSiirto(d, X);
         kirjanpito.annaSiirto(e, X);
         assertEquals(false, tuomari.jatkuukoPeli());
     }
     
     @Test
     public void viidensuoraVaakatasossaMerkkejaSekaisin() {
         Koordinaatti a = new Koordinaatti (19, 19);
         Koordinaatti b = new Koordinaatti (18, 19);
         Koordinaatti c = new Koordinaatti (17, 19);
         Koordinaatti d = new Koordinaatti (16, 19);
         Koordinaatti e = new Koordinaatti (15, 19);
         kirjanpito.annaSiirto(a, X);
         kirjanpito.annaSiirto(b, O);
         kirjanpito.annaSiirto(c, X);
         kirjanpito.annaSiirto(d, O);
         kirjanpito.annaSiirto(e, X);
         assertEquals(true, tuomari.jatkuukoPeli());
     }
     
     @Test
     public void viidensuoraPystytasossaMerkkejaSekaisin() {
         Koordinaatti a = new Koordinaatti (19, 19);
         Koordinaatti b = new Koordinaatti (19, 18);
         Koordinaatti c = new Koordinaatti (19, 17);
         Koordinaatti d = new Koordinaatti (19, 16);
         Koordinaatti e = new Koordinaatti (19, 15);
         kirjanpito.annaSiirto(a, X);
         kirjanpito.annaSiirto(b, X);
         kirjanpito.annaSiirto(c, O);
         kirjanpito.annaSiirto(d, O);
         kirjanpito.annaSiirto(e, X);
         assertEquals(true, tuomari.jatkuukoPeli());
     }
     
     @Test
     public void viidensuoraVasemmastaAlakulmastaYlaviistoon() {
         Koordinaatti a = new Koordinaatti(0, 19);
         Koordinaatti b = new Koordinaatti(1, 18);
         Koordinaatti c = new Koordinaatti(2, 17);
         Koordinaatti d = new Koordinaatti(3, 16);
         Koordinaatti e = new Koordinaatti(4, 15);
         kirjanpito.annaSiirto(a, X);
         kirjanpito.annaSiirto(b, X);
         kirjanpito.annaSiirto(c, X);
         kirjanpito.annaSiirto(d, X);
         kirjanpito.annaSiirto(e, X);
         assertEquals(false, tuomari.jatkuukoPeli());
     }
     
     @Test public void viidensuoraVasemmaltaKeskeltaYlaviistoon() {
         Koordinaatti a = new Koordinaatti(0, 10);
         Koordinaatti b = new Koordinaatti(1, 9);
         Koordinaatti c = new Koordinaatti(2, 8);
         Koordinaatti d = new Koordinaatti(3, 7);
         Koordinaatti e = new Koordinaatti(4, 6);
         kirjanpito.annaSiirto(a, X);
         kirjanpito.annaSiirto(b, X);
         kirjanpito.annaSiirto(c, X);
         kirjanpito.annaSiirto(d, X);
         kirjanpito.annaSiirto(e, X);
         assertEquals(false, tuomari.jatkuukoPeli());
     }
     
     @Test
     public void viidensuoraKeskeltaAlhaaltaYlaviistoon() {
         Koordinaatti a = new Koordinaatti(10, 19);
         Koordinaatti b = new Koordinaatti(11, 18);
         Koordinaatti c = new Koordinaatti(12, 17);
         Koordinaatti d = new Koordinaatti(13, 16);
         Koordinaatti e = new Koordinaatti(14, 15);
         kirjanpito.annaSiirto(a, X);
         kirjanpito.annaSiirto(b, X);
         kirjanpito.annaSiirto(c, X);
         kirjanpito.annaSiirto(d, X);
         kirjanpito.annaSiirto(e, X);
         assertEquals(false, tuomari.jatkuukoPeli());
     }
     
     @Test
     public void viidensuoraVasemmastaYlakulmastaAlaviistoon() {
         Koordinaatti a = new Koordinaatti(0, 0);
         Koordinaatti b = new Koordinaatti(1, 1);
         Koordinaatti c = new Koordinaatti(2, 2);
         Koordinaatti d = new Koordinaatti(3, 3);
         Koordinaatti e = new Koordinaatti(4, 4);
         kirjanpito.annaSiirto(a, X);
         kirjanpito.annaSiirto(b, X);
         kirjanpito.annaSiirto(c, X);
         kirjanpito.annaSiirto(d, X);
         kirjanpito.annaSiirto(e, X);
         assertEquals(false, tuomari.jatkuukoPeli());
     }
     
     @Test
     public void viidensuoraVasemmaltaKeskeltaAlaviistoon() {
         Koordinaatti a = new Koordinaatti(0, 10);
         Koordinaatti b = new Koordinaatti(1, 11);
         Koordinaatti c = new Koordinaatti(2, 12);
         Koordinaatti d = new Koordinaatti(3, 13);
         Koordinaatti e = new Koordinaatti(4, 14);
         kirjanpito.annaSiirto(a, X);
         kirjanpito.annaSiirto(b, X);
         kirjanpito.annaSiirto(c, X);
         kirjanpito.annaSiirto(d, X);
         kirjanpito.annaSiirto(e, X);
         assertEquals(false, tuomari.jatkuukoPeli());
     }
     
     @Test
     public void viidensuoraYlhaaltaKeskeltaAlaviistoon() {
         Koordinaatti a = new Koordinaatti(9, 0);
         Koordinaatti b = new Koordinaatti(10, 1);
         Koordinaatti c = new Koordinaatti(11, 2);
         Koordinaatti d = new Koordinaatti(12, 3);
         Koordinaatti e = new Koordinaatti(13, 4);
         kirjanpito.annaSiirto(a, O);
         kirjanpito.annaSiirto(b, O);
         kirjanpito.annaSiirto(c, O);
         kirjanpito.annaSiirto(d, O);
         kirjanpito.annaSiirto(e, O);
         assertEquals(false, tuomari.jatkuukoPeli());
     }
     
     
     
}
