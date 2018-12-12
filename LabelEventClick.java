
package uno;

import java.awt.Component;

import java.awt.event.ActionEvent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class LabelEventClick implements MouseListener  {

    
    
    public void actionPerformed(ActionEvent e)
	{

	}

 
    
    public void mouseClicked(MouseEvent e) {
     
     Movimientos m= new Movimientos();
     String name = ((JLabel)(e.getSource())).getName();
     m.Descartar( Util.getCarta( name),true);
    }

   
    
    public void mousePressed(MouseEvent e) {
            
    }

    public void mouseReleased(MouseEvent e) {
     
    }

    public void mouseEntered(MouseEvent e) {
       
          //Se envia a un proceso para que se ejecute en el fondo
           pThread p= new pThread();
           p.start();
           
            if (Movimientos.TurnoValido(e) )
            {
                
              String dir = Util.pathEfectos() +((JLabel)e.getSource()).getName().split("_")[0];
              ImageIcon img =new ImageIcon(dir + ".jpg");
              
              ((JLabel)e.getSource()).setIcon(img);
              
              //actualizar imagen de carta OVER
              Component c = Util.getComponent( ((JLabel)e.getSource()).getParent().getParent().getComponents() , "jPanelInfo");
              c =Util.getComponent( ((JPanel)(c)).getComponents() , "jVisor");                
              ((JLabel)c).setIcon(img);
              ((JLabel)c).setVisible(true);

            }
            else
            {
                ((JLabel)e.getSource()).setIcon(Util.ImageReversaBlock());
            }

    }
                
    public void mouseExited(MouseEvent e) {
        
     
         //actualizar imagen de carta OVER
          Component c =Util.getComponent( ((JLabel)e.getSource()).getParent().getParent().getComponents() , "jPanelInfo");
          c =Util.getComponent( ((JPanel)(c)).getComponents() , "jVisor");                
          ((JLabel)c).setIcon(null);
          ((JLabel)c).setVisible(false);    
        
         if (Movimientos.TurnoValido(e) ){
            String n = Util.pathCartas()+((JLabel)e.getSource()).getName().split("_")[0];
            
           ((JLabel)e.getSource()).setIcon(new ImageIcon(n+".jpg"));
   
        }
         else
         {
              ((JLabel)e.getSource()).setIcon(Util.ImageReversa());
         }
        
         

    }   

    
   
    
}
