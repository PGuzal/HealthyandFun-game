
package gra;




import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Okno menu gry
 * Klasa dziedzicząca po klasie Wzor
 * @author Patrycja Guzal
 */

public class Menu extends Wzor{  
    /**
     * Konstruktor klasy
     * Ustawienie parametrów przycisków i panelu
     */
    public Menu(){
        super();
        //Uzupełnienie listy kolorów
        Dane.kolor.add(0,new Color(0, 0, 0, 100));
        Dane.kolor.add(1,new Color(0, 0, 0));
        Dane.kolor.add(2,new Color(240, 255, 255, 100));
        Dane.kolor.add(3,new Color(240, 255, 255, 180));
        Dane.kolor.add(4,new Color(220, 20, 60, 180));
        Dane.kolor.add(5,new Color(128, 0, 0, 180));
        setLayout(null);//ustawienie rozkładu
        //utworzenie obiektu klasy Tlo
        Tlo panel = new Tlo();
        panel.setBounds(0, 0, Dane.szerokosc, Dane.wysokosc);//ustawienie pozycji panelu w oknie i jego wymiarów
        add(panel);//dodanie panelu do okna
        JLabel exit = new JLabel("EXIT");//utworzenie etykiety przycisku "exit"
        exit.setBounds(200,500,300, 100);//określenie położenia etykiety i jej wymiarów
        exit.setFont(Dane.f2);//okreslenie czcionki etykiety
        exit.setForeground(Color.PINK);//określenie kolory liter etykiety
        panel.add(exit);//dodanie etykiety do panelu
        JLabel start = new JLabel("START");//utworzenie etykiety przycisku "START"
        start.setBounds(180,200,300, 100);//określenie położenia etykiety i jej wymiarów
        start.setFont(Dane.f2);//okreslenie czcionki etykiety
        start.setForeground(Color.PINK);//określenie kolory liter etykiety
        panel.add(start);//dodanie etykiety do panelu
        JLabel ciekawostki = new JLabel("CIEKAWOSTKI");//utworzenie etykiety przycisku "ciekawostki"
        ciekawostki.setBounds(90,350,340, 100);//określenie położenia etykiety i jej wymiarów
        ciekawostki.setFont(Dane.f2);//okreslenie czcionki etykiety
        ciekawostki.setForeground(Color.PINK);//określenie kolory liter etykiety
        panel.add(ciekawostki);//dodanie etykiety do panelu
        repaint();//odrysowanie okna
       
        /*Obsługa zdarzeń - wciśnięcie przycisku myszy*/
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                //Gdy wybrano przycisk z etykietą "Start"
                if(me.getX()>100 && me.getX()<400 && me.getY()>200 && me.getY()<300){
                    dispose();//zamkniecie okna menu
                    new Poziom1();//utworzenie obiektu klasy Poziom1
                    Dane.nrPoziomu=1;
                } 
                //Gdy wybrano przycisk z etykietą "EXIT"
                else if(me.getX()>100 && me.getX()<400 && me.getY()>500 && me.getY()<600){
                    dispose();//zamkniecie okna menu
                }
                //Gdy wybrano przycisk z etykietą "ciekawostki"
                else if(me.getX()>80 && me.getX()<420 && me.getY()>350 && me.getY()<450){
                    Ciekawostki C= new Ciekawostki();//utworzenie obiektu klasy Ciekawostki
                    C.ciekawostki();
                    dispose();//zamkniecie okna menu
                }
            }//koniec mouseClicked()
        });
    }//koniec Menu()
}//koniec klasy Menu()

//klasa dziedzicząca po JPanel - panel Menu
class Tlo extends JPanel{
    //konstruktor klasy Tlo
    Tlo(){ 
        super();
        setLayout(null);//ustawienie rozkładu
        try//próba pobrania obrazków
        {
            Dane.tlo= ImageIO.read(new File("obrazki/tlo.png"));
            Dane.wesolo = ImageIO.read(new File("obrazki/wesolo.png"));
            Dane.iNapis = ImageIO.read(new File("obrazki/i.png"));
            Dane.zdrowo = ImageIO.read(new File("obrazki/zdrowo.png"));
        }
        catch( IOException e)
        {
            System.out.println(e);
        }
    }//koniec Tlo()
       /**
     * Metoda odpowiedzialna za odrysowanie panelu 
     * tlo i elementy rysowane gry
     * ustawienie obrazkow
     * @param g
     */
    @Override
    protected  void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//poprawienie jakości grafiki(antyaliasing)
        g2d.drawImage(Dane.tlo, 0, 0,null );//narysowanie tła
        g2d.drawImage(Dane.zdrowo,600, 200,null );//rysowanie obrazka
        g2d.drawImage(Dane.iNapis,750, 300,null );
        g2d.drawImage(Dane.wesolo,600, 400,null );
        g2d.setColor(Color.RED);//określenie koloru 
        g2d.setStroke(Dane.linia);//ustawienie parametrów linii
        g2d.drawRoundRect(100,200,300, 100,20,20);//rysowanie ramki zaokrąglonego kwadratu - przycisk
        g2d.drawRoundRect(80,350,340, 100,20,20);
        g2d.drawRoundRect(100,500,300, 100,20,20);
        g2d.setColor(Dane.kolor.get(4));
        g2d.fillRoundRect(100,200,300, 100,20,20);//rysowanie wypełnionego zaokrąglonego kwadratu - przycisk
        g2d.fillRoundRect(80,350,340, 100,20,20);
        g2d.fillRoundRect(100,500,300, 100,20,20);
    }//koniec metody PaintComponent()
}//koniec klasy Tlo

 
   
    

