import java.util.*;
import java.io.*;

public class ScannerAbeirense implements Iterator<String>, Closeable{

	private Scanner sc;

	public ScannerAbeirense(String s){
		sc=new Scanner(s);
	}
	public ScannerAbeirense(InputStream s){
		sc=new Scanner(s);
	}
	public ScannerAbeirense(File s) throws FileNotFoundException{
		sc=new Scanner(s);
	}
	public boolean hasNext(){
		return sc.hasNextLine();
	}
	public String next(){
		return sc.nextLine().replace('v','b').replace('V','B');
	}
	public void close(){
		sc.close();
	}

	public static void main(String args[]){
		ScannerAbeirense a = new ScannerAbeirense("Ola sou aveirense!\nDaVeiro");
		System.out.printf("%s\n",a.next());
		System.out.printf("%s\n",a.next());
	}
}
