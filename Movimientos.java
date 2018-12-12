/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.awt.Component;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Collections;
import javax.swing.JOptionPane;

public class Movimientos {
    
    public static  final String FAVOR_AGUJAS ="FR";
    public static  final String CONTRA_AGUJAS ="CR";
    public static boolean WAITING_UNO =false;
    public static boolean WAITING_CHANG_CARD=false;
    
    public static void generarPrimeraCarta()
    {
        boolean asignado=false;
        for (Cartas c: Util.cartas)
        {
         if (c.tc == TipoCartas.Salta  || c.tc == TipoCartas.Normal)
         {
             Util.UltimaCarta=new Cartas(c.sImagen, c.Puntos_Num, c.nombre,c.tc);
             asignado=true;
             break;
         }
         else{
             Collections.shuffle(Util.cartas);
         }
             
        }
        
        if (!asignado){
         Util.UltimaCarta= new Cartas("inicio.jpg", -1, "inicio", TipoCartas.Inicio); 
        }
    }
        
    public static boolean TurnoValido(MouseEvent e)
    {
       return ((JLabel)(e.getSource())).getParent().getName().endsWith(String.valueOf(Util.getTurnoDisplay()));
    }
    
    public static boolean TurnoValido(JLabel e)
    {
       return e.getParent().getName().endsWith(String.valueOf(Util.getTurnoDisplay()));
    }
      
    private static void  RobarCartas(int cant)
    {
          int turno=SiguienteTurno();
          
          for (int i=1;i<=cant;i++)
          {
              int index= Util.cartasDisponibles()-1 ;
              Util.jugadores[turno].cartas.add( Util.cartas.get(index));
              Util.cartas.remove(index);
          }
                  
    }
    
    public static void  CastigoRobarCartas(int cant,int turno)
    {
          for (int i=1;i<=cant;i++)
          {
              int index= Util.cartasDisponibles()-1 ;
              Util.jugadores[turno].cartas.add( Util.cartas.get(index));
              Util.cartas.remove(index);
          }
                  
   }
      
    public static int SiguienteTurno()
    {
          int t =Util.Turno_Actual+1;
          if (t>Util.numJugadores)
          {
              t=0;
          }
          return t;
          
    }
              
    public static void cambiarTurno()
    {
        if (Util.Turno_Actual==0)
            Util.Turno_Actual=1;
        else
            Util.Turno_Actual=0;
    }
    
    public static void CambiarCartas(JPanel main)
    {
        
     
     
     //volvear las cartas de los jugadores
     for (int i=0;i<=Util.numJugadores;i++)
     {
        Component co=Util.getComponent(main.getComponents(), "jPanel"+ (i+1));
        
        if (co ==null){continue;}
        
        for(Component l : ((JPanel) (co)).getComponents())
           {
             //ocultar cartas para el jugador contrario
             if ((i ==Util.Turno_Actual))
             {
                //mostrar las cartas para el Turno_Actual del jugador
                 String img = Util.pathCartas()+ ((JLabel) l).getName().split("_")[0];
                 ((JLabel) l).setIcon(new ImageIcon(img+".jpg"));
             }
             else
             {
                ((JLabel) l).setIcon(Util.ImageReversa());      
             }
                            
               }
           }
     }      
    
