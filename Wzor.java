/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gra;

import java.awt.*;
import javax.swing.*;
/**
 * Klasa abstrakcyjna dziedzicząca po klasie JFrame
 * @author Patrycja Guzal
 */

public abstract class Wzor extends JFrame{
    /**
     * Konstruktor klasy abstrakcyjnej służącej jako wzór dla klas po nim dziedziczących.
     * Określa położenie i ustawienia początkowe okna.
     */
    public Wzor(){
            super();
            setLayout(null);//ustawienie rozkładu
            //pobieranie parametrów rozmiaru ekranu
            int szerokoscEkranu=Toolkit.getDefaultToolkit().getScreenSize().width;
            int wysokoscEkranu=Toolkit.getDefaultToolkit().getScreenSize().height;
            //obliczenia służące do wyliczenia współrzędnych narożnika okna w celu wyśrodkowania na ekranie okna gry
            int xSrodek=(szerokoscEkranu-Dane.szerokosc)/2;
            int ySrodek=(wysokoscEkranu-Dane.wysokosc)/2;
            setLocation(xSrodek,ySrodek);//ustawienie wyliczonych wspołrzędnucj xŚrodek i yŚrodek
            setSize(Dane.szerokosc,Dane.wysokosc);//ustawienie wymiaru okna gry
            setUndecorated(true);//ukrycie ramki okna
            setResizable(false);//uniemożliwienie zmiany rozmiaru okna
            setVisible(true);//pokazywanie okna
           }// koniec Wzor()
}//koniec klasy Wzor





