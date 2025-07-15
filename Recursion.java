import java.util.*;
public class Recursion{
    public static void printInc(int n){     
        if(n==1){
            System.out.print(1);
            return;
        }
        printInc(n-1);
        System.out.print(n + " ");
    }

    public static void printDec(int n){
        if(n==1){
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        printDec(n-1);
    }

    public static int fact(int n){
        if(n==0){
            return 1;
        }
        int factnm1=fact(n-1);
        int factn=n*factnm1;
        return factn;
    }
    public static int sum(int n){
        if(n==1){
            return 1;
        }
        int sumnm1=sum(n-1);
        int sumn=n+sumnm1;
        return sumn;
    }
    public static int fib(int n){
        if(n==0|| n==1){
            return n;
        }
        int fnm1 = fib(n-1);
        int fnm2 = fib(n-2);
        int fn = fnm1 + fnm2;
        return fn;
    }
    public static boolean isSorted(int arr[], int i){
        if(i== arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr,i+1);
    }
    public static int firstOccur(int arr[], int key, int i){
        if(i==arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        return firstOccur(arr,key,i+1);
    }
    public static int lastOccur(int arr[], int key, int i){ //need to revise this
        if(i==arr.length){
            return -1;
        }
        int isFound = lastOccur(arr,key,i+1);
        if(isFound ==-1 && arr[i]==key){
            return i;
        }
        return isFound;
    }
    public static int pow(int x,int n){ //time complexity: O(n)
        if(n==0){
            return 1;
        }
        return x*pow(x,n-1);
    }
    public static int optimizedPow(int x, int n){ //time complexity: O(log n)
        if(n==0){
            return 1;
        }
        int halfpow = optimizedPow(x,n/2); // for n is even
        int halfpowSq = halfpow*halfpow;
        if(n%2!=0){                         //for n is odd
            halfpowSq = x* halfpowSq;
        }
        return halfpowSq;
    }

    public static int tilingWays(int n){
        if(n==0||n==1){
            return 1;
        }
        int fnm1 = tilingWays(n-1);    //vertical
        int fnm2 = tilingWays(n-2);    //horizontal
        int totalWays = fnm1+fnm2;
        return totalWays;
    }

    public static int removeDuplicates(int idx,string str, StringBuilder newStr, boolean map[]){
        if(idx == str.length()){
            System.out.println(newStr);
            return;
        }
        char currchar = str.charAt(idx);      //duplicate
        if(map[currchar - 'a'] == true){
            removeDuplicates(idx+1,str,newStr,map);     //newStr will not append
        }
        else{
            map[currchar - 'a'] = true;
            removeDuplicates(idx+1,str,newStr.append(currchar),map);
        }
    }

    public static void main(String args[]){
        Scanner Sc = new Scanner(System.in);
        System.out.print("1. Print numbers form 1 to n in increasing order\n");
        System.out.print("2. Print numbers form 1 to n in decreasing order\n");
        System.out.print("3. Factorial of a Number \n");
        System.out.print("4. Sum of first n natural numbers \n");
        System.out.print("5. Find the nth Fibonacci number \n");
        System.out.print("6. Check if the given array is sorted or not \n");
        System.out.print("7. Find the index of the first occurence of the searched key \n");
        System.out.print("8. Find the index of the last occurence of the searched key \n");
        System.out.print("9. To find X to the power n \n");
        System.out.print("10. To find X to the power n by a optimised method \n");
        System.out.print("11. Tiling problem \n");
        System.out.pirnt("12. Remove duplicate in a string \n");    
        //for the string with no special characters or capital letters (we can easily make an extended version for that)

        System.out.print("Which function do you want to perform : ");
        int a = Sc.nextInt();
        if(a==1){
            System.out.print("Enter n :");
            int n = Sc.nextInt();
            printInc(n);
        }
        else if(a==2){
            System.out.print("Enter n :");
            int n = Sc.nextInt();
            printDec(n);
        }
        else if(a==3){
            System.out.print("Enter n :");
            int n = Sc.nextInt();
            int factorial= fact(n);
            System.out.print(factorial);
        }
        else if(a==4){
            System.out.print("Enter n :");
            int n = Sc.nextInt();
            int sum = sum(n);
            System.out.print(sum);
        }
        else if(a==5){
            System.out.print("Enter n :");
            int n = Sc.nextInt();
            int fibo = fib(n);
            System.out.print(fibo);
        }
        else if(a==6){
            System.out.print("How many elements do you want to add in the Array: ");
            int n= Sc.nextInt();
            int numbers[] = new int[n];
            for(int i=0; i<=n-1; i++){
                System.out.print("Enter number: ");
                numbers[i]= Sc.nextInt();
            }
            boolean ans = isSorted(numbers,0);
            if(ans==true){
                System.out.print("The given array is sorted");
            }
            else{
                System.out.print("The given array is not sorted");
            }
        }
        else if(a==7){
            System.out.print("How many elements do you want to add in the Array: ");
            int n= Sc.nextInt();
            int numbers[] = new int[n];
            for(int i=0; i<=n-1; i++){
                System.out.print("Enter number: ");
                numbers[i]= Sc.nextInt();
            }
            System.out.print("Enter key :");
            int key = Sc.nextInt();
            int ind = firstOccur(numbers,key,0);
            if(ind == -1){
                System.out.print("Key not found");
            }
            else{
                System.out.print("Key found at index: " + ind);
            }
        }
        else if(a==8){
            System.out.print("How many elements do you want to add in the Array: ");
            int n= Sc.nextInt();
            int numbers[] = new int[n];
            for(int i=0; i<=n-1; i++){
                System.out.print("Enter number: ");
                numbers[i]= Sc.nextInt();
            }
            System.out.print("Enter key :");
            int key = Sc.nextInt();
            int ind = lastOccur(numbers,key,0);
            if(ind == -1){
                System.out.print("Key not found");
            }
            else{
                System.out.print("Key found at index: " + ind);
            }
        }
        else if(a==9){
            System.out.print("Enter X: ");
            int x = Sc,nextInt();
            System.out.print("Enter n: ");
            int n = Sc.nextInt();
            System.out.print(pow(x,n));
        }
        else if(a==10){
            System.out.print("Enter X: ");
            int x = Sc.nextInt();
            System.out.print("Enter n: ");
            int n = Sc.nextInt();
            System.out.print(optimizedPow(x,n));
        }
        else if(a==11){
            System.out.print("Enter n: ");
            int n = Sc.nextInt();
            System.out.print(tilingWays(n));
        }
        else if(a==12){
            String str = "kritika";
            removeDuplicates(0,str,new StringBuilder(""),new boolean[26]);
        }
        else{
            System.out.print("Invalid Entry!!!");
        }
    }
}