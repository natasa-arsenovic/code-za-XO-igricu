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
public abstract class Igrac {
 public String _oznaka;
 public Igrac (String oznaka){
     _oznaka=oznaka;
 }
 public abstract int postaviOznaku (Tabla tabla, int i);
}
