import java.util.*;

public class ListaGeneric<T>{
	private LinkedList<T> arr = new LinkedList<>();

	public boolean addElem(T p){ return arr.add(p);}
	public boolean remove(T p){ return arr.remove(p);}
	public int total(){return arr.size();}
	public Iterator<T> iterator(){ return new VectorIterator();}
	public BFIterator<T> BFiterator(){ return new VectorBFIterator();}

	private class VectorIterator implements Iterator<T>{
		private Iterator<T> a = arr.iterator();
		
		public boolean hasNext(){ return a.hasNext();}
		public T next(){ return a.next();}
		public void remove(){ a.remove();}
	}	
	private class VectorBFIterator implements BFIterator<T>{
		private ListIterator<T> a = arr.listIterator();
		
		public boolean hasNext(){ return a.hasNext();}
		public T next(){ return a.next();}
        public boolean hasPrevious(){ return a.hasPrevious();} 
        public T previous(){ return a.previous();}

	}	
}
