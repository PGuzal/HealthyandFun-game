/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gra;


import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.text.*;

/**
 *
 * @author Patrycja
 */

class Panel extends JPanel
{
 
    Panel()
    { 
        super();
        setLayout(null);
      
    
    }
    @Override
    protected  void paintComponent(Graphics g)
       {      
                super.paintComponent(g);
           	Graphics2D g2d = (Graphics2D)g;
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.drawImage(Dane.tlo, 0, 0,null );
                g2d.setColor(Color.RED);
                g2d.setStroke(Dane.linia);
                g2d.drawRoundRect(200,70,150,120,20,20);
                g2d.drawRoundRect(500,70,300, 120,20,20);
                g2d.setColor(Dane.kolor.get(4));
                g2d.fillRoundRect(500,70,300, 120,20,20);
                g2d.fillRoundRect(200,70,150,120,20,20);  
                Rectangle obrys = new Rectangle(141,261,718,218);
                g2d.draw(obrys);
               
        
              
	}

        
        
    }
public class PanelCiekawostki extends Wzor{
    JTextPane ciekawostka = new  JTextPane();
    PanelCiekawostki()
    {
              
       super();
       
       Panel panel = new Panel();
       panel.setBounds(0, 0, Dane.szerokosc, Dane.wysokosc);
       add(panel);
       JLabel exit = new JLabel("EXIT");
       JLabel nowa = new JLabel("Nowa");
       JLabel ciekawostkaPrzycisk = new JLabel("ciekawostka");
       
       exit.setBounds(225,70,150,120);
       exit.setFont(Dane.f2);
       exit.setForeground(Color.PINK);
       panel.add(exit);
       nowa.setBounds(580,60,150,80);
       nowa.setFont(Dane.f2);
       nowa.setForeground(Color.PINK);
       panel.add(nowa);
       ciekawostkaPrzycisk.setBounds(530,120,300, 80);
       ciekawostkaPrzycisk.setFont(Dane.f2);
       ciekawostkaPrzycisk.setForeground(Color.PINK);
       panel.add(ciekawostkaPrzycisk);
       
       
       StyledDocument doc = ciekawostka.getStyledDocument(); 
SimpleAttributeSet center = new SimpleAttributeSet(); 
StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER); 
doc.setParagraphAttributes(0, doc.getLength(), center, false); 
       ciekawostka.setBounds(150,270,700,200);
       ciekawostka.setBackground(Color.RED);
       ciekawostka.setForeground(Color.PINK);
       ciekawostka.setFont(Dane.f);
       ciekawostka.setEditable(false);
       panel.add(ciekawostka);
       ciekawostka.setVisible(true);
        repaint();
       
       addMouseListener(new MouseAdapter(){
            @Override
          public void mouseClicked(MouseEvent me){
              //Czy wybrano opcję Menu w pasku dolnym
               if(me.getX()>500 && me.getX()<800 && me.getY()>70 && me.getY()<190){
                 ciekawostki();
               } 
               else if(me.getX()>200 && me.getX()<350 && me.getY()>70 && me.getY()<190){
                dispose();
                new PanelMenu();
                }
          }});

       
}
    protected  void ciekawostki(){
    Dane.ciekawe="";
    Random losowanie = new Random(); 
    Dane.losowa = losowanie.nextInt(5);
    System.out.println(Dane.losowa);
    
    switch(Dane.losowa)
    {
        case 0:{
         
            Dane.ciekawe="\n\n Większość popularnych napojów typu Kubuś zawiera średnio 5 łyżeczek cukru! Może lepiej wypić zwykłą wodę z cytyną? Może jej smak cię zaskoczy!";
            
              break;
               }
         case 1:{
               
                Dane.ciekawe="\n\n Koktajle owocowe  mogą być dobrym pomysłem na drugie śniadanie do szkoły ! Namów rodziców na to połączenie super smaku i zdrowego żywienia!";
        
                 break;
               }
             
        case 2:{
           
               Dane.ciekawe="\n\n Jajka na śniadanie - dzięki nim czujesz się bardziej najedzony, niż zjadając kromkę chleba, a również jesz mniej w ciągu następnych godzin.";
        
                 break;
               }
        case 3:{
               
               Dane.ciekawe="\n\n Nie sięgaj od razu po jedzenie, gdy burczy Ci w brzuchu. Napij się szklanki wody i po kilku minutach burczenie ustanie, a nie zjesz zbędnych kalorii.";
               
                 break;
    }
        case 4:{
             
               Dane.ciekawe="\n\n Nie kupuj w szkolnych sklepikach słodkich napojów, słodyczy, tłustych i kalorycznych przekąsek jak chipsy, drożdżówki, batoniki."
                       + " W zamian poproś rodziców o kupno zdrowych produktów jak owoce, zbożowe ciasteczka i naturalne soki z małą zawartością cukru.";
              
                 break;
       }
    }
    ciekawostka.setText(Dane.ciekawe);
    }

    }
    

