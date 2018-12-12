/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author DAVID
 */
public class Partidas {
    
    private static RandomAccessFile ptas;
    private static String file_Partida="";
    private static RandomAccessFile ptas_finished;
    
    public static void configFiles() throws Exception
    {
        
         File f=new File( Util.pathdata() +"\\Partidas");
         if(!f.exists()) {f.mkdirs();}

         f =new File(Util.pathdata()+"\\Partidas\\ptas.uno");
         if (f.exists()==false) {f.createNewFile();}
         ptas=new RandomAccessFile(f, "rw");

         f =new File(Util.pathdata()+"\\Partidas\\history.uno");
         if (f.exists()==false) {f.createNewFile();}
         ptas_finished=new RandomAccessFile(f, "rw");

          if (ptas.length()<=0)
         {
             ptas.writeInt(1);
         }
      
    }
    
    public static void GuardarPtaFinalizada(String msj)throws Exception
    {
        //cod J1,J2,PJ1,PJ2,Fecha
        ptas_finished.seek(ptas_finished.length());
        ptas_finished.writeInt(Util.jugadores[0].cod);
        ptas_finished.writeInt(Util.jugadores[1].cod);
        ptas_finished.writeInt(Util.jugadores[0].puntos);
        ptas_finished.writeInt(Util.jugadores[1].puntos);
        ptas_finished.writeLong(new Date().getTime());
        ptas_finished.writeUTF(msj);
        file_Partida="";
    }
    
    private static int getCodigo() throws Exception
    {
        ptas.seek(0);
        int cod =ptas.readInt();
        ptas.seek(0);
        ptas.writeInt(cod+1);
        ptas.seek(0);
       // Util.Messaje("cod:" + cod + "otro cod saved " + ptas.readInt());
        return  cod;
    }
    
    public static void Guardar() throws Exception
   {
       
      String filename= "";
      if (file_Partida.length()<=0)
          filename= Util.pathdata() +"\\Partidas\\partida_" + getCodigo() + ".uno";
      else
          filename= file_Partida;
      
      List list = new ArrayList();
      list.add(Util.cartas);
      list.add(Util.cartasJugadas);
      list.add( new Date().toString() + ": " +Util.jugadores[0].nombre + " vs " + Util.jugadores[1].nombre  );
      list.add(Util.jugadores);
      
      list.add(Util.Turno_Actual);
      list.add(Util.CartaActual);
      list.add(Util.UltimaCarta);
      list.add(Util.JuegoConcluido);
      list.add(Util._cartasTotales);
      list.add(Util.GiroTurno);
      list.add(Util.LastColor);      
      list.add(Util.TurnoWithUNO);
    
      FileOutputStream fos = new FileOutputStream(filename);
      ObjectOutputStream out = new ObjectOutputStream(fos);

      out.writeObject(list);
      
      out.close();
      file_Partida="";
      Util.Messaje("JUEGO GUARDADO!!");
      
       
   }
   
    public static ArrayList<String> getPartidasGuardadas()
    {
         ArrayList<String>  partidas=new ArrayList<String>();
         File f=new File(Util.pathdata() +"\\Partidas");
         
         if (f.exists())
         {
             
             for(File p:f.listFiles())
             {
                 if (p.getName().startsWith("partida_")  && Util.extension(p.getAbsolutePath()).equals("uno"))
                 {
                     partidas.add( p.getName() + "/ " + getInfo (p.getAbsolutePath()));
                 }
             }
         }
         
         return partidas;
    }
    
    public static ArrayList<String> getTop10Historial()
    {
        ArrayList<String>  partidas=new ArrayList<String>();
        ArrayList<String>  partidasTop10=new ArrayList<String>();
        
        try {
            
           ptas_finished.seek(0);
           while (ptas_finished.getFilePointer() < ptas_finished.length())
           {
               ptas_finished.readInt();
               ptas_finished.readInt();
               ptas_finished.readInt();
               ptas_finished.readInt();
               ptas_finished.readLong();
               partidas.add( ptas_finished.readUTF());
           }
           
         int c=partidas.size() >=10?10:(partidas.size () -1);
         for(int i=c;i>=0;i--)
         {
             partidasTop10.add( partidas.get(i));
         }
            
        } catch (IOException ex) {
          Util.Messaje("Error al obtener el Top 10 :" + ex.getMessage());
        }
        
        
        return partidasTop10;
    }
      
   private static String getInfo (String filename)
   {    
       try {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fis);
        List list = (ArrayList) in.readObject();
        String partida= list.get(2).toString();
        return partida;
        
        } catch (Exception ex) {
           return "-";
        
        }
   }
   
   public static boolean Cargar(String filename)throws Exception
   {
      filename= Util.pathdata() +"\\Partidas\\" +filename; 
      
      FileInputStream fis = new FileInputStream(filename);
      ObjectInputStream in = new ObjectInputStream(fis);
      List list = (ArrayList) in.readObject();
      file_Partida=filename;
      int j1=-1,j2=-2;
      j1=Util.jugadores[0].cod;
      j2 =Util.jugadores[1].cod;
      
       Util.jugadores= (Jugador[])list.get(3);
      
       if (!((j1==Util.jugadores[0].cod) && (j2==Util.jugadores[1].cod)))
       {
           JOptionPane.showConfirmDialog(Util.MainPanel, "No se puede cargar la partida, deben ser los mismos jugadores.");
           return false;
       }
        
      Util.cartas = (ArrayList<Cartas>) list.get(0);
      Util.cartasJugadas= (ArrayList<Cartas>) list.get(1);
      String partida= list.get(2).toString();
    
      
      Util.Turno_Actual = Integer.parseInt(list.get(4).toString());
      Util.CartaActual = Integer.parseInt(list.get(5).toString());
      Util.UltimaCarta =(Cartas)list.get(6);
      Util.JuegoConcluido =Boolean.getBoolean(list.get(7).toString().toLowerCase());
      Util._cartasTotales= Integer.parseInt(list.get(8).toString());
      Util.GiroTurno =list.get(9).toString();
      Util.LastColor =(Colores)list.get(10);      
      Util.TurnoWithUNO = Integer.parseInt(list.get(11).toString());
      
      Util.DibujarCartasJugadorActual();
      Util.DibujarCartasJugadorSiguiente();
      Movimientos.CambiarCartas(Util.MainPanel);
      Util.ActualizarEtiquetas();
      //Color de un comodion o T4
   
        if (Util.UltimaCarta.tc ==  TipoCartas.T4 || Util.UltimaCarta.tc == TipoCartas.Comodin )
       {
           Component c= Util.getComponent( Util.MainPanel.getComponents() , "JColorSeleccionado");
            ImageIcon img =null;
            if (Util.LastColor == Colores.Amarillo) { img  =Imagenes.ColorTriangAmarillo();}
            if (Util.LastColor == Colores.Azul) { img  =Imagenes.ColorTriangAzul();}
            if (Util.LastColor == Colores.Rojo) { img  =Imagenes.ColorTriangRojo();}
            if (Util.LastColor == Colores.Verde) { img  =Imagenes.ColorTriangVerde();}
                  
            ((JLabel)c).setIcon(img);
            ((JLabel)c).setVisible(true); 
                    
       }
      
      in.close();
      
      return true ;
   }
   
}
