
import java.util.*;
import java.io.*;

public class ex71 {
    
    private static class Origem{
        String cidade;
        int voos=0;
        
        Origem(String c){
            cidade=c;
            voos=1;
        }
        
        void incVoos(){
            voos++;
        }
    }
    
    public static void main(String args[]) throws IOException {
        Sigla sl = Sigla.parseFile(new File("/home/manuel/Desktop/2Ano1Semestre/P3/P3-praticas/src/Aula07/ex71/companhias.txt"));
        ArrayList<Voo> voos = Voo.parseFile(new File("/home/manuel/Desktop/2Ano1Semestre/P3/P3-praticas/src/Aula07/ex71/voos.txt"), sl);

        Origem[] infoOrigem= printTabela(voos); //uso o a função que imprime as tabelas para me extrair um array das cidades origem

        Companhia[] atrasos = printTabelaToTxtFile(voos); //uso a função que guarda a informação num ficheiro de texto para extrair um array com as companhias e as médias dos atrasos
        
        printAtrasos(atrasos);
        
        fileOrigens(infoOrigem);
        
        
        
        
        
    }

    public static Origem[] printTabela(ArrayList<Voo> voos) {
        HashMap<String,Origem> tmp=new HashMap<>();
        System.out.println("Hora    Voo     Companhia           Origem                      Atraso    Obs");
        for (Voo voo : voos) {
            System.out.printf("%02d:%02d   %-8s%-20s%-29s", voo.time() / 60, voo.time() % 60, voo.id(), voo.cmp(), voo.orig());
            if(voo.t_atr()!=0)
                System.out.printf("%02d:%02d     Previsto: %02d:%02d", voo.t_atr() / 60, voo.t_atr() % 60, (voo.time() + voo.t_atr()) / 60, (voo.time() + voo.t_atr()) % 60);
            System.out.println();
            if(tmp.containsKey(voo.orig()))
                tmp.get(voo.orig()).incVoos();
            else
                tmp.put(voo.orig(), new Origem(voo.orig()));
        }
        
        return tmp.values().toArray(new Origem[tmp.values().size()]);
    }

    public static Companhia[] printTabelaToTxtFile(ArrayList<Voo> voos) throws FileNotFoundException {
        HashMap<String,Companhia> tmp=new HashMap<>();
        PrintWriter pwr = new PrintWriter(new File("/home/manuel/Desktop/2Ano1Semestre/P3/P3-praticas/src/Aula07/ex71/Infopublico.txt"));
        pwr.println("Hora    Voo     Companhia           Origem                      Atraso    Obs");
        for (Voo voo : voos) {
            pwr.printf("%02d:%02d   %-8s%-20s%-29s", voo.time() / 60, voo.time() % 60, voo.id(), voo.cmp(), voo.orig());
            if(voo.t_atr()!=0){
                pwr.printf("%02d:%02d     Previsto: %02d:%02d", voo.t_atr() / 60, voo.t_atr() % 60, (voo.time() + voo.t_atr()) / 60, (voo.time() + voo.t_atr()) % 60);
                if(tmp.containsKey((voo.cmp())))
                    tmp.get(voo.cmp()).addAtraso(voo.t_atr());
                else
                    tmp.put(voo.cmp(), new Companhia(voo.cmp(),voo.t_atr()));
            }
            pwr.println();
        }
        pwr.close();
        return tmp.values().toArray(new Companhia[tmp.values().size()]);
    }
    
    public static void printAtrasos(Companhia[] atrasos){
        sortAtrasos(atrasos);
        System.out.println("\nCompanhia           Média Atrasos:");
        for(Companhia comp:atrasos){
            System.out.printf("%-20s%02d:%02d\n", comp.nome(),comp.mediaAtrasos()/60,comp.mediaAtrasos()%60);
        }
    }
    
    private static void sortAtrasos(Companhia[] atrasos){
        for(int i=0;i<atrasos.length-1;i++)
            for(int j=i+1;j<atrasos.length;j++){
                if(atrasos[i].mediaAtrasos()>atrasos[j].mediaAtrasos()){
                    Companhia tmp=atrasos[i];
                    atrasos[i]=atrasos[j];
                    atrasos[j]=tmp;
                }
            }
    }
    
    public static void fileOrigens(Origem[] infoOrigem) throws FileNotFoundException{
        sortVoos(infoOrigem);
        PrintWriter pwr=new PrintWriter(new File("/home/manuel/Desktop/2Ano1Semestre/P3/P3-praticas/src/Aula07/ex71/cidades.txt"));
        pwr.println("Origem            Voos");
        for(Origem orig:infoOrigem){
            pwr.printf("%-20s%1d\n",orig.cidade,orig.voos);
        }
        pwr.close();
    }
    
    private static void sortVoos(Origem[] infoOrigem){
        for(int i=0;i<infoOrigem.length-1;i++)
            for(int j=i+1;j<infoOrigem.length;j++){
                if(infoOrigem[i].voos<infoOrigem[j].voos){
                    Origem tmp=infoOrigem[i];
                    infoOrigem[i]=infoOrigem[j];
                    infoOrigem[j]=tmp;
                }
            }
    }
}
