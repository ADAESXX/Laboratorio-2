import java.util.*;
public class Tablero {
    private int filas;
    private int columnas;
    private ArrayList<Ficha> fichas;

    public Tablero(int filas, int columnas){
        this.filas=filas;
        this.columnas=columnas;
        fichas= new ArrayList<>();
        
    }
}
