/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.io.Serializable;
import java.util.ArrayList;

public class Jugador extends  Usuarios implements Serializable {

    
    public ArrayList<Cartas> cartas=new ArrayList<Cartas>();
    public boolean SaidUno=false;
    
    public Jugador(String n, char s,String foto, int edad, int cod,boolean activo,boolean EsNuevo,int puntos)
    {
        super(n,foto,s,edad,cod,activo,EsNuevo,puntos);
    }
    
    public boolean tiene_color(Colores color)
    {
        boolean retorno=false;
        
        for (Cartas c :cartas)
        {
            
            if (c.color == color)
            {
                return true;
            }
        }
        
        return retorno;
    }
    
    public void AddPuntos(int pts)
    {
       puntos+=pts; 
    }
    public int getPuntos()
    {
        return puntos;
    }
    
    public void resetPuntos()
    {
        puntos=0;
    }
    
    public boolean CanSayUno()
    {
        return (cartas.size()==1?true:false);
    }
}
