import java.util.*;
import java.io.*;

public class Sigla{
	public HashMap<String,String> slg;

	public static Sigla parseFile(File fl) throws IOException{
		Sigla sig=new Sigla();
		sig.slg=new HashMap<>();
		Scanner sc = new Scanner(fl);
		String[] tmp;
		sc.nextLine(); //deletes first line
		while(sc.hasNextLine()){
			tmp=sc.nextLine().split("\t");
			sig.slg.put(tmp[0],tmp[1]);
		}
		System.out.printf("%s\n",sig.slg.toString());
		return sig;
	}
}
