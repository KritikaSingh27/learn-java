import java.util.*;
public class JavaBasics{
    public static void subarrays(int numbers[]){
        for(int i=0; i<numbers.length; i++){
            for(int j=1; j<numbers.length; j++){
                int sum=0;
                for(int k=i; k<=j; k++){
                    System.out.print(numbers[k] + " ");
                    sum+=numbers[k];
                }
                System.out.println("  sum = " + sum);
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int numbers[] = {2,4,6,8,10};
        subarrays(numbers);   
    }
}