/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmTablero.java
 *
 * Created on 11-05-2011, 06:24:32 PM
 */
package uno;

import PanelTransparente.JPanelTransparente;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class frmTablero extends javax.swing.JFrame {

    /** Creates new form frmTablero */
    public frmTablero() {
        initComponents();
        
       
        jbUno.setVisible(false);
       JMAIN.setIcon(Imagenes.PRINCIPAL());
        jVisor.setVisible(false);
        this.setSize(1055, 677);
        JColorSeleccionado.setVisible(false);
        Util.Tablero=this;
        Util.MainPanel=mainPanel;
        
        Util.PrepararTableroJuego(jPanel1, jPanel2);
        
        this.setResizable(false);
            
        this.setLocationRelativeTo(null);
        Util.Tablero=this;
        Util.MainPanel=mainPanel;
        
        JPanelTransparente jp =new JPanelTransparente();
        jp.setSize(jPanel1.getSize());
        jp.setLocation( 30,400);
        jp.setVisible(true);
        mainPanel.add(jp);
        mainPanel.revalidate();
        mainPanel.repaint();
        
    }

    public frmTablero(String Partida)
    {
        try {
            
           initComponents();           
           Util.Tablero=this;
           Util.MainPanel=mainPanel;
          
           if (!Partidas.Cargar(Partida))
            {
                
                MENU m = new MENU();
                m.setVisible(true);
                this.dispose();
            }
            
         
          jbUno.setVisible(false);
          JMAIN.setIcon(Imagenes.PRINCIPAL());
           jVisor.setVisible(false);
           this.setSize(1055, 677);
           //JColorSeleccionado.setVisible(false);           
           
           this.setResizable(false);

           this.setLocationRelativeTo(null);
           
           Util.Tablero=this;
           Util.MainPanel=mainPanel;
           
        } catch (Exception ex) {
            Util.Messaje(ex.getMessage());
            MENU m = new MENU();
            m.setVisible(true);
            this.dispose();
        }
        
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        ListCartasJugadas = new javax.swing.JLabel();
        ListCartaDisponibles = new javax.swing.JLabel();
        jpicture2 = new javax.swing.JLabel();
        jpicture1 = new javax.swing.JLabel();
        JColorSeleccionado = new javax.swing.JLabel();
        jJugador1 = new javax.swing.JLabel();
        jJugador2 = new javax.swing.JLabel();
        jPanel1 = new PanelTransparente.JPanelTransparente();
        jPanel2 = new PanelTransparente.JPanelTransparente();
        jPanelInfo = new PanelTransparente.JPanelTransparente();
        jVisor = new javax.swing.JLabel();
        JPuntos = new javax.swing.JLabel();
        jRetirada = new javax.swing.JLabel();
        jsave = new javax.swing.JLabel();
        jbUno = new javax.swing.JLabel();
        JMAIN = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("MainMain"); // NOI18N
        getContentPane().setLayout(null);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(uno.UnoApp.class).getContext().getResourceMap(frmTablero.class);
        mainPanel.setBackground(resourceMap.getColor("mainPanel.background")); // NOI18N
        mainPanel.setBorder(new javax.swing.border.LineBorder(resourceMap.getColor("mainPanel.border.lineColor"), 2, true)); // NOI18N
        mainPanel.setAlignmentX(0.0F);
        mainPanel.setAlignmentY(0.0F);
        mainPanel.setAutoscrolls(true);
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setLayout(null);

        ListCartasJugadas.setText(resourceMap.getString("ListCartasJugadas.text")); // NOI18N
        ListCartasJugadas.setName("ListCartasJugadas"); // NOI18N
        ListCartasJugadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ListCartasJugadasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ListCartasJugadasMouseExited(evt);
            }
        });
        mainPanel.add(ListCartasJugadas);
        ListCartasJugadas.setBounds(268, 245, 120, 160);

        ListCartaDisponibles.setName("ListCartaDisponibles"); // NOI18N
        ListCartaDisponibles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListCartaDisponiblesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ListCartaDisponiblesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ListCartaDisponiblesMouseExited(evt);
            }
        });
        mainPanel.add(ListCartaDisponibles);
        ListCartaDisponibles.setBounds(545, 244, 120, 160);

        jpicture2.setBackground(resourceMap.getColor("jpicture2.background")); // NOI18N
        jpicture2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jpicture2.setName("jpicture2"); // NOI18N
        mainPanel.add(jpicture2);
        jpicture2.setBounds(735, 240, 115, 155);

        jpicture1.setBackground(resourceMap.getColor("jpicture1.background")); // NOI18N
        jpicture1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jpicture1.setName("jpicture1"); // NOI18N
        mainPanel.add(jpicture1);
        jpicture1.setBounds(85, 245, 115, 155);

        JColorSeleccionado.setIcon(resourceMap.getIcon("JColorSeleccionado.icon")); // NOI18N
        JColorSeleccionado.setText(resourceMap.getString("JColorSeleccionado.text")); // NOI18N
        JColorSeleccionado.setToolTipText(resourceMap.getString("JColorSeleccionado.toolTipText")); // NOI18N
        JColorSeleccionado.setFocusable(false);
        JColorSeleccionado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JColorSeleccionado.setName("JColorSeleccionado"); // NOI18N
        JColorSeleccionado.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        JColorSeleccionado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JColorSeleccionadoMouseClicked(evt);
            }
        });
        mainPanel.add(JColorSeleccionado);
        JColorSeleccionado.setBounds(413, 270, 103, 111);

        jJugador1.setFont(resourceMap.getFont("jJugador1.font")); // NOI18N
        jJugador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jJugador1.setText(resourceMap.getString("jJugador1.text")); // NOI18N
        jJugador1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jJugador1.setName("jJugador1"); // NOI18N
        mainPanel.add(jJugador1);
        jJugador1.setBounds(30, 420, 230, 20);

        jJugador2.setFont(resourceMap.getFont("jJugador2.font")); // NOI18N
        jJugador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jJugador2.setText(resourceMap.getString("jJugador2.text")); // NOI18N
        jJugador2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jJugador2.setName("jJugador2"); // NOI18N
        mainPanel.add(jJugador2);
        jJugador2.setBounds(670, 420, 240, 22);

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setTran(0.0F);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        mainPanel.add(jPanel1);
        jPanel1.setBounds(80, 30, 730, 170);

        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setTran(0.0F);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        mainPanel.add(jPanel2);
        jPanel2.setBounds(80, 480, 730, 170);

        jPanelInfo.setName("jPanelInfo"); // NOI18N
        jPanelInfo.setTran(0.0F);
        jPanelInfo.setLayout(null);

        jVisor.setBorder(new javax.swing.border.LineBorder(resourceMap.getColor("jVisor.border.lineColor"), 1, true)); // NOI18N
        jVisor.setName("jVisor"); // NOI18N
        jVisor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jVisorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jVisorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jVisorMouseExited(evt);
            }
        });
        jPanelInfo.add(jVisor);
        jVisor.setBounds(10, 230, 120, 160);

        JPuntos.setFont(resourceMap.getFont("JPuntos.font")); // NOI18N
        JPuntos.setForeground(resourceMap.getColor("JPuntos.foreground")); // NOI18N
        JPuntos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JPuntos.setText(resourceMap.getString("JPuntos.text")); // NOI18N
        JPuntos.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        JPuntos.setName("JPuntos"); // NOI18N
        jPanelInfo.add(JPuntos);
        JPuntos.setBounds(10, 80, 120, 130);

        jRetirada.setFont(resourceMap.getFont("jRetirada.font")); // NOI18N
        jRetirada.setForeground(resourceMap.getColor("jRetirada.foreground")); // NOI18N
        jRetirada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRetirada.setIcon(resourceMap.getIcon("jRetirada.icon")); // NOI18N
        jRetirada.setText(resourceMap.getString("jRetirada.text")); // NOI18N
        jRetirada.setToolTipText(resourceMap.getString("jRetirada.toolTipText")); // NOI18N
        jRetirada.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jRetirada.setAlignmentY(0.0F);
        jRetirada.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jRetirada.setName("jRetirada"); // NOI18N
        jRetirada.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jRetirada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRetiradaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jRetiradaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jRetiradaMouseExited(evt);
            }
        });
        jPanelInfo.add(jRetirada);
        jRetirada.setBounds(10, 20, 50, 50);
        jRetirada.getAccessibleContext().setAccessibleDescription(resourceMap.getString("jRetirada.AccessibleContext.accessibleDescription")); // NOI18N

        jsave.setFont(resourceMap.getFont("jsave.font")); // NOI18N
        jsave.setForeground(resourceMap.getColor("jsave.foreground")); // NOI18N
        jsave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jsave.setIcon(resourceMap.getIcon("jsave.icon")); // NOI18N
        jsave.setText(resourceMap.getString("jsave.text")); // NOI18N
        jsave.setToolTipText(resourceMap.getString("jsave.toolTipText")); // NOI18N
        jsave.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jsave.setAlignmentY(0.0F);
        jsave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jsave.setName("jsave"); // NOI18N
        jsave.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jsave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jsaveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jsaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jsaveMouseExited(evt);
            }
        });
        jPanelInfo.add(jsave);
        jsave.setBounds(60, 24, 50, 50);

        mainPanel.add(jPanelInfo);
        jPanelInfo.setBounds(910, 0, 140, 670);

        jbUno.setIcon(resourceMap.getIcon("jbUno.icon")); // NOI18N
        jbUno.setText(resourceMap.getString("jbUno.text")); // NOI18N
        jbUno.setName("jbUno"); // NOI18N
        jbUno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbUnoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbUnoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbUnoMouseExited(evt);
            }
        });
        mainPanel.add(jbUno);
        jbUno.setBounds(405, 390, 120, 80);

        JMAIN.setIcon(resourceMap.getIcon("JMAIN.icon")); // NOI18N
        JMAIN.setText(resourceMap.getString("JMAIN.text")); // NOI18N
        JMAIN.setName("JMAIN"); // NOI18N
        mainPanel.add(JMAIN);
        JMAIN.setBounds(0, 0, 1050, 670);

        getContentPane().add(mainPanel);
        mainPanel.setBounds(0, 0, 1050, 670);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
       
