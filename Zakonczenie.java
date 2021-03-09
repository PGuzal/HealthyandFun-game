
package gra;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;


/**
 * Okno zakonczenia danego poziomu gry
 * Klasa dziedzicząca po klasie Wzor
 * @author Patrycja Guzal
 */   
public class Zakonczenie extends Wzor{
    JTextArea tekstWynik = new  JTextArea();
    //utworzenie obiektu klasy StatusGry
    StatusGry SG=new StatusGry();
    //utworzenie obiektu klasy PanelZakonczenieP1
    PanelZakonczenieP1 panel = new PanelZakonczenieP1();
    //utworzenie obiektu klasy Dane PanelZakonczenieP2
    PanelZakonczenieP2 panel2 = new PanelZakonczenieP2();
    JLabel menu = new JLabel("Menu");//utworzenie etykiety przycisku "Menu"
    JLabel restart = new JLabel("Restart");//utworzenie etykiety przycisku "Restart"
    JLabel poziom2 = new JLabel("Poziom 2");//utworzenie etykiety przycisku "Poziom 2"
    /**
    * Konstruktor klasy
    * Ustawienie parametrów przycisków i panelu
    */
    Zakonczenie(){
        setLayout(null);//ustawienie rozkładu
         //pobieranie parametrów rozmiaru ekranu
        int szerokoscEkranu=Toolkit.getDefaultToolkit().getScreenSize().width;
        int wysokoscEkranu=Toolkit.getDefaultToolkit().getScreenSize().height;
        //obliczenia służące do wyliczenia współrzędnych narożnika okna w celu wyśrodkowania na ekranie okna gry
        int xSrodek=(szerokoscEkranu-600)/2;
        int ySrodek=(wysokoscEkranu-500)/2;  
        setLocation(xSrodek,ySrodek);//ustawienie wyliczonych wspołrzędnucj xŚrodek i yŚrodek
        setSize(600,500);//ustawienie wymiaru okna gry
        add(panel);//dodanie panelu do okna
        panel.setBounds(0,0,600,500);//ustawienie pozycji panelu w oknie i jego wymiarów
        add(panel2);//dodanie panelu do okna
        panel2.setBounds(0,0,600,500);//ustawienie pozycji panelu w oknie i jego wymiarów
        menu.setFont(Dane.f2);//okreslenie czcionki etykiety
        menu.setForeground(Color.PINK);//określenie kolory liter etykiety
        restart.setFont(Dane.f2);
        restart.setForeground(Color.PINK);
        poziom2.setFont(Dane.f2);
        poziom2.setForeground(Color.PINK);
        tekstWynik.setBackground(new Color(0,0,0,0));//określenie koloru tła pola tekstowego
        tekstWynik.setForeground(Color.RED);//określenie koloru tekstu w polu tekstowym
        tekstWynik.setFont(Dane.f);//określenie czcionki w polu tekstowym
        tekstWynik.setLineWrap(true);//zawijanie tekstu w polu tekstowym
        tekstWynik.setWrapStyleWord(true);
        tekstWynik.setEditable(false);//uniemożliwienie wpisywania w pole tekstowe
        Poziomy();
       
        /*Obsługi zdarzeń - wciśnięcie przycisku myszy*/
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                //Gdy wybrano przycisk z etykietą "Restart"
                if(me.getX()>360 && me.getX()<540 && me.getY()>180 && me.getY()<240&&Dane.nrPoziomu==1||(me.getX()>300 && me.getX()<500 && me.getY()>400 && me.getY()<460&&Dane.nrPoziomu==2)){
                    //Jeżeli poziom pierwszy
                    if(Dane.nrPoziomu==1){
                        new Poziom1();//utworzenie obiektu klasy Poziom1
                        Dane.nrPoziomu=1;
                    }
                    //Jeżeli poziom drugi
                    else if (Dane.nrPoziomu==2){
                        new Poziom2();//utworzenie obiektu klasy Poziom2
                        Dane.nrPoziomu=2;
                    }
                    SG.reset();
                    dispose();//zamkniecie okna zakończenia
                } 
                //Gdy wybrano przycisk z etykietą "Menu"
                else if((me.getX()>360 && me.getX()<510 && me.getY()>90 && me.getY()<150&&Dane.nrPoziomu==1)||(me.getX()>300 && me.getX()<450 && me.getY()>310 && me.getY()<370&&Dane.nrPoziomu==2)){
                    SG.reset();
                    dispose();//zamkniecie okna zakończenia
                    new Menu();//utworzenie obiektu klasy Manu
                }
                //Gdy wybrano przycisk z etykietą "Poziom 2"
                else if(me.getX()>360 && me.getX()<570 && me.getY()>270 && me.getY()<330&&Dane.nrPoziomu==1&&Dane.punktyDobre.size()==12){
                    SG.reset();
                    dispose();//zamkniecie okna zakończenia
                    Dane.nrPoziomu=2;
                    new Poziom2();//utworzenie obiektu klasy Poziom2
                }
            }//koniec mouseClicked()
        });
    }//koniec Zakonczenie()
     /**
     * Metoda odpowiedzialną za wypisanie tekstu w panelu zakończenia
     */
    protected void teksty(){ 
        SG.wypiszWynik();
        //dodanie do zmiennej String wszystkich wyrazów z listy Stringów wyniki
        for(int l=0; l<Dane.wyniki.size();l++){
            if(l%2==0)
            Dane.tekstWyn+=(Dane.wyniki.get(l)+"\n");
            else
            {
            Dane.tekstWyn+=(Dane.wyniki.get(l));  
            }
        }                        
        tekstWynik.setText(Dane.tekstWyn); //dodanie tekstu do pola tekstowego
    }
     /**
     * Metoda odpowiedzialną za wyświetlenie odpowiednich elementów i odpowiedniego panelu w zależności od numeru Poziomu 
     */
    final protected void Poziomy(){ 
        //Jeżeli poziom pierwszy
        if(Dane.nrPoziomu==1){
            panel.setVisible(true);//widoczny panel
            panel2.setVisible(false);//niewidoczny panel2
            tekstWynik.setBounds(20,20,300,460);//ustawienie pozycji pola tekstowego i jego wymiarów
            menu.setBounds(380,90,150,60);//ustawienie pozycji etykiety i jej wymiarów
            restart.setBounds(370,180,200,60);//ustawienie pozycji etykiety i jej wymiarów
            panel.add(tekstWynik);//dodanie pola tekstowego do panelu
            panel.add(restart);//dodanie etykiety do panelu
            panel.add(menu);//dodanie etykiety do panelu
            //Jeżeli wszystkie odpowiedzi są dobre
            if(Dane.punktyDobre.size()==12){
                poziom2.setBounds(370,270,190,60);//ustawienie pozycji etykiety i jej wymiarów
                panel.add(poziom2);//dodanie etykiety do panelu
            }
        }
        //Jeżeli poziom drugi
        else{
            panel.setVisible(false);
            panel2.setVisible(true);
            tekstWynik.setBounds(300,20,290,270);
            menu.setBounds(310,310,150,60);
            restart.setBounds(310,400,200,60);
            panel2.add(tekstWynik);
            panel2.add(restart);
            panel2.add(menu);
        }
    }
}//koniec klasy Zakonczenie

