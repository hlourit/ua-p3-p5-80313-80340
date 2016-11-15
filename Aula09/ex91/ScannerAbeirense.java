
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;


public class ScannerAbeirense implements Iterator<String>, Closeable {
    
    private Scanner sc;
    
    public static void main(String[] args) {
        ScannerAbeirense s= new ScannerAbeirense("Vi uma Viviana em Viana em Novembro.");
        while(s.hasNext()){
            System.out.print(s.next()+" ");
        }
        System.out.println();
    }
    
    public ScannerAbeirense(String s){
        sc=new Scanner(s);
    }
    
    public ScannerAbeirense(InputStream i){
        sc=new Scanner(i);
    }
    
    public ScannerAbeirense(File f) throws FileNotFoundException{
        sc=new Scanner(f);
    }
    
    public boolean hasNext(){
        return sc.hasNext();
    }
    
    public String next(){
        String tmp=sc.next();
        tmp=tmp.replaceAll("v", "b");
        tmp=tmp.replaceAll("V", "B");
        return tmp;
    }
    
    public String nextLine(){
        String tmp=sc.nextLine();
        tmp=tmp.replaceAll("v", "b");
        tmp=tmp.replaceAll("V", "B");
        return tmp;
    }
    
    public void close(){
        sc.close();
    }
    
}
