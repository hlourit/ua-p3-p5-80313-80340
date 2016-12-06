import java.io.*;
import java.util.*;

public class ex123{
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
		vc.writeToFile(agd,new File("./vCard"));
		cc.writeToFile(agd,new File("./CSV"));

		Agenda agd1 = new Agenda(); 
		Agenda agd2 = new Agenda(); 
		Agenda agd3 = new Agenda(); 

		agd1.addEntradas(new File("./nokia"));
		agd2.addEntradas(new File("./vCard"));
		agd3.addEntradas(new File("./CSV"));

		System.out.printf("%s\n",agd1.toString());	
		System.out.printf("%s\n",agd2.toString());	
		System.out.printf("%s\n",agd3.toString());	
	}
}
