package AnaTrevisan_3014953_Assignment02;

import java.util.Arrays;

public class AnaTrevisan_3014953_Assignment02 {
    public static int factorial(int a) {
        int factorial = 1;
        for(int i = 1; i <=a; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    public static int power(int a, int b) {
        int power = 1;
        for(int i = 1; i <= b; i++) {
            power = power * a;
        }
        return power;
    }

    public static int LinearSearch(int[] a, int n, int q) {
        int i = 0;
        while(i<n && a[i] != q){
            i = i+1;
            if (i == n)
                return -1;
        }
        return i;
    }

    public static void main(String[] args) {
        // Factorial test
        int num = 3;
        System.out.println(num + "! = " + factorial(num));
        // Test on the power method
        int a = 2;
        int b = 3;
        System.out.println(a + " ^ " + b + " = " + power(a, b));
        // Test of the Linear Search
        int [] arr = {1, 3, 4, 5, 6};
        int length = arr.length;
        int q = 5;
        System.out.println("Search element " + q + " in array: " + Arrays.toString(arr) +" ; result: "+LinearSearch(arr, length, q));
        q = 8;
        System.out.println("Search element " + q + " in array: " + Arrays.toString(arr) + " ; result: "+LinearSearch(arr, length, q));
    }
}

