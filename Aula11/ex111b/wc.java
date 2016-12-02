import java.util.*;
import java.io.*;

public class wc{
	public static int[] count(String n) throws IOException{
		int[] ret = new int[2];
		int cnt=0;
		Set<String> s = new HashSet<String>();
		BufferedReader bf = new BufferedReader(new FileReader(n));
		String[] arr;
		//while(bf.ready()&&(cnt+=bf.readLine().split(" ").length)>0);
		while(bf.ready()){
			for(String a : bf.readLine().split(" ")){
				cnt++;
				s.add(a);
			}
		}
		
		System.out.printf("%d,%d\n",cnt,s.size());
		ret[0]=s.size();
		ret[1]=cnt;
		return ret;
	}
	public static void main(String args[]) throws IOException{
		count(args[0]);
	}
}
