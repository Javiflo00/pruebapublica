/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheroaleatorioventana2;

import ficheroaleatorioventana2.VentanaDepart.ClaseAnidada;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JFrame;

/**
 *
 * @author Usuario
 */
public class SuperclaseDepart extends JFrame {
    
    public SuperclaseDepart() {
    }

    @Override
    public void cerrar() {
        //SE PULSA EL BOTON salir
        System.exit(0);
        //dispose();
    }

    @Override
    public void verporconsola() throws IOException {
        String nom = "";
        String loc = "";
        int dep = 0;
        long pos;
        File fichero = new File("AleatorioDep.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");
        char[] cad = new char[10];
        char aux;
        if (file.length() > 0) {
            pos = 0; //para situarnos al principio
            System.out.println(" ------------------------------------------");
            System.out.println(" - - - VISUALIZO POR CONSOLA ");
            for (;;) {
                //recorro el fichero, visualiza también las posiciones vacías
                file.seek(pos);
                dep = file.readInt(); // obtengo el dep
                for (int i = 0; i < cad.length; i++) {
                    aux = file.readChar(); //recorro uno a uno los caracteres del apellido
                    cad[i] = aux; //los voy guardando en el array
                }
                nom = new String(cad); //convierto a String el array
                for (int i = 0; i < cad.length; i++) {
                    aux = file.readChar();
                    cad[i] = aux;
                }
                loc = new String(cad); //convierto a String el array
                System.out.println("DEP: " + dep + ", Nombre: " + nom + ", Localidad: " + loc);
                pos = pos + 44;
                //Si he recorrido todos los bytes salgo del for
                if (file.getFilePointer() == file.length()) {
                    break;
                }
            } //fin bucle for
            file.close(); //cerrar fichero
            System.out.println(" ------------------------------------------");
        } else //esto sólo sale la primera vez
        {
            System.out.println(" --------- FICHERO VACIO ---------");
        }
        ClaseAnidada ej = new ClaseAnidada((VentanaDepart) this);

        ej.entrada();
        System.out.println("Llamo a salida: " + ej.salida(10));
    } // botonCerrar verporconsola

    void visualiza(int dep) {
        String nom = "";
        String loca = "";
        long pos;
        int depa;
        File fichero = new File("AleatorioDep.dat");
        try {
            RandomAccessFile file = new RandomAccessFile(fichero, "r");
            // Calculo del reg a leer
            pos = 44 * (dep - 1);
            file.seek(pos);
            depa = file.readInt();
            System.out.println("Departamento leído:" + depa);
            char[] nom1 = new char[10];
            char aux;
            char[] loc1 = new char[10];
            for (int i = 0; i < 10; i++) {
                aux = file.readChar();
                nom1[i] = aux;
            }
            for (int i = 0; i < 10; i++) {
                aux = file.readChar();
                loc1[i] = aux;
            }
            nom = new String(nom1);
            loca = new String(loc1);
            System.out.println("DEP: " + dep + ", Nombre: " + nom + ", Localidad: " + loca);
            nombre.setText(nom);
            loc.setText(loca);
            file.close();
        } catch (IOException e1) {
            System.out.println("ERROR AL LEER AleatorioDep.dat");
            e1.printStackTrace();
        }
    } // botonCerrar visualiza

    void grabar(int dep, String nom, String loc) {
        long pos;
        StringBuffer buffer = null;
        File fichero = new File("AleatorioDep.dat");
        try {
            RandomAccessFile file = new RandomAccessFile(fichero, "rw");
            // Calculo del reg a leer
            pos = 44 * (dep - 1);
            //if (file.length()==0) return false; // si está vacío
            file.seek(pos);
            file.writeInt(dep);
            buffer = new StringBuffer(nom);
            buffer.setLength(10);
            file.writeChars(buffer.toString()); //insertar nombre
            buffer = new StringBuffer(loc);
            buffer.setLength(10);
            file.writeChars(buffer.toString()); //insertar loc
            file.close();
            System.out.println(" GRABADO el " + dep);
        } catch (IOException e1) {
            System.out.println("ERROR AL grabarr AleatorioDep.dat");
            e1.printStackTrace();
        }
    } // botonCerrar grabar
    
}
