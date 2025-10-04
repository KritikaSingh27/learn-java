import java.util.*;
public class DivideConquer {
    public static void printArray(int numbers[]){
        for(int i=0; i<numbers.length; i++){
        System.out.print(numbers[i] + " ");
        }
    }

    public static int[] readArray(Scanner sc){
        System.out.print("How many elements do you want to add in the Array: ");
        int n = sc.nextInt();
        if(n <= 0){
            return new int[0];
        }

        int numbers[] = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Enter number: ");
            numbers[i] = sc.nextInt();
        }
        return numbers;
    }

    public static void mergeSort(int arr[], int si, int ei){
        if(si>=ei){
            return;
        }
        int mid = si + (ei - si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }
    public static void merge(int arr[] , int si, int mid, int ei){
        int temp[] = new int[ei - si +1];

        int i = si;
        int j = mid + 1;
        int k = 0;

        while(i<=mid && j<=ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            } else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            temp[k++] = arr[i++];
        }

        while(j<=ei){
            temp[k++] = arr[j++];
        }

        for( k = 0, i = si; k < temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }

    public static void quickSort(int arr[], int si, int ei){
        if(si >= ei){
            return;
        }
        int pIdx = partition(arr,si,ei);
        quickSort(arr, si, pIdx-1);
        quickSort(arr, pIdx+1, ei);
    }
    public static int partition(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i = si-1;

        for(int j = si; j<ei; j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;
    }

    public static int Search(int arr[], int tar, int si, int ei){
        // if start index crosses end index, target not found
        if(si > ei){
            return -1;
        }

        int mid = si + (ei-si)/2;

        // found at mid
        if(arr[mid] == tar){
            return mid;
        }

        // Case 1 : mid on L1
        if(arr[si] <= arr[mid]){
            //case a: left of L1
            if(arr[si] <= tar && tar <= arr[mid]){
                return Search(arr, tar, si, mid-1);
            }
            // case b: right of L1
            else{
                return Search(arr, tar, mid+1, ei);
            }
        }

        //case 2: mid on L2
        else{
            //case c: right of L2
            if(arr[mid] <= tar && tar <= arr[ei]){
                return Search(arr, tar, mid+1, ei);
            }
            //case d: left of L2
            else{
                return Search(arr, tar, si, mid-1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.err.println("---------- Divide and Conquer ----------");
        System.out.println("1. Merge Sort");
        System.out.println("2. Quick Sort");
        System.out.println("3. Search in a Sorted and rotated array (variation of Binary search)");
        System.out.print("Enter what you want to perform: ");
        int a = Sc.nextInt();

        switch (a) {
            case 1:
                int numbers[] = readArray(Sc);

                System.out.print("The Array you enterd: ");
                printArray(numbers);
                System.out.println("");
                mergeSort(numbers, 0, numbers.length-1);
                System.out.print("Sorted array: ");
                printArray(numbers);
                break;

            case 2:
                int arr[] = readArray(Sc);

                System.out.print("The Array you enterd: ");
                printArray(arr);
                System.out.println("");

                quickSort(arr, 0, arr.length-1);
                System.out.print("Sorted array: ");
                printArray(arr);
                break;

            case 3:
                int snrarr[] = {4,5,6,7,0,1,2};
                int idx = Search(snrarr, 0 , 0 , snrarr.length-1);
                if(idx == -1){
                    System.out.println("Target not found");
                }else{
                    System.out.println("Target found at index " + idx);
                }
        
            default:
                break;
        }
    }
}
