
public class Cone extends GeladoDecorador{
    
    

    Cone(Gelado ice) {
        super(ice);
    }
    
    @Override
    public void base(int i) {
        myGelado.base(i);
        System.out.print(" em cone");
    }
    
}
