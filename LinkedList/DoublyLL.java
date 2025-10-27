package LinkedList;

public class DoublyLL {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void  print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void addFirst(int data){
        //create new node 
        Node newNode = new Node(data);
        size++;
        // only one node
        if(head ==  null){
            head = tail = newNode;
            return;
        }
        //add in the first
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data){
        //create new node
        Node newNode = new Node(data);
        size++;
        //if only one node
        if(head == null){
            head = tail = newNode;
            return;
        }
        //add in the last
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
    }

    public int removeFirst(){
        if(head == null){
            System.out.println("DLL is emmpty");
            return Integer.MIN_VALUE;
        }

        if(size == 1){
            int val = head.data;
            head = tail = null;
            size --;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size --;
        return val;
    }

    public int removeLast(){
        if(head == null){
            System.out.println("DLL is emmpty");
            return Integer.MAX_VALUE;
        }

        if(size == 1){
            int val = head.data;
            head = tail = null;
            size --;
            return val;
        }

        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        dll.addFirst(5);
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(6);
        dll.addLast(7);
        dll.print();
        System.out.println(dll.removeFirst() + " is removed from first");
        System.out.println(dll.removeLast() + " is removed from last");
        dll.print();
        System.out.println("Size of the LL is: " + size);
    }
}
