package AnaTrevisan_3014953_Assignment06;
/*
 * NewNumbers.java
 * 
 * Question 2
 *
 */

class Book{
	private String title;
	private String author;

	public Book(String t, String a){
		title = t; author = a;
	}

	public String title(){
		return title;
	}

	public String author(){
		return author;
	}

	public boolean equals(Object ob){
		if(!(ob instanceof Book)) return false;
		Book b = (Book)ob;
		return title.equals(b.title) && author.equals(b.author);
	}

	public int hashCode(){
		return 31*title.hashCode()*author.hashCode();
	}

	public String toString(){
		return "title: "+title+" author: "+author;
	}
}