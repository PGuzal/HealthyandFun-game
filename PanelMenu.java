/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gra;



import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Patrycja
 */
class Tlo extends JPanel
{
 
    Tlo()
    { 
      super();
      setLayout(null);
       try
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
    }
    @Override
    protected  void paintComponent(Graphics g)
       {
                super.paintComponent(g);
           	Graphics2D g2d = (Graphics2D)g;
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.drawImage(Dane.tlo, 0, 0,null );
                g2d.drawImage(Dane.zdrowo,600, 200,null );
                g2d.drawImage(Dane.iNapis,750, 300,null );
                g2d.drawImage(Dane.wesolo,600, 400,null );
	        g2d.setColor(Color.RED);
                g2d.setStroke(Dane.linia);
                g2d.drawRoundRect(100,200,300, 100,20,20);
                g2d.drawRoundRect(80,350,340, 100,20,20);
                g2d.drawRoundRect(100,500,300, 100,20,20);
                g2d.setColor(Dane.kolor.get(4));
                g2d.fillRoundRect(100,200,300, 100,20,20);
                g2d.fillRoundRect(80,350,340, 100,20,20);
                g2d.fillRoundRect(100,500,300, 100,20,20);
	}

        
        
    }
public class PanelMenu extends Wzor{

      
 public PanelMenu()
  {
       super();
       new Dane();
       setLayout(null);
       Tlo panel = new Tlo();
       panel.setBounds(0, 0, Dane.szerokosc, Dane.wysokosc);
       add(panel);
       JLabel exit = new JLabel("EXIT");
       JLabel start = new JLabel("START");
       JLabel ciekawostki = new JLabel("CIEKAWOSTKI");
       exit.setBounds(200,500,300, 100);
       exit.setFont(Dane.f2);
       exit.setForeground(Color.PINK);
       panel.add(exit);
       start.setBounds(180,200,300, 100);
       start.setFont(Dane.f2);
       start.setForeground(Color.pink);
       panel.add(start);
       ciekawostki.setBounds(90,350,340, 100);
       ciekawostki.setFont(Dane.f2);
       ciekawostki.setForeground(Color.PINK);
       panel.add(ciekawostki);
      
       repaint();
       
         addMouseListener(new MouseAdapter(){
            @Override
          public void mouseClicked(MouseEvent me){
               if(me.getX()>100 && me.getX()<400 && me.getY()>200 && me.getY()<300){
                 dispose();
                 new PanelGry();
                 Dane.nrPoziomu=1;
                } 
               else if(me.getX()>100 && me.getX()<400 && me.getY()>500 && me.getY()<600){
                 dispose();
                }
                else if(me.getX()>80 && me.getX()<420 && me.getY()>350 && me.getY()<450){
                 PanelCiekawostki PC= new PanelCiekawostki();
                 PC.ciekawostki();
                 
                dispose();
                }
            
          }});
  }

}
       

 
   
    

