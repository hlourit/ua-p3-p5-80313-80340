import java.util.*;

public class ex12{

	//The buffer needs to be cleared after every nextInt()

	private static Scanner sc = new Scanner(System.in);

	private static int menu_Handler(){
		System.out.printf("\nSelect an option:\n");
		System.out.printf("1-Add entry\n2-Remove entry\n3-Print list by name\n4-Print list by cc\n0-Exit\n");
		System.out.printf("Option->");
		return sc.nextInt();
	}
	private static void addEntry(ArrayList<Pessoa> pss){
		String tmp_name;
		int tmp_cc;
		String tmp_str_data[]= new String[3];
		Data tmp_data;

		try{
			System.out.printf("\nEnter name:");
			tmp_name=sc.nextLine();
			System.out.printf("Enter CC:");
			tmp_cc=sc.nextInt();
		}
		catch(Exception e){
			sc.nextLine(); //buffer clear
			System.out.printf("Bad input. Please try again.\n");
            //addEntry(pss);
            return;
	
		}
		try{
			sc.nextLine(); //buffer clear
			System.out.printf("Enter date (DD/MM/YYYY):");
			tmp_str_data=sc.nextLine().split("/");
			tmp_data=new Data(Integer.parseInt(tmp_str_data[0]),Integer.parseInt(tmp_str_data[1]),Integer.parseInt(tmp_str_data[2]));
		}
		catch(Exception e){
			System.out.printf("Bad input. Please try again.\n");
			//addEntry(pss);
			return;
		}
		pss.add(new Pessoa(tmp_name,tmp_cc,tmp_data));
		System.out.printf("Entry added.\n");
			
	}
	public static void removeEntry(ArrayList<Pessoa> pss){
		System.out.printf("\nEnter name or CC:");
		String str_id=sc.nextLine();
		try{
			int cc=Integer.parseInt(str_id);
			for(Pessoa ps : pss){
				if(ps.getCc()==cc){
					pss.remove(ps);
					System.out.printf("Done.\n");
					return;
				}
			}
		}
		catch(Exception e){
			for(Pessoa ps : pss){
				if(ps.getNome().equals(str_id)){
					pss.remove(ps);
					System.out.printf("Done.\n");
					return;
				}
			}
		}
		System.out.printf("No entry found.\n");
	}
	public static void printEntries(ArrayList<Pessoa> pss){
		System.out.printf("\n==========\n");
		for(Pessoa ps : pss){
			System.out.printf("%s\n==========\n",ps.toString());	
		}
	}
	private static Comparator<Pessoa> compareCC = new Comparator<Pessoa>() {
        
        @Override
        public int compare(Pessoa p1,Pessoa p2){
            return p1.getCc()-p2.getCc();
        }
    };
    private static Comparator<Pessoa> compareNome = new Comparator<Pessoa>() {
        
        @Override
        public int compare(Pessoa p1,Pessoa p2){
            return p1.getNome().compareToIgnoreCase(p2.getNome());
        }
    };
	public static void main(String[] args){
		ArrayList<Pessoa> pessoas=new ArrayList<>();
		int option=-1;

		while(option!=0){//asd

			option=menu_Handler();
			sc.nextLine(); //buffer clear			
	
			switch(option){
				
				case 1:
					addEntry(pessoas);
					break;
				case 2:
					removeEntry(pessoas);
					break;
				case 3:
					pessoas.sort(compareNome);
					printEntries(pessoas);
					break;
				case 4:
					pessoas.sort(compareCC);
					printEntries(pessoas);
					break;
			}
		}
	}
}
