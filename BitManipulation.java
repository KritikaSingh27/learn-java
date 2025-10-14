import java.util.*;
public class BitManipulation{
    public static void OddOrEven(int n){
        int bitmask = 1;
        if((n & bitmask) == 0){
            System.out.println("Even number");
        }
        else{
            System.out.println("Odd number");
        }
    }

    public static int getIthBit(int n, int i){
        int bitmask = 1<<i;
        if((n & bitmask) == 0){
            return 0;
        }
        else{
            return 1;
        }
    }

    public static int SetIthBit(int n, int i){
        int bitmask = 1<<i;
        return n|bitmask ;
    }

    public static int ClearIthBit(int n, int i){
        int bitmask = ~(1<<i);
        return (n & bitmask);
    }

    public static int UpdateIthBit1(int n, int i, int newBit){
        if(newBit == 0){
            return ClearIthBit(n,i);
        }
        else{
            return SetIthBit(n,i);
        }
    }

    public static int UpdateIthBit2(int n, int i, int newBit){
        n = ClearIthBit(n,i);
        int bitmask = newBit<<i;
        return n|bitmask ;
    }

    public static int ClearIBits(int n, int i){
        int bitmask = (~0)<<i;
        return (n & bitmask);
    }

    public static int ClearRange(int n, int i, int j){
        int a = ((~0)<<(j+1));
        int b = ((1<<i)-1);
        int bitmask = a|b;
        return (n & bitmask);
    }

    public static boolean ispowerOfTwo(int n){
        return(n & (n-1)) == 0;
    }

    public static int CountSetBits(int n){
        int count = 0;
        while(n>0){
            if((n & 1) != 0){
                count++;
            }
            n = n>>1;
        }
        return count;
    }

    public static int fastExpo(int a, int n){
        int ans = 1;
        while(n>0){
            if((n & 1) != 0){
                ans = ans*a;
            }
            a = a*a;
            n = n>>1;
        }
        return ans;
    }

    public static void main(String args[]){
        Scanner Sc = new Scanner(System.in);
        System.out.println("Choose the function you want to perform using Bit Manipulation ");
        System.out.println("1. check if a number is Odd or Even");
        System.out.println("2. Get Ith bit");
        System.out.println("3. Set Ith bit");
        System.out.println("4. Clear Ith bit");
        System.out.println("5. Update Ith bit");
        System.out.println("6. Clear I bits");
        System.out.println("7. Clear bits in a given range");
        System.out.println("8. Check if the number is in exponent of 2");
        System.out.println("9. Count set bits");
        System.out.println("10. fast exponentition");
        int ch = Sc.nextInt();
        if(ch==1){
            
        }
    }
}