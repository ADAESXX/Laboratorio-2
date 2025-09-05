public class Jugar {
    private Jugador oponente;
    private Jugador jugador;
    private Tablero tablero;

    public Jugar(){

    }

    public void setOponente(Jugador newOponente){
        this.oponente=newOponente;
    }
    public Jugador getOponente(){
        return oponente;
    }


    public void setJugador(Jugador newJugador){
        this.jugador= newJugador;
    }
    public Jugador getJugador(){
        return jugador;
    }

    public void setTablero(int filas, int columnas){
        this.tablero=new Tablero(filas, columnas);
    }
    public Tablero getTablero(){
        return tablero;
    }
}
