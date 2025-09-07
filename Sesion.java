import java.util.*;
public class Sesion {
    private ArrayList<String> sesiones;
    private int numsesion;

    public Sesion(){
        numsesion=0;
        sesiones= new ArrayList<>();
    }

    public void setSesiones(Jugador j1, Jugador j2, Jugador ganador){
        numsesion++;
        String cadena="Sesion " + numsesion + "\n  -" +j1.getNombre()+": " + j1.getPunteo() +"\n  -" +j2.getNombre()+": " + j2.getPunteo();
        if (ganador != null) {
            cadena += "\n  Ganador: " + ganador.getNombre();
        } else {
            cadena += "\n  Empate";
        }
        sesiones.add(cadena);
    }
    public ArrayList<String> getSesiones(){
        return sesiones;
    }


}
