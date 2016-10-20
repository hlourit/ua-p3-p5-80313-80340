import java.text.*;
import java.io.*;
import java.util.*;

public class NokiaCont implements IOagenda{

	public void writeToFile(Agenda a,File f) throws IOException{
		PrintWriter pw = new PrintWriter(f);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		pw.printf("Nokia\n");
		Entrada b[] = a.toArray();
		for(Entrada ent : b)
			pw.printf("%s\n%d\n%s\n\n",ent.getName(),ent.getNum(),df.format(ent.getBirthD()));
		pw.close();
	}
	public Agenda readFile(File f) throws Exception{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Agenda ag = new Agenda();
		Scanner sc = new Scanner(f);
		String tmpName;
		int tmpNum;
		Date tmpDate;
		if(!sc.nextLine().equals("Nokia")) throw new Exception("Wrong format");
		while(sc.hasNextLine()){
			tmpName=sc.nextLine();	
			if(tmpName.length()==0) continue;
			tmpNum=Integer.parseInt(sc.nextLine());	
			tmpDate=df.parse(sc.nextLine());	
			ag.addEntrada(new Entrada(tmpName,tmpNum,tmpDate));
		}
		return ag;
	}
}  