//klasa dziedzicząca po JPanel - panel Zakończenia dla poziomu pierwszego
class PanelZakonczenieP1 extends JPanel{
    //konstruktor klasy PanelZakonczenieP2
    PanelZakonczenieP1(){
        super();
        setLayout(null);//ustawienie rozkładu
        try{ //próba pobrania obrazków
            Dane.tlo=ImageIO.read(new File("obrazki/wyniktlo.png"));
        }
        catch( IOException e){
            System.out.println(e);
        } 
    }//koniec PanelZakonczenieP2()
      /**
     * Metoda odpowiedzialną za odrysowanie panelu 
     * tlo i elementy rysowane gry
     * ustawienie obrazkow
     * @param g
     */
    @Override
    protected  void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//poprawienie jakości grafiki(antyaliasing)
        g2d.drawImage(Dane.tlo,0,0,null );//narysowanie tła
        g2d.setColor(Dane.kolor.get(4));//określenie koloru 
        g2d.setStroke(Dane.przyciski);//ustawienie parametrów linii
        g2d.fillRoundRect(360,90,150,60,20,20);//rysowanie wypełnionego zaokrąglonego kwadratu - przycisk
        g2d.fillRoundRect(360,180,180,60,20,20); 
        g2d.setColor(Color.RED);
        g2d.drawRoundRect(360,90,150,60,20,20);//rysowanie ramki zaokrąglonego kwadratu - przycisk
        g2d.drawRoundRect(360,180,180,60,20,20); 
        g2d.setStroke(Dane.linia);
        Rectangle obrys = new Rectangle(2,2,596,496);
        g2d.draw(obrys);//rysowanie kwadratu
        //Jeżeli wszystkie odpowiedzi były dobre
        if(Dane.punktyDobre.size()==12){
            g2d.setColor(Dane.kolor.get(4));
            g2d.setStroke(Dane.przyciski);
            g2d.fillRoundRect(360,270,210,60,20,20); 
            g2d.setColor(Color.RED);
            g2d.drawRoundRect(360,270,210,60,20,20);
        }          
    }//koniec PaintComponent()
}//koniec klasy PanelZakonczenieP1

//klasa dziedzicząca po JPanel - panel Zakończenia dla poziomu drugiego
class PanelZakonczenieP2 extends JPanel{
    //konstruktor klasy PanelZakonczenieP2
    PanelZakonczenieP2(){
        super();
        setLayout(null);//ustawienie rozkładu
        try{//próba pobrania obrazków
            Dane.medal=ImageIO.read(new File("obrazki/medal.png"));
            Dane.jablko=ImageIO.read(new File("obrazki/jabluszko.png"));
        }
        catch( IOException e){
            System.out.println(e);
        } 
    }//koniec PanelZakonczenieP2() 
     /**
     * Metoda odpowiedzialną za odrysowanie panelu 
     * tlo i elementy rysowane gry
     * ustawienie obrazkow
     * @param g
     */
    @Override
    protected  void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//poprawienie jakości grafiki(antyaliasing)
        g2d.drawImage(Dane.tlo,0,0,null );//narysowanie tła
        g2d.setColor(Dane.kolor.get(4));//ustwienie koloru
        g2d.setStroke(Dane.linia);//ustawienie parametrów linii
        g2d.fillRoundRect(300,310,150,60,20,20);//rysowanie ramki zaokrąglonego kwadratu - przycisk
        g2d.fillRoundRect(300,400,200,60,20,20); 
        g2d.setColor(Color.RED);
        g2d.drawRoundRect(300,310,150,60,20,20);//rysowanie wypełnionego zaokrąglonego kwadratu - przycisk
        g2d.drawRoundRect(300,400,200,60,20,20);
        Rectangle obrys = new Rectangle(5,5,590,490);
        g2d.draw(obrys);//rysowanie kwadratu
        //Jeżeli wszystkie odpowiedzi były dobre
        if(Dane.punktyDobre.size()>3){
            g2d.drawImage(Dane.medal, 30, 50,null );
            g2d.drawImage(Dane.jablko, 110,120,null );
        }
    }//koniec PaintComponent()
}//koniec klasy PanelZakonczenieP2 

