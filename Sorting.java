import java.util.*;
public class Sorting{
    public static void printArray(int numbers[]){
        for(int i=0; i<numbers.length; i++){
        System.out.print(numbers[i] + " ");
        }
    }

    public static void bubbleSort(int numbers[]){
        for(int turn=0; turn <numbers.length-1; turn++){
            for(int j=0; j<numbers.length-1-turn; j++){
                if(numbers[j] > numbers[j+1]){
                    int temp = numbers[j];          //swapping
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
    }

    public static void SelectionSort(int numbers[]){
        for(int i=0; i<numbers.length-1; i++){
            int minPos = i;
            for(int j=i+1; j<numbers.length; j++){
                if(numbers[minPos] > numbers[j]){
                    minPos = j;
                }
            }
            int temp = numbers[minPos];
            numbers[minPos] = numbers[i];
            numbers[i] = temp;
        }
    }

    public static void InsertionSort(int numbers[]){
        for(int i=0; i<numbers.length-1; i++){
            int curr = numbers[i];
            int prev = i-1;
            while(prev>=0 && numbers[prev] > curr){
                numbers[prev+1] = numbers[prev];
                prev--;
            }
            numbers[prev+1] = curr;
        }
    }

    public static void CountingSort(int numbers[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<numbers.length; i++){
            largest = Math.max(largest,numbers[i]);
        }
        int count[] = new int[largest+1];
        for(int i=0; i<numbers.length; i++){
            count[numbers[i]]++;
        }
        int j=0;
        for(int i=0; i<count.length; i++){
            while(count[i]>0){
                numbers[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void bubbleSortDec(int numbers[]){
        for(int turn=0; turn <numbers.length-1; turn++){
            for(int j=0; j<numbers.length-1-turn; j++){
                if(numbers[j] < numbers[j+1]){
                    int temp = numbers[j];          //swapping
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
    }

    public static void SelectionSortDec(int numbers[]){
        for(int i=0; i<numbers.length-1; i++){
            int minPos = i;
            for(int j=i+1; j<numbers.length; j++){
                if(numbers[minPos] < numbers[j]){
                    minPos = j;
                }
            }
            int temp = numbers[minPos];
            numbers[minPos] = numbers[i];
            numbers[i] = temp;
        }
    }

    public static void InsertionSortDec(int numbers[]){
        for(int i=0; i<numbers.length; i++){
            int curr = numbers[i];
            int prev = i-1;
            while(prev>=0 && numbers[prev] < curr){
                numbers[prev+1] = numbers[prev];
                prev--;
            }
            numbers[prev+1] = curr;
        }
    }

    public static void CountingSortDec(int numbers[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<numbers.length; i++){
            largest = Math.max(largest,numbers[i]);
        }
        int count[] = new int[largest+1];
        for(int i=numbers.length-1; i>=0; i--){
            count[numbers[i]]++;
        }
        int j=numbers.length-1;
        for(int i=0; i<count.length; i++){
            while(count[i]>0){
                numbers[j] = i;
                j--;
                count[i]--;
            }
        }
    }

    public static void main(String args[]){
        Scanner Sc = new Scanner(System.in);
        System.out.print("How many elements do you want to add in the Array: ");
        int n= Sc.nextInt();
        int numbers[] = new int[n];
        for(int i=0; i<=n-1; i++){
            System.out.print("Enter number: ");
            numbers[i]= Sc.nextInt();
        }
        System.out.println();
        System.out.println("1. Print the Array");
        System.out.println("2. SORT in Ascending order");
        System.out.println("3. SORT in Descending order");

        System.out.print("Which function do you want to perform: ");
        int a = Sc.nextInt();
        if(a==1){
            printArray(numbers);
        }

        else if(a==2){
            System.out.println("Choose method");
            System.out.println("1. BUBBLE Sort");
            System.out.println("2. SELECTION Sort");
            System.out.println("3. Insertion Sort");
            System.out.println("4. Counting Sort");
            System.out.print("Enter your choice: ");
            int ch = Sc.nextInt();
            if(ch==1){
                bubbleSort(numbers);
                printArray(numbers);
            }
            else if(ch==2){
                SelectionSort(numbers);
                printArray(numbers);
            }
            else if(ch==3){
                InsertionSort(numbers);
                printArray(numbers);
            }
            else if(ch==4){
                CountingSort(numbers);
                printArray(numbers);
            }
            else{
                System.out.println("Invalid Entry !!!");
            }
        }
        else if(a==3){
            System.out.println("Choose method");
            System.out.println("1. BUBBLE Sort");
            System.out.println("2. SELECTION Sort");
            System.out.println("3. Insertion Sort");
            System.out.println("4. Counting Sort");
            System.out.print("Enter your choice: ");
            int ch = Sc.nextInt();
            if(ch==1){
                bubbleSortDec(numbers);
                printArray(numbers);
            }
            else if(ch==2){
                SelectionSortDec(numbers);
                printArray(numbers);
            }
            else if(ch==3){
                InsertionSortDec(numbers);
                printArray(numbers);
            }
            else if(ch==4){
                CountingSortDec(numbers);
                printArray(numbers);
            }
            else{
                System.out.println("Invalid Entry !!!");
            }
        }
    }
}