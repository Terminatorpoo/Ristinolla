
package ristinolla.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class ValikkorivinKuuntelija implements ActionListener{
    
    private GraafinenKayttoliittyma kayttis;
    private JButton uusiPeli;
    private JButton lopeta;
    
    public ValikkorivinKuuntelija(GraafinenKayttoliittyma kayttis, JButton lopeta, JButton uusiPeli) {
        this.kayttis = kayttis;
        this.uusiPeli = uusiPeli;
        this.lopeta = lopeta;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
           if(e.getSource() == lopeta){
            kayttis.suljeOhjelma();
           } else if(e.getSource() == uusiPeli) {
               kayttis.uusiPeli();
           }
        
    }
    
}
