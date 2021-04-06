package AnaTrevisan_3014953_Assignment4;

public class Assignment04 {
    public static void main(String[] args) {
        // Staring to test my code
		 		/* Create two LinkedListHT and populate them, adding tails and heads, I will be using two
		 		   because I will need them later when I need to test my equals method */
        LinkedListHT list3 = new LinkedListHT();
        LinkedListHT list = new LinkedListHT();
        list.addAtHead(3);
        list.addAtHead(6);
        list.addAtTail(34);
        list.addAtTail(42);
        list.addAtTail(5);
        LinkedListHT list2 = new LinkedListHT();
        list2.addAtHead(3);
        list2.addAtHead(6);
        list2.addAtTail(34);
        list2.addAtTail(42);
        list2.addAtTail(5);
        System.out.println("Compare list with list2 (equal):");
        System.out.println(list.equals(list2));
        System.out.println("list:" +list);
        System.out.println("list2:"+list2);
        System.out.println("Compare with list at reverse:");
        list2.reverse();
        System.out.println(list.equals(list2));
        System.out.println("list:" +list);
        System.out.println("list2:"+list2);
        System.out.println("Numbers sorted:");
        list.sortList();
        System.out.println(list);
        System.out.println("Sum of the numbers:");
        System.out.println(list.sum());
        System.out.println("Remove list Tail:");
        list.delAtTail();
        System.out.println(list);
        System.out.println("Remove list Head:");
        list.delAtHead();
        System.out.println(list);
    }
}

class Node{
    int data;
    Node next;
    public Node(int x){
        data = x; next = null;
    }
    public Node next(){return next;}
    public void setNext(Node p){
        next = p;
    }
    public void set(int x){data = x;}
    public int data(){return data;}
}

class LinkedListHT{
    //Indexes to begin list:
    private Node head = null;
    private Node tail = null;

    public void addAtTail(int x){
        Node nw = new Node(x);
        if(head == null){
            head = nw; tail = nw;
        }
        else{
            tail.setNext(nw);
            tail = nw;
        }
    }

    public void addAtHead(int x){
        Node nw = new Node(x);
        if(head == null){
            head = nw; tail = nw;
        }
        else{
            nw.setNext(head);
            head = nw;
        }
    }

    public void delAtHead(){ // Deletes the head node
        Node k = head;
        if (k == null){
            head =null;
        }
        else{
            head = k.next();
        }
    }

    public void delAtTail(){ // Deletes the tail node
        if (head==tail){
            head = null;
            tail = null;
        }
        else {
            Node k = head;
            while(k.next()!=tail){ // Gets the penultimate node
                k = k.next();
            }
            k.next = null; // Sets the last node to null
            tail = k;; // Sets the penultimate node to be the tail
        }
    }

    public int sum(){ // Sum all the values in the list
        int total = 0;
        Node k = head;

        while(k != null ){
            total += k.data();
            k = k.next();
        }
        return total;
    }

    public int[] toArray(){ // Transform the linked list to an array to be reversible
        int[] myArray = new int[this.size()];
        Node k = head;
        int counter = 0;
        while(k != null ){
            myArray[counter] = k.data();
            counter++;
            k = k.next();
        }
        return myArray;
    }

    public void reverse(){ // Reverse the order of the elements in the list
        int[] myArray = this.toArray();
        for (int j : myArray) {
            this.addAtHead(j);
            this.delAtTail();
        }
    }

    public int size(){ // Return size of  the list
        int counter = 0;
        Node k = head;

        while(k != null ){
            counter++;
            k = k.next();
        }
        return counter;
    }

    public boolean equals(Object ob){
        if (!(ob instanceof LinkedListHT))return false;
        LinkedListHT lst = (LinkedListHT)ob;
        if (this.head==null || lst.head==null) return false;
        if (this.size()!=lst.size()) return false;
        else{
            Node k = this.head;
            Node p = lst.head;
            while(k.next!=null){
                if (k.data()!=p.data()){
                    return false;
                }
                k = k.next();
                p = p.next();
            }
            return true;
        }
    }

    public void sortList() {
        // Indexes to begin sort:
        Node current = head;
        Node index = null;
        int temp;

        while (current != null) {
            index = current.next; // Current will be the next to the head
            while (index != null) {
                if (current.data > index.data) {  //If current data is greater than head, swap their data
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    public String toString(){
        if(head == null) return "[]";
        String s = "[";
        Node k = head;
        while(k.next() != null){
            s = s + k.data()+", ";
            k = k.next();
        }
        s = s + k.data()+"]";
        return s;
    }
}
