import java.util.*;
public class strings{
    public static boolean isPelindrome(String str){
        for(int i=0; i<str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static float Shortestpath(String path){
        int x = 0;
        int y = 0;
        for(int i=0; i<path.length(); i++){
            char dir = path.charAt(i);
            if(dir == 'E'){
                x++;
            }
            else if(dir =='W'){
                x--;
            }
            else if(dir == 'N'){
                y++;
            }
            else if(dir == 'S'){
                y--;
            }
            else{
                System.out.println("ERROR !");
            }
        }
        int X = x*x;
        int Y = y*y;
        float sd = (float)Math.sqrt(X + Y);
        return sd;
    }

    public static String subString(String str, int si, int ei){
        String substr = "";
        for(int i=si; i<=ei; i++){
            substr += str.charAt(i);
        }
        return substr;
    }

    public static String largest(String arr[]){
        String largest = arr[0];
        for(int i=1; i<arr.length; i++){
            if(largest.compareToIgnoreCase(arr[i])<0){
                largest = arr[i];
            }
        }
        return largest;
    }

    public static String toTitleCase(String str){
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == ' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String compress(String str){
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<str.length(); i++){
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count>1){
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }

    public static int countVowels(String str){
        int count = 0;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                count++;
            }
        }
        return count;
    }
    
        public static void main(String args[]){
        Scanner Sc = new Scanner(System.in);
        System.out.println("Choose function to perform");
        System.out.println("1. Pelindrome or not");
        System.out.println("2. Shortest path");
        System.out.println("3. substring");
        System.out.println("4. Find largest");
        System.out.println("5. Convert to Title Case");
        System.out.println("6. compress string");
        System.out.println("7. Count vowels which are in lowercase");
        System.out.print("Enter your choice: ");
        int a = Sc.nextInt();
        if(a==1){
            System.out.print("Enter your string: ");
            String str;
            str = Sc.next();
            System.out.println(isPelindrome(str));
        }
        else if(a==2){
            System.out.print("Enter the path string (it should be in uppercase and consits of 'E','W','N','S' only): ");
            String path;
            path = Sc.next();
            System.out.println("The shortest path is: " + Shortestpath(path));
        }
        else if(a==3){
            System.out.print("Enter your string: ");
            String str;
            str = Sc.next();
            System.out.print("Enter starting index: ");
            int si = Sc.nextInt();
            System.out.print("Enter ending index: ");
            int ei = Sc.nextInt();
            System.out.println("The sliced substring is: " + subString(str,si,ei));
        }
        else if(a==4){
            System.out.print("Enter the number of elements you want to enter: ");
            int n = Sc.nextInt();
            String str[] = new String[n];
            for(int i=0; i<n; i++){
                System.out.print("Enter element: ");
                str[i] = Sc.next();
            }
            System.out.println("Largest element is: " + largest(str));
        }
        else if(a==5){
            System.out.print("Enter your String: ");
            String str;
            str = Sc.next();
            System.out.println(toTitleCase(str));
        }
        else if(a==6){
            System.out.print("Enter your String: ");
            String str;
            str = Sc.next();
            System.out.println(compress(str));
        }
        else if(a==7){
            System.out.print("Enetr your string: ");
            String str;
            str = Sc.next();
            System.out.println("The number of lowercase vowels in the given string is: " + countVowels(str));
        }
        else{
            System.out.println("Error !!!");
        }
    }
}