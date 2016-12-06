import java.text.*;
import java.io.*;
import java.util.*;

public class CSVCont implements IOagenda{

	public void writeToFile(Agenda a,File f) throws IOException{
		PrintWriter pw = new PrintWriter(f);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		pw.printf("CSV\n");
		Entrada b[] = a.toArray();
		for(Entrada ent : b)
			pw.printf("%s\t%d\t%s\n",ent.getName(),ent.getNum(),df.format(ent.getBirthD()));
		pw.close();
	}
	public Agenda readFile(File f) throws Exception{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Agenda ag = new Agenda();
		Scanner sc = new Scanner(f);
		String[] tmpString;
		if(!sc.nextLine().equals("CSV")) throw new Exception("Wrong format");
		while(sc.hasNextLine()){
			tmpString=sc.nextLine().split("\t");
			ag.addEntrada(new Entrada(tmpString[0],Integer.parseInt(tmpString[1]),df.parse(tmpString[2])));
		}
		return ag;
	}
}  
