/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xo;
import javax.swing.JOptionPane;

/**
 *
 * @author Natasa
 */
public class Covek extends Igrac {
    public Covek (String oznaka){
        super (oznaka);
    }
    @Override
    public int postaviOznaku (Tabla tabla, int i){
        if  (!tabla.polja[i].getText().equals("")){
            JOptionPane.showMessageDialog(null,"Greska, polje je zauzeto");
            return 0;
        }else {
            tabla.polja[i].setText(this._oznaka);
            return 1;
        }
    }
    
}
