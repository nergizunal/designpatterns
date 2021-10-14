public class Main {
    public static void main ( String [] args){
        int[] arr = new int[50];
        int[] array = new int[50];

        for(int i = 0; i<50; i++)
        {
            arr[i] = 100 - i ;
        }
        for(int i = 0; i<50; i++)
        {
            array[i] = 100 - i ;
        }
        printArray(arr);
        //printArray(selectionSortR(arr,50,0));
        //printArray(selectionSort(arr));
        //printArray(array);
        //printArray(bubbleSort(arr));
       // printArray(optimizedBubbleSort(arr));
        //printArray(bubbleSortR(arr, arr.length));
       // printArray(insertionSort(arr));
       // printArray(insertionSortR(arr, arr.length));
       // printArray(mergeSort(arr, 0,arr.length-1));
        //printArray(mergeIterative(arr));
        printArray(quickSort(arr, 0, arr.length -1));


    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    private static int[] selectionSort(int [] array){ // Time: O(n^2) Space O(1)
        System.out.println("Selection Sort");
        int n = array.length;
        int [] arr = array;
        for(int i = 0 ; i<n; i++){
            int min_idx = i;
            for(int j = i + 1; j< n ; j ++){
                if(arr[j]<arr[i])
                    min_idx = j;
            }
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }

        return arr;
    }
    //recursive selection sort
    private static int[] selectionSortR(int [] array, int n, int index){ // Time: O(n^2) Space O(1)
        int []arr = array;
        if(index ==n) {
            System.out.println("Recursive Selection Sort");
            return arr;
        }
        int k = minIndex(arr, index, n-1);
        if(k!= index){
            //if min index is not current index, swap
            int temp = arr[k];
            arr[k] = arr[index];
            arr[index] = temp;
        }
        selectionSortR(arr, n, index + 1);
        return arr;
    }
    static int minIndex(int[] array, int i, int j){
        if(i ==j)
            return i;
        int k = minIndex(array, i +1, j);
        return (array[k] < array[i])? k:i;
    }
    private static int[] bubbleSort(int [] array){
        System.out.println("Bubble Sort");
        int [] arr = array;
        int n = array.length;
        for(int i = 0; i<n-1; i ++){
            for(int j = 0; j<n-i -1; j++){
                if(arr[j]>arr[j +1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j +1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
    private static int[] bubbleSortR(int[] array, int n){
        if(n ==  1) {
            System.out.println("Recursive Bubble Sort");
            return array;
        }
        for(int i = 0; i< n -1; i++){
            if(array[i] > array[i +1]){
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }

        }
        return  bubbleSortR(array, n -1);
    }
    private static int[] optimizedBubbleSort(int[] array){
        System.out.println("Optimized Bubble Sort");
        int [] arr = array;
        int n = array.length;
        boolean swapped = false;
        for(int i = 0; i<n-1; i ++){
            for(int j = 0; j<n-i -1; j++){
                if(arr[j]>arr[j +1]){
                    //swap
                    swapped = true;
                    int temp = arr[j];
                    arr[j] = arr[j +1];
                    arr[j + 1] = temp;
                }
            }
            if(swapped == false)
                break;
        }
        return arr;
    }
    private static int[] insertionSort(int[] array){
        System.out.println("Insertion Sort");

        for(int i = 1; i< array.length; i++){
            int key = array[i];
            int j = i -1;
            while(j>=0 && array[j]>key ){
                array[j + 1]  =array[j]; //iterate the index j to plus 1
                j--;
            }
            array[j + 1] = key; //place the key value
        }
        return array;
    }
    private static int[] insertionSortR(int[] array, int n){
        if(n <= 1) {
            System.out.println("Recursive Insertion Sort");
            return array;
        }
        insertionSortR(array, n-1);
        int last = array[n-1];
        int j = n -2;
        while(j>=0 && array[j]> last){
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = last;
        return array;
    }
    private static int[] mergeSort(int[] array, int l, int r){
        if(l == 0&&r == array.length -1)
            System.out.println("Merge Sort");
        if(l<r) {
            int m = l + (r - l) / 2; // find the middle index
            mergeSort(array, l, m); // left array
            mergeSort(array, m + 1, r); // right array
            merge(array, l, m, r);
        }
        return array;
    }

    //first sub array: array[l..m]
    //second sun array : array[m+1..r]
    private static void merge(int[] arr , int l, int m, int r){
        int n1 = m - l + 1; //size of subarray 1 since m is inclusive to the left array add 1
        int n2 = r - m; // size of subarray 2, m is not inclusive to the right array
        int L[] = new int[n1];
        int R[] = new int[n2];
        for(int i = 0 ; i<n1; i ++) // copy into the left array
            L[i] = arr[l + i];
        for(int i = 0; i<n2 ; i ++) // copy into the right array
            R[i] = arr[m +1 + i];
        int i = 0, j = 0;
        int k = l;
        while(i<n1 && j < n2){
            if(L[i] <=R[j]) { // compare and copy the smaller one to the next index
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // if it does not reach end of the any array, copy the rest
        while(i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    private static int[] mergeIterative(int[] arr){
        if(arr == null)
            return arr;
        if(arr.length>1){
            int mid = arr.length/2; // find the middle
            int[] left = new int[mid]; // create left array
            for(int i = 0; i < mid ; i ++)
                left[i] = arr[i];

            int[] right = new int[arr.length - mid]; // find the right array
            for(int i = mid; i < arr.length ; i ++)
                right[i-mid] = arr[i];

            mergeIterative(left);
            mergeIterative(right);
            // after recursive call for the 2 subarray, merge them
            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length){
                if(left[i]<= right[j]){
                    arr[k] = left[i];
                    k++;
                    i++;
                }
                else{
                    arr[k] = right[j];
                    k++;
                    j++;
                }
            }
            while (i < left.length ) {
                arr[k] = left[i];
                k++;
                i++;

            }
            while(j < right.length){
                arr[k] = right[j];
                k++;
                j++;
            }
            }
        return arr;
        }
        static int partition(int[] arr, int low, int high){
            int pivot = arr[high];
            int i = low -1;
            for(int j = low; j<high; j++){
                if(arr[j]<pivot){
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = arr[i];
                }
            }
            int temp = arr[i+1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            return i + 1;
        }
        static int[] quickSort(int[] arr, int low, int high){
        if(low == 0 && high == arr.length -1)
            System.out.println("Quick Sort");
            if (low < high) {
                int p = partition(arr, low, high);
                quickSort(arr, low, p -1);
                quickSort(arr, p +1, high);
            }
            return arr;
        }

}
