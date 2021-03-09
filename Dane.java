/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gra;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;



/**
 * Klasa pełniąca rolę kontenera na zmienne
 * @author Patrycja Guzal
 */
public class Dane {
    /**Tablica zawierająca liczby przypisane konkretnym stanom obrazków w grze( czy jest polożony na kwadracie)*/
    public static int[] zdarzenia;
    /**Tablica zawierająca współrzędne określające położenie obrazków na danym poziomie*/
    public static int[][] wspolrzedne;
    /**Tablica do któraj zapisywany jest numer obrazka położonego na danym kwadracie*/
    public static int[] kwadraty={0,0,0,0,0,0,0,0,0,0,0,0};
    /**Tablica w której zapisujemy czy dany kwadrat jest zajęty i czy obrazek podpięty jest jako kursora*/
    public static Boolean[] wolny = {true,true,true,true,true,true,true,true,true,true,true,true,true};
    /**Lista określająca które z położonych obrazków są prawidłową odpowiedzią*/
    public static ArrayList<Integer> punktyDobre = new ArrayList<Integer>();
    /**Lista określająca które z położonych obrazków są nieprawodłową odpowiedzią*/
    public static ArrayList<Integer> punktyZle = new ArrayList<Integer>();
    /**Lista słów które wyświetlają się po zakończeniu poziomu */
    public static ArrayList<String> wyniki = new ArrayList<String>();
    /**Lista kolorów zapisanych w formie RGB używanych w grze */
    public static ArrayList<Color> kolor = new ArrayList<Color>();
    /**Przypisany numer obrazka*/
    public static int i = 0;
    /**Blokowanie podpinania obeazkow jeżeli wszystkie kwadraty są zajęte*/
    public static int blokada=0;
    /**Losowana liczba */
    public static int losowa;
    /**Szerokość okna gry*/
    public static int szerokosc = 1024;
    /**Wysokość okna gry*/
    public static int wysokosc = 768;
    /**Numer aktualnego poziomu*/
    public static int nrPoziomu=0;
    
    
    /**Ciąg znaków będących ciekawostką wyświetlaną w PaneluCiekawostek*/
    public static String ciekawe="";
    /**Ciąg znaków będących spisem wyrazów wypisywanych po zakończeniu levelu*/
    public static String tekstWyn = "";
    
     /**Określa czy użyto odpowiedniego jedzenia do obiadu*/
    public static boolean zbilansowany=false;
    /**Blokuje ponowne przejście przez pętle po wykonaniu*/
    public static boolean korekta=false;
    /**Umożliwia schowanie podpowiedzi po ponownym kliknięciu przycisku*/
    public static boolean schowaj=true;
    /**Blokuje działania w grze gdy wyświetlana jest podpowiedź*/
    public static boolean zablokuj=false;
    
    /***/
    public static BufferedImage zdrowo;
    /**Blokuje ponowne przejście przez pętle po wykonaniu*/
    public static BufferedImage iNapis;
    /**Blokuje ponowne przejście przez pętle po wykonaniu*/
    public static BufferedImage wesolo;
    /**Blokuje ponowne przejście przez pętle po wykonaniu*/
    public static BufferedImage tlo;
    /**Blokuje ponowne przejście przez pętle po wykonaniu*/
    public static BufferedImage medal;
    /**Blokuje ponowne przejście przez pętle po wykonaniu*/
    public static BufferedImage jablko;
    
    /**Blokuje ponowne przejście przez pętle po wykonaniu*/
    public static BasicStroke linia = new BasicStroke(9.0f);
    /**Blokuje ponowne przejście przez pętle po wykonaniu*/
    public static BasicStroke przyciski = new BasicStroke(4.0f);
   
    /**Umożliwia powrót do kursora systemowego*/
    static Cursor GraCursor = new Cursor(Cursor.DEFAULT_CURSOR);
    /**Służy do zmiany obrazka kursora według klikniętego obrazka*/
    static Cursor Cursorzmiana = new Cursor(Cursor.DEFAULT_CURSOR);
   
    /**Czcionka wykorzystywana w etykietach przycisków w panelach gry*/
    static public Font f = new Font("Georgia", Font.BOLD, 20);
    /**Czcionka wykorzystywana w etykietach przycisków w panelach menu i ciekawostke*/
    static public Font f2 = new Font("Georgia", Font.BOLD, 40);
    /**Czcionka wykorzystywana w podpowiedziach na obu levelach gry*/            
    static public Font f3 = new Font("Georgia", Font.BOLD, 15);
}//koniec klasy Dane()

