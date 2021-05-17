/*
 * Implement the Queue<E> interface (given on moodle) with a class called MyQueue<E>. Your
 * class should use the class ArrayDequeue<E>() from the Java Collection classes to implement the interface.
 * Write test code for your MyQueue class (in the same class) and ensure all methods are fully tested.
 *
 */

package AnaTrevisan_3014953_Assignment05;

import java.util.*;

class MyQueue<T> implements Queue<T>,Iterable<T>{
  	private final ArrayDeque<T> elements;
	private final int queueSize;

	public MyQueue(int s){ // Generates a deque of generic elements and pre defined size queue size "s"
		this.elements = new ArrayDeque<>();
		this.queueSize = s;
	}

	public boolean join(T x){ // Add element to the end of the queue
		if(this.full()){
			return false;
		}
		this.elements.addLast(x);
		return true;
	}

	public T top(){ // Returns the element at the head of the queue
		return this.elements.peek(); // peek() is used to retrieves, but does not remove, the head of this deque, or returns null if this deque is empty
	}

	public boolean leave(){ // Removes the element at the head of the queue
		if (this.elements.poll() == null){ // poll() is used to retrieves and removes the head of this deque, or returns null if this deque is empty
			return false;
		}
		return true;
	}

	public boolean full(){ // Checks if queue is full
		return this.elements.size() == queueSize;
	}

	public boolean empty(){ // Checks if queue is empty
		return this.elements.isEmpty();
	}

	public boolean contains(T x){ // Checks if stack contains object
		return this.elements.contains(x);
	}

	@Override
	public String toString() {
		return "MyQueue{" +
				"elements=" + this.elements +
				", queueSize=" + this.queueSize +
				'}';
	}

	@Override
	public Iterator<T> iterator() {
		return this.elements.iterator();
	}
}
