
package gra;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;


/**
 * Okno gry Poziomu 1
 * Klasa dziedzicząca po klasie Wzor
 * @author Patrycja Guzal
 */

public class Poziom1 extends Wzor{
    Toolkit tk = Toolkit.getDefaultToolkit();
    JTextPane podpowiedzTekst = new  JTextPane();
    JFrame Frame;
    /**
    * Konstruktor klasy
    * Ustawienie parametrów przycisków,pola tekstowego i panelu 
    */
    public Poziom1(){
        super();
        setLayout(null);//ustawienie rozkładu
        //deklaracja tablicy ze zbiorem numerów obrazków
        Dane.zdarzenia = new int[15];
        //Uzupełnienie listy wpółrzędnych dla obrazków
        Dane.wspolrzedne= new int[15][2];
        Dane.wspolrzedne[0][0]=180;
        Dane.wspolrzedne[0][1]=320;
        Dane.wspolrzedne[1][0]=880;
        Dane.wspolrzedne[1][1]=450;
        Dane.wspolrzedne[2][0]=100;
        Dane.wspolrzedne[2][1]=550;
        Dane.wspolrzedne[3][0]=660;
        Dane.wspolrzedne[3][1]=200;
        Dane.wspolrzedne[4][0]=600;
        Dane.wspolrzedne[4][1]=90;
        Dane.wspolrzedne[5][0]=780;
        Dane.wspolrzedne[5][1]=370;
        Dane.wspolrzedne[6][0]=330;
        Dane.wspolrzedne[6][1]=200;
        Dane.wspolrzedne[7][0]=900;
        Dane.wspolrzedne[7][1]=550;
        Dane.wspolrzedne[8][0]=210;
        Dane.wspolrzedne[8][1]=190;
        Dane.wspolrzedne[9][0]=780;
        Dane.wspolrzedne[9][1]=280;
        Dane.wspolrzedne[10][0]=100;
        Dane.wspolrzedne[10][1]=450;
        Dane.wspolrzedne[11][0]=300;
        Dane.wspolrzedne[11][1]=110;
        Dane.wspolrzedne[12][0]=800;
        Dane.wspolrzedne[12][1]=180;
        Dane.wspolrzedne[13][0]=105;
        Dane.wspolrzedne[13][1]=220;
        Dane.wspolrzedne[14][0]=50;
        Dane.wspolrzedne[14][1]=340;
        //utworzenie obiektu klasy Tlo
        PanelPoziom1 panel = new PanelPoziom1();
        panel.setBounds(0, 0, Dane.szerokosc, Dane.wysokosc);//ustawienie pozycji panelu w oknie i jego wymiarów
        add(panel);//dodanie panelu do okna
        JLabel exit = new JLabel("EXIT");//utworzenie etykiety przycisku "exit"
        exit.setBounds(48,100, 90, 60);//określenie położenia etykiety i jej wymiarów
        exit.setFont(Dane.f);//okreslenie czcionki etykiety
        exit.setForeground(Dane.kolor.get(5));//określenie kolory liter etykiety
        panel.add(exit);//dodanie etykiety do panelu
        JLabel podpowiedz = new JLabel("Podpowiedź");
        podpowiedz.setBounds(18,20,130, 60);
        podpowiedz.setFont(Dane.f);
        podpowiedz.setForeground(Dane.kolor.get(5));
        panel.add(podpowiedz); 
        JLabel sprawdz = new JLabel("Sprawdź");
        sprawdz.setFont(Dane.f);
        sprawdz.setForeground(Dane.kolor.get(5));
        sprawdz.setBounds(195,5,140, 60);
        panel.add(sprawdz);
        JLabel zakoncz = new JLabel("i zakończ");
        zakoncz.setFont(Dane.f);
        zakoncz.setForeground(Dane.kolor.get(5));
        zakoncz.setBounds(190,30,140, 60);
        panel.add(zakoncz);
        podpowiedzTekst.setText("Podstawą twojej diety jak i piramidy żywienia powinny być owoce i warzywa.\n"
                         + "Powyżej znajdować powinny się produkty zbożowe,a następnym szczeblem piramidy jest nabiał.\n"
                         + "Po nabiale w piramidzie nadchodzi czas na mięsa i ryby. Ostatni szczebel piramidy to tłuszcze\n");//dodanie wybranego tekstu do pola tekstowego
        
        podpowiedzTekst.setBounds(320,10,680, 100);
        podpowiedzTekst.setBackground(new Color(0,0,0,0));
        podpowiedzTekst.setForeground(Color.BLACK);
        podpowiedzTekst.setFont(Dane.f3);
        podpowiedzTekst.setEditable(false);//uniemożliwienie wpisywanie w pole tekstowe
        podpowiedzTekst.setVisible(false);//ukrycie pola tekstowego
        panel.add(podpowiedzTekst);
        repaint();//odrysowanie okna
       
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
            //Gdy wybrano przycisk z etykietą "Podpowiedź"
                if(me.getX()>10 && me.getX()<180 && me.getY()>20 && me.getY()<80){
                    //Jeżeli przycisk został naciśnięty pierwszy raz
                    if(Dane.schowaj==true){
                        podpowiedzTekst.setVisible(true);//ukazanie pola tekstowego
                        Dane.schowaj=false;
                    }
                    //Jeżeli przycisk został naciśnięty drugi raz
                    else{
                        podpowiedzTekst.setVisible(false);//schowanie pola tekstowego
                        Dane.schowaj=true;   
                    }
                } 
                //Gdy wybrano przycisk z etykietą "Menu"
                else if(me.getX()>30 && me.getX()<130 && me.getY()>100 && me.getY()<160){
                    dispose();//zamkniecie okna Poziomu1
                    new Menu();//utworzenie obiektu klasy menu
                }
                //Gdy wybrano przycisk z etykietą "Sprawdź i zakończ"
                else if(me.getX()>170 && me.getX()<310 && me.getY()>20 && me.getY()<80){
                    //Jeżeli wszystkie kwadraty zostały uzupełnione
                   // if(Dane.blokada==12){
                        dispose();//zamkniecie okna Poziomu1
                        Dane.nrPoziomu=1;
                        Zakonczenie zakoncz= new Zakonczenie();//utworzenie obiektu klasy  Zakonczenie
                        zakoncz.teksty();//wywołanie metody teksty()
                    //}
                    //Jeżeli nie wszystkie kwadraty zostały uzupełnione
                    //else{
                      //  JOptionPane.showMessageDialog(Frame,"Musisz zapełnić wszystkie kwadraty","Uwaga",JOptionPane.WARNING_MESSAGE);//wyświetlenie wiadomości o nieuzupełnieniu wszystkich pól
                    //}
                }
                //Jeżeli kliknięto na obrazek 
                else if(me.getX()>180 && me.getX()<250 && me.getY()>320 && me.getY()<367){
                    //Jeżeli jakiś kwadrat jest pusty i obrazek nie jest już położony na jakimś kwadraci i nie jest włączona podpowiedż
                    if( Dane.zdarzenia[0]==0&&Dane.blokada<12&&Dane.schowaj==true){
                        //Jeżeli do kursora nie jest przypięty obrazek
                        if(Dane.wolny[12] == true){
                            Dane.i=0;
                            obrazekKlik(Dane.i,panel.obrazP1.get(Dane.i));
                        }
                        //Jeżeli do kursora jest przypięty obrazek
                        else{
                            odklik(0);
                        }
                    }
                }
                else if(me.getX()>880 && me.getX()<927 && me.getY()>450 && me.getY()<520){
                    if( Dane.zdarzenia[1]==0&&Dane.blokada<12&&Dane.schowaj==true){
                        if(Dane.wolny[12] == true){
                            Dane.i=1;
                            obrazekKlik(Dane.i,panel.obrazP1.get(Dane.i));
                        }
                        else{
                            odklik(1);
                        }
                    }
                }
                else if(me.getX()>100 && me.getX()<139 && me.getY()>550 && me.getY()<620){
                    if( Dane.zdarzenia[2]==0&&Dane.blokada<12&&Dane.schowaj==true){
                        if(Dane.wolny[12] == true){
                            Dane.i=2;
                            obrazekKlik(Dane.i,panel.obrazP1.get(Dane.i));
                        }
                        else{
                            odklik(2);
                        }
                    }
                }
                else if(me.getX()>660 && me.getX()<710 && me.getY()>200 && me.getY()<270){
                    if( Dane.zdarzenia[3]==0&&Dane.blokada<12&&Dane.schowaj==true){
                        if(Dane.wolny[12] == true){
                            Dane.i=3;
                            obrazekKlik(Dane.i,panel.obrazP1.get(Dane.i));
                        }
                        else{
                            odklik(3);
                        }
                    }
                }
                else if(me.getX()>600 && me.getX()<670 && me.getY()>90 && me.getY()<125){
                    if( Dane.zdarzenia[4]==0&&Dane.blokada<12&&Dane.schowaj==true){
                        if(Dane.wolny[12] == true){
                            Dane.i=4;
                            obrazekKlik(Dane.i,panel.obrazP1.get(Dane.i));
                        }
                        else{
                            odklik(4);
                        }
                    }
                }
                else if(me.getX()>780 && me.getX()<850 && me.getY()>370 && me.getY()<434){
                    if( Dane.zdarzenia[5]==0&&Dane.blokada<12&&Dane.schowaj==true){
                        if(Dane.wolny[12] == true){
                            Dane.i=5;
                            obrazekKlik(Dane.i,panel.obrazP1.get(Dane.i));
                        }
                        else{
                            odklik(5);
                        }
                    }
                }
                else if(me.getX()>330&& me.getX()<400 && me.getY()>200 && me.getY()<235){
                    if( Dane.zdarzenia[6]==0&&Dane.blokada<12&&Dane.schowaj==true){
                        if(Dane.wolny[12] == true){
                            Dane.i=6;
                            obrazekKlik(Dane.i,panel.obrazP1.get(Dane.i));
                        }
                        else{
                            odklik(6);
                        }
                    }
                }
                else if(me.getX()>900&& me.getX()<968 && me.getY()>550 && me.getY()<620){
                    if( Dane.zdarzenia[7]==0&&Dane.blokada<12&&Dane.schowaj==true){
                        if(Dane.wolny[12] == true){
                            Dane.i=7;
                            obrazekKlik(Dane.i,panel.obrazP1.get(Dane.i));
                        }
                        else{
                            odklik(7);
                        }
                    }
                }
                else if(me.getX()>210&& me.getX()<257 && me.getY()>190 && me.getY()<260){
                    if( Dane.zdarzenia[8]==0&&Dane.blokada<12&&Dane.schowaj==true){
                        if(Dane.wolny[12] == true) {
                        Dane.i=8;
                        obrazekKlik(Dane.i,panel.obrazP1.get(Dane.i));
                        }
                        else{
                            odklik(8);
                        }
                    }
                }
                else if(me.getX()>780&& me.getX()<850 && me.getY()>280 && me.getY()<330){
                    if( Dane.zdarzenia[9]==0&&Dane.blokada<12&&Dane.schowaj==true){
                        if(Dane.wolny[12] == true){
                            Dane.i=9;
                            obrazekKlik(Dane.i,panel.obrazP1.get(Dane.i));
                        }
                        else{
                            odklik(9);
                        }
                    }
                }
                else if(me.getX()>100&& me.getX()<170 && me.getY()>450 && me.getY()<500){
                    if( Dane.zdarzenia[10]==0&&Dane.blokada<12&&Dane.schowaj==true){
                        if(Dane.wolny[12] == true){
                            Dane.i=10;
                            obrazekKlik(Dane.i,panel.obrazP1.get(Dane.i));
                        }
                        else{
                            odklik(10);
                        }
                    }
                }
                else if(me.getX()>300&& me.getX()<440 && me.getY()>110 && me.getY()<150){
                    if( Dane.zdarzenia[11]==0&&Dane.blokada<12&&Dane.schowaj==true){
                        if(Dane.wolny[12] == true){
                            Dane.i=11;
                            obrazekKlik(Dane.i,panel.obrazP1.get(Dane.i));
                        }
                        else{
                            odklik(11);
                        }
                    }
                }
                else if(me.getX()>800&& me.getX()<870 && me.getY()>180 && me.getY()<238){
                    if( Dane.zdarzenia[12]==0&&Dane.blokada<12&&Dane.schowaj==true){
                        if(Dane.wolny[12] == true){
                            Dane.i=12;
                            obrazekKlik(Dane.i,panel.obrazP1.get(Dane.i));
                        }
                        else{
                            odklik(12);
                        }
                    }
                }
                else if(me.getX()>105&& me.getX()<175&& me.getY()>220 && me.getY()<301){
                    if( Dane.zdarzenia[13]==0&&Dane.blokada<12&&Dane.schowaj==true){
                        if(Dane.wolny[12] == true){
                            Dane.i=13;
                            obrazekKlik(Dane.i,panel.obrazP1.get(Dane.i));
                        }
                        else{
                            odklik(13);
                        }
                    }
                }
                else if(me.getX()>50&& me.getX()<92 && me.getY()>340 && me.getY()<410){
                    if( Dane.zdarzenia[14]==0&&Dane.blokada<12&&Dane.schowaj==true){
                        if(Dane.wolny[12] == true){
                            Dane.i=14;
                            obrazekKlik(Dane.i,panel.obrazP1.get(Dane.i));
                        }
                        else{
                            odklik(14);
                        }
                    }
                }
                //Jeżeli kliknięto na obszar wookół kwadratu
                else if(me.getX()>640 && me.getX()<710 && me.getY()>580 && me.getY()<650){
                    //Jeżeli kliknięto na kwadrat
                    if (me.getX()>660 && me.getX()<690 && me.getY()>600 && me.getY()<630&&Dane.wolny[0]==true&&Dane.wolny[12] == false) {
                        Dane.kwadraty[0]=Dane.i;
                        kwadratKlik(Dane.kwadraty[0],0,me.getX(),me.getY());
                    }  
                    else{
                        //Jeżeli obrazek nie jest przypięty do kursora
                        if(Dane.wolny[12] == true){
                            zmiana(Dane.kwadraty[0],0);
                        }
                    }
                }
                else if(me.getX()>560 && me.getX()<630 && me.getY()>630 && me.getY()<700){
                    if (me.getX()>580 && me.getX()<610 && me.getY()>650 && me.getY()<680&&Dane.wolny[1]==true&&Dane.wolny[12] == false) {
                        Dane.kwadraty[1]=Dane.i;
                        kwadratKlik(Dane.kwadraty[1],1,me.getX(),me.getY());
                    }  
                    else {
                        if(Dane.wolny[12] == true){
                            zmiana(Dane.kwadraty[1],1);
                        }
                    }
                }
                else if(me.getX()>480 && me.getX()<550 && me.getY()>580&& me.getY()<650){
                    if (me.getX()>500 && me.getX()<530 && me.getY()>600 && me.getY()<630&&Dane.wolny[2]==true&&Dane.wolny[12] == false) {
                        Dane.kwadraty[2]=Dane.i;
                        kwadratKlik(Dane.kwadraty[2],2,me.getX(),me.getY());
                    }  
                    else{
                        if(Dane.wolny[12] == true){
                            zmiana(Dane.kwadraty[2],2);
                        }     
                    }   
                }
                else if(me.getX()>280 && me.getX()<350 && me.getY()>580&& me.getY()<650){
                    if (me.getX()>300 && me.getX()<330 && me.getY()>600 && me.getY()<630&&Dane.wolny[3]==true&&Dane.wolny[12] == false) {
                        Dane.kwadraty[3]=Dane.i;
                        kwadratKlik(Dane.kwadraty[3],3,me.getX(),me.getY());
                    }  
                    else{
                        if(Dane.wolny[12] == true){
                            zmiana(Dane.kwadraty[3],3);
                        }
                    }   
                }
                else if(me.getX()>590 && me.getX()<660 && me.getY()>455&& me.getY()<525){
                    if (me.getX()>610 && me.getX()<640 && me.getY()>475 && me.getY()<505&&Dane.wolny[4]==true&&Dane.wolny[12] == false) {
                        Dane.kwadraty[4]=Dane.i;
                        kwadratKlik(Dane.kwadraty[4],4,me.getX(),me.getY());
                    }  
                    else {
                        if(Dane.wolny[12] == true){
                            zmiana(Dane.kwadraty[4],4);
                        }
                    }   
                }
                else if(me.getX()>430 && me.getX()<500 && me.getY()>510&& me.getY()<580){
                    if (me.getX()>450 && me.getX()<480 && me.getY()>530 && me.getY()<560&&Dane.wolny[5]==true&&Dane.wolny[12] == false) {
                        Dane.kwadraty[5]=Dane.i;
                        kwadratKlik(Dane.kwadraty[5],5,me.getX(),me.getY());
                    }  
                    else  {
                        if(Dane.wolny[12] == true){
                            zmiana(Dane.kwadraty[5],5);
                        }
                    }   
                }
                else if(me.getX()>580 && me.getX()<650 && me.getY()>360&& me.getY()<430){
                    if (me.getX()>600 && me.getX()<630 && me.getY()>380 && me.getY()<410&&Dane.wolny[6]==true&&Dane.wolny[12] == false) {
                        Dane.kwadraty[6]=Dane.i;
                        kwadratKlik(Dane.kwadraty[6],6,me.getX(),me.getY());
                    }  
                    else {
                        if(Dane.wolny[12] == true){
                            zmiana(Dane.kwadraty[6],6);
                        }
                    }   
                }
                else if(me.getX()>420 && me.getX()<490 && me.getY()>340&& me.getY()<410){
                    if (me.getX()>440 && me.getX()<470 && me.getY()>360 && me.getY()<390&&Dane.wolny[7]==true&&Dane.wolny[12] == false) {
                        Dane.kwadraty[7]=Dane.i;
                        kwadratKlik(Dane.kwadraty[7],7,me.getX(),me.getY());
                    }  
                    else  {
                        if(Dane.wolny[12] == true){
                            zmiana(Dane.kwadraty[7],7);
                        }
                    }   
                }
                else if(me.getX()>300 && me.getX()<370 && me.getY()>390&& me.getY()<460){
                    if (me.getX()>320 && me.getX()<350 && me.getY()>410 && me.getY()<440&&Dane.wolny[8]==true&&Dane.wolny[12] == false) {
                        Dane.kwadraty[8]=Dane.i;
                        kwadratKlik(Dane.kwadraty[8],8,me.getX(),me.getY());
                    }  
                    else  {
                        if(Dane.wolny[12] == true){
                            zmiana(Dane.kwadraty[8],8);
                        }
                    }   
                }
                else if(me.getX()>400 && me.getX()<470 && me.getY()>270&& me.getY()<340){
                    if (me.getX()>420 && me.getX()<450 && me.getY()>290 && me.getY()<320&&Dane.wolny[9]==true&&Dane.wolny[12] == false) {
                        Dane.kwadraty[9]=Dane.i;
                        kwadratKlik(Dane.kwadraty[9],9,me.getX(),me.getY());
                    }  
                    else  {
                        if(Dane.wolny[12] == true){
                            zmiana(Dane.kwadraty[9],9);
                        }
                    }   
                }
                else if(me.getX()>520 && me.getX()<590 && me.getY()>220&& me.getY()<290){
                    if (me.getX()>540 && me.getX()<570 && me.getY()>240 && me.getY()<270&&Dane.wolny[10]==true&&Dane.wolny[12] == false) {
                        Dane.kwadraty[10]=Dane.i;
                        kwadratKlik(Dane.kwadraty[10],10,me.getX(),me.getY());
                    }  
                    else  {
                        if(Dane.wolny[12] == true){
                            zmiana(Dane.kwadraty[10],10);
                        }
                    }   
                }
                else if(me.getX()>475 && me.getX()<535 && me.getY()>120&& me.getY()<190){
                    if (me.getX()>495 && me.getX()<515 && me.getY()>140 && me.getY()<170&&Dane.wolny[11]==true&&Dane.wolny[12] == false) {
                        Dane.kwadraty[11]=Dane.i;
                        kwadratKlik(Dane.kwadraty[11],11,me.getX(),me.getY());
                    }  
                    else  {
                        if(Dane.wolny[12] == true){
                            zmiana(Dane.kwadraty[11],11);
                        }
                    }   
                }   
                repaint();    
            }//koniec mouseClicked() 
        });
    }//koniec Poziom1
    /**
    * Metoda odpowiedzialna za zmiane parametrów sygnalizujacych polozenie obrazka w danym kwadracie
    * @param w
    * @param z
    * @param x
    * @param y
    */
    protected void kwadratKlik(int z,int w,int x,int y){  
        Dane.zdarzenia[z]++;//zablokowanie mozliwosci klikania na obrazek i podpinania jako kursor
        setCursor(Dane.GraCursor);//powrot systemowego kursora
        Dane.wolny[w] =false;//zablokowanie możliwości kładzenia obrazka na dany kwadrat
        Dane.wolny[12] = true;//umożliwienie podpięcia kolejnego obrazka jako kursor
        Dane.wspolrzedne[z][0]=x-20;
        Dane.wspolrzedne[z][1]=y-25;
        Dane.blokada++;
        //dodanie numeru obrazka do listy dobrych odpowiedzi
        if(w>=0&&w<=3&&z>=0&&z<=3){
            Dane.punktyDobre.add(z);
        }
        else if((w==4||w==5)&&(z==6||z==7)){
            Dane.punktyDobre.add(z);
        }
        else if(w>=6&&w<=8&&z>=8&&z<=10){
            Dane.punktyDobre.add(z);
        }
        else if((w==9||w==10)&&(z==4||z==5)){
            Dane.punktyDobre.add(z);
        }
        else if(w==11&&z==14){
            Dane.punktyDobre.add(z);
        }
        //dodanie numeru obrazka do listy złych odpowiedzi
        else{
            Dane.punktyZle.add(z);
        }
    }//koniec metody kwadratKlik()
    /**
     * Metoda odpowiedzialna za powrót systemowego kursora
     * Zmiana parametrów w celu zaznaczenia braku obrazka przy kursorze
     * @param w
     */
    protected void odklik(int w){
        setCursor(Dane.GraCursor);
        Dane.zdarzenia[w]=0;
        Dane.wolny[12] = true;
    }//koniec metody odklik
    /**
     * Metoda odpowiedzialna za zmiane kursora na kliknięty obrazek
     * @param kursor
     * @param z
     */
    protected void obrazekKlik(int z, BufferedImage kursor){
        Dane.Cursorzmiana = tk.createCustomCursor(kursor, new Point(10,10), "obrazek");
        setCursor(Dane.Cursorzmiana);
        Dane.wolny[12] = false;
    }//koniec metody obrazekKlik()
     /**
     * Metoda odpowiedzialna za powrót obrazka na jego początkową pozycję
     * Usunięcie obrazka z listy odpowiedzi
     * @param w
     * @param z
     */
    protected void zmiana(int z, int w){
        //Usuniecie danego obrazka z listy dobrych odpowiedzi
        if(!Dane.punktyDobre.isEmpty()){
            int s =Dane.punktyDobre.indexOf(z);//pobranie indeksu z listy
            Dane.punktyDobre.remove(s);//usuniecie pozycji o danym indeksie
        }
        //Usuniecie danego obrazka z listy złych odpowiedzi
        if(!Dane.punktyZle.isEmpty()){
            int g =Dane.punktyZle.indexOf(z);
            Dane.punktyZle.remove(g);
        }
        Dane.wolny[w]=true;//odblokowanie możliwości kładzenia obrazków na dany kwadrat
        Dane.zdarzenia[z]=0;//odblokowanie mozliwosci klikania na obrazek i podpinania jako kursor
        //Jeżeli numerem obrazka było 0
        if(z==0){
            Dane.blokada--;//zmiejszenie liczby używanych kwadratów
            Dane.wspolrzedne[z][0]=180;//powrot wspolrzednej x obrazka
            Dane.wspolrzedne[z][1]=320;//powrot wspolrzednej y obrazka
        }
        else if(z==1){
            Dane.blokada--;
            Dane.wspolrzedne[z][0]=880;
            Dane.wspolrzedne[z][1]=450;
        }
        else if(z==2){
            Dane.blokada--;
            Dane.wspolrzedne[z][0]=100;
            Dane.wspolrzedne[z][1]=550;
        }
        else if(z==3){
            Dane.blokada--;
            Dane.wspolrzedne[z][0]=660;
            Dane.wspolrzedne[z][1]=200;
        }
        else if(z==4){
            Dane.blokada--;
            Dane.wspolrzedne[z][0]=600;
            Dane.wspolrzedne[z][1]=90;
        }
        else if(z==5){
            Dane.blokada--;
            Dane.wspolrzedne[z][0]=780;
            Dane.wspolrzedne[z][1]=370;
        }
        else if(z==6){
            Dane.blokada--;
            Dane.wspolrzedne[z][0]=330;
            Dane.wspolrzedne[z][1]=200;
        }
        else if(z==7){
            Dane.blokada--;
            Dane.wspolrzedne[z][0]=900;
            Dane.wspolrzedne[z][1]=550;
        }
        else if(z==8){
            Dane.blokada--;
            Dane.wspolrzedne[z][0]=210;
            Dane.wspolrzedne[z][1]=190;
        }
        else if(z==9){
            Dane.blokada--;
            Dane.wspolrzedne[z][0]=780;
            Dane.wspolrzedne[z][1]=280;
        }
        else if(z==10){
            Dane.blokada--;
            Dane.wspolrzedne[z][0]=100;
            Dane.wspolrzedne[z][1]=450;
        }
        else if(z==11){
            Dane.blokada--;
            Dane.wspolrzedne[z][0]=300;
            Dane.wspolrzedne[z][1]=110;
        }
        else if(z==12){
            Dane.blokada--;
            Dane.wspolrzedne[z][0]=800;
            Dane.wspolrzedne[z][1]=180;
        }
        else if(z==13){
            Dane.blokada--;
            Dane.wspolrzedne[z][0]=105;
            Dane.wspolrzedne[z][1]=220;
        }
        else if(z==14){
            Dane.blokada--;
            Dane.wspolrzedne[z][0]=50;
            Dane.wspolrzedne[z][1]=340;
        }
    }//koniec metody zmiana()  
}//koniec klasy Poziom1  

