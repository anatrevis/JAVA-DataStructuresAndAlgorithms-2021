package AnaTrevisan_3014953_Assignment08;

/*
 * Assignment 08
 *
 * Name: Ana Trevisan
 * Student Number: 3014953
 *
 */

import java.util.ArrayList;
import java.util.List;

// QUESTION 1: Your code should provide a test platform for the public methods in the class BinarySearchTree.
// In particular add, remove,preOrder, inOrder, postOrder, height and contains.
// QUESTION 2: Add the following methods to the BinarySearchTree<E> class:
// * public E maxElement() : Returns the largest element in the tree
// * public ArrayList<E> leafNodes() : Returns an ArrayList containing the leaf nodes in the tree. A leaf node is one
// whose left and right children are null
// * public List<E> get(Predicate<E> pr) : Retrieve a list that satisfies pr.

public class Assignment08Test {
	public static void main(String[] args) {
		Word java = new Word("java");
		Word python = new Word("python");
		Word php = new Word("php");
		Word five = new Word("5");

		BinarySearchTree<Word> tree1 = new BinarySearchTree<Word>();
		System.out.println();
		System.out.println("~~~ Testing Question 1 ~~~");

		System.out.println("Creating empty tree1. Generating 20 random strings and adding to the tree1: ");
		int count = 0;
		while(count<5) {
			String str = str_gen();
			System.out.print(str + " ");
			tree1.add(new Word(str));
			count ++;
		}
		System.out.println();
		System.out.println("tree1: "+tree1.toString());

		System.out.println("preOrder tree1: "+ tree1.preOrder());
		System.out.println("inOrder tree1: "+ tree1.inOrder());
		System.out.println("postOrder tree1: "+ tree1.postOrder());
		System.out.println("height of tree1: "+ tree1.height());
		System.out.println("tree1 contains \"python\"? " + tree1.contains(python));


		System.out.println("Creating tree2 from a Word list:");
		List<Word> wordList = new ArrayList<Word>();
		wordList.add(java);
		wordList.add(python);
		wordList.add(php);
		BinarySearchTree<Word> tree2 = new BinarySearchTree<Word>(wordList);
		System.out.println("tree2: "+ tree2.toString());

		System.out.println("preOrder tree2: "+ tree2.preOrder());
		System.out.println("inOrder tree2: "+ tree2.inOrder());
		System.out.println("postOrder tree2: "+ tree2.postOrder());
		System.out.println("height of tree2: "+ tree2.height());
		System.out.println("tree2 contains \"python\"? " + tree2.contains(python));
		System.out.println("Remove \"python\" from tree2.");
		tree2.remove(python);
		System.out.println("tree2: "+ tree2.toString());

		System.out.println("~~~ Testing Question 2 ~~~");
		System.out.println("tree1 largest element: "+ tree1.maxElement());
		System.out.println("tree1 leaf nodes: "+ tree1.leafNodes());
		System.out.println("tree1 get \"words\" that are bigger than 5: "+ tree1.get(x -> (Integer.valueOf(x.word()) > Integer.valueOf(five.word()))));
		System.out.println("tree2 largest element: "+ tree2.maxElement());
		System.out.println("tree2 leaf nodes: "+ tree2.leafNodes());
		System.out.println("tree2 get words equals to \"java\": "+ tree2.get(x -> x.equals(java)));

	}

	public static String str_gen() { // generates random string
		int min = 0;
		int max = 100;
		//Generate random int value from 50 to 100
		int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
		return String.valueOf(random_int);
	}
}