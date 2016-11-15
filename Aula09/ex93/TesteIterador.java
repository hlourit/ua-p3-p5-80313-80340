import java.util.*;
public abstract class TesteIterador {
	public static void main(String[] args) {
		VectorPessoas vp = new VectorPessoas();
		for (int i=0; i<10; i++)
			vp.addPessoa(new Pessoa("Bebé no Vector "+i,
						1000+i, Data.today()));
		Iterator<Pessoa> vec = vp.iterator();
		while ( vec.hasNext() )
			System.out.println( vec.next() );
		ListaPessoas lp = new ListaPessoas();
		for (int i=0; i<10; i++)
			lp.addPessoa(new Pessoa("Bebé na Lista "+i,
						2000+i, Data.today()));
		Iterator<Pessoa> lista = lp.iterator();
		while ( lista.hasNext() )
			System.out.println( lista.next() );
/////////////////////////////////////////////////////////
		System.out.println("--------------------------------------");
		BFIterator<Pessoa> BFvec = vp.BFiterator();
		while ( BFvec.hasNext() )
			System.out.println( BFvec.next() );
		System.out.println("=============");
		while ( BFvec.hasPrevious() )
			System.out.println( BFvec.previous() );

		BFIterator<Pessoa> BFlista = lp.BFiterator();
		while ( BFlista.hasNext() )
			System.out.println( BFlista.next() );
		System.out.println("=============");

		while ( BFlista.hasPrevious() )
			System.out.println( BFlista.previous() );
	}
}
