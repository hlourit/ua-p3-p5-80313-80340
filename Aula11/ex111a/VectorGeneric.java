import java.util.*;

public class VectorGeneric<T>{
	private ArrayList<T> arr = new ArrayList<>();

	public boolean addElem(T p){ return arr.add(p);}
	public boolean removeElem(T p){ return arr.remove(p);}
	public int totalElem(){return arr.size();}
	public Iterator<T> iterator(){ return new VectorIterator();}
	public BFIterator<T> BFiterator(){ return new VectorBFIterator();}

	public class VectorIterator implements Iterator<T>{
		private Iterator<T> a = arr.iterator();
		
		public boolean hasNext(){ return a.hasNext();}
		public T next(){ return a.next();}
		public void remove(){ a.remove();}
	}	
	public class VectorBFIterator implements BFIterator<T>{
		private ListIterator<T> a = arr.listIterator();
	
		public boolean hasPrevious(){ return a.hasPrevious();}	
		public boolean hasNext(){ return a.hasNext();}
		public T next(){ return a.next();}
		public T previous(){ return a.previous();}
	}
}
