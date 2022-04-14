package vista;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author leledezma
 */
public class DaemonThread extends Thread {
    private JPanel camino;
    private int imgX;
    public DaemonThread(JPanel camino,int imgX) {
        this.camino = camino;
        this.imgX = imgX;
    }
    
    @Override
    public void run() {
        int x=0,y,w,h;
        
        y = camino.getY();
        w = camino.getWidth();
        h = camino.getHeight();
        try {
            while (true) {
                Thread.sleep(867);
                this.camino.setBounds(x, y, 0, h);
                //this.camino.setBackground(Color.yellow);
                
                //this.camino.setBounds(x, y, w, h);
            }

        } catch (InterruptedException ie) {
            ie.printStackTrace();

        } finally {
            System.out.println("Hilo Demonio Terminando"); // never called
        }
    }

}
