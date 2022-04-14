package Utilerias;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author EduardoCGarcia
 */
public class FondoPanel extends JPanel{
    private Image imagen;
    public void pain(Graphics g ){
        imagen = new ImageIcon(getClass().getResource("/images/tortuga.png")).getImage();
        g.drawImage(imagen, 0, 0, 100,100,this);
        setOpaque(true);
        super.paint(g);
    }
}
