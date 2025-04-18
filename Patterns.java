import java.util.*;
public class Patterns{
    public static void main(String args[]){
        Scanner Sc= new Scanner(System.in);
        System.out.println("1. Half pyramid (stars)");
        System.out.println("2. Half pyramid (recurring numbers)");
        System.out.println("3. Half pyramid (alphabets) ");
        System.out.println("4. Inverted half pyramid (stars)");
        System.out.println("5. Inverted half pyramid (recurring numbers)");
        System.out.println("6. Floyd's triangle");
        System.out.println("7. Hollow rectangle");
        System.out.println("8. Reverse Half pyramid (stars)");
        System.out.println("9. Pyramid");
        System.out.println("10. Inverted pyramid");
        System.out.println("11. 0-1 Triangle");
        System.out.println("12. Butterfly");
        System.out.println("13. Rhombus");
        System.out.println("14. Hollow Rhombus");
        System.out.println("15. Diamond");
        System.out.print("Enter what you want to print: ");
        int n= Sc.nextInt();
        if(n==1){
            System.out.print("Enter number of lines: ");
            int a= Sc.nextInt();
            star_half_pyramid(a);
        }
        else if(n==2){
            System.out.print("Enter number of lines: ");
            int a= Sc.nextInt();
            recnum_half_pyramid(a);
        }
        else if(n==3){
            System.out.print("Enter number of lines: ");
            int a=Sc.nextInt();
            alpha_half_pyramid(a);
        }
        else if(n==4){
            System.out.print("Enter number of lines: ");
            int a=Sc.nextInt();
            star_inv_half_pyramid(a);
        }
        else if(n==5){
            System.out.print("Enter number of lines: ");
            int a= Sc.nextInt();
            recnum_inv_half_pyramid(a);
        }
        else if(n==6){
            System.out.print("Enter number of lines: ");
            int a= Sc.nextInt();
            floyd_triangle(a);
        }
        else if(n==7){
            System.out.print("Enter length: ");
            int l= Sc.nextInt();
            System.out.print("Enter width: ");
            int b= Sc.nextInt();
            hollow_rectangle(l,b);
        }
        else if(n==8){
            System.out.print("Enter number of lines: ");
            int a= Sc.nextInt();
            rev_half_pyramid(a);
        }
        else if(n==9){
            System.out.print("Enter number of lines: ");
            int a= Sc.nextInt();
            pyramid(a);
        }
        else if(n==10){
            System.out.print("Enter number of lines: ");
            int a =Sc.nextInt();
            inv_pyramid(a);
        }
        else if(n==11){
            System.out.print("Enter number of lines: ");
            int a= Sc.nextInt();
            zero_one_triangle(a);
        }
        else if(n==12){
            System.out.print("Enter number of lines: ");
            int a= Sc.nextInt();
            butterfly(a);
        }
        else if(n==13){
            System.out.print("Enter edge length: ");
            int a= Sc.nextInt();
            rhombus(a);
        }
        else if(n==14){
            System.out.print("Enter edge length: ");
            int a= Sc.nextInt();
            hollow_rhombus(a);
        }
        else if(n==15){
            System.out.print("Enter no. of lines: ");
            int a= Sc.nextInt();
            diamond(a);
        }
        else{
            System.out.print("Invalid Entry!!!");
        }
    }

    public static void star_half_pyramid(int a){
        for(int line=1; line<=a; line++){
            for(int star=1; star<=line; star++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void recnum_half_pyramid(int a){
        for(int line=1; line<=a; line++){
            for(int num=1; num<=line; num++){
                System.out.print(num);
            }
            System.out.println();
        }
    }

    public static void alpha_half_pyramid(int a){
        char ch='A';
        for(int line=1; line<=a; line++){
            for(int c=1; c<=line; c++ ){
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }

    public static void star_inv_half_pyramid(int a){
        for(int line=1; line<=a; line++){
            for(int star=1; star<=a-line+1; star++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void recnum_inv_half_pyramid(int a){
        for(int line=1; line<=a; line++){
            for(int num=1; num<=a-line+1; num++){
                System.out.print(num);
            }
            System.out.println();
        }
    }

    public static void floyd_triangle(int a){
        int N=1;
        for(int line=1; line<=a; line++){
            for(int num=1; num<=line; num++){
                System.out.print(N + " ");
                N++;
            }
            System.out.println();
        }
    }

    public static void hollow_rectangle(int length,int width){
        for(int i=1; i<=length; i++){
            for(int j=1; j<=width; j++){
                if(i==1 || i==length || j==1 || j==width){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void rev_half_pyramid(int a){
        for(int i=1; i<=a; i++){
            for(int j=1; j<=a-i; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pyramid(int a){
        for(int i=1; i<=a; i++){
            for(int j=1; j<=a-i; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print(" *");
            }
            System.out.println();
        }
    }

    public static void inv_pyramid(int a){
        for(int i=a; i>=1; i--){
            for(int j=1; j<=(a-i); j++){
                System.out.print(" ");
            }
            for(int j=1; j<=(2*i-1); j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void zero_one_triangle(int a){
        for(int i=1; i<=a; i++){
            for(int j=1; j<=i; j++){
                if((i+j)%2==0){
                    System.out.print("1");
                }
                else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    public static void butterfly(int a){
        for(int i=1; i<=a; i++){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            for(int j=1; j<=2*(a-i); j++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=a; i>=1; i--){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            for(int j=1; j<=2*(a-i); j++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void rhombus(int a){
        for(int i=1; i<=a; i++){
            for(int j=1; j<=a-i; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=a; j++){
                System.out.print(" *");
            }
            System.out.println();
        }
    }

    public static void hollow_rhombus(int a){
        for(int i=1; i<=a; i++){
            for(int j=1; j<=a-i; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=a; j++){
                if(i==1 || i==a || j==1 || j==a){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void diamond(int a){
        for(int i=1; i<=a; i++){          // pyramid
            for(int j=1; j<=(a-i); j++){
                System.out.print(" ");
            }
            for(int j=1; j<=(2*i-1); j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=a; i>=1; i--){         // inverted pyramid
            for(int j=1; j<=(a-i); j++){
                System.out.print(" ");
            }
            for(int j=1; j<=(2*i-1); j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
