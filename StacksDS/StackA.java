package StacksDS;

import java.util.ArrayList;

public class StackA {
    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();

        //to check if the stack is empty
        public boolean isEmpty(){
            return list.size() == 0;
        }

        //Push
        public void push(int data){
            list.add(data);
        }

        //Pop
        public int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }

        //Peek
        public int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
