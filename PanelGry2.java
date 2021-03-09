/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gra;

import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Patrycja
 */


class PanelPoziom2 extends JPanel
{ 
    ArrayList<BufferedImage> obraz = new ArrayList<BufferedImage>();
    PanelPoziom2()
    {
        
        super();
       
        setVisible(true);
        setLayout(null);
         try
        { 
        
         
        obraz.add(ImageIO.read(new File("obrazki/salata2.png")));
        obraz.add(ImageIO.read(new File("obrazki/salatka.png")));
        obraz.add(ImageIO.read(new File("obrazki/marchew2.png")));
        obraz.add(ImageIO.read(new File("obrazki/pomidory.png")));
        obraz.add(ImageIO.read(new File("obrazki/ziemniak.png")));
        
        obraz.add(ImageIO.read(new File("obrazki/ryba2.png")));
        obraz.add(ImageIO.read(new File("obrazki/boczek2.png")));
        obraz.add(ImageIO.read(new File("obrazki/stek2.png")));
        obraz.add(ImageIO.read(new File("obrazki/udko.png")));
        obraz.add(ImageIO.read(new File("obrazki/kielbasa2.png")));
        
        obraz.add(ImageIO.read(new File("obrazki/pizza.png")));
        obraz.add(ImageIO.read(new File("obrazki/hamburger2.png")));
        obraz.add(ImageIO.read(new File("obrazki/hotdog2.png")));
        obraz.add(ImageIO.read(new File("obrazki/frytki2.png")));
        
        obraz.add(ImageIO.read(new File("obrazki/cola.png")));
        obraz.add(ImageIO.read(new File("obrazki/sok.png")));
        obraz.add(ImageIO.read(new File("obrazki/woda.png")));
        
        obraz.add(ImageIO.read(new File("obrazki/jajo2.png")));
        obraz.add(ImageIO.read(new File("obrazki/ryz2.png")));
        obraz.add(ImageIO.read(new File("obrazki/makaron2.png")));
        
        obraz.add(ImageIO.read(new File("obrazki/kratki.jpg")));
        obraz.add(ImageIO.read(new File("obrazki/talerz.png")));
        }
        catch( IOException e)
                {
                  System.out.println(e);
                } 
    }
    @Override
    protected  void paintComponent(Graphics g)
       {
                super.paintComponent(g);
           	Graphics2D g2d = (Graphics2D)g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.drawImage(obraz.get(20), 0, 0,null );
                g2d.drawImage(obraz.get(21), 200,200,null);
                //przyciski
                g2d.setColor(Color.WHITE);
                g2d.setStroke(Dane.przyciski);
                g2d.drawRoundRect(10,20,140, 60,20,20);
                g2d.drawRoundRect(30, 100, 90, 60,20,20);
                g2d.drawRoundRect(170, 20, 140, 60,20,20);
                g2d.setColor(Dane.kolor.get(3));
                g2d.fillRoundRect(10,20,140,60,20,20);
                g2d.fillRoundRect(30,100,90,60,20,20);
                g2d.fillRoundRect(170, 20, 140, 60,20,20);
                g2d.setColor(Dane.kolor.get(0));
                g2d.fillRect(310,330,40,40);
                g2d.fillRect(550,250,40,40);
                g2d.fillRect(550,380,40,40);
                g2d.fillRect(880,330,60,60);
                g2d.drawRect(880,330,60,60);
                
                
            
                g2d.drawImage(obraz.get(0),Dane.wspolrzedne[0][0],Dane.wspolrzedne[0][1],null );
                g2d.drawImage(obraz.get(1),Dane.wspolrzedne[1][0],Dane.wspolrzedne[1][1],null );
                g2d.drawImage(obraz.get(2),Dane.wspolrzedne[2][0],Dane.wspolrzedne[2][1],null );
                g2d.drawImage(obraz.get(3),Dane.wspolrzedne[3][0],Dane.wspolrzedne[3][1],null );
                g2d.drawImage(obraz.get(4),Dane.wspolrzedne[4][0],Dane.wspolrzedne[4][1],null );
                //mieso
                g2d.drawImage(obraz.get(5),Dane.wspolrzedne[5][0],Dane.wspolrzedne[5][1],null );
                g2d.drawImage(obraz.get(6),Dane.wspolrzedne[6][0],Dane.wspolrzedne[6][1],null ); 
                g2d.drawImage(obraz.get(7),Dane.wspolrzedne[7][0],Dane.wspolrzedne[7][1],null );
                g2d.drawImage(obraz.get(8),Dane.wspolrzedne[8][0],Dane.wspolrzedne[8][1],null );
                g2d.drawImage(obraz.get(9),Dane.wspolrzedne[9][0],Dane.wspolrzedne[9][1],null );
                //niezdrowe
                g2d.drawImage(obraz.get(10),Dane.wspolrzedne[10][0],Dane.wspolrzedne[10][1],null );
                g2d.drawImage(obraz.get(11),Dane.wspolrzedne[11][0],Dane.wspolrzedne[11][1],null );
                g2d.drawImage(obraz.get(12),Dane.wspolrzedne[12][0],Dane.wspolrzedne[12][1],null );
                g2d.drawImage(obraz.get(13),Dane.wspolrzedne[13][0],Dane.wspolrzedne[13][1],null );     
                //napoje
                g2d.drawImage(obraz.get(14),Dane.wspolrzedne[14][0],Dane.wspolrzedne[14][1],null );
                g2d.drawImage(obraz.get(15),Dane.wspolrzedne[15][0],Dane.wspolrzedne[15][1],null );
                g2d.drawImage(obraz.get(16),Dane.wspolrzedne[16][0],Dane.wspolrzedne[16][1],null );
                //dodatki
                g2d.drawImage(obraz.get(17),Dane.wspolrzedne[17][0],Dane.wspolrzedne[17][1],null );
                g2d.drawImage(obraz.get(18),Dane.wspolrzedne[18][0],Dane.wspolrzedne[18][1],null );
                g2d.drawImage(obraz.get(19),Dane.wspolrzedne[19][0],Dane.wspolrzedne[19][1],null );             
       }   
    }
