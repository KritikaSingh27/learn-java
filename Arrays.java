    import java.util.*;
public class Arrays{
    public static void printArray(int numbers[]){
        for(int i=0; i<numbers.length; i++){
        System.out.print(numbers[i] + " ");
        }
    }

    public static int linearSearch(int numbers[], int key){
        for(int i=0; i<numbers.length; i++){
            if(numbers[i]==key){
                return i;
            }
        }
        return -1;
    }
    
    public static int getLargest(int numbers[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<numbers.length; i++){
            if(largest<numbers[i]){
                largest= numbers[i];
            }
        }
        return largest;
    }

    public static int getSmallest(int numbers[]){
        int smallest= Integer.MAX_VALUE;
        for(int i=0; i<numbers.length; i++){
            if(smallest>numbers[i]){
                smallest= numbers[i];
            }
        }
        return smallest;
    }

    public static int BinarySearch(int numbers[], int key){
        int start=0;
        int end= numbers.length -1 ;
        while(start<=end){
            int mid = (start+end)/2;
            if(numbers[mid]== key){
                return mid;
            }
            else if(numbers[mid]<key){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }

    public static void reverse(int numbers[]){
        int start=0;
        int end = numbers.length-1;
        while(start<end){        // Swap
            int temp = numbers[end];
            numbers[end]= numbers[start];
            numbers[start]=temp;
            start++;
            end--;
        }
        System.out.print("{");
        for(int i=0; i<numbers.length; i++){
            System.out.print(numbers[i] + ",");
        }
        System.out.print("}");
    }

    public static void PrintPairs(int numbers[]){
        for(int i=0; i<numbers.length; i++){
            int curr= numbers[i];
            for(int j=i+1; j<numbers.length; j++){
                System.out.print("(" + curr + "," + numbers[j] + ")");
            }
            System.out.println();
        }
    }

    public static void subarrays(int numbers[]){
        for(int i=0; i<numbers.length; i++){
            for(int j=i; j<numbers.length; j++){
                for(int k=i; k<=j; k++){
                    System.out.print(numbers[k]+ " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void brute(int numbers[]){
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0; i<numbers.length; i++){
            for(int j=i; j<numbers.length; j++){
                currSum=0;
                for(int k=i; k<=j; k++){
                    currSum+=numbers[k];
                }
                System.out.println(currSum);
                if(maxSum<currSum){
                    maxSum=currSum;
                }
            }
        }
        System.out.println("maximum sum = " + maxSum);
    }

    public static void prefixSum(int numbers[]){
        int currSum=0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];
        prefix[0] = numbers[0];
        for(int i=1; i<prefix.length; i++){
            prefix[i] = prefix[i-1] + numbers[i];
        }
        for(int i=0; i<numbers.length; i++){
            for(int j=i; j<numbers.length; j++){
                currSum=i==0 ? prefix[j]: prefix[j]-prefix[i-1];
                if(maxSum < currSum){
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Maximum sum = " + maxSum);
    }

    public static void kadanes(int numbers[]){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i=0; i<numbers.length; i++){
            currSum+=numbers[i];
            if(currSum<0){
                currSum=0;
            }
            maxSum = Math.max(currSum, maxSum);
        }
        System.out.println("Maximum sum = " + maxSum);
    }

    public static int trappedRainwater(int height[]){
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for(int i=1; i<height.length; i++){
            leftMax[i] = Math.max(height[i],leftMax[i-1]);
        }
        int rightMax[] = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }
        int trappedWater=0;
        for(int i=0; i<height.length; i++){
            int waterLevel = Math.min(leftMax[i],rightMax[i]);
            trappedWater+= waterLevel-height[i];    //considering width to be 1 unit
        }
        return trappedWater;
    }

    public static int stockProfit(int prices[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++){
            if(buyPrice < prices[i]){
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit , profit);
            }
            else{
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static boolean repetition(int numbers[]){
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                if(numbers[i] == numbers[j]){
                return true;
                }
            } 
        }
        return false;
    }

    public static int searchSol_2(int numbers[], int start, int end, int target){
        while(start<=end){
            int mid = start + (end - start)/2 ;
            if(numbers[mid] == target){
                return mid;
            }
            else if(numbers[mid] < target){
                start= mid +1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }

    public static int minIndex(int numbers[]){
        int start = 0;
        int end = numbers.length-1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(mid>0 && numbers[mid]<numbers[mid-1]){
                return mid;
            }
            else if(numbers[start]<=numbers[mid] && numbers[end]<numbers[mid]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return end;
    }

    public static int search(int numbers[], int target){
        int min = minIndex(numbers);
        if(numbers[min] <= target && target <= numbers[numbers.length-1]){
            return searchSol_2(numbers, min, numbers.length-1, target);
        }
        else{
            return searchSol_2(numbers, 0, min, target);
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
        System.out.println("2. Linear Search");
        System.out.println("3. Largest number");
        System.out.println("4. Smallest number");
        System.out.println("5. Binary Search"); //can be used only if the array is Sorted
        System.out.println("6. Reverse the Array and print it");
        System.out.println("7. Print Pairs");
        System.out.println("8. Print Subarrays");
        System.out.println("9. Max Subarray sum");
        System.out.println("10. Trapping rainwater");
        System.out.println("11. maximum profit from Buy and Sell Stocks");
        System.out.println("12. check if there is any repetition ");
        System.out.println("13. Solution 2");
        
        System.out.print("Which function do you want to perform: ");
        int a = Sc.nextInt();
        if(a==1){
            printArray(numbers);
        }
        else if(a==2){
            System.out.print("Enter the key whose index you want to search");
            int key= Sc.nextInt();
            int index= linearSearch(numbers,key);
            if(index==-1){
                System.out.println("NOT FOUND !");
            }
            else{
                System.out.println("Key is at Index: " + index);
            }
        }
        else if(a==3){
            System.out.print("The largest number in this Array is: " + getLargest(numbers));
        }
        else if(a==4){
            System.out.print("The Smallest number in this Array is: " + getSmallest(numbers));
        }
        else if(a==5){
            System.out.print("Enter the key whose index you want to search");
            int key= Sc.nextInt();
            int index= BinarySearch(numbers,key);
            if(index==-1){
                System.out.println("NOT FOUND !");
            }
            else{
                System.out.println("Key is at Index: " + index);
            }
        }
        else if(a==6){
            reverse(numbers);
        }
        else if(a==7){
            PrintPairs(numbers);
        }
        else if(a==8){
            subarrays(numbers);
        }
        else if(a==9){
            System.out.println("Select Method: ");
            System.out.println("1. Brute force");
            System.out.println("2. Prefix sum");
            System.out.println("3. KADANE's Algorithm"); // cannot be used if all the numbers are negative
            System.out.print("Enter your choice: ");
            int ch= Sc.nextInt();
            if(ch==1){
                brute(numbers);
            }
            else if(ch==2){
                prefixSum(numbers);
            }
            else if(ch==3){
                kadanes(numbers);
            }
            else{
                System.out.print("Wrong Entry !!!");
            }
        }
        else if(a==10){
            System.out.print("Do you want to keep the height array same as you entered (y/n) : ");
            char ch = Sc.next().charAt(0);
            if(ch== 'y' || ch== 'Y'){
                System.out.print("Trapped Rainwater is = " + trappedRainwater(numbers) + " units");
            }
            else if(ch=='n'|| ch=='N'){
                System.out.print("How many elements do you want to add in the height array : ");
                int e = Sc.nextInt();
                int height[] = new int[e];
                for(int i=0; i<e; i++){
                    System.out.print("Enter number: ");
                    height[i]= Sc.nextInt();
                }
                System.out.print("Trapped Rainwater is = " + trappedRainwater(height) + " units");
            }
            else{
                System.out.println("Invalid choice !!!");
            }
        }
        else if(a==11){
            System.out.print("Do you want to keep the prices array same as you entered (y/n) : ");
            char ch = Sc.next().charAt(0);
            if(ch== 'y' || ch== 'Y'){
                System.out.print("Highest profit obtained is = " + stockProfit(numbers));
            }
            else if(ch=='n'|| ch=='N'){
                System.out.print("How many elements do you want to add in the prices array : ");
                int e = Sc.nextInt();
                int prices[] = new int[e];
                for(int i=0; i<e; i++){
                    System.out.print("Enter number: ");
                    prices[i]= Sc.nextInt();
                }
                System.out.print("Highest profit obtained is = " + stockProfit(prices));
            }
            else{
                System.out.println("Invalid choice !!!");
            }
        }
        else if(a==12){
            System.out.println(repetition(numbers));
        }
        else if(a==13){
            System.out.print("Enter a number to search: ");
            int key = Sc.nextInt();
            System.out.println("Index of the number is:" + search(numbers,key));
        }
        else{
            System.out.print("Wrong Entry !!!");
        }
    }
}