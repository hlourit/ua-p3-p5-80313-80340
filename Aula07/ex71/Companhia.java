
public class Companhia {
    private final String nome;
    private int mediaAtrasos;
    private int nrAtrasos=1;
    
    public Companhia(String n,int m_a){
        nome=n;
        mediaAtrasos=m_a;
    }
    
    public String nome(){
        return nome;
    }
    
    public void addAtraso(int a){
        
        mediaAtrasos=(mediaAtrasos+a)/++nrAtrasos;
    }
    
    public int mediaAtrasos(){
        return mediaAtrasos;
    }
}
