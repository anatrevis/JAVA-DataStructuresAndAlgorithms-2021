package AnaTrevisan_3014953_Assignment07;
/**
 * student name:
 * student number:
 *
 */

import java.util.*;
public class Assignment7Test {
	public static void main(String[] args){
		DSAHashList<Point> list = new DSAHashList<Point>(1000);
		// Test add Method
		for (int i=1; i<=1000; i++) {
			int x = (int)(Math.random()*500)+1;
			int y = (int)(Math.random()*500)+1;
			int z = (int)(Math.random()*500)+1;
	
			Point p = new Point(x, y, z);
			list.add(p);
		}

		int x = 0;
		int y = 0;
		int z = 0;
		Point pZero = new Point(x, y, z);
		list.add(pZero);

		x = 1;
		y = 1;
		z = 1;
		Point pOne = new Point(x, y, z);
		list.add(pOne);

		System.out.println("pZero equals pOne? "+pZero.equals(pOne));
		System.out.println("Table: "+list.toString());
		System.out.println("Number of lists in table: "+list.size());
		System.out.println("Table contains pZero(0,0,0)? "+list.contains(pZero));
		System.out.println("Table removes pZero(0,0,0)? "+list.remove(pZero));
		System.out.println("Table: "+list.toString());
		System.out.println("Table contains pZero(0,0,0)? "+list.contains(pZero));
		System.out.println("Table: "+list.toString());
		System.out.println("Number of lists in table: "+list.size());
		System.out.println("Empty places on table: "+list.empty()+" From: "+list.tableLists());
		System.out.println("Used places on table: "+list.usage()+" From: "+list.tableLists());
		System.out.println("Maximum list length: "+list.largestListLen());
		System.out.println("Smallest list length: "+list.smallestListLen());
		System.out.println("Table contains pOne(1,1,1)? "+list.contains(pOne));
		System.out.println("Get Point that contains x=1 and y=1 and z=1: "+list.get(point -> point.x()==0 && point.y()==0 && point.z()==0));
		System.out.println("Get list that contains pOne(1,1,1): "+list.getList(pOne));
		list.remove(list.getList(pOne));
		System.out.println("Removed the list that contains pOne(1,1,1): " + list.toString());
		System.out.println("Table size: "+list.size());
		System.out.println("Empty places on table: "+list.empty()+" From: "+list.tableLists());
		System.out.println("Used places on table: "+list.usage()+" From: "+list.tableLists());

		int[] arr = list.listSizes();
		for (int i=0; i< arr.length; i++) {
			System.out.println("Lists with size "+i+": "+arr[i]);
		}
		System.out.println();
	}
}