private void ListCartasJugadasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListCartasJugadasMouseEntered
    ListCartasJugadas.setIcon(Util.UltimaCarta.ImageOver());
}//GEN-LAST:event_ListCartasJugadasMouseEntered

private void ListCartasJugadasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListCartasJugadasMouseExited
    
    ListCartasJugadas.setIcon(Util.UltimaCarta.Image());
}//GEN-LAST:event_ListCartasJugadasMouseExited

private void ListCartaDisponiblesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListCartaDisponiblesMouseEntered
   String dir = Util.pathEfectos()+  "Reversa.jpg";
    ListCartaDisponibles.setIcon(new ImageIcon(dir));
}//GEN-LAST:event_ListCartaDisponiblesMouseEntered

private void ListCartaDisponiblesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListCartaDisponiblesMouseExited

    String dir = Util.pathCartas() +  "Reversa.jpg";
    ListCartaDisponibles.setIcon(new ImageIcon(dir));
}//GEN-LAST:event_ListCartaDisponiblesMouseExited

private void jsaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jsaveMouseEntered
    jsave.setIcon(Imagenes.SaveOver());
    
}//GEN-LAST:event_jsaveMouseEntered

private void jsaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jsaveMouseExited
    jsave.setIcon(Imagenes.Save());
}//GEN-LAST:event_jsaveMouseExited

