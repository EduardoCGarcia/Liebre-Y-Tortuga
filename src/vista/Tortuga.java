/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import Utilerias.FondoPanel;
import javax.swing.JPanel;


public class Tortuga extends JPanel{
    private int x,y,w,h;

    public Tortuga(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.setBounds(x, y, w, h);
    }
    
    
}
