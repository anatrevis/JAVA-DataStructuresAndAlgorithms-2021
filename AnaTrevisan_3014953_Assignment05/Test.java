/*
* Testing the classes MyStack.java and MyQueue.java
*/

package AnaTrevisan_3014953_Assignment05;

import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
		System.out.println("Testing MyStack: ");
		MyStack<Character> stack = new MyStack<Character>(3);
		stack.push('a');
		stack.push('!');
		stack.push('3');
		System.out.println(stack.toString());
		System.out.println("Which is the element at the top of the stack? "+ stack.top());
		System.out.println("Is stack empty? "+stack.empty());
		System.out.println("Is stack full? "+stack.full());
		System.out.println("Can we add another element? "+stack.push('4'));
		System.out.println("Can we remove the first element of the stack? "+ stack.pop());
		System.out.println(stack.toString());
		// Test iterator
		System.out.print("Printing elements with iterator: ");
		Iterator stackIterator =stack.iterator();
		System.out.print( "{" );
		while(stackIterator.hasNext()) {
		  System.out.print( " ["+stackIterator.next() + "] ");
		}
		System.out.print( "}" );
		System.out.println("");
		System.out.println("Testing MyQueue: ");
		MyQueue<Integer> queue = new MyQueue<Integer>(4);
		queue.join(0);
		queue.join(20);
		queue.join(-3);
		System.out.println(queue.toString());
		System.out.println("Which is the element at the top of the queue? "+ queue.top());
		System.out.println("Is the queue empty? "+queue.empty());
		System.out.println("Is the queue full? "+queue.full());
		System.out.println("Can we add another element? "+queue.join(4));
		System.out.println(queue.toString());
		System.out.println("Can we remove the head of the queue? "+queue.leave());
		System.out.println(queue.toString());
		System.out.println("This queue contains the element of value '10'? "+queue.contains(10));
		System.out.println("This queue contains the element of value '0'? "+queue.contains(10));
		System.out.print("Printing elements with iterator: ");
		Iterator queueIterator =queue.iterator();
		System.out.print( "{" );
		while(queueIterator.hasNext()) {
			System.out.print( " ["+queueIterator.next() + "] ");
		}
		System.out.print( "}" );

	}
}

