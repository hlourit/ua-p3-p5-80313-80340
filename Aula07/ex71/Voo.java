import java.util.*;
import java.io.*;

public class Voo{
	private int time;
	private String cmp;
	private	String id;
	private String orig;
	private int t_atr;

	public Voo(int t,String s,String n,String o,int ta){
		time=t;
		cmp=s;
		id=n;
		orig=o;
		t_atr=ta;
	}
        
        
        public int time(){
            return time;
        }
        
        public String cmp(){
            return cmp;
        }
        
        public String id(){
            return id;
        }
        
        public String orig(){
            return orig;
        }
        
        public int t_atr(){
            return t_atr;
        }
        
	public static ArrayList<Voo> parseFile(File fl,Sigla s) throws IOException{
		ArrayList<Voo> arr=new ArrayList<>();
		Scanner sc = new Scanner(fl);
		sc.nextLine();


		int tm;
		String sg;
		String tp;
		String or;
		int atm;

		String[] tmp;
		while(sc.hasNextLine()){
			tmp=sc.nextLine().split("\t");
			tm=Integer.parseInt(tmp[0].split(":")[0])*60+Integer.parseInt(tmp[0].split(":")[1]);	
			sg=s.slg.get(tmp[1].substring(0,2));
			tp=tmp[1];
			or=tmp[2];
			if(tmp.length==4)
				atm=Integer.parseInt(tmp[3].split(":")[0])*60+Integer.parseInt(tmp[3].split(":")[1]);	
			else atm=0;
			arr.add(new Voo(tm,sg,tp,or,atm));			

		}
		return arr;
	}
}
