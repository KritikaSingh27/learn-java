import java.util.*;

public class Backtracking {

    public static void findSubsets(String str, String ans, int i){
        //base case
        if(i == str.length()){
            if(str == ""){
                System.out.println("Null");
            }
            else{
                System.out.println(ans);
            }
            return;
        }
        //yes choice
        findSubsets(str, ans+str.charAt(i), i+1);
        //no choice
        findSubsets(str, ans, i+1);
    }

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        
        System.out.println("1. Find all the subsets of a string");
        System.out.print("Which function do you want to perform: ");
        int a = Sc.nextInt();

        if(a == 1){
            String str = "abc";
            String ans = "";
            findSubsets(str, ans, 0);
        }
        
    }
}