//klasa dziedzicząca po JPanel - panel Poziomu1
class PanelPoziom1 extends JPanel{
    ArrayList<BufferedImage> obrazP1 = new ArrayList<BufferedImage>(); 
    //konstruktor klasy PanelPoziom1
    PanelPoziom1(){
        super();
        setLayout(null);//ustawienie rozkładu
        //próba pobrania obrazków
        try{   
            obrazP1.add(ImageIO.read(new File("obrazki/jablko.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/gruszka.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/kabaczek.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/papryka.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/boczek.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/kielbasa.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/chleb.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/ryz.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/mlekoczer.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/ser.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/serzolty.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/hotdog.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/hamburger.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/frytki.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/oliwa.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/paprykaostra.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/pomidor.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/winogrono.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/marchew.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/salata.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/mieso.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/stek.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/ryba.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/bulki.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/kromka.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/precel.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/zboze.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/zboze2.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/ziarnazb.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/makaron.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/jogurt.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/mlekobut.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/mlekonieb.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/jajo.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/ziarna.png")));
            obrazP1.add(ImageIO.read(new File("obrazki/kolor.png")));
        }
        catch( IOException e){
            System.out.println(e);
        }   
    }//koniec PanelPoziom1
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
        g2d.drawImage(obrazP1.get(35), 0,0,null );//narysowanie tła
        int x [] = {100, 924, 512};
        int y [] = {700, 700, 100};
        int n  = 3;
        //rysowanie trójkąta - piramidy
        Polygon piramida = new Polygon(x,y, n);
        Line2D linia1 = new Line2D.Double(184,580,840,580);
        Line2D linia2 = new Line2D.Double(266,460,758,460);
        Line2D linia3 = new Line2D.Double(350,340,674,340);
        Line2D linia4 = new Line2D.Double(432,220,591,220);
         g2d.setColor(Color.WHITE);
        g2d.setStroke(Dane.linia);
        g2d.draw(piramida);
        g2d.setColor(Dane.kolor.get(3));
        g2d.fillPolygon(x,y,n);
        g2d.setColor(Color.WHITE);
        g2d.draw(linia1);
        g2d.draw(linia2);
        g2d.draw(linia3);
        g2d.draw(linia4);
        g2d.setColor(Color.WHITE);//określenie koloru
        g2d.setStroke(Dane.przyciski);//ustawienie parametrów linii
        g2d.drawRoundRect(10,20,140, 60,20,20);//rysowanie ramki zaokrąglonego kwadratu - przycisk
        g2d.drawRoundRect(30,100, 90, 60,20,20);
        g2d.drawRoundRect(170, 20, 140, 60,20,20);
        g2d.setColor(Dane.kolor.get(3));
        g2d.fillRoundRect(10,20,140, 60,20,20);
        g2d.fillRoundRect(30,100, 90, 60,20,20);
        g2d.fillRoundRect(170, 20, 140, 60,20,20);
        g2d.setColor(Dane.kolor.get(0));
        g2d.fillRect(660,600,30,30);//rysowanie wypełnionego kwadratu - pola do położenia obrazka
        g2d.fillRect(580,650,30,30);
        g2d.fillRect(500,600,30,30);
        g2d.fillRect(300,600,30,30);
        g2d.fillRect(610,475,30,30);
        g2d.fillRect(450,530,30,30);
        g2d.fillRect(600,380,30,30);
        g2d.fillRect(440,360,30,30);
        g2d.fillRect(320,410,30,30);
        g2d.fillRect(420,290,30,30);
        g2d.fillRect(540,240,30,30);
        g2d.fillRect(495,140,30,30);
        g2d.drawImage(obrazP1.get(0),Dane.wspolrzedne[0][0],Dane.wspolrzedne[0][1],null );
        g2d.drawImage(obrazP1.get(1),Dane.wspolrzedne[1][0],Dane.wspolrzedne[1][1],null );
        g2d.drawImage(obrazP1.get(2),Dane.wspolrzedne[2][0],Dane.wspolrzedne[2][1],null );
        g2d.drawImage(obrazP1.get(3),Dane.wspolrzedne[3][0],Dane.wspolrzedne[3][1],null );
        g2d.drawImage(obrazP1.get(4),Dane.wspolrzedne[4][0],Dane.wspolrzedne[4][1],null );
        g2d.drawImage(obrazP1.get(5),Dane.wspolrzedne[5][0],Dane.wspolrzedne[5][1],null );
        g2d.drawImage(obrazP1.get(6),Dane.wspolrzedne[6][0],Dane.wspolrzedne[6][1],null );
        g2d.drawImage(obrazP1.get(7),Dane.wspolrzedne[7][0],Dane.wspolrzedne[7][1],null );
        g2d.drawImage(obrazP1.get(8),Dane.wspolrzedne[8][0],Dane.wspolrzedne[8][1],null );
        g2d.drawImage(obrazP1.get(9),Dane.wspolrzedne[9][0],Dane.wspolrzedne[9][1],null );                 
        g2d.drawImage(obrazP1.get(10),Dane.wspolrzedne[10][0],Dane.wspolrzedne[10][1],null );
        g2d.drawImage(obrazP1.get(11),Dane.wspolrzedne[11][0],Dane.wspolrzedne[11][1],null );
        g2d.drawImage(obrazP1.get(12),Dane.wspolrzedne[12][0],Dane.wspolrzedne[12][1],null );
        g2d.drawImage(obrazP1.get(13),Dane.wspolrzedne[13][0],Dane.wspolrzedne[13][1],null );
        g2d.drawImage(obrazP1.get(14),Dane.wspolrzedne[14][0],Dane.wspolrzedne[14][1],null );
        g2d.drawImage(obrazP1.get(15), 130,650,null );
        g2d.drawImage(obrazP1.get(16), 720,590,null );
        g2d.drawImage(obrazP1.get(17), 800,620,null );
        g2d.drawImage(obrazP1.get(18),300,620,null );
        g2d.drawImage(obrazP1.get(19),190,590,null );
        g2d.drawImage(obrazP1.get(20),432,230,null );
        g2d.drawImage(obrazP1.get(21),580,310,null );
        g2d.drawImage(obrazP1.get(22),500,290,null );
        g2d.drawImage(obrazP1.get(23),400,470,null );  
        g2d.drawImage(obrazP1.get(24),670,470,null );
        g2d.drawImage(obrazP1.get(25), 310,480,null );
        g2d.drawImage(obrazP1.get(26), 740,500,null );
        g2d.drawImage(obrazP1.get(27),600,540,null );
        g2d.drawImage(obrazP1.get(28),510,480,null );
        g2d.drawImage(obrazP1.get(29),210,500,null );
        g2d.drawImage(obrazP1.get(30),360,380,null );
        g2d.drawImage(obrazP1.get(31),640,380,null );
        g2d.drawImage(obrazP1.get(32),345,345,null );
        g2d.drawImage(obrazP1.get(33),490,349,null );   
        g2d.drawImage(obrazP1.get(34),475,180,null );    
    }//koniec metody PaintComponent()
}//koniec klasy PanelPoziom1