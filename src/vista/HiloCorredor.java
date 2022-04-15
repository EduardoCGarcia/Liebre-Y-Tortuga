/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import static vista.Pista.meta;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author EduardoCGarcia
 */
public class HiloCorredor extends Thread {

    private Corredor corredor;
    private Thread thread;
    private int x, y,w,h;
    private String nombre;
    private Random rand;
    private JLabel lblnombre;
    private JPanel camino;

    public HiloCorredor() {
    }


    public HiloCorredor(Corredor corredor, int x, int y, int w, int h, String nombre, JLabel lblnombre, JPanel camino) {
        this.corredor = corredor;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.nombre = nombre;
        this.lblnombre = lblnombre;
        this.camino = camino;
    }
    
    
    
    public Corredor getTortuga() {
        return corredor;
    }

    public void setTortuga(Corredor corredor) {
        this.corredor = corredor;
    }

    @Override
    public void run() {
        rand = new Random();
        
        do {
            
            int posAntX = x;
            int a = rand.nextInt(200);
            if (x + a < 900) {
                x += a;
                this.corredor.setBounds(x, y, w, h);
                lblnombre.setText(nombre + " " + x);
                lblnombre.setBounds(x, lblnombre.getY(), lblnombre.getWidth(), lblnombre.getHeight());
                this.camino.setBounds(posAntX, y, x-posAntX, h);
                this.camino.setBorder(BorderFactory.createLineBorder(Color.black));
                
                
            } else {
                x = 900;
                this.corredor.setBounds(x, y, w, h);
                lblnombre.setBounds(x, lblnombre.getY(), lblnombre.getWidth(), lblnombre.getHeight());
                this.camino.setBounds(posAntX, y, x-posAntX, h);
                lblnombre.setText(nombre + " " + x);
                
            }
            esperarXsegundos(2);
        } while (x < 900);

        System.out.println("El hilo " + nombre + " a terminado");
        meta(nombre);

    }

    @Override
    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
    

}
