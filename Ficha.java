//terminado 06/09/2025

public class Ficha {
    private int id;
    private String imagen;
    private boolean estado;

    public Ficha(){
        id=-1;
        estado=false;
    }

    public void setId(int newid){
        this.id=newid;
    }
    public int getId(){
        return id;
    }

    // este estado es de si esta volteada o no
    public void setImagen(int newid, boolean newestado){
        if (newestado==true){
            String[] iconos={"🥰","😴","🤠","🤖","👻","😺","🐯","🐺","🦒","🦊","🐭","🐻‍❄️","🐻","🐔","🫏","🫎","🐒","🐎","🐆","🐑","🦥","🐊","🦖","🐢","🦈","🐬","🦭","🐡","🕊️","🐦"};
            this.imagen=iconos[newid];
        }
        else{
            this.imagen="🀄";
        }

    }
    public String getImagen(){
        return imagen;
    }

    // este estado es si ya esta emparejada o no
    public void setEstado(boolean newestado){
        this.estado=newestado;
    }
    public boolean getEstado(){
        return estado;
    }
}
