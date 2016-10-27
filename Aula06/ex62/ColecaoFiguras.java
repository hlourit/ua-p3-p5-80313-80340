

import java.util.ArrayList;

public class ColecaoFiguras {
    private ArrayList<Figure> colecao;
    private final double maxArea;
    
    public ColecaoFiguras(double maxArea){
        this.maxArea=maxArea;
        colecao=new ArrayList<Figure>();
    }
    
    public boolean addFigura(Figure f){
        if(colecao.contains(f) || areaTotal()+f.area()>maxArea)
            return false;
        colecao.add(f);
        return true;
        
    }
    
    public boolean delFigura(Figure f){
        return colecao.remove(f);
    }
    
    public  double areaTotal(){
        double soma=0;
        for(Figure f:colecao)
            soma+=f.area();
        return soma;
    }
    
    public boolean exists(Figure f){
        return colecao.contains(f);
    }
    
    @Override
    public String toString(){
        return String.format("ColecaoFiguras, %d elementos, area total: %2.1f, area maxima: %2.1f\n", colecao.size(),areaTotal(),maxArea);
    }
    
    public Figure[] getFiguras(){
        return colecao.toArray(new Figure[colecao.size()]);
    }
    
    public Ponto[] getCentros(){
        Ponto[] p=new Ponto[colecao.size()];
        for(int i=0;i<colecao.size();i++){
            p[i]=colecao.get(i).centro();
        }
        return p;
    }
    
    
}
