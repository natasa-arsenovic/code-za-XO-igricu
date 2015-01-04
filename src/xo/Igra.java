/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xo;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Natasa
 */

public class Igra implements ActionListener {
  private Tabla tabla;
    private Igrac igrac1, igrac2;
    int brojac;
    boolean pobeda;
    int no1, no2, no3;
    String message;
    final int kombinacije[][] = new int[][] {
    {1, 2, 3}, {1, 4, 7}, {1, 5, 9},
    {4, 5, 6}, {2, 5, 8}, {3, 5, 7},
    {7, 8, 9}, {3, 6, 9}
    };
    public Igra() {
        brojac = 1;
        tabla = new Tabla();
        tabla.setVisible(true);
        for(int i=1;i<=9;i++){
            tabla.polja[i].addActionListener(this);
        }     
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(tabla.novaIgra == true){
            brojac = 1;
            tabla.novaIgra = false;
        } 
        Object source = e.getSource();
        int ret;
        if(tabla.tip == 0){
                igrac1 = new Covek("x");
                igrac2 = new Covek("o");
                
           } else {
                igrac1 = new Covek("x");
                igrac2 = new Racunar("o");
           }
        for(int i=1;i<=9;i++){
            if(source == tabla.polja[i]){
               if(brojac%2 == 1){ 
                  ret = igrac1.postaviOznaku(tabla, i);
                   if(igrac2 instanceof Racunar){ 
                       if(brojac<9 && ret == 1 ){
                            igrac2.postaviOznaku(tabla, i);
                            brojac++;
                       }
                   }
               } else { 
                        ret = igrac2.postaviOznaku(tabla,i);
               }
               if(ret == 1)
                    brojac++;
            }  
        }   
        proveri();
    }
    
    
    public void proveri() {
        for(int i=0; i<7; i++) {
            if(!tabla.polja[kombinacije[i][0]].getText().equals("") &&
            tabla.polja[kombinacije[i][0]].getText().equals(tabla.polja[kombinacije[i][1]].getText()) &&
            tabla.polja[kombinacije[i][1]].getText().equals(tabla.polja[kombinacije[i][2]].getText())) {
                pobeda = true;
                no1 = kombinacije[i][0];
                no2 = kombinacije[i][1];
                no3 = kombinacije[i][2];
                tabla.polja[no1].setBackground(Color.white);
                tabla.polja[no2].setBackground(Color.white);
                tabla.polja[no3].setBackground(Color.white);
                break;
            }
        }
        if(pobeda || (!pobeda && brojac>9)) {
            if(pobeda) {
                if(brojac % 2 == 0)
                    message = "X je pobedio!";
                else
                    message = "O je pobedio!";
                pobeda = false;
            } else if(!pobeda && brojac>=9) {
                message = "Niko nije pobedio.";
            }
            tabla.labela.setText(message);
            //JOptionPane.showMessageDialog(null, message);
            for(int i=1; i<=9; i++) {
                tabla.polja[i].setEnabled(false);
            }
        }
    }
    
    public static void main(String[] args){
    
            new Igra();
    }

}
