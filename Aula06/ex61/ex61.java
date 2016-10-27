import java.util.*;
import java.io.*;
public class ex61{
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args){
		LinkedList<Alimento> alimentos = new LinkedList<>();
		LinkedList<Prato> pratos = new LinkedList<>();
		Ementa em = new Ementa(args[0],args[1]);

		while(true){
			show();
			switch(rcvInt()){
				case 0:
					return;
				case 1:
					{ //using scopes for simplicity
						System.out.printf("\nVariedade:");
						VariedadeCarne vc = rcvVariedadeCarne();
						System.out.printf("\nProteinas:");
						double prt = rcvDouble();
						System.out.printf("\nCalorias:");
						double cal = rcvDouble();
						System.out.printf("\nPeso:");
						double pes = rcvDouble();
						alimentos.add(new Carne(vc,prt,cal,pes));
					}
					break;
				case 2:
					{
						System.out.printf("\nTipo:");
						TipoPeixe tp = rcvTipoPeixe();
						System.out.printf("\nProteinas:");
						double prt = rcvDouble();
						System.out.printf("\nCalorias:");
						double cal = rcvDouble();
						System.out.printf("\nPeso:");
						double pes = rcvDouble();
						alimentos.add(new Peixe(tp,prt,cal,pes));
					}
					break;
				case 3:
					{
						System.out.printf("\nNome:");
						String nm = rcvString();
						System.out.printf("\nProteinas:");
						double prt = rcvDouble();
						System.out.printf("\nCalorias:");
						double cal = rcvDouble();
						System.out.printf("\nPeso:");
						double pes = rcvDouble();
						alimentos.add(new Cereal(nm,prt,cal,pes));
					}
					break;
				case 4:
					{
						System.out.printf("\nNome:");
						String nm = rcvString();
						System.out.printf("\nProteinas:");
						double prt = rcvDouble();
						System.out.printf("\nCalorias:");
						double cal = rcvDouble();
						System.out.printf("\nPeso:");
						double pes = rcvDouble();
						alimentos.add(new Legume(nm,prt,cal,pes));
					}
					break;
				case 5:
					{
						System.out.printf("\n==================");
						int i=0;
						for(Alimento a : alimentos)
							System.out.printf("\n%d-> %s",i++,a.toString());
						System.out.printf("\n==================\n");
					}
					break;	
				case 6:
					{
						System.out.printf("\nNome:");
						String nm = rcvString();
						pratos.add(new Prato(nm));
					}
					break;
				case 7:
					{
						System.out.printf("\nID: ");
						pratos.remove(rcvValidPos(pratos.size()));	
					}
					break;
				case 8:
					{
						System.out.printf("\nPrato id: ");
						int ida=rcvValidPos(pratos.size());	
						System.out.printf("\nIngredente id: ");
						int idb=rcvValidPos(alimentos.size());	
						pratos.get(ida).addIngrediente(alimentos.get(idb));
					}
					break;
				case 9:
					{
						System.out.printf("\nPrato id: ");
						int ida=rcvValidPos(pratos.size());	
						System.out.printf("\nId relativo do ingredente: ");
						int idb=rcvValidPos(pratos.get(ida).alimentos().length);	
						pratos.get(ida).removeIngrediente(idb);
					}
					break;
				case 10:
					{
						System.out.printf("\n==================");
						int i=0;
						for(Prato a : pratos)
							System.out.printf("\n%d-> %s",i++,a.toString());
						System.out.printf("\n==================\n");
					}
					break;
				case 11:
					{
						System.out.printf("\nId:");
						int id=rcvValidPos(pratos.size());
						System.out.printf("\nDia da semana:");
						em.addPrato(pratos.get(id),rcvDiaSemana());
					}
					break;
				case 12:
					{
						System.out.printf("\nId:");
						em.removePrato(rcvValidPos(em.pratos().length));
					}
					break;
				case 13:
					{
						System.out.printf("\n==================");
						System.out.printf("\n%s",em.toString());
						System.out.printf("\n==================\n");
					}
					break;
				case 14:
					{
						System.out.printf("\nNome do ficheiro:");
						if(saveToFile(rcvString(),em))
							System.out.printf("Success!\n");
						else
							System.out.printf("Failed\n");
					}
					break;
				case 15:
					{
						System.out.printf("\nNome do ficheiro:");
						Ementa tmp=loadFromFile(rcvString());
						if(tmp!=null){
							System.out.printf("Success!\n");
							em=tmp;
						}
						else
							System.out.printf("Failed\n");
					}
			}
		}
	}
	private static int rcvValidPos(int size){
		try{
			int a=Integer.parseInt(sc.nextLine());
			if(a<size) return a;
			return rcvValidPos(size);
		}
		catch(Exception e){
			return rcvValidPos(size); //too ugly?
		}
	}
	private static String rcvString(){
		return sc.nextLine();
	}
	private static int rcvInt(){
		try{
			return Integer.parseInt(sc.nextLine());
		}
		catch(Exception e){
			return rcvInt(); //too ugly?
		}
	}
	private static double rcvDouble(){
		try{
			return Double.parseDouble(sc.nextLine());
		}
		catch(Exception e){
			return rcvDouble(); //too ugly?
		}
	}
	private static DiaSemana rcvDiaSemana(){
		try{
			return DiaSemana.valueOf(sc.nextLine());
		}
		catch(Exception e){
			return rcvDiaSemana(); //too ugly?
		}
	}
	private static VariedadeCarne rcvVariedadeCarne(){
		try{
			return VariedadeCarne.valueOf(sc.nextLine());
		}
		catch(Exception e){
			return rcvVariedadeCarne(); //too ugly?
		}
	}
	private static TipoPeixe rcvTipoPeixe(){
		try{
			return TipoPeixe.valueOf(sc.nextLine());
		}
		catch(Exception e){
			return rcvTipoPeixe(); //too ugly?
		}
	}
	private static boolean saveToFile(String name,Ementa em){
		try{
			FileOutputStream out = new FileOutputStream(name); 
			ObjectOutputStream os = new ObjectOutputStream(out); 
			os.writeObject("Ementa"); 
			os.writeObject(em); 
			os.flush();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	private static Ementa loadFromFile(String name){

		try{
			FileInputStream in = new FileInputStream(name); 
			ObjectInputStream ins = new ObjectInputStream(in); 
			if(((String)ins.readObject()).equals("Ementa"))
				return (Ementa)ins.readObject();
			return null;
		}
		catch(Exception e){
			return null;
		}
	}
	private static void show() {
		System.out.printf("\nIngrediente\n>1-Adicionar Carne\n>2-Adicionar Peixe\n>3-Adicionar Cereal\n>4-Adicionar Legume\n>5-Listar Ingredientes");
		System.out.printf("\nPrato\n>6-Criar prato\n>7-Remover prato\n>8-Adicionar Ingrediente\n>9-Remover Ingrediente\n10>Listar Pratos");
		System.out.printf("\nEmenta\n>11-Adicionar Prato\n>12-Remover Prato\n>13-Listar Ementa");
		System.out.printf("\nIO\n>14-Save to file\n>15-Load from file\n>0-Exit\n");
	}
}
//Programa de testes, nothing special down there...
/*	public static void test(String[] args) throws Exception{
		Ementa em = fillWithCrap();
		System.out.printf("%s\n",em.toString());

		//write to file
		FileOutputStream out = new FileOutputStream("Ementa"); 
		ObjectOutputStream os = new ObjectOutputStream(out); 
		os.writeObject("Ementa"); 
		os.writeObject(em); 
		os.flush();

		//read from file
		FileInputStream in = new FileInputStream("Ementa"); 
		ObjectInputStream ins = new ObjectInputStream(in); 
		
		if(((String)ins.readObject()).equals("Ementa"))
			System.out.printf("%s\n",(Ementa)ins.readObject());
	}

	public static Ementa fillWithCrap(){
        Ementa ementa = new Ementa("Java", "8"); 
		//hehe, java is crap :p
        Prato[] pratos = new Prato[10];
        for (int i=0; i < pratos.length; i++){
            pratos[i] = randPrato(i);
            int cnt = 0;
            while (cnt <2){ // Adicionar 2 Ingredientes a cada Prato
                Alimento aux = randAlimento();
                if (pratos[i].addIngrediente(aux))
                    cnt++;
            }
            ementa.addPrato(pratos[i], DiaSemana.rand()); // Dia Aleatório
        }
		return ementa;
    }
    // Retorna um Alimento Aleatoriamente
    public static Alimento randAlimento() {
        switch ((int) (Math.random() * 4)) {
            default:
            case 0:
                return new Carne(VariedadeCarne.frango, 22.3, 345.3, 300);
            case 1:
                return new Peixe(TipoPeixe.congelado, 31.3, 25.3, 200);
            case 2:
                return new Legume("Couve Flor", 21.3, 22.4, 150);
            case 3:
                return new Cereal("Milho", 19.3, 32.4, 110);
        }
    }
    // Retorna um Tipo de Prato Aleatoriamente
    public static Prato randPrato(int i) {
        switch ((int) (Math.random() * 3)) {
            default:
            case 0:
                return new Prato("Prato N." + i);
            case 1:
                return new PratoVegetariano("Prato N." + i + " (Vegetariano)");
            case 2:
                return new PratoDieta("Prato N." + i + " (Dieta)", 90.8);
        }
    }		
*/
