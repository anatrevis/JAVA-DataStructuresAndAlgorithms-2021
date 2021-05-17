/*
 * Name: Queue (Interface)
 *
 * Version: 1.0
 *
 */

package AnaTrevisan_3014953_Assignment05;

import java.util.Iterator;

interface Queue<T>{
	public boolean join(T x);
	public T top();
	public boolean leave();
	public boolean full();
	public boolean empty();
	public String toString();
	public boolean contains(T x);
	public Iterator<T> iterator();
}
