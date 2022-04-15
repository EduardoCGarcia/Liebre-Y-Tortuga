/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;


import Utilerias.FondoImagen;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author EduardoCGarcia
 */
public class main {
    
    public static void main(String[] args) {
        Pista p = new Pista();
        FondoImagen fondo = new FondoImagen();
        fondo.setRuta("fondo2.jpg");
        fondo.setBounds(0, 0, p.getWidth(), p.getHeight());
        //fondo.setBackground(Color.red);
        p.add(fondo);
        p.setVisible(true);

    }
}
