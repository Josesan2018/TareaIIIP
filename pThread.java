/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;


public class pThread  extends Thread {

    pThread() {
    
         Sonido.Over();    
    }
    
  public static void Break(final int t,final Acciones a,final Object parametro)
  {
     Runnable r =new Runnable() {
            int time=t;
            Acciones act =a;
            Object p=parametro;
            public void run() {
                
             try 
             {        
                switch (act)
                {
                    case CAMBIAR_CARTAS:
                        break;
                    case CAMBIAR_TURNO_WAIT_UNO:
                        Movimientos.WAITING_UNO=true;
                        break;
                    case TOMAR_CARTA:
                        Movimientos.WAITING_CHANG_CARD=true;
                        break;
                }
                        
                Thread.sleep(time * 1000);

                        switch (act)
                        {
                            case CAMBIAR_CARTAS:
                                Movimientos.CambiarCartas(Util.MainPanel);
                                break;
                            case CAMBIAR_TURNO_WAIT_UNO:
                               
                                Movimientos.cambiarTurno();
                                Util.DibujarCartasJugadorSiguiente();
                                Util.DibujarCartasJugadorActual();                                
                                Movimientos.CambiarCartas(Util.MainPanel);
                                Util.ActualizarEtiquetas();
                                Movimientos.WAITING_UNO=false;
                                break;
                            case TOMAR_CARTA:
                                
                                Movimientos m= new Movimientos();
                                
                                  //Removerla de las cartas disponibles
                                 Util.cartas.remove((Cartas)p);
                                 
                                 //agregarla a la cartas de lis jugadores
                                 Util.jugadores[Util.Turno_Actual].cartas.add((Cartas)p);
                                Movimientos.WAITING_CHANG_CARD=false;
                                
                                if ( !m.Descartar( (Cartas)p,false)){
                                //volver a dibujar debido a que puede haber algun error en la carta y la funcion local dibujo algo temporal
                                //en el tablero
                                
                                
                                Movimientos.cambiarTurno();                                
                                Util.DibujarCartasJugadorActual();
                                Util.DibujarCartasJugadorSiguiente();
                                Movimientos.CambiarCartas(Util.MainPanel);
                                Util.ActualizarEtiquetas();
                                
                              //  Util.Messaje("carta no se pudo descartar :" + ((Cartas)(p)).nombre );
                                
                                }
                                
                                break;
                      }               
        
                } catch (InterruptedException e) {
                     Util.Messaje(e.getMessage());
                }       
            }
        };
     
     Thread th =new  Thread(r);
     th.start();           
  }
  
 
}
