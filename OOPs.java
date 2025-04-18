import java.util.*;
public class OOPs{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First number:-");
        System.out.print("Enter real part: ");
        int a1 = sc.nextInt();
        System.out.print("Enter Imaginary part: ");
        int b1 = sc.nextInt();
        System.out.println("Enter Second number:-");
        System.out.print("Enter real part: ");
        int a2 = sc.nextInt();
        System.out.print("Enter Imaginary part: ");
        int b2 = sc.nextInt();

        System.out.println("The numbers are: "+ a1 + "+i" + b1 + " and " + a2 + "+i" + b2);

        Complex c = new Complex();
        c.sum(a1,b1,a2,b2);
        c.diff(a1,b1,a2,b2);
        c.prod(a1,b2,a2,b2);
    }
}

class Complex{
    void sum(int a1,int b1,int a2, int b2){
        int re = a1+a2;
        int im = b1+b2;
        System.out.println("Sum = " + re + "+ i" + im);
    }

    void diff(int a1,int b1,int a2, int b2){
        int re = a1-a2;
        int im = b1-b2;
        System.out.println("Difference = " + re + "+i" + im);
    }

    void prod(int a1,int b1,int a2, int b2){
        int re = ((a1*a2)-(b1*b2));
        int im = ((b1*a2)+(b2*a1));
        System.out.println("Product = " + re + "+i" + im);
    }
}
