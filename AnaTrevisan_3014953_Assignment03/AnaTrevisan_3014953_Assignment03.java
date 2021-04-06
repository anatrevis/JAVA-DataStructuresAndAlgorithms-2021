package AnaTrevisan_3014953_Assignment03;

public class AnaTrevisan_3014953_Assignment03 {

    public static void main(String[]args)
    {
        AnaTrevisan_3014953_Assignment03 a3 = new AnaTrevisan_3014953_Assignment03();

        //System.out.print("Before: ");		printArray(arr);
        a3.testSpeed(10);
        //System.out.print("After: ");		printArray(arr);

        //printArray(arr);
        a3.testSpeed(99);
        //System.out.print("After: ");		printArray(arr);

        //printArray(arr);
        a3.testSpeed(100);
        //System.out.print("After: ");		printArray(arr);

        //printArray(arr);
        a3.testSpeed(101);
        //System.out.print("After: ");		printArray(arr);

        //printArray(arr);
        a3.testSpeed(500);
        //System.out.print("After: ");		printArray(arr);

        //printArray(arr);
        a3.testSpeed(5000);
        //System.out.print("After: ");		printArray(arr);
}

    void testSpeed(int size)
    {
        double[] arr = createArray(size);
        long start = System.nanoTime();
        mergeInsertSort(arr,0,arr.length);
        long end = System.nanoTime();
        long timeToRun = end-start;
        System.out.println("Time in nanseconds for array size "+size+": "+timeToRun);
        checkSort(arr); // If array is not sorted it will print an error
//        printArray(arr);
        //if (arr.length<102)	printArray(arr);
    }

    public double[] createArray(int numElements)
    {
        double[] myArray = new double[numElements];
        for(int i=0;i<numElements;i++){
            myArray[i] = Math.random()*100;
        }
        return myArray;
    }

    public void checkSort(double[] arr)
    {
        for(int i=0; i<arr.length-1; i++){
            if (arr[i] > arr[i+1])
            {
		    	for(int j=0; j<arr.length; j++){
		    		if (j==i)System.out.print("###");
		    		if (j==i+2)System.out.print("###");
		    		System.out.print(arr[j] + " ");
		    	}
                System.out.println();
                System.out.println();
                System.out.printf("!!!!! Array is not sorted, value at index %d is bigger than the next value\n", i);
                System.out.println();
                break;
            }
        }
    }

    public void printArray(double[] myArray)
    {
        for (double v : myArray) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    public void mergeInsertSort(double arr[],int lb, int ub){
        if (ub - lb <= 100)
            insertSort(arr, lb, ub);
        else
        {
            int mid = (lb+ub)/2;
            mergeInsertSort(arr,lb,mid);
            mergeInsertSort(arr,mid,ub);
            merge(arr,lb,mid,ub);
        }
    }

    public void merge(double[] arr, int lo, int mid, int hi) {
        //lo<=mid<=hi
        int i =lo; int j = mid;
        //use temp array to store merged sub-sequence
        double temp[] = new double[hi-lo]; int t = 0;
        while(i<mid && j<hi){
            if(arr[i]<=arr[j]){
                temp[t] =arr[i];
                i++;t++;
            }
            else{
                temp[t] = arr[j];
                j++;
                t++;
            }
            //tag on remaining sequence
            while(i<mid){
                temp[t] = arr[i];
                i++;
                t++;

            }
            while(j<hi){
                temp[t]=arr[j];
                j++;
                t++;
            }
            //copy temp back to arr[]
            i=lo;t=0;
            while(t<temp.length){
                arr[i]=temp[t];
                i++;
                t++;
            }
        }

    }

    public void insertSort(double[] arr, int start, int end) {
        for (int i = 1; i < end; i++){
            int j = i;
            double temp = arr[i];
            while ((j > 0) && (arr[j-1] > temp)){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] =  temp;
        }
    }

}