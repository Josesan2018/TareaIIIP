/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.awt.Component;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class ControlUsuarios {

    private static RandomAccessFile jugs;
    private static RandomAccessFile cods;

    public static void configFiles() throws Exception {
        File f = new File(Util.pathdata() + "\\jugadores.uno");
        if (!f.exists()) {
            f.createNewFile();
        }
        jugs = new RandomAccessFile(f, "rw");

        f = new File(Util.pathdata() + "\\codigos.uno");
        if (!f.exists()) {
            f.createNewFile();
        }
        cods = new RandomAccessFile(f, "rw");



        if (cods.length() <= 0) {
            cods.writeInt(1);
        }

    }

    private static int getCodigo() throws Exception {
        cods.seek(0);
        int cod = cods.readInt();
        cods.seek(0);
        cods.writeInt(cod + 1);
        cods.seek(0);
        return cod;
    }

    public static boolean Existe(String nombre) throws Exception {
        jugs.seek(0);
        while (jugs.getFilePointer() < jugs.length()) {
            String user = jugs.readUTF(); //nombre
            jugs.readUTF();   //Foto
            jugs.readChar();  //sexo
            jugs.readInt();   //edad
            jugs.readInt();   //cod
            jugs.readInt();  //puntos
            boolean activo = jugs.readBoolean();//Activo

            if (user.equals(nombre) && activo) {
                return true;
            }

        }

        return false;
    }

    public static boolean Agregar(Component parent, String nombre, String foto, char sexo, int edad) {
        try {

            int len = nombre.trim().length();
            nombre = nombre.substring(0, (len >= 15 ? 15 : len));

            if (Existe(nombre)) {
                Util.Messaje(parent, "El nombre de usuario ya existe!");
                return false;
            }

            int cod = getCodigo();
            jugs.seek(jugs.length());

            jugs.writeUTF(nombre);
            jugs.writeUTF(foto);
            jugs.writeChar(sexo);
            jugs.writeInt(edad);
            jugs.writeInt(cod);
            jugs.writeInt(0); //puntos
            jugs.writeBoolean(true);

            Util.Messaje(parent, "Usuario agregado exitosamente!");

            return true;
        } catch (Exception ex) {
            Util.Messaje(parent, "Error al agregar al usuario: " + ex.getMessage());
            return false;
        }
    }

    public static boolean Inactivar(String nombre) {
        try {

            if (!Existe(nombre)) {
                Util.Messaje("Usuario no existe");
                return false;
            }

            jugs.seek(jugs.getFilePointer() - 1);
            jugs.writeBoolean(false);
            return true;

        } catch (Exception ex) {
            Util.Messaje("Error al eliminar el usuario: " + nombre + ", " + ex.getMessage());
            return false;
        }
    }

    public static boolean AddPuntos(String nombre, int puntos) {
        try {

            if (!Existe(nombre)) {
                Util.Messaje("Usuario no existe");
                return false;
            }

            jugs.seek(jugs.getFilePointer() - 5);
            int pts = jugs.readInt();

            jugs.seek(jugs.getFilePointer() - 4);
            jugs.writeInt(puntos + pts);

            return true;

        } catch (Exception ex) {
            Util.Messaje("Error al guardar los puntos del jugador: " + nombre + ", " + ex.getMessage());
            return false;
        }
    }

    public static ArrayList<Usuarios> GetDisponibles() {
        ArrayList<Usuarios> u = new ArrayList<Usuarios>();

        try {


            jugs.seek(0);
            while (jugs.getFilePointer() < jugs.length()) {
                String user = jugs.readUTF(); //nombre
                String foto = jugs.readUTF();   //Foto
                char sexo = jugs.readChar();  //sexo
                int edad = jugs.readInt();   //edad
                int cod = jugs.readInt();   //cod
                int puntos = jugs.readInt();//puntos


                if (jugs.readBoolean()) {
                    u.add(new Usuarios(user, foto, sexo, edad, cod, true, true, puntos));
                }

            }


        } catch (Exception ex) {
            Util.Messaje("Error al listar los usuarios:" + ex.getMessage());
        }

        return u;
    }

    public static ArrayList<String> GetRankingTop10() {
        ArrayList<Usuarios> dispo = GetDisponibles();
        Usuarios jugadores[] = new Usuarios[dispo.size()];
        for (int i = 0; i < dispo.size(); i++) {
            jugadores[i] = new Usuarios();
            jugadores[i].nombre = dispo.get(i).nombre;
            jugadores[i].puntos = dispo.get(i).puntos;
        }

        boolean continuar = true;

        for (int i = 0; continuar; i++) {
            continuar = false;
            for (int j = 0; j < jugadores.length - 1; j++) {
                if (jugadores[j].puntos < jugadores[j + 1].puntos) {
                    continuar = true;
                    Usuarios tmp = jugadores[j];
                    jugadores[j] = jugadores[j + 1];
                    jugadores[j + 1] = tmp;

                }
            }
        }

        ArrayList<String> top10 = new ArrayList<String>();

        int c = jugadores.length >= 10 ? 10 : jugadores.length;

        for (int i = 0; i < c; i++) {
            top10.add(Util.padLeft(jugadores[i].nombre, ' ', 15) + Util.padLeft(String.valueOf(jugadores[i].puntos), ' ', 15) + " puntos");
        }

        return top10;
    }

    public static void GuardarPuntosDeJugadores() {
        for (int i = 0; i < Util.jugadores.length; i++) {
            if (Util.jugadores[i] == null) {
                continue;
            }

           // if (i == TurnoGanador) {
                ControlUsuarios.AddPuntos(Util.jugadores[i].nombre, Util.jugadores[i].puntos);
            //} else {
               // ControlUsuarios.AddPuntos(Util.jugadores[i].nombre, 0);
            //}
        }

        Util.JuegoConcluido = true;
    }
}