    public static Object[] VerificarMovimiento(Cartas card,boolean MostrarAlertas)
    {
        
        Cartas last = Util.UltimaCarta;
        Object retorno[]=new Object[5];
        retorno[0]=false;
        retorno[1]=false;
        retorno[2]=Util.Turno_Actual;
        retorno[3]=Util.getTurnoDisplay();
        retorno[4]=Util.getTurnoDisplay_Nombre();
        
        int turno =Util.Turno_Actual;
        //[0] = movimiento valido
        //[1] = hizo cambio de Turno_Actual
        //[2] = Turno_Actual             -> value  
        //[3] = Turno_Actual actual para -> display
        //[4] = jugador al que se le verifica el movimiento
       
        boolean skip=false;
        if (last.tc == TipoCartas.Comodin || last.tc ==  TipoCartas.T4)
        {
            if (Util.LastColor !=null &&  Util.LastColor == card.color )
            {
                Util.LastColor=null;
                skip=true;
            }
        }
        
        if (card.tc ==TipoCartas.T2)
        {
            //Esta carta sólo se puede descartar sobre una carta del mismo color o
           // sobre otra carta Toma dos.
            if (last.tc == card.tc || last.color == card.color || skip)
            {
              RobarCartas(2); // robar dos cartas
              cambiarTurno(); //perder Turno_Actual
              cambiarTurno(); //perder Turno_Actual
              retorno[0]=true;
              retorno[1]=true;
               
            }
            else
            {
                if (MostrarAlertas){
                Util.Messaje("Movimiento de  Carta Toma Dos invalida!!");}
                  
            }
                
        }else if (card.tc == TipoCartas.Reversa)
        {
            //Esta carta sólo se puede descartar 
           // sobre una carta del mismo color o sobre otra carta Reversa.
            if (last.tc == card.tc || last.color == card.color || skip)
            {
               Util.GiroTurno= Util.GiroTurno.equalsIgnoreCase(FAVOR_AGUJAS)?CONTRA_AGUJAS:FAVOR_AGUJAS; //cambio giro de Turno_Actual
               cambiarTurno(); //perder Turno_Actual
               cambiarTurno(); //perder Turno_Actual
               retorno[0]=true;
               retorno[1]=true;
               
            }
            else
            {
                if (MostrarAlertas){
                Util.Messaje("Movimiento de Reversa invalida!!");}
                 
            }
            
            
            
        }else if (card.tc == TipoCartas.Salta)
        {
            //Esta carta sólo se puede descartar sobre una carta del mismo color o
            //sobre otra carta Salta
            if (last.tc == card.tc || last.color == card.color || skip)
            {
               cambiarTurno(); //perder Turno_Actual
               cambiarTurno(); //perder Turno_Actual
               retorno[0]=  true;
               retorno[1]=true;
            }
            else
            {
                if (MostrarAlertas){
                 Util.Messaje("Movimiento de carta Bloqueo invalida!!");}
                 
            }
            
        }else if (card.tc ==  TipoCartas.Comodin)
        {
         
            FrmColores fc = new FrmColores(null,true);                   
            fc.setSize(412, 434);
            fc.setResizable(false);
            fc.setVisible(true);
            
            Util.LastColor =fc.colorSelecc;
            
            retorno[0]=  true;  
            retorno[1]=false;
            
            
        }
        else if (card.tc == TipoCartas.T4)
        {
            FrmColores fc = new FrmColores(null,true);
            fc.setVisible(true);
            
            
            Util.LastColor =fc.colorSelecc;
            
            //El jugador que descarte esta carta dirá el nuevo color que se jugará o
            //puede repetir el que ya estaba para descartarse
            //Desafortunadamente, esta carta sólo se puede descartar si el jugador que la tiene no tiene
            //otra carta en su mano que coincida en color con la de la pila de DESCARTE.
            //
           // if ( !(Util.jugadores[turno].tiene_color(Util.LastColor)))
           // {
                RobarCartas(4); // agregarle 4 cartas al siguiente jugador
                cambiarTurno(); // pierde Turno_Actual
                cambiarTurno(); // pierde Turno_Actual
                retorno[0]=  true;
                retorno[1]=true;
          /* }
            else
            {
                if (MostrarAlertas){
               CastigoRobarCartas(4, turno);
               Util.DibujarCartasJugadorActual();
               CambiarCartas(Util.MainPanel);
               Util.Messaje("Lanzaste la carta Toma 4 ilegalmente, haz sido castigado con 4 cartas!!");}
                
             }
           */
        }
        else if (card.tc== TipoCartas.Normal)
        {
           if (card.Puntos_Num == last.Puntos_Num  || card.color == last.color || skip)
           {
               
              retorno[0]=  true;
              retorno[1]=false;
              // retorna true y deja que el codigo de LabelEventClick haga su trabajo normalmente
              
           }
           else
           {
               if (MostrarAlertas){
               Util.Messaje("Movimiento de carta normal invalido!!");}
               
           }
        }
     
        //verificar si es la ultima carta y si es T2 o T4        
        if (Util.jugadores[turno].cartas.isEmpty() && ( card.tc ==TipoCartas.T2 || card.tc ==TipoCartas.T4) )
        {
            int n= (card.tc==TipoCartas.T4 ? 4 : 2);
            
            RobarCartas( n );
            Util.DibujarCartasJugadorActual();
            Util.DibujarCartasJugadorSiguiente();
            CambiarCartas(Util.MainPanel);
            Util.Messaje(Util.getTurnoSiguiente_Nombre() +" ha sido castigado con" + n +" cartas");
        }
        
        return retorno;
    }
    
