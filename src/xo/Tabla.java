/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xo;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Natasa
 */
public class Tabla extends JFrame implements ActionListener {
    
  
   JButton polja[] = new JButton[10];
   int tip; // 0 - igrac protiv igraca, 1 - igrac protiv racunara
   JPanel everything = new JPanel();
   JPanel playingField = new JPanel();
   JPanel start = new JPanel();
   JPanel response = new JPanel();
   JLabel labela = new JLabel();
   
   JButton button1v1 = new JButton("Igrac VS Igrac");
   JButton button1vC = new JButton("Igrac VS Racunar"); 
   JButton isprazni = new JButton("Isprazni polja");
   
   boolean novaIgra = false;
   
   public Tabla(){
        this.setTitle("XOX igra");
        this.setSize(300, 300);
        everything.setLayout(new GridLayout(3,1,2,2));
        everything.add(start);
        start.add(button1v1);
        start.add(button1vC);   
        playingField.setLayout(new GridLayout(3, 3, 2, 2));
        playingField.setBackground(Color.black);
        for(int i=1;i<=9;i++){
            polja[i] = new JButton();
            polja[i].setBackground(new Color(220, 220, 220));
            playingField.add(polja[i]);
        }
        
        response.add(labela);
        response.add(isprazni);
        this.add(everything);
        
        button1v1.addActionListener(this);
        button1vC.addActionListener(this);
        isprazni.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        this.remove(start);
        start.setVisible(false);
        everything.add(playingField);
        everything.add(response);
        if(source == button1v1){
           this.tip = 0;
        } else if (source == button1vC){
           this.tip = 1;
        } else {
            isprazni();
            this.novaIgra = true;
        }
        
    }
    
    public void isprazni() {
        for(int i=1;i<=9;i++){
            this.polja[i].setText("");
            this.polja[i].setEnabled(true);
            this.polja[i].setBackground(new Color(220, 220, 220));
            this.labela.setText("");
        }  
    }
}
