public class Ficha {
    private String id;
    private String imagen;
    private boolean estado;

    public Ficha(){

    }

    public void setId(String newid){
        this.id=newid;
    }
    public String getId(){
        return id;
    }


    public void setImagen(String newimagen){
        this.imagen=newimagen;
    }
    public String getImagen(){
        return imagen;
    }


    public void setEstado(boolean newestado){
        this.estado=newestado;
    }
    public boolean getEstado(){
        return estado;
    }
}
