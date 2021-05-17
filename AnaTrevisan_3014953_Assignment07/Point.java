package AnaTrevisan_3014953_Assignment07; /**
 * student name:
 * student number:
 */

import java.util.*;
public class Point{
	private int x,y,z;

	Point(int a, int b, int c){
		this.x = a; this.y = b; this.z = c;
	}

	public int x(){
		return this.x;
	}

	public int y(){
		return this.y;
	}

	public int z(){
		return this.z;
	}

	public String toString(){
		return "("+this.x+","+this.y+","+this.z+")";
	}

	public boolean equals(Object o) {
		if(!(o instanceof Point))
			return false;
		Point p = (Point)o;
		if(this.x == p.x() && this.y == p.y() && this.z == p.z())
			return true;
		return false;
	}

	public int hashCode() {
		int x = this.x;
		int y = this.y;
		int z = this.z;

		return Integer.hashCode(x) + Integer.hashCode(y) + Integer.hashCode(z);
	}
}