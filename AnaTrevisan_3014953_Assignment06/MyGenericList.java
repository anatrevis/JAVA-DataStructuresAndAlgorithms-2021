package AnaTrevisan_3014953_Assignment06;
/*
 * NewNumbers.java
 * 
 */

import java.util.*;
import java.util.function.*;
class MyGenericList<E> implements Iterable<E>{
	private List<E> data = new LinkedList<>();

	public void add(E x){
		if(x != null)
			data.add(x);
	}

	public void add(List<E> ls){
		if(ls == null)
			return;
		for(E x : ls)
			data.add(x);
	}

	public boolean contains(Predicate<E> pr){
		for(E x : data) if(pr.test(x)) return true;
		return false;
	}

	public List<E> filterList(Predicate<E> pr){
		List<E> tmp = new LinkedList<>();
		for(E x : data) if(pr.test(x)) tmp.add(x);
		return tmp;
	}

	public void remove(Predicate<E> pr){
		data.removeIf(pr);
	}

	public void print(Consumer<E> cn){
		data.forEach(cn);
		System.out.println();
	}

	public Iterator<E> iterator(){
		return data.iterator();
	}
}