/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Luis Enrique
 */
public class InfoGenero {
    int cantHombres, cantMujeres, total;
    
    public InfoGenero()
    {
        cantHombres=cantMujeres=total=0;
    }
    public void contar(int cantHombres, int cantMujeres, int total)
    {
        cantHombres+=cantHombres;
        cantMujeres+=cantMujeres;
        total+=total;
    }
    public void contar2(int genero)
    {
        if(genero==2)
            cantHombres++;
        else
            cantMujeres++;
        total++;
    }
}
