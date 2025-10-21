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

    public void removeCycle(){
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
        Node prev = null;   //last node
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle
        prev.next = null;
        
    }

    public static void main(String[] args) {
        CircularLL cll = new CircularLL();
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        System.out.println(cll.isCycle());
        cll.removeCycle();
        System.out.println(cll.isCycle());
    }
}
