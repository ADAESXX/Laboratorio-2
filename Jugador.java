//terminado 05/09/2025
public class Jugador {
    private String nombre;
    private int punteo;

    public Jugador(){

    }


    public void setNombre(String newnombre){
        this.nombre=newnombre;
    }
    public String getNombre(){
        return nombre;
    }

    public void setPunteo(int newpunteo){
        this.punteo=newpunteo;
    }
    public int getPunteo(){
        return punteo;
    }
}
