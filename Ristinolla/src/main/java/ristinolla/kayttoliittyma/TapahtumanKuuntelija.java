package ristinolla.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TapahtumanKuuntelija implements ActionListener {

    
    private JButton nappi;
    private GraafinenKayttoliittyma gui;
    

    public TapahtumanKuuntelija(GraafinenKayttoliittyma gui) {
       this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gui.getLogic().teeSiirto(gui.getLogic().kenenVuoro(), , yKoordinaatti);
    }
}