public class PanelGry2 extends Wzor{
   Toolkit tk = Toolkit.getDefaultToolkit();
   StatusGry SG = new StatusGry();
   JTextArea podpowiedzTekst = new  JTextArea();
   JFrame Frame;
 
 
   
 
    public PanelGry2()
  {
       super();
       Dane.zdarzenia = new int[20];
       Dane.wspolrzedne= new int[20][20];
       Dane.wspolrzedne[0][0]=500;
       Dane.wspolrzedne[0][1]=10;
       Dane.wspolrzedne[1][0]=20;
       Dane.wspolrzedne[1][1]=380;
       Dane.wspolrzedne[2][0]=650;
       Dane.wspolrzedne[2][1]=15;
       Dane.wspolrzedne[3][0]=220;
       Dane.wspolrzedne[3][1]=630;
       Dane.wspolrzedne[4][0]=340;
       Dane.wspolrzedne[4][1]=20;
       Dane.wspolrzedne[5][0]=500;
       Dane.wspolrzedne[5][1]=500;
       Dane.wspolrzedne[6][0]=560;
       Dane.wspolrzedne[6][1]=120;
       Dane.wspolrzedne[7][0]=580;
       Dane.wspolrzedne[7][1]=640;
       Dane.wspolrzedne[8][0]=90;
       Dane.wspolrzedne[8][1]=450;
       Dane.wspolrzedne[9][0]=780;
       Dane.wspolrzedne[9][1]=410;
       Dane.wspolrzedne[10][0]=800;
       Dane.wspolrzedne[10][1]=620;
       Dane.wspolrzedne[11][0]=30;
       Dane.wspolrzedne[11][1]=590;
       Dane.wspolrzedne[12][0]=250;
       Dane.wspolrzedne[12][1]=130;
       Dane.wspolrzedne[13][0]=150;
       Dane.wspolrzedne[13][1]=160;
       Dane.wspolrzedne[14][0]=860;
       Dane.wspolrzedne[14][1]=20;
       Dane.wspolrzedne[15][0]=380;
       Dane.wspolrzedne[15][1]=530;
       Dane.wspolrzedne[16][0]=45;
       Dane.wspolrzedne[16][1]=210;
       Dane.wspolrzedne[17][0]=720;
       Dane.wspolrzedne[17][1]=520;
       Dane.wspolrzedne[18][0]=900;
       Dane.wspolrzedne[18][1]=490;
       Dane.wspolrzedne[19][0]=230;
       Dane.wspolrzedne[19][1]=500;
       
     
       setLayout(null);
      
       PanelPoziom2 panel = new PanelPoziom2();
       panel.setBounds(0, 0, Dane.szerokosc, Dane.wysokosc);
       add(panel);
       JLabel exit = new JLabel("EXIT");
       JLabel podpowiedz = new JLabel("Podpowiedź");
       JLabel sprawdz = new JLabel("Sprawdź");
       JLabel zakoncz = new JLabel("i zakończ");
        exit.setBounds(48,100, 90, 60);
       exit.setFont(Dane.f);
       exit.setForeground(Dane.kolor.get(5));
       panel.add(exit);
       podpowiedz.setFont(Dane.f);
       podpowiedz.setForeground(Dane.kolor.get(5));
       podpowiedz.setBounds(15,20,140, 60);
       panel.add(podpowiedz);
       sprawdz.setFont(Dane.f);
       sprawdz.setForeground(Dane.kolor.get(5));
       sprawdz.setBounds(195,5,140, 60);
       panel.add(sprawdz);
       zakoncz.setFont(Dane.f);
       zakoncz.setForeground(Dane.kolor.get(5));
       zakoncz.setBounds(190,30,140, 60);
       panel.add(zakoncz);
       podpowiedzTekst.setText("Podstawą twojej diety jak i piramidy żywienia powinny być owoce i warzywa.\n"
                         + "Powyżej znajdować powinny się produkty zbożowe,a następnym szczeblem piramidy jest nabiał.\n"
                         + "Po nabiale w piramidzie nadchodzi czas na mięsa i ryby. Ostatni szczebel piramidy to tłuszcze\n");
       podpowiedzTekst.setBounds(150,300,750, 150);
       podpowiedzTekst.setBackground(new Color(0,0,0,0));
       podpowiedzTekst.setForeground(Color.BLACK);
       podpowiedzTekst.setFont(Dane.f3);
       podpowiedzTekst.setLineWrap(true);
       podpowiedzTekst.setWrapStyleWord(true);
       podpowiedzTekst.setEditable(false);
       podpowiedzTekst.setVisible(false);
       panel.add(podpowiedzTekst);
      
       repaint();
    

       addMouseListener(new MouseAdapter(){
            @Override
          public void mouseClicked(MouseEvent me){
         
               
               if(me.getX()>10 && me.getX()<180 && me.getY()>8 && me.getY()<70){
                  if(Dane.schowaj==true){
                podpowiedzTekst.setVisible(true);
                Dane.schowaj=false;
               }
               else
               {
                podpowiedzTekst.setVisible(false);
                Dane.schowaj=true; 
               }
                } 
               else if(me.getX()>30 && me.getX()<130 && me.getY()>100 && me.getY()<160){
                dispose();
                new PanelMenu();
                }
                else if(me.getX()>170 && me.getX()<310 && me.getY()>20 && me.getY()<80){
               if(Dane.blokada==3&&Dane.wolny[3]==false)
               {
               dispose();
               Dane.nrPoziomu=2;
               Zakonczenie zakoncz= new Zakonczenie();
               zakoncz.teksty();
               }
               else
               {
                   JOptionPane.showMessageDialog(Frame,"Musisz zapełnić wszystkie kwadraty","Uwaga",JOptionPane.WARNING_MESSAGE);
               }
               }
                else if(me.getX()>500 && me.getX()<600 && me.getY()>10 && me.getY()<118){
                 if( Dane.zdarzenia[0]==0&&Dane.blokada<3&&Dane.schowaj==true){
                 if(Dane.wolny[4] == true)
                 {
                 Dane.i=0;
                 obrazekKlik(Dane.i,panel.obraz.get(0));
                 }
                    else 
                 {
                     odklik(0);
                }
                 }
                }
                 else if(me.getX()>20 && me.getX()<120 && me.getY()>380 && me.getY()<483){
                 if( Dane.zdarzenia[1]==0&&Dane.blokada<3&&Dane.schowaj==true){ 
                  if(Dane.wolny[4] == true)
                 {  
                
                 Dane.i=1;
                  obrazekKlik(Dane.i,panel.obraz.get(1));
                 }
                    else 
                 {
                     odklik(1);
                 }
                 }
              }
                 else if(me.getX()>650 && me.getX()<850 && me.getY()>15 && me.getY()<115){
                  if( Dane.zdarzenia[2]==0&&Dane.blokada<3&&Dane.schowaj==true){
                  if(Dane.wolny[4] == true)
                 {
                 Dane.i=2;
                 obrazekKlik(Dane.i,panel.obraz.get(2));
                 }
                  
                     else 
                 {
                     odklik(2);
                  }
                  }
              }
                else if(me.getX()>245 && me.getX()<340 && me.getY()>625 && me.getY()<695){
                 if( Dane.zdarzenia[3]==0&&Dane.blokada<3&&Dane.schowaj==true){
                 if(Dane.wolny[4] == true)
                 {
                 Dane.i=3;
                   obrazekKlik(Dane.i,panel.obraz.get(3));
                 }
                   else 
                 {
                     odklik(3);
                 }
                 }
              }
                 else if(me.getX()>340 && me.getX()<460 && me.getY()>20 && me.getY()<120){
                 if( Dane.zdarzenia[4]==0&&Dane.blokada<3&&Dane.schowaj==true){
                 if(Dane.wolny[4] == true)
                 {
                 Dane.i=4;
                   obrazekKlik(Dane.i,panel.obraz.get(4));
                 }
                      else 
                 {
                     odklik(4);
                 }
                 }
              }
                  else if(me.getX()>500 && me.getX()<665 && me.getY()>500 && me.getY()<600){
                 if( Dane.zdarzenia[5]==0&&Dane.blokada<3&&Dane.schowaj==true){
                 if(Dane.wolny[4] == true)
                 {
                 Dane.i=5;
                 obrazekKlik(Dane.i,panel.obraz.get(5));
                 }
                       else 
                 {
                     odklik(5);
                 }
                 }
              }
                   else if(me.getX()>560 && me.getX()<760 && me.getY()>130 && me.getY()<195 ||me.getX()>660 && me.getX()<760 && me.getY()>130 && me.getY()<215 ){
                 if( Dane.zdarzenia[6]==0&&Dane.blokada<3&&Dane.schowaj==true){
                 if(Dane.wolny[4] ==true)
                 {
                 Dane.i=6;
                 obrazekKlik(Dane.i,panel.obraz.get(6));
                 }
                    else 
                 {
                     odklik(6);
                 }  
              }
                   }
                  else if(me.getX()>600 && me.getX()<760 && me.getY()>645 && me.getY()<710){
                 if( Dane.zdarzenia[7]==0&&Dane.blokada<3&&Dane.schowaj==true){
                 if(Dane.wolny[4] ==true)
                 { 
                 Dane.i=7;
                 obrazekKlik(Dane.i,panel.obraz.get(7));
                 }
                      else 
                 {
                     odklik(7);
                 } 
                  }
                  }
               
                  else if(me.getX()>90 && me.getX()<204 && me.getY()>490 && me.getY()<580 ||me.getX()>204 && me.getX()<254 && me.getY()>450 && me.getY()<500 ){
                 if( Dane.zdarzenia[8]==0&&Dane.blokada<3&&Dane.schowaj==true){
                 if(Dane.wolny[4] ==true)
                 {
                 Dane.i=8;
                 obrazekKlik(Dane.i,panel.obraz.get(8));
                 }
                      else 
                 {
                     odklik(8);
                 }
              }
                  }
                  else if((me.getX()>778 && me.getX()<848 && me.getY()>413 && me.getY()<488)||(me.getX()>830 && me.getX()<890 && me.getY()>470 && me.getY()<510)){
                 if( Dane.zdarzenia[9]==0&&Dane.blokada<3&&Dane.schowaj==true){
                 if(Dane.wolny[4] ==true)
                 {  
                 Dane.i=9;
                 obrazekKlik(Dane.i,panel.obraz.get(9));
                 }
                     else 
                 {
                     odklik(9);
                 }     
                  }
                  }
                  else if(me.getX()>800 && me.getX()<1000 && me.getY()>620 && me.getY()<720){
                 if( Dane.zdarzenia[10]==0&&Dane.blokada<3&&Dane.zablokuj==false){
                 if(Dane.wolny[4] ==true)
                 {  
                 Dane.i=10;
                 obrazekKlik(Dane.i,panel.obraz.get(10));
                 }
                     else 
                 {
                     odklik(10);
                 }     
                  }
                  }
                  else if(me.getX()>30 && me.getX()<151 && me.getY()>590 && me.getY()<690){
                 if( Dane.zdarzenia[11]==0&&Dane.blokada<3&&Dane.schowaj==true){
                 if(Dane.wolny[4] ==true)
                 {  
                 Dane.i=11;
                 obrazekKlik(Dane.i,panel.obraz.get(11));
                 }
                     else 
                 {
                     odklik(11);
                 }     
                  }
                  }
                  else if(me.getX()>275 && me.getX()<425 && me.getY()>140 && me.getY()<185){
                 if( Dane.zdarzenia[12]==0&&Dane.blokada<3&&Dane.schowaj==true){
                 if(Dane.wolny[4] ==true)
                 {  
                 Dane.i=12;
                 obrazekKlik(Dane.i,panel.obraz.get(12));
                 }
                     else 
                 {
                     odklik(12);
                 }     
                  }
                  }
                 else if(me.getX()>150 && me.getX()<250 && me.getY()>160 && me.getY()<276){
                 if( Dane.zdarzenia[13]==0&&Dane.blokada<3&&Dane.schowaj==true){
                 if(Dane.wolny[4] ==true)
                 {  
                 Dane.i=13;
                 obrazekKlik(Dane.i,panel.obraz.get(13));
                 }
                     else 
                 {
                     odklik(13);
                 }     
                  }
                  }
                else if(me.getX()>860 && me.getX()<960 && me.getY()>20 && me.getY()<182)
               { 
                 if( Dane.zdarzenia[14]==0&&Dane.wolny[3] ==true&&Dane.schowaj==true){
                 if(Dane.wolny[4] ==true)
                 {  
                 Dane.i=14;
                 obrazekKlik(Dane.i,panel.obraz.get(14));
                 }
                  else 
                 {
                     odklik(14);
                 } 
               }
               }
                else if(me.getX()>380 && me.getX()<480 && me.getY()>530 && me.getY()<703)
               { 
                 if( Dane.zdarzenia[15]==0&&Dane.wolny[3] ==true&&Dane.schowaj==true){
                 if(Dane.wolny[4] ==true)
                 {  
                 Dane.i=15;
                 obrazekKlik(Dane.i,panel.obraz.get(15));
                 }
                  else 
                 {
                     odklik(15);
                 } 
               }
               }
               else if(me.getX()>45 && me.getX()<125 && me.getY()>210 && me.getY()<367)
               { 
                 if( Dane.zdarzenia[16]==0&&Dane.wolny[3] ==true&&Dane.schowaj==true){
                 if(Dane.wolny[4] ==true)
                 {  
                 Dane.i=16;
                 obrazekKlik(Dane.i,panel.obraz.get(16));
                 }
                  else 
                 {
                     odklik(16);
                 } 
               }
               }
               else if(me.getX()>720 && me.getX()<837 && me.getY()>520 && me.getY()<620)
               { 
                if( Dane.zdarzenia[17]==0&&Dane.blokada<3&&Dane.schowaj==true){
                 if(Dane.wolny[4] ==true)
                 {
                 Dane.i=17;
                 obrazekKlik(Dane.i,panel.obraz.get(17));
                 }
                     else 
                 {
                     odklik(17);
                 } 
                }
               }
               else if(me.getX()>900 && me.getX()<1000 && me.getY()>490 && me.getY()<593)
               { 
                if( Dane.zdarzenia[18]==0&&Dane.blokada<3&&Dane.schowaj==true){
                 if(Dane.wolny[4] ==true)
                 {
                 Dane.i=18;
                 obrazekKlik(Dane.i,panel.obraz.get(18));
                 }
                     else 
                 {
                     odklik(18);
                 } 
                }
               }
               else if(me.getX()>230 && me.getX()<350 && me.getY()>500 && me.getY()<600)
               { 
                if( Dane.zdarzenia[19]==0&&Dane.blokada<3&&Dane.schowaj==true){
                 if(Dane.wolny[4] ==true)
                 {
                 Dane.i=19;
                 obrazekKlik(Dane.i,panel.obraz.get(19));
                 }
                     else 
                 {
                     odklik(19);
                 } 
                }
               }
              //kwadrat1
            else if (me.getX()>250 && me.getX()<450 && me.getY()>250 && me.getY()<420)
                     {
             if(me.getX()>305 && me.getX()<350 && me.getY()>325 && me.getY()<370&&Dane.wolny[0]==true&&Dane.wolny[4] == false&&(Dane.i<14||Dane.i>16)){
                                  
                  Dane.kwadraty[0]=Dane.i;
                  Dane.blokada++;//inkrementacja 
                  kwadratKlik(Dane.kwadraty[0],0);
                  Dane.wspolrzedne[Dane.kwadraty[0]][0]=me.getX()-60;
                  Dane.wspolrzedne[Dane.kwadraty[0]][1]=me.getY()-50;
                  
             }
             else{
                  if(Dane.wolny[4] == true){
                 zmiana(Dane.kwadraty[0],0);
                  }
             }
             repaint();
              }
             //kwadrat2
              else if(me.getX()>450 && me.getX()<700 && me.getY()>220 && me.getY()<320){
                if (me.getX()>545 && me.getX()<590 && me.getY()>245 && me.getY()<290&&Dane.wolny[1]==true&&Dane.wolny[4] == false&&(Dane.i<14||Dane.i>16)){    
                  Dane.kwadraty[1]=Dane.i;
                  Dane.blokada++;//inkrementacja 
                  kwadratKlik(Dane.kwadraty[1],1);
                  Dane.wspolrzedne[Dane.kwadraty[1]][0]=me.getX()-60;
                  Dane.wspolrzedne[Dane.kwadraty[1]][1]=me.getY()-50;
                  } 
                 else {
                     if(Dane.wolny[4] == true){
                      zmiana(Dane.kwadraty[1],1);
                     }
                 } 
                  repaint();
              }
               // kwadrat3
              else if(me.getX()>450 && me.getX()<700 && me.getY()>320 && me.getY()<520){
                if (me.getX()>545 && me.getX()<590 && me.getY()>380 && me.getY()<420&&Dane.wolny[2]==true&&Dane.wolny[4] == false&&(Dane.i<14||Dane.i>16)) {
                  Dane.kwadraty[2]=Dane.i;
                  Dane.blokada++;//inkrementacja 
                  kwadratKlik(Dane.kwadraty[2],2);
                  Dane.wspolrzedne[Dane.kwadraty[2]][0]=me.getX()-60;
                  Dane.wspolrzedne[Dane.kwadraty[2]][1]=me.getY()-50;
                  }  
                 else  {
                    if(Dane.wolny[4] == true){
                      zmiana(Dane.kwadraty[2],2);
                    }
                 } 
                  repaint(); 
              }
       
              else if (me.getX()>870 && me.getX()<1000 && me.getY()>230 && me.getY()<390){
                 if(me.getX()>880 && me.getX()<950 && me.getY()>330 && me.getY()<390&&Dane.wolny[3]==true&&Dane.i>=14&&Dane.i<=16)//kwadrat4
               {
                  Dane.kwadraty[3]=Dane.i;
                  kwadratKlik(Dane.kwadraty[3],3);
                  Dane.wspolrzedne[Dane.kwadraty[3]][0]=me.getX()-20;
                  Dane.wspolrzedne[Dane.kwadraty[3]][1]=me.getY()-120;
                  }
                     
                 else  {
                      zmiana(Dane.kwadraty[3],3);
                 } 
                  repaint();   
              }
          }      }); 
  }

 
    protected void odklik(int w)//funkcja umozliwiajaca zdjecie obrazka z kursora bez odkladania obrazka na kwadrat
{
    setCursor(Dane.GraCursor);
    Dane.zdarzenia[w]=0;
    Dane.wolny[4] = true;
}
    protected void kwadratKlik(int z,int w)//funkcja umozliwiajaca zmiane paramterow sygnalizujacych polozenie obrazka w danym kwadracie
{  
    Dane.zdarzenia[z]++;//zablokowanie mozliwosci klikania na obrazek i podpinania jako kursor
    setCursor(Dane.GraCursor);//powrot systemowego kursora
    Dane.wolny[w] =false;//
    Dane.wolny[4] = true;
    if(z<10||z>13)
    {
        Dane.punktyDobre.add(z);
        System.out.println(Dane.punktyDobre.indexOf(z));
    }
    else
    {
        Dane.punktyZle.add(z);
    }
}
   protected void obrazekKlik(int z, BufferedImage kursor)
   {
                 Dane.Cursorzmiana = tk.createCustomCursor(kursor, new Point(10,10), "obrazek");
                 setCursor(Dane.Cursorzmiana);
                 Dane.wolny[4] = false;
   }
    protected void zmiana(int z, int w)//funkcja umozliwiajaca powrot obrazka na pierwotne miejsce
{
    if(!Dane.punktyDobre.isEmpty()){
     System.out.println(Dane.punktyDobre.indexOf(z)+" Dobre mmmm");
    int s =Dane.punktyDobre.indexOf(z);
    Dane.punktyDobre.remove(s);
    }
    if(!Dane.punktyZle.isEmpty()){
    System.out.println(Dane.punktyZle.indexOf(z)+" Zle mmmm");
    int g =Dane.punktyZle.indexOf(z);
    Dane.punktyZle.remove(g);
}
    Dane.wolny[w]=true;
    Dane.zdarzenia[z]=0;//odblokowanie mozliwosci klikania na obrazek i podpinania jako kursor
  if(z==0)
    {
    Dane.blokada--;//odblokowanie mozliwosci uzycia kwadratu
    Dane.wspolrzedne[z][0]=500;//powrot wspolrzednej x obrazka
    Dane.wspolrzedne[z][1]=10;//powrot wspolrzednej y obrazka
    }
  else if(z==1)
    {
    Dane.blokada--;//odblokowanie mozliwosci uzycia kwadratu
    Dane.wspolrzedne[z][1]=380;
    Dane.wspolrzedne[z][0]=20;
    }
  else if(z==2)
    {
   Dane.blokada--;//odblokowanie mozliwosci uzycia kwadratu
   Dane.wspolrzedne[z][1]=15;
   Dane.wspolrzedne[z][0]=650;
    }
  else if(z==3)
    {
   Dane.blokada--;//odblokowanie mozliwosci uzycia kwadratu
   Dane.wspolrzedne[z][1]=630;
   Dane.wspolrzedne[z][0]=220;
    }
  else if(z==4)
    {
   Dane.blokada--;//odblokowanie mozliwosci uzycia kwadratu
   Dane.wspolrzedne[z][1]=20;
   Dane.wspolrzedne[z][0]=340;
    }
  else if(z==5)
    {
   Dane.blokada--;//odblokowanie mozliwosci uzycia kwadratu
   Dane.wspolrzedne[z][1]=500;
   Dane.wspolrzedne[z][0]=500;
    }
  else if(z==6)
    {
   Dane.blokada--;//odblokowanie mozliwosci uzycia kwadratu
   Dane.wspolrzedne[z][1]=120;
   Dane.wspolrzedne[z][0]=560;
    }
  else if(z==7)
  {
   Dane.blokada--;//odblokowanie mozliwosci uzycia kwadratu
   Dane.wspolrzedne[z][1]=640;
   Dane.wspolrzedne[z][0]=580;
    }
  else if(z==8)
    {
   Dane.blokada--;//odblokowanie mozliwosci uzycia kwadratu
   Dane.wspolrzedne[z][1]=450;
   Dane.wspolrzedne[z][0]=90;
    }
  else if(z==9)
    {
   Dane.blokada--;//odblokowanie mozliwosci uzycia kwadratu
   Dane.wspolrzedne[z][1]=410;
   Dane.wspolrzedne[z][0]=780;
    }
   else if(z==10)
    {
   Dane.blokada--;//odblokowanie mozliwosci uzycia kwadratu
   Dane.wspolrzedne[z][1]=620;
   Dane.wspolrzedne[z][0]=800;
    }
   else if(z==11)
    {
   Dane.blokada--;//odblokowanie mozliwosci uzycia kwadratu
   Dane.wspolrzedne[z][1]=590;
   Dane.wspolrzedne[z][0]=30;
    }
   else if(z==12)
    {
   Dane.blokada--;//odblokowanie mozliwosci uzycia kwadratu
   Dane.wspolrzedne[z][1]=130;
   Dane.wspolrzedne[z][0]=250;
    }
   else if(z==13)
    {
   Dane.blokada--;//odblokowanie mozliwosci uzycia kwadratu
   Dane.wspolrzedne[z][1]=160;
   Dane.wspolrzedne[z][0]=150;
    }
   else if(z==14)
    {
   Dane.wspolrzedne[z][1]=20;
   Dane.wspolrzedne[z][0]=860;
    }
   else if(z==15)
    {
   Dane.wspolrzedne[z][1]=530;
   Dane.wspolrzedne[z][0]=380;
    }
   else if(z==16)
    {
   Dane.wspolrzedne[z][1]=210;
   Dane.wspolrzedne[z][0]=45;
    }
   else if(z==17)
    {
   Dane.blokada--;
   Dane.wspolrzedne[z][1]=520;
   Dane.wspolrzedne[z][0]=720;
    }
   else if(z==18)
    {
   Dane.blokada--;
   Dane.wspolrzedne[z][1]=490;
   Dane.wspolrzedne[z][0]=900;
    }
   else if(z==19)
    {
   Dane.blokada--;
   Dane.wspolrzedne[z][1]=500;
   Dane.wspolrzedne[z][0]=230;
    }
} 
}
   