/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import Utilerias.FondoPanel;
import java.awt.Color;

/**
 *
 * @author EduardoCGarcia
 */
public class main {
    static FondoPanel fondo =  new FondoPanel();
    public static void main(String[] args) {
        Pista p = new Pista();
        p.t = new Tortuga(0,0,100,100);
        p.t.setBackground(Color.black);
        
        p.add(p.t);
        p.setVisible(true);
        
    }
}
