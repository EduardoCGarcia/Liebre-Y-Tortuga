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
public class HiloTortuga extends Thread {

    private Tortuga tortuga;
    private Thread thread;
    private int x, y;
    private String nombre;
    private Random rand;
    private JLabel lblnombre;
    private JPanel camino;

    public HiloTortuga() {
    }

    public HiloTortuga(Tortuga tortuga, int x, int y, String nombre, JLabel lblnombre,JPanel camino) {
        this.tortuga = tortuga;
        this.x = x;
        this.y = y;
        this.nombre = nombre;
        this.lblnombre = lblnombre;
        this.camino = camino;
    }

    public Tortuga getTortuga() {
        return tortuga;
    }

    public void setTortuga(Tortuga tortuga) {
        this.tortuga = tortuga;
    }

    @Override
    public void run() {
        rand = new Random();
        
        do {
            
            int posAntX = x;
            int a = rand.nextInt(150);
            if (x + a < 700) {
                x += a;
                this.tortuga.setBounds(x, y, 100, 100);
                lblnombre.setBounds(x, y + 100, 100, 40);
                this.camino.setBounds(posAntX, y, x-posAntX, 100);
                this.camino.setBorder(BorderFactory.createLineBorder(Color.black));
                
                System.out.println(nombre);
            } else {
                x = 700;
                this.tortuga.setBounds(x, y, 100, 100);
                lblnombre.setBounds(x, y + 100, 100, 40);
                this.camino.setBounds(posAntX, y, x-posAntX, 100);
                
                System.out.println(nombre);
            }
            esperarXsegundos(2);
        } while (x < 700);

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
