package ArrayList;

import java.util.ArrayList;

// given a sorted and rotated ArrayList and a target, print true if any pair has the sum equal to the target otherwise false

public class PairSum {
    public static boolean pairsum(ArrayList<Integer>list , int target){
        int bp = -1; //breaking point
        int n = list.size();
        for(int i=0; i<n; i++){
            if(list.get(i) > list.get(i+1)){ //identify breaking point
                bp = i;
                break;
            }
        }

        int lp = bp+1;
        int rp = bp;

        while(lp != rp){
            if(list.get(lp) + list.get(rp) == target){
                return true;
            }

            if(list.get(lp) + list.get(rp) < target){
                lp = (lp + 1) % n;
            }
            else{
                rp = (n + rp - 1) % n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer>list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        System.out.println(pairsum(list, 16));
    }
}
