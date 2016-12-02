import java.util.Comparator;
import java.util.List;

public class Ex112 {
    private static Figure maiorFiguraJ7(List<Figure> figs) {
        
        
        Figure maior = figs.get(0);
        for (Figure f : figs) {
            if (f.compareTo(maior) > 1) {
                maior = f;
            }
        }
        return maior;
    }
    
    private static Figure maiorFiguraJ8(List<Figure> figs) {
        return figs.stream().max(Figure::compareTo).get();
    }
    
    private static Figure maiorFiguraJ8_perimetro(List<Figure> figs) {
        return figs.stream().max(Comparator.comparing(Figure::perimeter)).get();
    }
    
    private static double totalAreaJ8(List<Figure> figs) {
        return figs.stream().mapToDouble(Figure::area).reduce(0, (a,b)->a+b);
    }
    
    private static double totalAreaJ8(List<Figure> figs,String type) {
        return figs.stream().filter(f->f.getClass().equals(type)).mapToDouble(Figure::area).reduce(0, (a,b)->a+b);
    }
    
    
}