private void jsaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jsaveMouseClicked
if (Util.JuegoConcluido)
{
    Util.Messaje("EL JUEGO YA HA CONCLUIDO");
}
else
{
            try {
                
                  if (JOptionPane.showConfirmDialog(this, "Deseas guardar el juego?") != JOptionPane.OK_OPTION)
                    {
                       return; 
                    }
                Partidas.Guardar();
                MENU m = new MENU();
                m.setVisible(true);
                this.dispose();
            } catch (Exception ex) {
                Util.Messaje(ex.getMessage());
            }
}


}//GEN-LAST:event_jsaveMouseClicked

private void ListCartaDisponiblesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListCartaDisponiblesMouseClicked
    
    if (Util.JuegoConcluido){return;}
    
    if(Movimientos.WAITING_CHANG_CARD) {return;}
    
    if (Util.cartas.size()<=0)
    {
           Util.Messaje("Se volveran a barajear las cartas jugadas");
                     
           for (Cartas c:Util.cartasJugadas)
           {
               Util.cartas.add(c);
           }
           
           Util.cartasJugadas.clear();
           
           Util.barajear();
           Util.barajear();
           Util.barajear();
           Util.barajear();
    }
    
    if (Util.cartas.size()>0)
    {
        
       Cartas card=Util.cartas.get(0);
       
       if (Util.Turno_Actual==0){
            local_dibujarCartas(jPanel1,0,card);}
       else{
           local_dibujarCartas(jPanel2,1,card);}
        
        pThread.Break(1,Acciones.TOMAR_CARTA,card);

    }

    
}//GEN-LAST:event_ListCartaDisponiblesMouseClicked