    public static void UNO()
    {
     
            Util.jugadores[Util.Turno_Actual].SaidUno=true;
            Util.TurnoWithUNO=Util.Turno_Actual;
            Util.Messaje("DESAFIO!!");
//            FrmUno f=new FrmUno();
//            f.setVisible(true);
//            f.Cerrar();
            if (Util.jugadores[Movimientos.SiguienteTurno()].CanSayUno() && (!Util.jugadores[Movimientos.SiguienteTurno()].SaidUno ))
            {
                    Movimientos.CastigoRobarCartas(2, Movimientos.SiguienteTurno());
                    Util.DibujarCartasJugadorActual();
                    Util.DibujarCartasJugadorSiguiente();
                    Movimientos.CambiarCartas(Util.MainPanel);
                    Util.TurnoWithUNO=-1;
                    Component c =Util.getComponent(Util.MainPanel.getComponents(),"jbUno");
                    ((JLabel) c).setVisible(false);
                    Util.jugadores[0].SaidUno=false;
                    Util.jugadores[1].SaidUno=false;
                    
                    Util.Messaje("RETO GANADO " +Util.getTurnoSiguiente_Nombre() + " NO TE HA DESAFIADO,POR LO TANTO SIDO CASTIGADO CON DOS CARTAS");   
                    
            }
            
            Component c =Util.getComponent(Util.MainPanel.getComponents(),"jbUno");
            ((JLabel) c).setVisible(false);
            
     
    }
    
