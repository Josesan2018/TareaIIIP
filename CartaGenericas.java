/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.io.Serializable;
import javax.swing.ImageIcon;


public class CartaGenericas implements Serializable {
    
    protected String sImagen ;
    //protected Color color;
    protected int Puntos_Num;
    protected String nombre;
    protected TipoCartas tc;
    protected Colores color;
    
    public CartaGenericas(String imagen,int n, String nombre,TipoCartas tc)
    {
        this.sImagen=imagen;
        this.Puntos_Num=n;
        this.tc=tc;
        this.nombre=nombre;
        asignarColor(nombre);
        
    }
    
    private void asignarColor(String n)
    {
        String patron = n.substring(0,4).toLowerCase();
        if (patron.equalsIgnoreCase("azul"))
        {
            this.color= Colores.Azul;
        }
        else if (patron.equalsIgnoreCase("rojo"))
        {
            this.color = Colores.Rojo;
        }
        else if(patron.equalsIgnoreCase("verd"))
        {
            this.color= Colores.Verde;
        }else if (patron.equalsIgnoreCase("amar"))
        {
            this.color= Colores.Amarillo;
        }
        
    }
    
    public String getDireccion()
    {
        return  Util.pathCartas() + sImagen;
    }
    
    public String getDireccionEfec()
    {
        return  Util.pathEfectos() + sImagen;
    }
    
    public ImageIcon Image()
    {
        return (new ImageIcon (getDireccion()));
    }
    
    public ImageIcon ImageOver()
    {
        return (new ImageIcon (getDireccionEfec()));
    }
    
    protected void setPuntos_Num (int num)
    {
        this.Puntos_Num=num;
    }
    
}
