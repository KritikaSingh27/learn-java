import java.util.*;
public class DivideConquer {
    public static void printArray(int numbers[]){
        for(int i=0; i<numbers.length; i++){
        System.out.print(numbers[i] + " ");
        }
    }

    public static void printStringArray(String words[]){
        for(int i=0; i<words.length; i++){
        System.out.print(words[i] + " ");
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

    public static String[] readSringArray(Scanner sc){
        System.out.print("How many elements do you want to add in the words Array: ");
        int n = sc.nextInt();

        if(n <= 0){
            return new String[0];
        }

        String words[] = new String[n];
        for(int i = 0; i < n; i++){
            System.out.print("Enter word: ");
            words[i] = sc.next();
        }
        return words;
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

    public static void stringMergeSort(String words[], int si, int ei){
        if(si>=ei){
            return;
        }
        int mid = si + (ei - si)/2;
        stringMergeSort(words, si, mid);
        stringMergeSort(words, mid+1, ei);
        stringMerge(words, si, mid, ei);
    }
    public static void stringMerge(String words[] , int si, int mid, int ei){
        String temp[] = new String[ei - si +1];

        int i = si;
        int j = mid + 1;
        int k = 0;

        while(i<=mid && j<=ei){
            if(words[i].compareTo(words[j]) < 0){
                temp[k] = words[i];
                i++;
            } else{
                temp[k] = words[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            temp[k++] = words[i++];
        }

        while(j<=ei){
            temp[k++] = words[j++];
        }

        for( k = 0, i = si; k < temp.length; k++, i++){
            words[i] = temp[k];
        }
    }

    private static int countInRange(int nums[], int num, int si, int ei){
        int count = 0;
        for(int i=si; i<=ei; i++){
            if(nums[i] == num){
                count++;
            }
        }
        return count;
    }
    private static int majorityElementRec(int nums[], int si, int ei){
        if(si == ei){
            return nums[si];
        }
        int mid = si + (ei-si)/2;

        int left = majorityElementRec(nums, si, mid);
        int right = majorityElementRec(nums, mid+1, ei);

        if(left == right){
            return left;
        }
        int leftCount = countInRange(nums, left , si, ei);
        int rightCount = countInRange(nums, right, si, ei);

        return leftCount > rightCount ? left : right ;
    }
    public static int majorityElement(int nums[]){
        return majorityElementRec(nums, 0, nums.length-1);
    }

    public static int invMerge( int arr[], int si,int mid, int ei){
        int temp[] = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;
        int invCount = 0;

        while(i<= mid && j<=ei){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
                invCount += (mid - i + 1);
            }
            k++;
        }

        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=ei){
            temp[k++] = arr[j++];
        }

        for(i=si, k=0; k<temp.length; k++,i++){
            arr[i] = temp[k];
        }
        return invCount;
    }
    public static int countInv(int arr[], int si, int ei){
        if(si<ei){
            int mid = si + (ei-si)/2;
            
            int leftInvCount = countInv(arr, si, mid);
            int rightInvCount = countInv(arr, mid+1, ei);
            int mergeInvCount = invMerge(arr, si, mid, ei);

            int invCount = leftInvCount + rightInvCount + mergeInvCount;
            return invCount;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.err.println("---------- Divide and Conquer ----------");
        System.out.println("1. Merge Sort");
        System.out.println("2. Quick Sort");
        System.out.println("3. Search in a Sorted and rotated array (variation of Binary search)");
        System.out.println("4. Merge sort for an array of Strings");
        System.out.println("5. Find the majority element of an array");
        System.out.println("6. Find the inversion count in the array");
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
                System.out.println("Enter a Sorted and Rotated Array");
                int snrarr[] = readArray(Sc);
                System.out.print("The Array you entered: ");
                printArray(snrarr);

                System.out.println("");
                System.out.print("Enter Target: ");
                int target = Sc.nextInt();
                int idx = Search(snrarr, target , 0 , snrarr.length-1);
                if(idx == -1){
                    System.out.println("Target not found");
                }else{
                    System.out.println("Target found at index " + idx);
                }

                break;

            case 4:
                String words[] = readSringArray(Sc);

                System.out.print("The Array you enterd: ");
                printStringArray(words);
                System.out.println("");

                stringMergeSort(words, 0, words.length-1);
                System.out.print("Sorted Array: ");
                printStringArray(words);

                break;
        
            case 5:
                int nums[] = readArray(Sc);
                int result = majorityElement(nums);
                System.out.println("The majority element in the given array is: " + result);

            case 6:
                int array[] = readArray(Sc);
                int invCount = countInv(array, 0, array.length-1);
                System.out.println("The Inversion count of the given array is: " + invCount);

            default:
                break;
        }
    }
}
