import java.util.*;

public class ListaPessoas{
	private LinkedList<Pessoa> arr = new LinkedList<>();

	public boolean addPessoa(Pessoa p){ return arr.add(p);}
	public boolean removePessoa(Pessoa p){ return arr.remove(p);}
	public int totalPessoas(){return arr.size();}
	public Iterator<Pessoa> iterator(){ return new VectorIterator();}
	public BFIterator<Pessoa> BFiterator(){ return new VectorBFIterator();}

	private class VectorIterator implements Iterator<Pessoa>{
		private Iterator<Pessoa> a = arr.iterator();
		
		public boolean hasNext(){ return a.hasNext();}
		public Pessoa next(){ return a.next();}
		public void remove(){ a.remove();}
	}	
	private class VectorBFIterator implements BFIterator<Pessoa>{
		private ListIterator<Pessoa> a = arr.listIterator();
		
		public boolean hasNext(){ return a.hasNext();}
		public Pessoa next(){ return a.next();}
        public boolean hasPrevious(){ return a.hasPrevious();} 
        public Pessoa previous(){ return a.previous();}

	}	
}
