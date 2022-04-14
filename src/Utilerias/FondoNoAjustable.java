/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Gonzalo CH
 */
public class FondoNoAjustable extends JPanel {

    private Image imagen;
    private String ruta;

    @Override
    public void paint(Graphics g) {
        imagen = new ImageIcon(getClass().getResource("/imagenes/" + ruta)).getImage();
        g.drawImage(imagen, 0, 0,getWidth(),450, this);
        setOpaque(false);
        super.paint(g);
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
