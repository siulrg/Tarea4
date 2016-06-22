/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Enrique
 */
public class Iterador implements Iterator {
    BufferedReader br;
    boolean finaliced;
    Lock lock;

    public Iterador(String path) {
        finaliced = false;
        lock=new Lock{};
        try {
        FileInputStream fstream = new FileInputStream(path);
        br = new BufferedReader(new InputStreamReader(fstream));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Iterador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean hasNext() {
        return !finaliced;
    }
    @Override
    public Object next() {

        String strLine = null;
        if (!finaliced) {
            strLine = getLineas();
            if (strLine == null) {
                finaliced = true;
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(Iterador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return strLine;
    }
    private String getLineas() {
        String line = null;
        try {

            lock.lock();
            if (!finaliced) {
                line = br.readLine();
            }
            lock.unlock();

        } catch (IOException ex) {
            Logger.getLogger(Iterador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return line;
    }

    
}
