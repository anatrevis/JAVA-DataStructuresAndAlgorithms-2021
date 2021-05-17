package AnaTrevisan_3014953_Assignment06;
/*
 * Question2.java
 * 
 */

import java.util.*;
import java.util.function.*;
public class Question2Test {
	public static void main(String[] args){
		/*Question 2 ============================================================
		Using the generic class MyGenricList<E> (given) write a code sequence that
		tests all of its the methods. You are given a Book class that you can use
		to perform your tests. Note that creating a MyGenricList<Integer> instance is not
		an acceptable data type for your tests.
		================================================================== */
		// Creating MyGenricList(Book)
		MyGenericList<Book> genericList=new MyGenericList<Book>();
		// Adding books MyGenricList(Book)
		genericList.add(new Book("Sapiens", "Yuval Noah Harari"));
		genericList.add(new Book("Harry Potter", "J. K. Rowling"));
		genericList.add(new Book("Dark Matter", "Blake Crouch"));
		// Adding a list of books to MyGenricList(Book)
		List<Book> linkedList=new LinkedList<Book>();
		linkedList.add(new Book("Flowers for Algernon","Daniel Keyes"));
		linkedList.add(new Book("The Fellowship of the Ring","J. R. R. Tolkien"));
		linkedList.add(new Book("The Two Towers","J. R. R. Tolkien"));
		linkedList.add(new Book("The Return of the King","J. R. R. Tolkien"));
		genericList.add(linkedList);
		System.out.print("List of all books: ");
		genericList.print(x->System.out.print("["+ x +"],"));
		//Testing contains with assert
		// Check if book exists through title
		assert genericList.contains(x -> x.title().equals("Sapiens")) == true : "The book \"Sapiens\" is in the list";
		System.out.println("Check if book with title \"Sapiens\" is in the list: "+genericList.contains(x -> x.title().equals("Sapiens")));
		assert genericList.contains(x -> x.title().equals("The Hobbit")) == false : "The book \"The Hobbit\" is in the list";
		System.out.println("Check if book with title \"The Hobbit\" is in the list: "+genericList.contains(x -> x.title().equals("The Hobbit")));
		// Check if book exists through author
		assert genericList.contains(x -> x.author().equals("J. R. R. Tolkien")) == true : "The author \"J. R. R. Tolkien\" is in the list";
		System.out.println("Check if book with author \"J. R. R. Tolkien\" is in the list: "+genericList.contains(x -> x.author().equals("J. R. R. Tolkien")));

		//Testing filter
		// Check filter books through title
		System.out.println("Filter books with title \"Sapiens\" is in the list: "+genericList.filterList(x -> x.title().equals("Sapiens")));
		System.out.println("Filter books with title \"The Hobbit\" is in the list: "+genericList.filterList(x -> x.title().equals("The Hobbit")));
		// Check filter books through author
		System.out.println("Filter books with author \"\"J. R. R. Tolkien\" is in the list: "+genericList.filterList(x -> x.author().equals("J. R. R. Tolkien")));

		//Testing remove
		genericList.remove(x -> x.title().equals("Sapiens"));
		System.out.print("List af all books after removing the book with title \"Sapiens\": ");
		genericList.print(x->System.out.print("["+x+"],"));
		genericList.remove(x -> x.author().equals("J. R. R. Tolkien"));
		System.out.print("List af all books after removing books from the author \"J. R. R. Tolkien\": ");
		genericList.print(x->System.out.print("["+x+"],"));

		//Testing iterator
		Iterator iterator = genericList.iterator();
		System.out.print("List elements through iterator : ");
		while (iterator.hasNext())
			System.out.print("["+ iterator.next() + "], ");
		System.out.println();
	}
}