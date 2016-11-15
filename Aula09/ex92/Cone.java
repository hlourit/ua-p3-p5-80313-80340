
public class Cone implements Gelado {
    
    
    private Gelado myGelado;
    

    Cone(Gelado ice) {
        myGelado=ice;
    }
    
    @Override
    public void base(int i) {
        myGelado.base(i);
        System.out.print(" em cone");
    }
    
}