    public static int getPuntosContrarios(int TurnoGanador){
        int pts=0;
        
        for (int i=0;i<= Util.numJugadores;i++)
        {
            if (i==TurnoGanador) {continue;}
            
            for(Cartas c :Util.jugadores[i].cartas)
            {
                pts+=c.Puntos_Num;
            }
        }
        
        return pts;
    }
    

    
    public boolean Descartar(Cartas card,boolean mostrarAlertas)
    {
      try{
        
        if (Util.JuegoConcluido)
        {return false;}
         
        if (WAITING_UNO)
        {return false;}
        
        if (WAITING_CHANG_CARD)
        {return false;}
        
        //if (!Movimientos.TurnoValido(label) ){return;}
        
        //Obtener el JLabel que representa el conjunto de cartas jugadas            
        Component c =Util.getComponent(Util.MainPanel.getComponents() , "ListCartasJugadas");        
        if (c==null){return false;}
        
        if (card ==null)
        {                   
          JOptionPane.showMessageDialog(null, "Carta invalida - " );
          return false;
        }
                
                Object retornos[] = VerificarMovimiento(card,mostrarAlertas);
                
                String movimientoValido = retornos[0].toString().toLowerCase();
                
                if (! (movimientoValido .equals("true")))
                {
                 //   Util.Messaje("Movimiento invalido!");
                   return false;
                }
                
                
                //actualizar imagen de carta OVER
                Component cCarta = Util.getComponent(Util.MainPanel.getComponents(),"jPanelInfo");
                cCarta =Util.getComponent( ((JPanel)(cCarta)).getComponents() , "jVisor");                
                ((JLabel)cCarta).setIcon(null);
                ((JLabel)cCarta).setVisible(false); 

                
                String Cambioturno =retornos[1].toString().toLowerCase() ;
                int turno = Integer.valueOf( retornos[2].toString()) ;
                int turno_ejecutadoDisplay =Integer.valueOf( retornos[3].toString()) ;                
                String turno_ejecutanoNombreDisplay = retornos[4].toString();
                
                
               
                
                //Agregar la nueva carta a cartas jugadas
                Util.cartasJugadas.add(card);
                
                //Quitarle la carta jugador de Turno_Actual actual
                Util.jugadores[turno].cartas.remove(card);  
                
                //Sumarle los puntos al jugador que esta descartando
                Util.jugadores[ turno].AddPuntos(card.Puntos_Num);
                
                //Cambiar la imagen de la cartas jugadas por la imagen de la carta seleccinada
                ((JLabel)c).setIcon(card.Image());
                
                int count =Util.jugadores[turno].cartas.size();
                
                int puntos =Util.jugadores[turno].getPuntos();
                Util.UltimaCarta = card;
                
               
                //actualizar Color elegido por T4, Comodin                 
                Component myc =Util.getComponent( Util.MainPanel.getComponents() , "JColorSeleccionado");                
                ((JLabel)myc).setIcon(null);
                ((JLabel)myc).setVisible(false); 
                  
                if (Util.UltimaCarta.tc ==  TipoCartas.T4 || Util.UltimaCarta.tc == TipoCartas.Comodin )
                {
                  ImageIcon img =null;
                  if (Util.LastColor == Colores.Amarillo) { img  =Imagenes.ColorTriangAmarillo();}
                  if (Util.LastColor == Colores.Azul) { img  =Imagenes.ColorTriangAzul();}
                  if (Util.LastColor == Colores.Rojo) { img  =Imagenes.ColorTriangRojo();}
                  if (Util.LastColor == Colores.Verde) { img  =Imagenes.ColorTriangVerde();}
                  
                  ((JLabel)myc).setIcon(img);
                  ((JLabel)myc).setVisible(true); 
                     

                }
                
                if (count <=0)
                {
                    
                    Component b = Util.getComponent(Util.MainPanel.getComponents(), "jbUno");
                    ((JLabel) b).setVisible(false);
                    
                    int ptsOpo= getPuntosContrarios(turno);
                    Util.jugadores[turno].AddPuntos(ptsOpo + 3);
                    Util.jugadores[SiguienteTurno()].resetPuntos();
                    Util.jugadores[SiguienteTurno()].puntos=0;
                    //ControlUsuarios.GuardarPuntosDeJugadores(turno);
                    ControlUsuarios.GuardarPuntosDeJugadores();
                    
                    String txt =turno_ejecutanoNombreDisplay +" le gano en UNO! a " + Util.getTurnoSiguiente_Nombre() +" con " + puntos;
                    txt +=turno_ejecutanoNombreDisplay + " ha recibido los " + ptsOpo +" puntos de las cartas de "+ Util.getTurnoSiguiente_Nombre();
                    
                    
                    Partidas.GuardarPtaFinalizada(txt);
                    Util.Messaje(txt);
                    
                    Util.CloseTablero();
                    MENU m= new MENU();
                    m.setVisible(true);
                    
                    
                }
                else if (count ==1)
                {
                    Component b = Util.getComponent(Util.MainPanel.getComponents(), "jbUno");
                    ((JLabel) b).setVisible(true);
                    Util.DibujarCartasJugadorActual();
                    Util.ActualizarEtiquetas();
                    pThread.Break(2, Acciones.CAMBIAR_TURNO_WAIT_UNO,null);
   
                }
                else{
                 
                    //Cambiar el Turno_Actual del jugador
                    if (!(Cambioturno.equals("true"))){
                        Movimientos.cambiarTurno();
                    }
                     Util.DibujarCartasJugadorActual();
                     Util.DibujarCartasJugadorSiguiente();
                     Movimientos.CambiarCartas(Util.MainPanel);
                     Util.ActualizarEtiquetas();
                 
                }
                
                return true;
     
        }
        
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(Util.MainPanel, ex);
            return false;
        }
    }
}
