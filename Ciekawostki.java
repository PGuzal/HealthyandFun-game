
package gra;


import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.text.*;


/**
 * Okno menu ciekawostek
 * Klasa dziedzicząca po klasie Wzor
 * @author Patrycja Guzal
 */

public class Ciekawostki extends Wzor{
    JTextPane ciekawostka = new  JTextPane();
     /**
     * Konstruktor klasy
     *  Ustawienie parametrów przycisków,pola tekstowego i panelu 
     */
    public Ciekawostki(){
        super();
        //utworzenie obiektu klasy Panel
        Panel panel = new Panel();
        panel.setBounds(0, 0, Dane.szerokosc, Dane.wysokosc);//ustawienie pozycji panelu w oknie i jego wymiarów
        add(panel);//dodanie panelu do okna
        JLabel exit = new JLabel("EXIT");//utworzenie etykiety przycisku "exit"
        exit.setBounds(225,70,150,120);//określenie położenia etykiety i jej wymiarów
        exit.setFont(Dane.f2);//okreslenie czcionki etykiety
        exit.setForeground(Color.PINK);//określenie kolory liter etykiety
        panel.add(exit);//dodanie etykiety do panelu
        JLabel nowa = new JLabel("Nowa");
        nowa.setBounds(580,60,150,80);
        nowa.setFont(Dane.f2);
        nowa.setForeground(Color.PINK);
        panel.add(nowa);
        JLabel ciekawostkaPrzycisk = new JLabel("ciekawostka");
        ciekawostkaPrzycisk.setBounds(530,120,300, 80);
        ciekawostkaPrzycisk.setFont(Dane.f2);
        ciekawostkaPrzycisk.setForeground(Color.PINK);
        panel.add(ciekawostkaPrzycisk);
        //wyśrodkowanie tekstu w polu tekstowym
        StyledDocument dokument = ciekawostka.getStyledDocument(); 
        SimpleAttributeSet wycentrowanie = new SimpleAttributeSet(); 
        StyleConstants.setAlignment(wycentrowanie, StyleConstants.ALIGN_CENTER); 
        dokument.setParagraphAttributes(0, dokument.getLength(),wycentrowanie, false); 
        ciekawostka.setBounds(150,270,700,200);
        ciekawostka.setBackground(Color.RED);//ustawienie koloru tła pola tekstowego
        ciekawostka.setForeground(Color.PINK);
        ciekawostka.setFont(Dane.f);
        ciekawostka.setEditable(false);//uniemożliwienie wpisywanie w pole tekstowe
        panel.add(ciekawostka);
        repaint();//odrysowanie okna
       
        /*Obsługa zdarzeń - wciśnięcie przycisku myszy*/
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                //Gdy wybrano przycisk z etykietą "Nowa ciekawostka"
                if(me.getX()>500 && me.getX()<800 && me.getY()>70 && me.getY()<190){
                    ciekawostki();
                } 
                else if(me.getX()>200 && me.getX()<350 && me.getY()>70 && me.getY()<190){
                    dispose();//zamkniecie okna ciekawostki
                    new Menu();//utworzenie obiektu klasy menu
                }
            }//koniec mouseClicked()
        });
    }//koniec Ciekawostki()
      /**
     * Metoda odpowiedzialną za wybór wyświetlanego tekstu w Polu tekstowym
     * losowanie liczby przypisanej do danego tekstu
     */
    protected  void ciekawostki(){
        Dane.ciekawe="";
        //losowanie liczby odpowiadającej ciekawostce  
        Random losowanie = new Random(); 
        Dane.losowa = losowanie.nextInt(5);
        //określenie na podstwie wylosowanej liczby która ciekawostka ma być wyświetlona
        switch(Dane.losowa){
            case 0:{
                Dane.ciekawe="\n\n Większość popularnych napojów typu Kubuś "
                + "zawiera średnio 5 łyżeczek cukru! Może lepiej wypić zwykłą wodę z cytyną?"
                + " Może jej smak cię zaskoczy!";
                break;
            }
            case 1:{   
                Dane.ciekawe="\n\n Koktajle owocowe  mogą być dobrym pomysłem na drugie śniadanie do szkoły !"
                + " Namów rodziców na to połączenie super smaku i zdrowego żywienia!";
                break;
            }  
            case 2:{
                Dane.ciekawe="\n\n Jajka na śniadanie - dzięki nim czujesz się bardziej najedzony,"
                + " niż zjadając kromkę chleba, a również jesz mniej w ciągu następnych godzin.";
                break;
            }
            case 3:{
                Dane.ciekawe="\n\n Nie sięgaj od razu po jedzenie, gdy burczy Ci w brzuchu. "
                + "Napij się szklanki wody i po kilku minutach burczenie ustanie, a nie zjesz zbędnych kalorii.";
                break;
            }
            case 4:{
                Dane.ciekawe="\n\n Nie kupuj w szkolnych sklepikach słodkich napojów, "
                + "słodyczy, tłustych i kalorycznych przekąsek jak chipsy, drożdżówki, batoniki."
                + " W zamian poproś rodziców o kupno zdrowych produktów jak owoce, zbożowe ciasteczka"
                + " i naturalne soki z małą zawartością cukru.";
                break;
            }
        }
        ciekawostka.setText(Dane.ciekawe);//dodanie wybranego tekstu do pola tekstowego
    }//koniec metody ciekawostka() 
}//koniec klasy Ciekawostki

//klasa dziedzicząca po JPanel - panel Ciekawostek
class Panel extends JPanel{
    //konstruktor klasy Panel
    Panel(){ 
        super();
        setLayout(null);//ustawienie rozkładu
    }//koniec Panel()
    @Override
    /**
    * Metoda odpowiedzialną za odrysowanie panelu 
    * tlo i elementy rysowane gry
    * ustawienie obrazkow     
    * @param g
    */
    protected  void paintComponent(Graphics g){      
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//poprawienie jakości grafiki(antyaliasing)
        g2d.drawImage(Dane.tlo, 0, 0,null );//narysowanie tła
        g2d.setColor(Color.RED);//określenie koloru 
        g2d.setStroke(Dane.linia);//ustawienie parametrów linii
        g2d.drawRoundRect(200,70,150,120,20,20);//rysowanie ramki zaokrąglonego kwadratu - przycisk
        g2d.drawRoundRect(500,70,300, 120,20,20);
        g2d.setColor(Dane.kolor.get(4));
        g2d.fillRoundRect(500,70,300, 120,20,20);//rysowanie wypełnionego zaokrąglonego kwadratu - przycisk
        g2d.fillRoundRect(200,70,150,120,20,20);  
        Rectangle obrys = new Rectangle(141,261,718,218);
        g2d.draw(obrys);//rysowanie kwadratu - ramka pola tekstowego 
    }//koniec metody paintComponent()
}//koniec klasy Panel

