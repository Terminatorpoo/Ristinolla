
package ristinolla.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class OhjelmistologiikkaTest {
    Ohjelmistologiikka logics = new Ohjelmistologiikka();
    
    public OhjelmistologiikkaTest() {
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
     public void vaihtuukoVuoro() {
         logics.vuoroVaihtuu();
         assertEquals(false, logics.getPelaaja1().isOnkoMinunVuoro());
     }
     
     @Test
     public void kenenVuoro() {
         assertEquals(logics.getPelaaja1(), logics.kenenVuoro());
     }
     
     @Test
     public void laitonSiirto() {
         Koordinaatti ko = new Koordinaatti(1, 1);
         logics.getKirjanpito().annaSiirto(ko, logics.getX());
         System.out.println(ko);
         assertEquals(false, logics.onkoSiirtoLaillinen(1, 1));
     }
     
     @Test
     public void laillinenSiirto() {
         Koordinaatti ko = new Koordinaatti(1, 1);
         logics.getKirjanpito().annaSiirto(ko, logics.getX());
         assertEquals(true, logics.onkoSiirtoLaillinen(2, 2));
     }
     
     @Test
     public void siirtoTallentuuKirjanpitoon(){
         logics.teeSiirto(logics.getPelaaja1(), 1, 1);
         assertEquals(true, logics.getKirjanpito().sisaltaakoPelimerkkia(1, 1));
     }
     
     @Test
     public void vaaraSiirtoEiTallennuKirjanpitoon(){
         logics.teeSiirto(logics.getPelaaja1(), 1, 1);
         logics.teeSiirto(logics.getPelaaja2(), 1, 1);
         assertEquals(logics.getPelaaja1().getMerkki(), logics.getKirjanpito().mikaMerkkiRuudussa(1, 1));
     }
}
