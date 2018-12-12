/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;


public class Imagenes {
    
   static int width = 200;
   static int height = 200;
   public String fotopath="";
public static BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);


    public static ImageIcon  UserAceptar()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\usuario\\azul.png"));
    }
    
    public static ImageIcon  UserAceptarOver()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\usuario\\azul2.png"));
    }
    
    public static ImageIcon  UserCancelar()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\usuario\\rojo.png"));
    }
       
    
    public static ImageIcon  UserCancelarOver()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\usuario\\rojo2.png"));
    }
    
    public static ImageIcon  ColorAzul()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\colores\\azul.png"));
    }
    
     public static ImageIcon  ColorAzulOver()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\colores\\azul2.png"));
    }
     
     public static ImageIcon  ColorVerde()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\colores\\verde.png"));
    }
    
     public static ImageIcon  ColorVerdeOver()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\colores\\verde2.png"));
    }
     
    public static ImageIcon  ColorRojo()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\colores\\rojo.png"));
    }
    
     public static ImageIcon  ColorRojoOver()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\colores\\rojo2.png"));
    }
    
          
    public static ImageIcon  ColorAmarillo()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\colores\\Amarillo.png"));
    }
    
     public static ImageIcon  ColorAmarilloOver()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\colores\\Amarillo2.png"));
    }
     
    public static ImageIcon  ColorAddFotoOver()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\add_azul2.png"));
    }
    
    public static ImageIcon  ColorAddFoto()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\add.png"));
    }
    
      public static ImageIcon  ColorRevFotoOver()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\remove_azul2.png"));
    }
    
    public static ImageIcon  ColorRevFoto()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\remove.png"));
    }
    
    
      public static ImageIcon  UsuarioAnonimo()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\user.png"));
    }
      
     public static ImageIcon  OK()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\select.png"));
    }
    
    
      public static ImageIcon  OKOver()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\select_2.png"));
    }
      
    public static ImageIcon  OKset()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\select_set.png"));
    }
    
    public static ImageIcon  OKsetOver()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\select_set_2.png"));
    }
    
     public static ImageIcon  DeleteUser()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\delete_user.png"));
    }
    
    public static ImageIcon  DeleteUserOver()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\delete_user_2.png"));
    }
    
     public static ImageIcon  UserData()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\user_data.png"));
    }
    
    public static ImageIcon  UserDataOver()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\user_data_2.png"));
    }
    
      public static ImageIcon  Home()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\home.png"));
    }
    
    public static ImageIcon  HomeOver()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\home_2_1.png"));
    }
    
    
    public static ImageIcon  Save()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\save.png"));
    }
    
    public static ImageIcon  SaveOver()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\save_2.png"));
    }
    
    
      
    public static ImageIcon  MenuPNuevoJuego()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\Amarillo.png"));
    }
    
    public static ImageIcon  MenuPNuevoJuegoOver()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\Amarillo2.png"));
    }
    
    public static ImageIcon  MenuPJugadores()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\azulm.png"));
    }
    
    public static ImageIcon  MenuPJugadoresOver()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\azul2m.png"));
    }
    
    public static ImageIcon  MenuPTop10()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\morado.png"));
    }
    
    public static ImageIcon   MenuPTop10Over()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\morado2.png"));
    }
    
    public static ImageIcon  MenuSalir()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\rojom.png"));
    }
    
    public static ImageIcon   MenuSalirOver()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\botones\\rojo2m.png"));
    }
    
    
     public static ImageIcon  AddUser()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\add_user.png"));
    }
    
    public static ImageIcon   AddUserOver()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\add_user_2.png"));
    }
    
       public static ImageIcon  Next()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\next.png"));
    }
    
    public static ImageIcon   NextOver()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\next_2.png"));
    }
    
   public static ImageIcon   ColorTriangVerde()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\Verde.png"));
    }
    
    public static ImageIcon   ColorTriangAzul()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\Azul.png"));
    }
    
      public static ImageIcon   ColorTriangAmarillo()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\Amarillo.png"));
    }
    
       public static ImageIcon   ColorTriangRojo()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\Rojo.png"));
    }
        public static ImageIcon   botonUNO()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\boton1.png"));
    }
        
        public static ImageIcon   botonUNOOver()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\boton1_2.png"));
    }
        
         public static ImageIcon   PRINCIPAL()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\main.png"));
    } 
   
      public static ImageIcon   FechaPartida()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\fechaPartida.png"));
    }
      
    public static ImageIcon   FechaPartidaOver()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\fechaPartida_2.png"));
    } 
    
   public static ImageIcon   FechaPartidaCliked()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\fechaPartida_3.png"));
    } 
   
      public static ImageIcon   Top10Detalle()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\star10deta.png"));
    }
    
    
      public static ImageIcon   Top10Ranking()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\star10Ranking.png"));
    }
   
         public static ImageIcon Top10Banner()
    {
         pThread p= new pThread();
           p.start();
       return (new ImageIcon( Util.path() + "\\img\\top10.png"));
    }
    public ImageIcon getFoto(JLabel Jfoto)
    {

     JFileChooser chooser = new JFileChooser();
     chooser.setDialogTitle("Agrega imagen de perfil");
     chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
     int opcion= chooser.showOpenDialog(Jfoto.getParent());

     if (opcion== JFileChooser.APPROVE_OPTION)
         {
             fotopath = chooser.getSelectedFile().getAbsolutePath();
             
             
             ImageIcon foto = new ImageIcon(fotopath);
             ImageIcon fotoReal =new ImageIcon(foto.getImage().getScaledInstance(Jfoto.getSize().width,  Jfoto.getSize().height,Image.SCALE_DEFAULT ));
             return fotoReal;


         }
     return null;
    }


   public  static ImageIcon getFoto(JLabel Jfoto,String fotopath)
    {

     try
     {
         File f= new File ( Util.path()+ fotopath);
         fotopath=f.getAbsolutePath();
         
         if (f.exists()){
         
             
             if (f.getName().equalsIgnoreCase("user.png"))                 
             {
                 return UsuarioAnonimo();
             }
             
             ImageIcon foto = new ImageIcon(fotopath);
             ImageIcon fotoReal =new ImageIcon(foto.getImage().getScaledInstance(Jfoto.getSize().width,  Jfoto.getSize().height,Image.SCALE_DEFAULT ));
             return fotoReal;
         }
         
        return UsuarioAnonimo();  
      }
     
     catch (Exception ex)
     {
        return UsuarioAnonimo(); 
     }
         
        
    }

}