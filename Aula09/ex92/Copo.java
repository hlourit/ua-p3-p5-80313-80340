
public class Copo implements Gelado{
    
    Gelado myGelado;
    
    public Copo(Gelado ice) {
        myGelado=ice;
    }
    
    @Override
    public void base(int i) {
        myGelado.base(i);
        System.out.print(" em copo");
        
    }
    
}
