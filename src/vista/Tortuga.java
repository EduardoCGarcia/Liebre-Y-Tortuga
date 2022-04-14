/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import Utilerias.FondoImagen;


public class Tortuga extends FondoImagen{
    private int x,y,w,h;
    

    @Override
    public void setRuta(String ruta) {
        super.setRuta(ruta); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Tortuga(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.setBounds(x, y, w, h);
    }
}
