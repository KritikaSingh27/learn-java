package Backtracking;

//find the number of ways to reach from (i,j) to (n-1,m-1) in a N x M matrix 
//Allowed moves - Right or down

//Time Complexity: O(2**(m+n))

public class GridWays {
    public static int gridWays(int i, int j, int n, int m){
        //base case
        if(i==n-1 && j==n){  //last cell condition
            return 1;
        }
        else if(i==n || j==n){ //no ways
            return 0;
        }

        //calculating ways
        int w1 = gridWays(i+1, j, n, m); // down
        int w2 = gridWays(i, j+1, n, m); // Right
        return w1+w2;
    }

    //we can make this code optimal by directly finding the number of ways by the formula of permutations

    public static void main(String[] args) {
        int ways = gridWays(0, 0, 3, 4);
        System.out.println("Number of ways in which we can reach the target is :" + ways);
    }
}
