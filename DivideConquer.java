import java.util.*;
public class DivideConquer {
    public static void printArray(int numbers[]){
        for(int i=0; i<numbers.length; i++){
        System.out.print(numbers[i] + " ");
        }
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
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.err.println("---------- Divide and Conquer ----------");
        System.out.println("1. Merge Sort");
        System.out.println("2. Quick Sort");
        System.out.print("Enter what you want to perform: ");
        int a = Sc.nextInt();

        System.out.print("How many elements do you want to add in the Array: ");
        int n= Sc.nextInt();
        int numbers[] = new int[n];
        for(int i=0; i<=n-1; i++){
            System.out.print("Enter number: ");
            numbers[i]= Sc.nextInt();
        }

        System.out.print("The Array you enterd: ");
        printArray(numbers);
        System.out.println("");

        switch (a) {
            case 1:
                mergeSort(numbers, 0, numbers.length-1);
                System.out.print("Sorted array: ");
                printArray(numbers);
                break;

            case 2:
                quickSort(numbers, 0, numbers.length-1);
                System.out.print("Sorted array: ");
                printArray(numbers);
                break;
        
            default:
                System.out.println("Please try again and choose a valid option");
                break;
        }
    }
}
