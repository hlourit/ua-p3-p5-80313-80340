
public class Copo extends GeladoDecorador{
    
    public Copo(Gelado ice) {
        super(ice);
    }
    
    @Override
    public void base(int i) {
        myGelado.base(i);
        System.out.print(" em copo");
        
    }
    
}
