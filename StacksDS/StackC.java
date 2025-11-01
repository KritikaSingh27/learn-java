package StacksDS;

import java.util.*;

public class StackC {
    //push an element at the bottom of the string
    public static void pushAtBottom(int data, Stack<Integer> s){
        //base case
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(data, s);
        s.push(top);
    }

    //Reverse a stack
    public static void reverseStack(Stack<Integer>s){
        if(s.isEmpty()){
            return;
        }

        int top = s.pop();
        reverseStack(s);
        pushAtBottom(top, s);
    }

    //Reverse a string using a stack
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder result = new StringBuilder();
        while(!s.isEmpty()){
            char curr = s.pop();
            result.append(curr);
        }

        return result.toString();
    }


    public static void stockSpan(int stocks[], int span[]){
        Stack<Integer>s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i = 1; i<stocks.length; i++){
            int  currPrice = stocks[i];
            while (!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }
            else{
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

    public static void printStack(Stack<Integer>s){
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);

        pushAtBottom(4, s);

        reverseStack(s);
        printStack(s);

        String str = "abc";
        System.out.println("The reversed string is : " + reverseString(str));

        int stocks[] = {100,80,60,70,60,85,100};
        int span[] = new int[stocks.length];
        stockSpan(stocks, span);
        
        for(int i=0; i<span.length; i++){
            System.out.print(span[i] + " ");
        }
    }
}
