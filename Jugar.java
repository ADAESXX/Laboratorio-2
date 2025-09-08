public class Jugar {
    private Jugador oponente;
    private Jugador jugador;
    private Ficha[][] tablero;
    private Jugador turnoActual;

    public Jugar(){
    	oponente=null;
    	jugador=null;
    }

    public void setOponente(Jugador newOponente){
        this.oponente=newOponente;
        this.oponente.setPunteo(0);
    }
    public Jugador getOponente(){
        return oponente;
    }


    public void setJugador(Jugador newJugador){
        this.jugador= newJugador;
        //se define que este será el primero en jugar
        this.turnoActual=jugador;
        this.jugador.setPunteo(0);
    }
    public Jugador getJugador(){
        return jugador;
    }

    public void setTurnoActual(Jugador newturnoactual){
        this.turnoActual= newturnoactual;
    }
    public Jugador getTurnoActual(){
        return turnoActual;
    }

    public void setTablero(int filas, int columnas){
        Tablero t=new Tablero();
        this.tablero= t.crearTablero(filas, columnas);
    }
    public Ficha[][] getTablero(){
        return tablero;
    }

    public void cambiarTurno(){
        if (turnoActual==jugador){
            turnoActual=oponente;
        }
        else{
            turnoActual=jugador;
        }
    }
    
    
    // f1 y c1 corresponden a las coordenadas de la ficha en el tablero
    // f2 y c2 corresponden a las coordenadas de la ficha en el tablero
    public boolean jugarTurno(int f1, int c1, int f2, int c2){
        //creacion de fichas a evaluar
        Ficha ficha1= tablero[f1][c1];
        Ficha ficha2= tablero[f2][c2];

        //se destapan
        ficha1.setEstado(true);
        ficha2.setEstado(true);
        // si son iguales suma el punto
        if (ficha1.getId()==ficha2.getId()){
            turnoActual.setPunteo(turnoActual.getPunteo()+1);
            //permite que se conserve el turno
            return true;
        }
        else{
            ficha1.setEstado(false);
            ficha2.setEstado(false);
            cambiarTurno();
            //cambia de turno
            return false;
        }
    }

    public boolean juegoTerminado(){
        for (int f=0; f<tablero.length; f++){
            for (int c=0; c<tablero[0].length; c++){
                if (tablero[f][c].getEstado()==false){
                    return false;
                }
            }
        }
        return true;
    }

    public Jugador determinarGanador(){
        if(jugador.getPunteo()>oponente.getPunteo()){
            return jugador;
        }
        else if (jugador.getPunteo()<oponente.getPunteo()) {
            return oponente;
        }
        else{
            //esto indica el empate :)
            return null;
        }
    }
}
