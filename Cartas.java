package uno;

import java.io.Serializable;

public class Cartas extends CartaGenericas implements Serializable {
    
    public Cartas(String imagen ,int n,String nombre,TipoCartas tc)
    {   
        
        super(imagen,n,nombre,tc);
        
        if (tc ==TipoCartas.Salta || tc ==TipoCartas.Reversa || tc ==TipoCartas.T2 ) {n=20;}
        
        if (tc ==TipoCartas.T4 || tc ==TipoCartas.Comodin ) {n=50;}
        
        super.setPuntos_Num(n);
        
    }
    
    
    
    
}


