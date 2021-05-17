/*
 * Implement a class called MyStack<E> that implements the Stack<E> interface (given on moodle) using an ArrayList<E>.
 * Write test code for your MyStack class (in the same class) and ensure all methods are fully tested.
 */

package AnaTrevisan_3014953_Assignment05;

import java.util.*;

class MyStack<E> implements Stack<E>, Iterable<E>{
  	private final ArrayList<E> elements;
	private final int stackSize;
	
	public MyStack(int s){ // Generates a list of generic elements and pre defined size stack size "s"
		this.elements = new ArrayList<>();
		this.stackSize = s;
	}

	public boolean push(E x){ // Adds element at the top of the stack
	 	if(this.full()){ //Check if operation is valid to avoid stack overload
	 		return false;
		}
	 	this.elements.add(x);
	 	return true;
	}

	public boolean pop(){ // Removes element on the top of the stack
		if(this.empty()){ //Check if operation is valid to avoid index out of bounds
			return false;
		}
		this.elements.remove(this.elements.size()-1);
		return true;
	}

	public E top(){ // Return the element on the top of the stack
		if(this.elements.size() > 0){ //Check if operation is valid
			return this.elements.get(this.elements.size()-1);
		}
		return null;
	}

	public boolean empty(){ // Checks if stack is empty
		return this.elements.isEmpty();
	}

	public boolean full(){ // Checks if stack is full
		if(this.elements.size() == this.stackSize){
			return true;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() { // Used to loop through the stack
		return this.elements.iterator();
	}

	@Override
	public String toString() {
		return "MyStack{" +
				"elements=" + this.elements +
				", stackSize=" + this.stackSize +
				'}';
	}

}
