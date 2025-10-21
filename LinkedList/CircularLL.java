package LinkedList;

public class CircularLL {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //detect cycle in a LL
    // Floyd's cycle finding algorithm
    public boolean isCycle(){
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle(){
        // detect cycle - Floyd's cycle finding algorithm
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
               isCycle = true;
               break;
            }
        }
        if(isCycle == false){
            return;
        }

        //find meeting point
        slow = head;
        
    }

    public static void main(String[] args) {
        CircularLL cll = new CircularLL();
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(2);
        head.next.next.next.next = null;
        System.out.println(cll.isCycle());
    }
}
