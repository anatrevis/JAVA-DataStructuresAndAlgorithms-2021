package AnaTrevisan_3014953_Assignment01;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SingleClass {
    public static void multipleThree(Scanner in) { // A recursive function that reads a list of integer values, sentinel -1, and prints all multiples of 3.
        System.out.print("Enter a number to the list or enter -1 to end: ");
        List<Integer> list=new ArrayList<Integer>();
        int i = in.nextInt();
        list.add(i);

        if (i != -1) {
            multipleThree(in);
        }
        list.removeIf(number -> number % 3 != 0);
        System.out.print(list);
    }

    public static void zeroOccurence (int arr[]){
        int n = arr.length;
        if(arr[n] != 0){
            zeroOccurence(arr[n-1]);
        }
        int Occurrences = 0;
    }

    public static void main(String[] args) {
//        System.out.println("Multiples of 3: ");
//        Scanner input = new Scanner(System.in);
//        multipleThree(input);
//        input.close();

        int arr[] = { 1, 2, 3, 4, 5 };
    }

}




