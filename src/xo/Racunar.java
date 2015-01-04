/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xo;

/**
 *
 * @author Natasa
 */
public class Racunar extends Igrac {
    
    public Racunar (String oznaka){
        super (oznaka);
    }
    @Override
    
    public int postaviOznaku (Tabla tabla, int i){
        int count=0, k=0, rand;
        for (int j=1; j<=9; j++){
            if (tabla.polja[j].getText().equals("")){
                count++;
            }
        }
        int niz[]=new int [count];
        for(int j=1; j<=9; j++) {
            if (tabla.polja[j].getText().equals("")){
            niz[k]=j;
        }
        }
    rand =(int)Math.random() * count;
    tabla.polja [niz[rand]].setText(this._oznaka);
    return 1;
    }
    
}
    
