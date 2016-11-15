
public class Topping implements Gelado {
    
    private Gelado myGelado;
    private String topping;
    
    public Topping(Gelado ice, String topping) {
        myGelado=ice;
        this.topping=topping;
        
    }



    @Override
    public void base(int i) {
        myGelado.base(i);
        System.out.print(" com "+topping);
    }
    
}