private ArrayList<Cartas> getCartas(int turno,Cartas icard)
{
    ArrayList<Cartas> cartas=new ArrayList<Cartas>();
    cartas.add(icard);
    for(int i =Util.jugadores[turno].cartas.size() -1 ;  i >=0 ;i-- )
    {
        cartas.add(Util.jugadores[turno].cartas.get(i));
    }
    
    return cartas;
}
private void local_dibujarCartas(JPanel JPanelJugador,int turno,Cartas icard)
{
    JPanelJugador.removeAll();
    JPanelJugador.revalidate();
    JPanelJugador.repaint();
        
    //((JPanel) (JPanelJugador.getParent())).revalidate();
    ArrayList<Cartas> cartas =getCartas(turno,icard);
    
    
    int x =0;
    int xlow=0;
    for (Cartas card:cartas)  
    {
       //Cartas card=jugadores[turno].cartas.get(i);         
       JLabel label = new JLabel();
       label.setIcon(card.Image());       
       label.setBorder(new javax.swing.border.LineBorder(Util.resourceMap.getColor("jVisor.border.lineColor"), 1, true));        
       //label.addMouseListener(new LabelEventClick());
       label.setName(card.nombre );
       label.setVisible(true);       
       label.setSize(120 -xlow, 160 - xlow);

       label.setLocation(x, 0);
       x+=20;
       xlow +=2;       
       
       JPanelJugador.add(label);
       JPanelJugador.revalidate();
    }
    
    JPanelJugador.revalidate();
    JPanelJugador.repaint();
}
private void jVisorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jVisorMouseClicked
// TODO add your handling code here:
}//GEN-LAST:event_jVisorMouseClicked

private void jVisorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jVisorMouseEntered
// TODO add your handling code here:
}//GEN-LAST:event_jVisorMouseEntered

private void jVisorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jVisorMouseExited
// TODO add your handling code here:
}//GEN-LAST:event_jVisorMouseExited

private void JColorSeleccionadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JColorSeleccionadoMouseClicked

}//GEN-LAST:event_JColorSeleccionadoMouseClicked

