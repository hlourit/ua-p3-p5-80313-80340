
public class GeladoSimples implements Gelado {
    
    private String sabor;
    
    public GeladoSimples(String sabor) {
        this.sabor=sabor;
    }

    public void base(int i){
        System.out.print("\n"+i+" bola");
        if(i>1)
            System.out.print("s");
        System.out.print(" de gelado ");
        System.out.print(" "+sabor);
    }

}
