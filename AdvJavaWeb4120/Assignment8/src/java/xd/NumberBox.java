package xd;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harsh
 */
public class NumberBox  implements Serializable{
    
    private int magicNumber;
    
     public NumberBox(){
        this.generateNumber();
    }
    
    public void generateNumber(){
    this.magicNumber = (int)(Math.random()*1000 + 1);
    }
    
    public int getMagicNumber(){
    return magicNumber;
    }
    
}
