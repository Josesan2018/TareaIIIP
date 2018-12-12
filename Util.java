/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;



import java.awt.Component;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public  class Util implements  Serializable{
  
    static org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(uno.UnoApp.class).getContext().getResourceMap(frmTablero.class);
    
    //serializar //
    
    public static  ArrayList<Cartas> cartas;
    public static  ArrayList<Cartas> cartasJugadas;    
    public static Jugador jugadores[];
    
    public static int Turno_Actual =0;
    public static int CartaActual=0;
    public static Cartas UltimaCarta;
    public static boolean JuegoConcluido =false;    
    public static int _cartasTotales =0;
    public static String GiroTurno ;
    public static Colores LastColor=null;
   // public static Colores T4color=null;
    public static int TurnoWithUNO=-1;
    
    //serializar  //
    
    public static final int numJugadores=1;
    public static final int numCartas=13; //11;
    public static final int countCartas=14; //12;
    public static final int maxNumCartas=9; //num de carta mas alto
    public static JPanel MainPanel=null;    
    public static JFrame Tablero =null;
    
    public static void CloseTablero()
    {
        if (Tablero!=null) {Tablero.dispose();}
    }
    
    public static void init()
    {
         cartas =new ArrayList<Cartas>();
         cartasJugadas=new  ArrayList<Cartas>();

         GenerarCartas();
        
         JuegoConcluido=false;
         GiroTurno=Movimientos.FAVOR_AGUJAS;
    }
    

    
    public static int cartasDisponibles()
    {
     return cartas.size();   
    }
    
    public static int cartasJugadas()
    {
     return cartasJugadas.size();   
    }
       
    public static int cartasTotales()
    {
     return _cartasTotales;   
    }
    
    public Util()
    {
       
        GenerarCartas();
    }
     public static void RemoverCarta(Cartas carta)
             
    {
        cartas.remove(carta);
    }
    
    public static void RemoverCarta(int i)
    {
        cartas.remove(cartas.get(i));
    }
     
    private static ArrayList<String> cNormales()
    {
    
        ArrayList<String> c = new ArrayList<String>();
        c.add("Rojo");
        c.add("Verde");
        c.add("Azul");
        c.add("Amarillo");
        c.add("AmarilloR");
        c.add("AmarilloS");
        c.add("AmarilloT");
        c.add("AzulR");
        c.add("AzulS");
        c.add("AzulT");
        c.add("RojoR");
        c.add("RojoS");
        c.add("RojoT");
        c.add("VerdeR");
        c.add("VerdeS");
        c.add("VerdeT");
        Collections.shuffle(c);
        return c;
                
    }
    
    private static ArrayList<String> cEspeciales()
    {
    
        ArrayList<String> c = new ArrayList<String>();
       
        c.add("Rojo0");
        c.add("Verde0");
        c.add("Azul0");
        c.add("Amarillo0");
        c.add("Comodin");
        c.add("Tome4");
        
        Collections.shuffle(c);
        return c;
                
    }
            
    public static void GenerarCartas()
    {
        cartas.removeAll(cartas);
        
        ArrayList<String> color =cNormales();
        Collections.shuffle(color);       
        
        for(String col : color)
        {
           int num =1;
           TipoCartas t;
           boolean cartaEspecial=true;
         
           if (col.endsWith("R")){t =TipoCartas.Reversa; }
           else if (col.endsWith("S")){t =TipoCartas.Salta; }
           else if (col.endsWith("T")){t =TipoCartas.T2; }
           else {t =TipoCartas.Normal; num = maxNumCartas; cartaEspecial=false; }

          //ciclo 1->1 o 1->9 dependiendo si es normal o especial
           for(int x=1; x<= num ; x++)
            {
                //Ciclo para generar dos cartas
                for(int j=0;j< 2;j++)
                {
                    Cartas c;
                    if (cartaEspecial){
                        //AmarilloS.jpg,Amarillo0.jpg
                        c = new Cartas( col + (col.endsWith("0")?"0":"")+  ".jpg", x, col+("_" + (j+1)),t);}
                    else{
                        //Amarrillo1.jpg
                        c = new Cartas(col + String.valueOf(x) + ".jpg", x,col +String.valueOf(x)+("_" + (j+1)),t);}
                    
                    cartas.add(c);
                }
             }
        }
        
       barajear();
         
        ArrayList<String> esp =cEspeciales();
        Collections.shuffle(esp);
        
         for(String e : esp)
            {   int num=4;
                TipoCartas t;
                
                if (e.endsWith("0")) { num =1 ; t= TipoCartas.Normal; }
                else if (e.endsWith("n")) {t= TipoCartas.Comodin; }
                else if (e.endsWith("S")) {t= TipoCartas.Salta; }
                else if (e.endsWith("4")) {t= TipoCartas.T4; }
                else {t= TipoCartas.Comodin; }
                
                for(int j=0;j< num;j++)
                {
                    Cartas c = new Cartas(e+".jpg", -1,e+("_" + (j+1)), t );
                    cartas.add(c);
                }
            }
         
        barajear();
        
         _cartasTotales =cartas.size();
         
      }
    
    public static void barajear()
    {
        Collections.shuffle(cartas);
        Collections.shuffle(cartas);
        Collections.shuffle(cartas);
        Collections.shuffle(cartas);
        
    }
    
   
    public static Cartas  getCarta(String n)
    {
     
       for (Cartas c : jugadores[Turno_Actual].cartas)
        {
            if (c.nombre.equalsIgnoreCase(n))
            {
                return c;
            }
        }
        return null;
    }
    
 
    
    public static int getTurnoDisplay()
      {
          return (Turno_Actual+1);
      }
    
     public static String getTurnoDisplay_Nombre()
      {
          return jugadores[Turno_Actual].nombre;
      }
     
    public static String getTurnoSiguiente_Nombre()
      {
          return jugadores[Movimientos.SiguienteTurno()].nombre;
      }  
      
    public static String path()
    {
        return System.getProperty("user.dir"); 
    }
    
     public static String pathSonidos()
    {
        return System.getProperty("user.dir")+ "\\sonidos\\";
    }
     
      public static String pathCartas()
    {
        return System.getProperty("user.dir")+ "\\cartas\\"; 
    }
      
    public static String pathEfectos()
    {
        return System.getProperty("user.dir")+ "\\efectos\\"; 
    }
    
       public static String pathdata()
    {
        return System.getProperty("user.dir")+ "\\data\\"; 
    }
    
            public static String pathdataJugadoresFoto()
    {
        return System.getProperty("user.dir")+ "\\data\\jugadores\\"; 
    }
            
      public static Border sgetBorder()
      {
           
          return null;//return javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("jLabel1.border.lineColor"));
          
      }
      
      public static ImageIcon ImageReversa()
      {
          return  new ImageIcon(pathEfectos()+"Reversa.jpg");
      }
      
      public static ImageIcon ImageReversaBlock()
      {
          return  new ImageIcon(pathEfectos()+"ReversaBloc.jpg");
      }
      
      public static ImageIcon ImageReversaOK()
      {
          return  new ImageIcon(pathEfectos()+"ReversaOK.jpg");
      }
      
      public static void Messaje(Object message)
      {
          JOptionPane.showMessageDialog(MainPanel, message);
      }
      
      public static void Messaje(Component Parent,Object message)
      {
          JOptionPane.showMessageDialog(Parent, message);
      }
      
    public  static String extension(String fullPath) {
    int dot = fullPath.lastIndexOf(".");
    return fullPath.substring(dot + 1);
  }
       
   public static void GenerarCartasJugadores()
   {
       int c=0;
       
       for (int i =0;  i <= Util.numCartas ;i++)
        {  
            
        Cartas card=Util.cartas.get(i);        
      
        if ( (i % 2) ==0)
        {            

            Util.jugadores[0].cartas.add(card);
           
        }
        else
        {

          Util.jugadores[1].cartas.add(card);
          
        }
               
        Util.RemoverCarta(card);
        c++;
        
       if (i== Util.maxNumCartas) 
            i=0;
        
        if (c>= Util.countCartas)
            break;
        }
   }
   
   public static void PrepararTableroJuego(JPanel JPanelJugador1,JPanel JPanelJugador2 )
   {
      //0. Init
      //1. Generar cartas jugadores
      //2. Dibujar cartas jugadores(this)
      //3. Generar primera carta
      //4. Ocultar las cartas del jugador contrario
      //5. Actualizar etiquetas de información
       
       init();                                      //0
       GenerarCartasJugadores();                    //1
       DibujarCartasJugador(JPanelJugador1,0);      //2
       DibujarCartasJugador(JPanelJugador2,1);      //2
       Movimientos.generarPrimeraCarta();           //3
       Movimientos.CambiarCartas( (JPanel) JPanelJugador1.getParent() );  //4       
       ActualizarEtiquetas();         //5
   }
   
   public static void DibujarCartasJugador(JPanel JPanelJugador, int turno)
   {
       
    JPanelJugador.removeAll();
    JPanelJugador.revalidate();
    
    ((JPanel) (JPanelJugador.getParent())).revalidate();
        
    int x =0;
    int xlow=0;
    for (int i =jugadores[turno].cartas.size() -1 ;  i >=0 ;i--)  
    {
       Cartas card=jugadores[turno].cartas.get(i);         
       JLabel label = new JLabel();
       label.setIcon(card.Image());       
       label.setBorder(new javax.swing.border.LineBorder(resourceMap.getColor("jVisor.border.lineColor"), 1, true));        
       label.addMouseListener(new LabelEventClick());
       label.setName(card.nombre );
       label.setVisible(true);       
       label.setSize(120 -xlow, 160 - xlow);

       label.setLocation(x, 0);
       x+=20;
       xlow +=2;       
       
       JPanelJugador.add(label);
       JPanelJugador.revalidate();
    }
    
    Component c;
    if (turno==Util.Turno_Actual)
    {
         c =getComponent(JPanelJugador.getParent().getComponents(), "jPanelInfo");
         c =getComponent( ((JPanel)(c)).getComponents() , "JPuntos");
         
         ((JLabel)c).setText(jugadores[turno].nombre + "  pts:"+ Util.jugadores[turno].getPuntos());
         
          
          c =getComponent(MainPanel.getComponents(),"jbUno");
    
          if (jugadores[turno].cartas.size()==1 && !jugadores[Movimientos.SiguienteTurno()].SaidUno ){
            ((JLabel) c).setVisible(true);}
          else  
          if (jugadores[Movimientos.SiguienteTurno()].CanSayUno() &&  (!jugadores[Movimientos.SiguienteTurno()].SaidUno )){
              ((JLabel) c).setVisible(true);}
          else{
              ((JLabel) c).setVisible(false);
          }
    }
        
   
    
    JPanelJugador.revalidate();
    JPanelJugador.repaint();
    
  }
   
   public static void DibujarCartasJugadorActual()
   {
    
     
     JPanel JPanelJugador=null;
    
    Component p =getComponent( MainPanel.getComponents() , "jPanel" +Util.getTurnoDisplay());
    JPanelJugador =((JPanel)(p));
    
     if (JPanelJugador==null) {return;}
     
     DibujarCartasJugador(JPanelJugador, Util.Turno_Actual);
     
   }
   
   public static void DibujarCartasJugadorSiguiente()
   {
    
     
     JPanel JPanelJugador=null;
    
    Component p =getComponent( MainPanel.getComponents() , "jPanel" + ( Movimientos.SiguienteTurno()+1));
    JPanelJugador =((JPanel)(p));
    
     if (JPanelJugador==null) {return;}
     
     DibujarCartasJugador(JPanelJugador, Movimientos.SiguienteTurno());
     
   }
   

   
   public static void ActualizarEtiquetas()
   {
    
    Component cpanel =getComponent(MainPanel.getComponents() ,"jPanelInfo");
    JPanel panel =((JPanel)cpanel);
    
    //Actualizar etiquetas de informacion
    Component c =null;
    
//    c = getComponent(panel.getComponents(), "jdisponibles");
//    ((JLabel)c).setVisible(true);
//    ((JLabel)c).setText("Cartas Disponibles:"+Util.cartasDisponibles() );
//                
//    c = getComponent(panel.getComponents(), "jcartasJugadas");
//    ((JLabel)c).setVisible(true);
//    ((JLabel)c).setText("Cartas Jugadas:"+Util.cartasJugadas());
//                
//    c = getComponent(panel.getComponents(), "JLturno");
//    ((JLabel)c).setVisible(true);
//    ((JLabel)c).setText("Turno:"+Util.getTurnoDisplay());
                
                               
//    c = getComponent(panel.getComponents(), "JLturnonombre");
//    ((JLabel)c).setVisible(true);
//    ((JLabel)c).setText("Turno:"+ Util.getTurnoDisplay_Nombre());    
//     
    String dir = Util.pathCartas()+  "Reversa.jpg";
    c= getComponent( MainPanel.getComponents() , "ListCartaDisponibles");
    ((JLabel)c).setIcon(new ImageIcon(dir));
    
    
    //mostrar la primera carta de juego
    c= getComponent( MainPanel.getComponents() , "ListCartasJugadas");
    ((JLabel)c).setIcon( Util.UltimaCarta.Image());
    
    
    
     //Cambiar cambiar fotos
    c= getComponent( MainPanel.getComponents() , "jpicture1");    
    ((JLabel)(c)).setIcon( Imagenes.getFoto(((JLabel)(c)), Util.jugadores[0].Foto ));
     
    c= getComponent( MainPanel.getComponents() , "jpicture2");         
    ((JLabel)(c)).setIcon( Imagenes.getFoto(((JLabel)(c)), Util.jugadores[1].Foto ));
    
    c= getComponent( MainPanel.getComponents() , "jJugador1");    
    ((JLabel)(c)).setText(Util.jugadores[0].nombre );
    
    c= getComponent( MainPanel.getComponents() , "jJugador2");    
    ((JLabel)(c)).setText(Util.jugadores[1].nombre );
    
   }
   
    public static Component getComponent(MouseEvent e,String Control)
    {
        for (Component c : ((JLabel)e.getSource()).getParent().getParent().getComponents() )
        {
            if (Control.equals(c.getName()))
            {
                return c;
            }
        }
        
        return null;
    }
    
    public static Component getComponent(Component comps[],String Control)
    {
        for (Component c : comps)
        {
            if (Control.equals(c.getName()))
            {
                return c;
            }
        }
        
        return null;
    }
       
  public static String padLeft(String texto,char textoreplicar, int replicar)
  {
						
    return String.format("%"+replicar+"s", texto).replace(textoreplicar, ' ');
			
  }
  
  	
public static String padRigth(String texto,char textoreplicar, int replicar)
  {
						
    return String.format("%s"+replicar, texto).replace(textoreplicar, ' ');
			
   }
		
}
