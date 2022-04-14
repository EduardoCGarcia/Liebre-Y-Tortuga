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
    public synchronized void run() {
        int x=0,y,w,h;
        x = camino.getX();
        y = camino.getY();
        w = camino.getWidth();
        h = camino.getHeight();
        try {
            while (true) {
                Thread.sleep(2000);
                //this.camino.setBounds(x, y, w, h);
            }

        } catch (InterruptedException ie) {
            ie.printStackTrace();

        } finally {
            System.out.println("Hilo Demonio Terminando"); // never called
        }
    }

}
