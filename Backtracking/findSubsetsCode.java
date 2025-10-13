package Backtracking;

public class findSubsetsCode{
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
        String str = "abc";
        String ans = "";
        findSubsets(str, ans, 0);
    }
}
