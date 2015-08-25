
package ristinolla.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TuomariTest {
    Ohjelmistologiikka logic = new Ohjelmistologiikka();
    
    
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
        logic.luoRuudukko(25);
        logic.luoTuomari(logic.getKirjanpito(), logic.getRuudukko());
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
         logic.getKirjanpito().annaSiirto(a, logic.getX());
         logic.getKirjanpito().annaSiirto(b, logic.getX());
         logic.getKirjanpito().annaSiirto(c, logic.getX());
         logic.getKirjanpito().annaSiirto(d, logic.getX());
         logic.getKirjanpito().annaSiirto(e, logic.getX());
         assertEquals(false, logic.getTuomari().jatkuukoPeli());
     }
     
     
     
     @Test
     public void viidensuoraOikeastaAlakulmastaVasemmalle(){
         Koordinaatti a = new Koordinaatti (19, 19);
         Koordinaatti b = new Koordinaatti (18, 19);
         Koordinaatti c = new Koordinaatti (17, 19);
         Koordinaatti d = new Koordinaatti (16, 19);
         Koordinaatti e = new Koordinaatti (15, 19);
         logic.getKirjanpito().annaSiirto(a, logic.getX());
         logic.getKirjanpito().annaSiirto(b, logic.getX());
         logic.getKirjanpito().annaSiirto(c, logic.getX());
         logic.getKirjanpito().annaSiirto(d, logic.getX());
         logic.getKirjanpito().annaSiirto(e, logic.getX());
         assertEquals(false, logic.getTuomari().jatkuukoPeli());
     }
     
     @Test
     public void viidensuoraVasemmastaYlakulmastaAlaspain() {
         Koordinaatti a = new Koordinaatti (0, 0);
         Koordinaatti b = new Koordinaatti (0, 1);
         Koordinaatti c = new Koordinaatti (0, 2);
         Koordinaatti d = new Koordinaatti (0, 3);
         Koordinaatti e = new Koordinaatti (0, 4);
         logic.getKirjanpito().annaSiirto(a, logic.getX());
         logic.getKirjanpito().annaSiirto(b, logic.getX());
         logic.getKirjanpito().annaSiirto(c, logic.getX());
         logic.getKirjanpito().annaSiirto(d, logic.getX());
         logic.getKirjanpito().annaSiirto(e, logic.getX());
         assertEquals(false, logic.getTuomari().jatkuukoPeli());
     }
     
     @Test
     public void viidensuoraOikeastaAlakulmastaYlospain() {
         Koordinaatti a = new Koordinaatti (19, 19);
         Koordinaatti b = new Koordinaatti (19, 18);
         Koordinaatti c = new Koordinaatti (19, 17);
         Koordinaatti d = new Koordinaatti (19, 16);
         Koordinaatti e = new Koordinaatti (19, 15);
         logic.getKirjanpito().annaSiirto(a, logic.getX());
         logic.getKirjanpito().annaSiirto(b, logic.getX());
         logic.getKirjanpito().annaSiirto(c, logic.getX());
         logic.getKirjanpito().annaSiirto(d, logic.getX());
         logic.getKirjanpito().annaSiirto(e, logic.getX());
         assertEquals(false, logic.getTuomari().jatkuukoPeli());
     }
     
     @Test
     public void viidensuoraVaakatasossaMerkkejaSekaisin() {
         Koordinaatti a = new Koordinaatti (19, 19);
         Koordinaatti b = new Koordinaatti (18, 19);
         Koordinaatti c = new Koordinaatti (17, 19);
         Koordinaatti d = new Koordinaatti (16, 19);
         Koordinaatti e = new Koordinaatti (15, 19);
         logic.getKirjanpito().annaSiirto(a, logic.getX());
         logic.getKirjanpito().annaSiirto(b, logic.getO());
         logic.getKirjanpito().annaSiirto(c, logic.getX());
         logic.getKirjanpito().annaSiirto(d, logic.getO());
         logic.getKirjanpito().annaSiirto(e, logic.getX());
         assertEquals(true, logic.getTuomari().jatkuukoPeli());
     }
     
     @Test
     public void viidensuoraPystytasossaMerkkejaSekaisin() {
         Koordinaatti a = new Koordinaatti (19, 19);
         Koordinaatti b = new Koordinaatti (19, 18);
         Koordinaatti c = new Koordinaatti (19, 17);
         Koordinaatti d = new Koordinaatti (19, 16);
         Koordinaatti e = new Koordinaatti (19, 15);
         logic.getKirjanpito().annaSiirto(a, logic.getX());
         logic.getKirjanpito().annaSiirto(b, logic.getX());
         logic.getKirjanpito().annaSiirto(c, logic.getO());
         logic.getKirjanpito().annaSiirto(d, logic.getO());
         logic.getKirjanpito().annaSiirto(e, logic.getX());
         assertEquals(true, logic.getTuomari().jatkuukoPeli());
     }
     
     @Test
     public void viidensuoraVasemmastaAlakulmastaYlaviistoon() {
         Koordinaatti a = new Koordinaatti(0, 19);
         Koordinaatti b = new Koordinaatti(1, 18);
         Koordinaatti c = new Koordinaatti(2, 17);
         Koordinaatti d = new Koordinaatti(3, 16);
         Koordinaatti e = new Koordinaatti(4, 15);
         logic.getKirjanpito().annaSiirto(a, logic.getX());
         logic.getKirjanpito().annaSiirto(b, logic.getX());
         logic.getKirjanpito().annaSiirto(c, logic.getX());
         logic.getKirjanpito().annaSiirto(d, logic.getX());
         logic.getKirjanpito().annaSiirto(e, logic.getX());
         assertEquals(false, logic.getTuomari().jatkuukoPeli());
     }
     
     @Test public void viidensuoraVasemmaltaKeskeltaYlaviistoon() {
         Koordinaatti a = new Koordinaatti(0, 10);
         Koordinaatti b = new Koordinaatti(1, 9);
         Koordinaatti c = new Koordinaatti(2, 8);
         Koordinaatti d = new Koordinaatti(3, 7);
         Koordinaatti e = new Koordinaatti(4, 6);
         logic.getKirjanpito().annaSiirto(a, logic.getX());
         logic.getKirjanpito().annaSiirto(b, logic.getX());
         logic.getKirjanpito().annaSiirto(c, logic.getX());
         logic.getKirjanpito().annaSiirto(d, logic.getX());
         logic.getKirjanpito().annaSiirto(e, logic.getX());
         assertEquals(false, logic.getTuomari().jatkuukoPeli());
     }
     
     @Test
     public void viidensuoraKeskeltaAlhaaltaYlaviistoon() {
         Koordinaatti a = new Koordinaatti(10, 19);
         Koordinaatti b = new Koordinaatti(11, 18);
         Koordinaatti c = new Koordinaatti(12, 17);
         Koordinaatti d = new Koordinaatti(13, 16);
         Koordinaatti e = new Koordinaatti(14, 15);
         logic.getKirjanpito().annaSiirto(a, logic.getX());
         logic.getKirjanpito().annaSiirto(b, logic.getX());
         logic.getKirjanpito().annaSiirto(c, logic.getX());
         logic.getKirjanpito().annaSiirto(d, logic.getX());
         logic.getKirjanpito().annaSiirto(e, logic.getX());
         assertEquals(false, logic.getTuomari().jatkuukoPeli());
     }
     
     @Test
     public void viidensuoraVasemmastaYlakulmastaAlaviistoon() {
         Koordinaatti a = new Koordinaatti(0, 0);
         Koordinaatti b = new Koordinaatti(1, 1);
         Koordinaatti c = new Koordinaatti(2, 2);
         Koordinaatti d = new Koordinaatti(3, 3);
         Koordinaatti e = new Koordinaatti(4, 4);
         logic.getKirjanpito().annaSiirto(a, logic.getX());
         logic.getKirjanpito().annaSiirto(b, logic.getX());
         logic.getKirjanpito().annaSiirto(c, logic.getX());
         logic.getKirjanpito().annaSiirto(d, logic.getX());
         logic.getKirjanpito().annaSiirto(e, logic.getX());
         assertEquals(false, logic.getTuomari().jatkuukoPeli());
     }
     
     @Test
     public void viidensuoraVasemmaltaKeskeltaAlaviistoon() {
         Koordinaatti a = new Koordinaatti(0, 10);
         Koordinaatti b = new Koordinaatti(1, 11);
         Koordinaatti c = new Koordinaatti(2, 12);
         Koordinaatti d = new Koordinaatti(3, 13);
         Koordinaatti e = new Koordinaatti(4, 14);
         logic.getKirjanpito().annaSiirto(a, logic.getX());
         logic.getKirjanpito().annaSiirto(b, logic.getX());
         logic.getKirjanpito().annaSiirto(c, logic.getX());
         logic.getKirjanpito().annaSiirto(d, logic.getX());
         logic.getKirjanpito().annaSiirto(e, logic.getX());
         assertEquals(false, logic.getTuomari().jatkuukoPeli());
     }
     
     @Test
     public void viidensuoraYlhaaltaKeskeltaAlaviistoon() {
         Koordinaatti a = new Koordinaatti(9, 0);
         Koordinaatti b = new Koordinaatti(10, 1);
         Koordinaatti c = new Koordinaatti(11, 2);
         Koordinaatti d = new Koordinaatti(12, 3);
         Koordinaatti e = new Koordinaatti(13, 4);
         logic.getKirjanpito().annaSiirto(a, logic.getO());
         logic.getKirjanpito().annaSiirto(b, logic.getO());
         logic.getKirjanpito().annaSiirto(c, logic.getO());
         logic.getKirjanpito().annaSiirto(d, logic.getO());
         logic.getKirjanpito().annaSiirto(e, logic.getO());
         assertEquals(false, logic.getTuomari().jatkuukoPeli());
     }
     
     
     
}
