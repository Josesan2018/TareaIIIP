/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 *
 * @author DAVID
 */
public class LabelEventClickPta implements MouseListener {

    public static String FileName="";
    boolean clicked=false;
    public void mouseClicked(MouseEvent e) {
        
        if (!clicked) {
        
            String t= ((JLabel) (e.getSource())).getName();
            t =t.split("/")[0];
            FileName=t;
        
            ((JLabel) (e.getSource())).setIcon(Imagenes.FechaPartidaCliked());
             clicked=true;
        }
        else
        {
            
             clicked=false;
            FileName="";
            ((JLabel) (e.getSource())).setIcon(Imagenes.FechaPartida());
        }
    }

    public void mousePressed(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseEntered(MouseEvent e) {
        if (clicked) {return;}
        ((JLabel) (e.getSource())).setIcon(Imagenes.FechaPartidaOver());
    }

    public void mouseExited(MouseEvent e) {
        if (clicked) {return;}
        ((JLabel) (e.getSource())).setIcon(Imagenes.FechaPartida());
    }
    
}
