package AnaTrevisan_3014953_Assignment08;

/*
 * Assignment 08
 *
 * Name: Ana Trevisan
 * Student Number: 3014953
 *
 */

import java.util.*;
import java.util.function.Predicate;

class BinarySearchTree<E extends Comparable<E>> implements Iterable<E>{
	private BNode<E> root;
	private int count;

	public BinarySearchTree(){
		root = null;
		count = 0;
	}
	public BinarySearchTree(Collection <? extends E> ls){
		root = null;
		count = 0;
		for(E x : ls) {
			this.add(x);
		}
	}
	public void add(E x){
		root = add(root,x);
	}
	private BNode<E> add(BNode<E> rt, E x){
		if(x == null)
			return rt; //do not allow null values

		if(rt == null){
			count++;
			return new BNode<E>(x);
		}
		else if(x.compareTo(rt.data()) < 0){
			BNode<E> p = add(rt.left(), x);
			rt.setLeft(p);
			return rt;
		}
		else if(x.compareTo(rt.data()) > 0){
			BNode<E> p = add(rt.right(), x);
			rt.setRight(p);
			return rt;
		}
		else // x already present, so no change
			return rt;
	}

	public boolean contains(E x){
		return contains(root, x);
	}

	private boolean contains(BNode<E> rt, E x){
		if(rt == null)
			return false;
		else{
			if(rt.data().equals(x)) return true;
			else if(x.compareTo(rt.data()) < 0)
				return contains(rt.left(),x);
			else
				return contains(rt.right(), x);
		}
	}

	public int size(){
		return count;
	}

	public void remove(E x){
		BNode<E> ptr = null; BNode<E> parentPtr = null;
		if(root != null){
			ptr = root; parentPtr = root;
			boolean found = false;
			while(ptr != null && !found){
				if(ptr.data().equals(x))
					found = true;
				else{
					parentPtr = ptr;
					if(x.compareTo(ptr.data()) < 0)
						ptr = ptr.left();
					else
						ptr = ptr.right();
				}
			}
			if(found){
				count--;
				if(ptr == root){
					root = removeNode(root);
				}
				else{
					if(x.compareTo(parentPtr.data()) < 0){
						BNode<E> n = removeNode(parentPtr.left());
						parentPtr.setLeft(n);
					}
					else{
						BNode<E> n = removeNode(parentPtr.right());
						parentPtr.setRight(n);
					}
				}
			}
		}
	}

	private BNode<E> removeNode(BNode<E> rt){
		if(rt == null)
			return null;
		else if (rt.left() == null && rt.right() == null)
			return null;
		else if(rt.left() == null)
			return rt.right();
		else if(rt.right() == null){
			return rt.left();
		}
		else{
			BNode<E> ptr = rt.left();
			BNode<E> parentPtr = null;
			while(ptr.right() != null){
				parentPtr = ptr;
				ptr = ptr.right();
			}
			rt.set(ptr.data());
			if(parentPtr == null)
				rt.setLeft(ptr.left());
			else
				parentPtr.setRight(ptr.left());
			return rt;
		}
	}

	public int height(){
		return height(root);
	}

	private int height(BNode<E> rt){
		if(rt == null) return -1;
		else{
			return 1 + max(height(rt.left()),height(rt.right()));
		}
	}

	private int max(int a,int b){
		return a >= b? a:b;
	}

	public ArrayList<E> inOrder(){
		ArrayList<E> lst = new ArrayList<E>();
		inOrder(root,lst);
		return lst;
	}

	private void inOrder(BNode<E> rt, ArrayList<E> lst){
		if(rt != null){
			inOrder(rt.left(), lst);
			lst.add(rt.data());
			inOrder(rt.right(),lst);
		}
	}

	public ArrayList<E> preOrder(){
		ArrayList<E> lst = new ArrayList<E>();
		preOrder(root,lst);
		return lst;
	}

	private void preOrder(BNode<E> rt, ArrayList<E> lst){
		if(rt != null){
			lst.add(rt.data());
			preOrder(rt.left(), lst);
			preOrder(rt.right(),lst);
		}
	}

	public ArrayList<E> postOrder(){
		ArrayList<E> lst = new ArrayList<E>();
		postOrder(root,lst);
		return lst;
	}

	private void postOrder(BNode<E> rt, ArrayList<E> lst){
		if(rt != null){
			postOrder(rt.left(), lst);
			postOrder(rt.right(),lst);
			lst.add(rt.data());
		}
	}

	// Question 2 BEGIN

	public E maxElement() {
		ArrayList inOrderTree = this.inOrder();
		Word maxElement = (Word)inOrderTree.get(0);

		for (int i = 0; i < inOrderTree.size(); i++) {
			if (maxElement.compareTo((Word) inOrderTree.get(i)) < 1){ // Gets String with highest value
				maxElement = (Word)inOrderTree.get(i);
			}
		}
		return (E) maxElement;
	}

	public ArrayList<E> leafNodes(){
		ArrayList<E> lst = new ArrayList<E>();
		searchLeafNodes(root,lst);
		return lst;
	}

	private void searchLeafNodes(BNode<E> root, ArrayList<E> lst){
		if(root != null){
			searchLeafNodes(root.left(), lst);
			if(root.left()==null && root.right()==null)
				lst.add(root.data());
			searchLeafNodes(root.right(),lst);
		}
	}

	public List<E> get(Predicate<E> pr) {
		ArrayList<E> lst = new ArrayList<E>();
		ArrayList inOrderTree = this.inOrder();

		for (int i = 0; i < inOrderTree.size(); i++) {
			if (pr.test((E) inOrderTree.get(i))){
				lst.add((E) inOrderTree.get(i));
			}
		}
		return lst;
	}

	// Question 2 END

	public Iterator<E> iterator(){
		ArrayList<E> ls = this.inOrder();
		return ls.iterator();
	}
	public String toString(){
		return this.inOrder().toString();
	}

	private class BNode<E extends Comparable<E>>{
		private E data;
		private BNode<E> left;
		private BNode<E> right;

		public BNode(E d){
			data = d;
			left = null;
			right = null;
		}

		public E data(){
			return data;
		}

		public void set(E x){
			data = x;
		}

		public BNode<E> left(){
			return left;
		}

		public BNode<E> right(){
			return right;
		}

		public void setLeft(BNode<E> k){
			left = k;
		}

		public void setRight(BNode<E> k){
			right =k;
		}

	}

}