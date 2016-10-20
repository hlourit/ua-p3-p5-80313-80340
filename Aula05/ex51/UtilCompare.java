public abstract class UtilCompare{
	
	public static Comparable findMax(Comparable[] t){
		Comparable max = t[0];
		for(Comparable c:t)
			if(c.compareTo(max)>0)
				max=c;
		return max;
	}
	
	public static void sortArray(Comparable[] t){
		int i=t.length-1;
		boolean houveTrocas=false;
		do{
			houveTrocas=false;
			for(int n=0;n<i;n++){
				if(t[n].compareTo(t[n+1])>0){
					Comparable tmp=t[n];
					t[n]=t[n+1];
					t[n+1]=tmp;
					houveTrocas=true;
				}
			}
			i--;
		}while(houveTrocas);
	}
}
