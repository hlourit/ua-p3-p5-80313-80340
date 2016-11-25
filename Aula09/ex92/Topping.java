
public class Topping extends GeladoDecorador{
    
    private String topping;
    
    public Topping(Gelado ice, String topping) {
        super(ice);
        this.topping=topping;
        
    }



    @Override
    public void base(int i) {
        myGelado.base(i);
        System.out.print(" com "+topping);
    }
    
}
