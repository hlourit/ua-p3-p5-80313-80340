import java.util.*;

class ex11{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num_count = 0;
		boolean big = true;
		boolean small = true;
		String str = sc.nextLine();
		for(int i=0;i<str.length();i++){ //count
			char chr = str.charAt(i);
			if(Character.isDigit(chr)) num_count++;
			else if(Character.isUpperCase(chr)) small=false;
			else if(Character.isLowerCase(chr)) big=false;
		}

		System.out.printf("Number of digits: %d\n",num_count);
		System.out.printf("Is all upper case: %s\n", big? "True":"False");
		System.out.printf("Is all lower case: %s\n", small? "True":"False");
		System.out.printf("Number of words: %d\n", str.length()>0? str.split("\\s+").length:0);
		System.out.printf("New string: ");
		if(str.length()>1){
			for(int i=1;i<str.length();i=i+2){  //invert
				System.out.printf("%c",str.charAt(i));
				System.out.printf("%c",str.charAt(i-1));
			}
			if(str.length()%2!=0) System.out.printf("%c",str.charAt(str.length()-1));
		}
		System.out.printf("\n");
	}
}
