import java.io.*;
import java.util.*;

public class ex53{
	public static void main(String[] args) throws Exception{
		Agenda agd = new Agenda();
		NokiaCont nc = new NokiaCont();
		vCardCont vc = new vCardCont();
		CSVCont cc = new CSVCont();

		agd.addEntrada(new Entrada("joao",1324,new Date(34)));
		agd.addEntrada(new Entrada("fdsoao",13224,new Date(31345434)));
		agd.addEntrada(new Entrada("joqe5ho",137324,new Date(23732734)));
		agd.addEntrada(new Entrada("jsdfgo",136524,new Date(7236734)));

		System.out.printf("%s\n",agd.toString());	

		nc.writeToFile(agd,new File("./nokia"));
		Agenda agd1=nc.readFile(new File("./nokia"));
		System.out.printf("%s\n",agd1.toString());	

		vc.writeToFile(agd,new File("./vCard"));
		Agenda agd2 = vc.readFile(new File("./vCard"));
		System.out.printf("%s\n",agd2.toString());	

		cc.writeToFile(agd,new File("./CSV"));
		Agenda agd3 = cc.readFile(new File("./CSV"));
		System.out.printf("%s\n",agd3.toString());	
	
	}
}
