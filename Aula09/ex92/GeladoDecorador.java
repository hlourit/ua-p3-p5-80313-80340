
public class GeladoDecorador implements Gelado {
    
    protected Gelado myGelado;

    public GeladoDecorador(Gelado myGelado) {
        this.myGelado = myGelado;
    }
    
    
    @Override
    public void base(int i){
        myGelado.base(i);
    }
    
}
