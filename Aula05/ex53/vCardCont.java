import java.text.*;
import java.io.*;
import java.util.*;

public class vCardCont implements IOagenda{

	public void writeToFile(Agenda a,File f) throws IOException{
		PrintWriter pw = new PrintWriter(f);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		pw.printf("vCard\n");
		Entrada b[] = a.toArray();
		for(Entrada ent : b)
			pw.printf("#%s#%d#%s\n",ent.getName(),ent.getNum(),df.format(ent.getBirthD()));
		pw.close();
	}
	public Agenda readFile(File f) throws Exception{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Agenda ag = new Agenda();
		Scanner sc = new Scanner(f);
		String[] tmpString;
		if(!sc.nextLine().equals("vCard")) throw new Exception("Wrong format");
		while(sc.hasNextLine()){
			tmpString=sc.nextLine().split("#");
			ag.addEntrada(new Entrada(tmpString[1],Integer.parseInt(tmpString[2]),df.parse(tmpString[3])));
		}
		return ag;
	}
}  
