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

    public static void findPermutations(String str, String ans){
        //base case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        for(int i=0; i< str.length(); i++){
            //choose the current character
            char curr = str.charAt(i);
            //remove curr from the string
            String newStr = str.substring(0, i) + str.substring(i+1);
            //adding curr at last
            findPermutations(newStr, ans + curr);
        }
    }

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        
        System.out.println("1. Find all the subsets of a string");
        System.out.println("2. Find all the permutations of a string");
        System.out.print("Which function do you want to perform: ");
        int a = Sc.nextInt();

        if(a == 1){
            String str = "abc";
            String ans = "";
            findSubsets(str, ans, 0);
        }
        
        else if(a==2){
            String str = "abc";
            String ans = "";
            findPermutations(str, ans);
        }
    }
}
