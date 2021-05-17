/*
 * student name:
 * student number:
 */
package AnaTrevisan_3014953_Assignment07;
import java.util.*;
import java.util.function.*;
class DSAHashList<E> implements Iterable<E>{
	private ArrayList<LinkedList<E>> table;

	public DSAHashList(int n){
		// n = the number of lists to create -
		// it does NOT limit the number of elements in the table
		table = new ArrayList<>();
		for(int j = 0; j < n; j++)
			table.add(new LinkedList<>());
	}

	private int hashC(E x){
		int k = x.hashCode();
		//an alternative is to mask the minus using
		//int k = x.hashCode() & 0x7fffffff;
		int h = Math.abs(k % table.size());
		return(h);
	}

	public void add(E x){
		int index = hashC(x);
		table.get(index).addFirst(x);
	}

	public boolean contains(E x){
		int index = hashC(x);
		return(table.get(index).contains(x));
	}

	public boolean remove(E x){
		int index = hashC(x);
		return table.get(index).remove(x);
	}

	public int size(){
		int count = 0;
		for (LinkedList<E> element : table) {
			count += element.size();
		}
		return count;
	}

	// Question 2:

	public LinkedList<E> getList(E x) {
		 //Insert code here
		int index = hashC(x);
		return new LinkedList(table.get(index));
	}

	public void remove(List<E> ls) {
		 //Insert code here
		for (E x : ls) {
			int hc = hashC(x);
			LinkedList<E> ll = table.get(hc);
			for(int i=0; i<ll.size(); i++) {
				if(ll.get(i).equals(x)) {
					ll.remove(i);
					i--;
				}
			}
		}
	}

	List<E> get(Predicate<E> pr) {
		// insert code here
		ArrayList<E> temp = new ArrayList<E>();
		for (LinkedList<E> ll : table) {
			for (E elem : ll) {
				if (pr.test(elem)) {
					temp.add(elem);
				}
			}
		}
		return temp;
	}


	public Iterator<E> iterator(){
		ArrayList<E> items = new ArrayList<E>();
		int ind = 0;
		while(ind < table.size()){
			Iterator<E> it = table.get(ind).iterator();
			while(it.hasNext()) items.add(it.next());
			ind++;
		}
		return items.iterator();
	}

	public String toString(){
		return table.toString();
	}

	//Question 1:

	public int tableLists(){ //gets the total number of lists on the table
		return table.size();
	}

	public int usage(){ //gets number of occupied lists on the table
		int count = 0;
		for (LinkedList<E> list : table) {
			if (list.size() > 0)
				count++;
		}
		return count;
	}

	public int empty(){ // gets number of empty lists on the table
		int count = 0;
		for (LinkedList<E> list : table) {
			if (list.size() == 0)
				count++;
		}
		return count;
	}

	public int largestListLen(){ //gets size of the largest list on the table
		int max = 0;
		for (LinkedList<E> list : table) {
			int k = list.size();
			if (k > max) {
				max = k;
			}
		}
		return max;
	}

	public int smallestListLen(){ //gets size of the smallest list on the table
		int min = table.get(0).size();
		for(int j = 1; j < table.size(); j++){
			int k = table.get(j).size();
			if(k < min) min = k;
		}
		return min;
	}

	public int[] listSizes(){
		int n = this.largestListLen();
		int[] d = new int[n+1]; // array to return the length

		for(int j = 0; j < d.length; j++) { // fill all array with 0
			d[j] = 0;
		}
		for (LinkedList<E> list : table) { // fill array with table list lengths
			int m = list.size();
			d[m] = d[m] + 1;
		}
		return d;
	}


}