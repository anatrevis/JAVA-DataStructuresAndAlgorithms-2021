package AnaTrevisan_3014953_Assignment06;
/*
 * Question1.java
 *
 */

import java.util.*;
		import java.util.function.*;
public class Question1Test {
	public static void main(String[] args){
				/*Question 1 ==========================================================
		Using the class NewNumbers (given) write a code sequence that tests
		the methods:
			forAllNumbers(Predicate<Integer> pr),
			List<Integer> subList(Predicate<Integer> pr)
			List<Integer> mappingList(Function<Integer,Integer> f)
			Sample tests might be: all the values are positive, all negative,
			retrieve a list of the even numbers, a list of negative numbers,
			use mapList to return the square of all the numbers, etc
			You should write at least three tests for each method
		======================================================================*/
		// Testing add to list
		NewNumbers list = new NewNumbers();
		//Testing add integer
		list.add(0);
		//Testing add array
		list.add(Arrays.asList(1,2,3,4,6,-1,-5,7,8,12,4,-5,0,0,1,4,-2));
		list.print(x->System.out.print(x+" "));

		// Sublists created from NewNumbers list
		List<Integer> positiveNumbers = list.subList(x -> x >= 0);
		List<Integer> negativeNumbers = list.subList(x -> x < 0);
		List<Integer> evenNumbers = list.subList(x -> x % 2 == 0);
		List<Integer> oddNumbers = list.subList((x -> x %2 != 0));
		List<Integer> biggerThan50numbers = list.subList((x -> x > 50));
		// Model lists to compare
		List<Integer> modelPositive = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 6, 7, 8, 12, 4, 0, 0, 1, 4));
		List<Integer> modelNegative = new ArrayList<>(Arrays.asList(-1,-5,-5,-2));
		List<Integer> modelEven = new ArrayList<>(Arrays.asList(0, 2, 4, 6, 8, 12, 4, 0, 0, 4, -2));
		List<Integer> modelOdd = new ArrayList<>(Arrays.asList(1, 3, -1, -5, 7, -5, 1));

		//Test contains:
		System.out.println("The list contains numbers < 6?");
		assert list.contains(x -> x < 6) == true :" Contains numbers < 6"; // asserts that is true
		System.out.println(list.contains(x -> x < 6));
		System.out.println("The list contains zeros?");
		assert list.contains(x -> x == 0) == true :" Contains 0"; // asserts that is true
		System.out.println(list.contains(x -> x == 0));
		System.out.println("The list contains the number 50?");
		assert list.contains(x -> x == 50) == false :" Dont contain the number 50"; // asserts that is false
		System.out.println(list.contains(x -> x == 50));

		//Test forAllNumbers using assertions
		System.out.println("All numbers are less than 50?");
		assert list.forAllNumbers(x -> x < 50) == true :" All numbers are less than 50"; // asserts that is true
		System.out.println(list.forAllNumbers(x -> x < 50));
		System.out.println("All numbers are even?");
		assert list.forAllNumbers(x -> (x % 2) == 0) == false :"Not all numbers are even"; // asserts that is false
		System.out.println(list.forAllNumbers(x -> (x % 2) == 0));

		// Tests subList using assertions
		System.out.println("Which numbers are positive? ");
		for(int j=0; j<positiveNumbers.size(); j++) {
			assert positiveNumbers.get(j).equals(modelPositive.get(j)) : " The positiveNumbers list should be equal to listPositive"; //asserts that the numbers are equals to model list
			System.out.print(positiveNumbers.get(j) + " ");
		}
		System.out.println("\nWhich numbers are negative? ");
		for(int j=0; j<modelNegative.size(); j++) {
			assert negativeNumbers.get(j).equals(modelNegative.get(j)) : " The negativeNumbers list should be equal to modelNegative";
			System.out.print(positiveNumbers.get(j) + " ");
		}
		System.out.println("\nWhich numbers are even? ");
		for(int j=0; j<modelEven.size(); j++) {
			assert evenNumbers.get(j).equals(modelEven.get(j)) : " The evenNumbers list should be equal to listEven";
			System.out.print(evenNumbers.get(j) + " ");
		}
		System.out.println("\nWhich numbers are odd? ");
		for(int j=0; j<modelOdd.size(); j++) {
			assert oddNumbers.get(j).equals(modelOdd.get(j)) : " The oddNumbers list should be equal to modelOdd";
			System.out.print(oddNumbers.get(j) + " ");
		}
		System.out.println("\nWhich numbers are greater than 50? ");
		assert biggerThan50numbers.isEmpty(): " The biggerThan50numbers list should be empty"; // asserts that list is  empty
		System.out.println("Empty list.");

		//Test mappingList
		// Make all numbers in the list to be squared
		System.out.println("All values of list squared: ");
		System.out.println(list.mappingList(i -> i*i));
		// Make all numbers in the list to be negative
		System.out.println("All values of the list negated: ");
		System.out.println(list.mappingList(Math::negateExact)); //Direct invocation
		// Make all negative numbers into their positive absolute value
		Function<Integer,Integer> makePositive = i -> {
			if(i < 0){
				i = Math.abs(i);
			}
			return i;
		};
		System.out.println("All of the values transformed into positive: ");
		System.out.println(list.mappingList(makePositive));

		//Test count with assertions
		assert list.count(x -> x >= 0) == 14 : "There are 14 positive numbers";
		System.out.println("Number of positive numbers = " + list.count(x -> x >= 0));
		assert list.count(x -> x %2 == 0) == 11 : "There are 11 even numbers"; //asserts that the numbers are equals to model list
		System.out.println("Number of even numbers = " + list.count(x -> x %2 == 0));
		assert list.count(x -> x %2 != 0) == 7 : "There are 7 odd numbers";
		System.out.println("Number of odd numbers = " + list.count(x -> x %2 != 0));

		//Test sum with assertions
		assert list.sum(x -> x == x) == 39 : "There sum of all numbers should be 39";
		System.out.println("Sum of all numbers: " + list.sum(x -> x == x));
		assert list.sum(x -> x > 0) == 52 : "There sum of all positive numbers should be 52";
		System.out.println("Sum of all positive numbers: " + list.sum(x -> x > 0));
		assert list.sum(x -> x < 0) == -13 : "There sum of all negative numbers should be -13";
		System.out.println("Sum of all negative numbers: " + list.sum(x -> x < 0));	}
}