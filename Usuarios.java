/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.io.File;
import java.io.Serializable;




public class Usuarios implements  Serializable {
    
    
    public  String nombre;
    public  String Foto;
    public  char sexo;
    public  int edad;
    public  int cod;
    public  boolean Activo;
    public int puntos=0;
    
    public Usuarios ()
    {
        
    }
    public Usuarios(String nombre,String foto,char sexo,int edad,int cod, boolean activo,boolean EsNuevo,int puntos)
    {
        
        
           if (foto==null || foto.trim().length()<=0)
            {
                foto=Util.path()+ "\\img\\user.png";
                
            }
       
         File f=new File(Util.path() + "\\data\\jugadores");
         if (!f.exists()) {f.mkdirs();}
        
        if (EsNuevo){    
                
                File copia= new File(foto);
                                
                String ext = Util.extension(copia.getAbsolutePath());                
                File mycopia=new File(Util.pathdataJugadoresFoto()+ nombre +  "."+ext) ;
                
                copia.renameTo(mycopia);
                
                foto="\\data\\jugadores\\"+mycopia.getName();
                
            }
        
        
        this.nombre=nombre;
        this.Foto=foto;
        this.sexo=sexo;
        this.edad=edad;
        this.cod=cod;
        this.Activo=activo;
        this.puntos=puntos;
    }
}
