package ArrayList;

import java.util.ArrayList;
import java.util.Collections;

//A number x is lonely when it appears only once,and no adjacent numbers (i.e. x + 1 and x - 1) appear in the arraylist.
//Return all lonely numbers in nums.

public class LonelyNumber {
    public static ArrayList<Integer> lonelyNumber(ArrayList<Integer>list){
        Collections.sort(list);
        ArrayList<Integer>nums = new ArrayList<>();
        int n = list.size();

        // if the size is 1, the element is lonely for sure
        if(n == 1){
            nums.add(list.get(0));
        }
        else{
            //check first element
            if(list.get(0) + 1 < list.get(1)){
                nums.add(list.get(0));
            }
            //check middle elements
            for(int i=1; i<n-1; i++){
                if(list.get(i-1) + 1 < list.get(i) && list.get(i) + 1 < list.get(i+1)){
                    nums.add(list.get(i));
                }
            }
            //check last element
            if(list.get(n-2) + 1 < list.get(n-1)){
                nums.add(list.get(n - 1));
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        ArrayList<Integer>list = new ArrayList<>();
        list.add(10);
        list.add(6);
        list.add(5);
        list.add(8);
        System.out.println("The lonely numbers are: " + lonelyNumber(list));
    }
}
