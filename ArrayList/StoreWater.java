package ArrayList;
import java.util.ArrayList;

public class StoreWater{
    public static int storeWater(ArrayList<Integer> height){ //to calculate which is the largest container that can be formed
        int maxWater = 0;
        int lp = 0;
        int rp = height.size() - 1;

        while (lp < rp) {
            // Calculate the area of water
            int ht = Math.min(height.get(lp), height.get(rp));
            int wd = rp - lp;
            int currWater = ht * wd;
            maxWater = Math.max(maxWater, currWater);

            // Update pointer
            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {

        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println("Maximum water stored: " + storeWater(height));
    }
}
