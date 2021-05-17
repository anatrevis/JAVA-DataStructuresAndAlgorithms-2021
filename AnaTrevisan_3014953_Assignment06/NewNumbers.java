package AnaTrevisan_3014953_Assignment06;/*
 /*
 * NewNumbers.java
 *
 * Question 1
 *
 */

import java.util.*;
import java.util.function.*;
class NewNumbers{
	private List<Integer> data = new ArrayList<>();

	void add(int x){
		data.add(x);
	}

	void add(List<Integer> lst){
		data.addAll(lst);
	}

	boolean contains(Predicate<Integer> pr){
		for(Integer x : data)
			if(pr.test(x)) return true;
		return false;
	}

	boolean forAllNumbers(Predicate<Integer> pr){
		for(Integer x : data)
			if(!pr.test(x)) return false;
		return true;
	}

	List<Integer> subList(Predicate<Integer> pr){
		List<Integer> tmp = new ArrayList<>();
		for(Integer x : data)
			if(pr.test(x)) tmp.add(x);
		return tmp;
	}

	List<Integer> mappingList(Function<Integer,Integer> f){
		List<Integer> tmp = new ArrayList<>();
		for(Integer x : data) tmp.add(f.apply(x));
		return tmp;
	}

	int count(Predicate<Integer> pr){
		int count = 0;
		for(Integer x : data) if(pr.test(x)) count++;
		return count;
	}

	int sum(Predicate<Integer> pr){
		int s = 0;
		for(Integer x : data) if(pr.test(x)) s += x;
		return s;
	}

	void print(Consumer<Integer> cn){
		data.forEach(cn);
		System.out.println();
	}
}