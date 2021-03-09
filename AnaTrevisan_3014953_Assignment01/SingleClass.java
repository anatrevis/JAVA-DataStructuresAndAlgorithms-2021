package AnaTrevisan_3014953_Assignment01;
import java.util.*;

public class SingleClass {
    public static void multipleThree(Scanner in) { // A recursive function that reads a list of integer values, sentinel -1, and prints all multiples of 3.
        System.out.print("Enter a sequence of numbers or enter -1 to end: ");
        int i = in.nextInt();
        if (i==-1){
            System.out.println("Multiples of 3 from the entered sequence: ");
        }
        else{
            multipleThree(in);
            if (i %3 ==0){
                System.out.print(i + " ");
            }
        }

    }

    public static int zeroOccurence (int[] arr, int n){ // A recursive function that takes an integer array as one of its arguments and computes the frequency of the number 0 in the array.
        int occurrences = 0;
        if (n < 0)
            return 0;
        if(arr[n] == 0){
            occurrences ++;
        }
        return(occurrences+ zeroOccurence(arr, n-1));
    }

    public static int convertToBinary(int decimal_number) // A recursive function that prints a given positive integer value as its binary equivalent. For example, if the value is 11 the output should be 1011
    {
        if (decimal_number == 0)
            return 0;
        else
            return (decimal_number % 2 + 10 * convertToBinary(decimal_number / 2));
    }

    public static void fibSequence(int i, int n, int[] f){ // A recursive method that stores fibonacci terms in an array of size n, where n is the number of terms required, as it generates them

        if (i==0){
            f[i] = 0;
        }
        else if (i==1){
            f[i] = 1;
        }
        else{
            f[i] = f[i-1] + f[i-2];
        }

        if(i < n-1){
            fibSequence(i+1,n,f);
        }
        else {
            System.out.println(Arrays.toString(f));
        }

    }


    public static void main(String args[]) {
        System.out.println("###Question 1:###");
        Scanner input = new Scanner(System.in);
        multipleThree(input);
        System.out.println("\n###Question 2:###");
        int arr1[] = { 1, 2, 3, 4, 0 };
        int arr2[] = { 1, 2, 3, 4, 5 };
        int arr3[] = { 1, 0, 3, 4, 0 };
        int arr4[] = {};
        System.out.println("Occurrences of zero in the array { 1, 2, 3, 4, 0 }: "+zeroOccurence(arr1, arr1.length-1));
        System.out.println("Occurrences of zero in the array { 1, 2, 3, 4, 5 }: "+zeroOccurence(arr2, arr2.length-1));
        System.out.println("Occurrences of zero in the array { 1, 0, 3, 4, 0 }: "+zeroOccurence(arr3, arr3.length-1));
        System.out.println("Occurrences of zero in the array { }: "+zeroOccurence(arr4, arr4.length-1));
        System.out.println("###Question 3:###");
        System.out.println("11 in binary: "+ convertToBinary(11));
        System.out.println("2 in binary: "+ convertToBinary(2));
        System.out.println("###Question 4:###");
        System.out.println("Enter how many terms of the fibonacci sequence you want to store: ");
        int numberOfTerms = input.nextInt();
        input.close();
        int[] array = new int[numberOfTerms];
        System.out.format("Fibonacci array of %d elements: ", numberOfTerms);
        fibSequence(0, numberOfTerms, array);
    }

}




