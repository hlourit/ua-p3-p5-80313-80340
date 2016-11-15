public interface BFIterator<E> {
	boolean hasPrevious();
	E previous();
	boolean hasNext();
	E next();
}
