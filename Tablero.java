//terminado 06/09/2025
import java.util.*;
public class Tablero {
    private int filas;
    private int columnas;
    private ArrayList<Ficha> fichas;

    public Tablero(){

    }
    public Ficha[][] crearTablero(int filas, int columnas){
        //las filas y columnas deben de ser numeros multiplos de 2
        this.filas=filas;
        this.columnas=columnas;
        //creo el tablero de fichas
        Ficha[][] tablero= new Ficha[filas][columnas];

        //creo las fichas que ingresaré en el tablero//
        //como es un numero par, puedo dividir entre dos, para hacer pares
        fichas=new ArrayList<>();
        int numfichas= (filas*columnas)/2;
        //crear pares de fichas
        for (int i=0; i<numfichas;i++){
            //se crea una nueva ficha
            Ficha ficha1=new Ficha();
            ficha1.setId(i);
            ficha1.setImagen(i, false);
            ficha1.setEstado(false);
            // se agrega al arreglo de las fichas que usaré
            fichas.add(ficha1);

            //se crea una nueva ficha
            Ficha ficha2=new Ficha();
            ficha2.setId(i);
            ficha2.setImagen(i, false);
            ficha2.setEstado(false);
            // se agrega al arreglo de las fichas que usaré
            fichas.add(ficha2);
        }
        //se mezclan las fichas
        Collections.shuffle(fichas);

        //creo el tablero//
        int indice=0;
        for (int f=0; f<filas; f++){
            for (int c=0; c<columnas; c++){
                tablero[f][c]=fichas.get(indice++);
            }
        }
        
        return tablero;   
        
    }
    
}