private void jRetiradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRetiradaMouseClicked

    if (Util.JuegoConcluido)
    {
        Util.Messaje("EL JUEGO YA HA CONCLUIDO");
    }

    if (Movimientos.WAITING_CHANG_CARD)
    {
        Util.Messaje("Actualmente lanzaste una carta y se esta evaluando, Por favor espera un momento.");
        return;
    }

    if (JOptionPane.showConfirmDialog(this, Util.getTurnoDisplay_Nombre()+ " deseas retirarte del juego?") != JOptionPane.OK_OPTION)
    {
       return; 
    }

     String s =Util.getTurnoSiguiente_Nombre();
     String a =Util.getTurnoDisplay_Nombre();
    //Mostrar las cartas del otro jugador
    Movimientos.cambiarTurno();
    Movimientos.CambiarCartas(mainPanel);
    Util.ActualizarEtiquetas();

    if (JOptionPane.showConfirmDialog(this, s+ ", "+ a+" desea retirarse del juego, Estas de acuerdo?") != JOptionPane.OK_OPTION)
    {
       //Volver a mostrar las cartas del primer jugador 
        Movimientos.cambiarTurno();
        Movimientos.CambiarCartas(mainPanel);
        Util.ActualizarEtiquetas(); 
        return; 
    }

    try {

            //Volver a mostrar las cartas del primer jugador
            Movimientos.cambiarTurno();
            Movimientos.CambiarCartas(mainPanel);
            Util.ActualizarEtiquetas();

            int pts= Movimientos.getPuntosContrarios(Movimientos.SiguienteTurno());
            Util.jugadores[Util.Turno_Actual].resetPuntos();
            Util.jugadores[Util.Turno_Actual].puntos=0;
            Util.jugadores[Movimientos.SiguienteTurno()].AddPuntos(pts);

            String msj=Util.getTurnoSiguiente_Nombre() + " ha ganado con "+  Util.jugadores[Movimientos.SiguienteTurno()].puntos+ " puntos %s ya que " + Util.getTurnoDisplay_Nombre() +" se ha retirado\n";
            msj= String.format(msj," y ha recibido " + pts + " puntos de sus cartas restantes.");

            ControlUsuarios.GuardarPuntosDeJugadores();
            Partidas.GuardarPtaFinalizada(msj);        
            Util.Messaje(msj);
            MENU m = new MENU();
            m.setVisible(true);
            this.dispose();
        }catch (Exception ex) {
            Util.Messaje(ex.getMessage());
        }


}//GEN-LAST:event_jRetiradaMouseClicked

private void jRetiradaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRetiradaMouseEntered
    jRetirada.setIcon(Imagenes.HomeOver());
}//GEN-LAST:event_jRetiradaMouseEntered

private void jRetiradaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRetiradaMouseExited
    jRetirada.setIcon(Imagenes.Home());
}//GEN-LAST:event_jRetiradaMouseExited

private void jbUnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbUnoMouseClicked
Movimientos.UNO();
}//GEN-LAST:event_jbUnoMouseClicked

private void jbUnoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbUnoMouseEntered
jbUno.setIcon(Imagenes.botonUNOOver());
}//GEN-LAST:event_jbUnoMouseEntered

private void jbUnoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbUnoMouseExited
jbUno.setIcon(Imagenes.botonUNO());
}//GEN-LAST:event_jbUnoMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmTablero().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JColorSeleccionado;
    private javax.swing.JLabel JMAIN;
    private javax.swing.JLabel JPuntos;
    private javax.swing.JLabel ListCartaDisponibles;
    private javax.swing.JLabel ListCartasJugadas;
    private javax.swing.JLabel jJugador1;
    private javax.swing.JLabel jJugador2;
    private PanelTransparente.JPanelTransparente jPanel1;
    private PanelTransparente.JPanelTransparente jPanel2;
    private PanelTransparente.JPanelTransparente jPanelInfo;
    private javax.swing.JLabel jRetirada;
    private javax.swing.JLabel jVisor;
    private javax.swing.JLabel jbUno;
    private javax.swing.JLabel jpicture1;
    private javax.swing.JLabel jpicture2;
    private javax.swing.JLabel jsave;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}