import java.util.*;
import java.io.*;

public class wc{
	public static int[] count(String n) throws IOException{
		int[] ret = new int[2];
		int cnt=0;
		Map<String,Integer> s = new HashMap<>();
		BufferedReader bf = new BufferedReader(new FileReader(n));
		String[] arr;

		while(bf.ready()){
			for(String a : bf.readLine().split(" ")){
				if(!s.containsKey(a))
					s.put(a,1);
				else
					s.put(a,s.get(a)+1);
			}
		}
		
		System.out.printf("%s\n",s.toString());
		ret[0]=s.size();
		ret[1]=cnt;
		return ret;
	}
	public static void main(String args[]) throws IOException{
		count(args[0]);
	}
}
