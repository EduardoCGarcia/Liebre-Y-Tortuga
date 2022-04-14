/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import static vista.Pista.meta;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

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

    public HiloTortuga() {
    }

    public HiloTortuga(Tortuga tortuga, int x, int y, String nombre, JLabel lblnombre) {
        this.tortuga = tortuga;
        this.x = x;
        this.y = y;
        this.nombre = nombre;
        this.lblnombre = lblnombre;
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
            int a = rand.nextInt(150);
            if (x + a < 700) {
                x += a;
                this.tortuga.setBounds(x, y, 100, 100);
                lblnombre.setBounds(x, y + 100, 100, 40);
                esperarXsegundos(1);
                System.out.println(nombre);
            } else {
                x = 700;
                this.tortuga.setBounds(x, y, 100, 100);
                lblnombre.setBounds(x, y + 100, 100, 40);
                esperarXsegundos(0);
                System.out.println(nombre);
            }
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
    
    private void huellas(){
        
    }

}
