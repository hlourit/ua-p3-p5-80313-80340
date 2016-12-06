public class UtilCompare{
	
	public static <T> void sortArray(Comparable<T>[] t){
		int i=t.length-1;
		boolean houveTrocas=false;
		do{
			houveTrocas=false;
			for(int n=0;n<i;n++){
				if(t[n].compareTo(((T)t[n+1]))>0){
					Comparable<T> tmp=t[n];
					t[n]=t[n+1];
					t[n+1]=tmp;
					houveTrocas=true;
				}
			}
			i--;
		}while(houveTrocas);
	}
}
