import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.awt.*;
import java.nio.charset.Charset;
import javax.swing.*;
import java.awt.event.*;

public class Pergunta{
	private ImageIcon img;
	private String perg;
	private String resp[];
	private int correct;

	public Pergunta(ImageIcon i,String p,String r[],int crt){
		img=i; perg=p; resp=r; correct=crt;
	}

	public static Pergunta[] parseFile(Path f) throws IOException{
		ArrayList<Pergunta> arr = new ArrayList<>();

		String[] line;
		ImageIcon img;
		String perg;
		String resp[]=new String[4];
		int correct;
		
		for(String sc : Files.readAllLines(f)){
			line=sc.split(":")[1].split("&&");

			img=new ImageIcon("imgs/"+line[0]);
			perg=line[1];
			resp=new String[4];
			resp[0]=line[2];			
			resp[1]=line[3];			
			resp[2]=line[4];			
			resp[3]=line[5];			
			correct=Integer.parseInt(line[6]);
						
			arr.add(new Pergunta(img,perg,resp,correct));
		}

		return arr.toArray(new Pergunta[arr.size()]);
	}

	public ImageIcon getImage(){ return img;}
	public String getQuestion(){ return perg;}
	public String[] getAnswers(){ return resp;}
	public int getCorrectIndex(){ return correct;}

	@Override
	public String toString(){
		return img.toString()+"|"+perg+"|"+resp+"|"+correct;
	}
}
