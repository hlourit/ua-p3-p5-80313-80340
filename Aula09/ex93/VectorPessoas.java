import java.util.*;

public class VectorPessoas{
	private ArrayList<Pessoa> arr = new ArrayList<>();

	public boolean addPessoa(Pessoa p){ return arr.add(p);}
	public boolean removePessoa(Pessoa p){ return arr.remove(p);}
	public int totalPessoas(){return arr.size();}
	public Iterator<Pessoa> iterator(){ return new VectorIterator();}
	public BFIterator<Pessoa> BFiterator(){ return new VectorBFIterator();}

	public class VectorIterator implements Iterator<Pessoa>{
		private Iterator<Pessoa> a = arr.iterator();
		
		public boolean hasNext(){ return a.hasNext();}
		public Pessoa next(){ return a.next();}
		public void remove(){ a.remove();}
	}	
	public class VectorBFIterator implements BFIterator<Pessoa>{
		private ListIterator<Pessoa> a = arr.listIterator();
	
		public boolean hasPrevious(){ return a.hasPrevious();}	
		public boolean hasNext(){ return a.hasNext();}
		public Pessoa next(){ return a.next();}
		public Pessoa previous(){ return a.previous();}
	}
}
