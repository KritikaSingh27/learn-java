package LinkedList;

public class Linkedlist {
    public static class Node {
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

    public void print(){
        if(head == null){
            System.out.println("Linked List is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void addFirst(int data){
        //step 1 - creating a new node
        Node newNode = new Node(data);
        size++;
        //if the linkedlist is empty
        if(head == null){
            head = tail = newNode;
            return;
        }
        //step 2 - making a link
        newNode.next = head;;
        //step 3 - making the newNode as head
        head = newNode;
    }

    public void addLast(int data){
        //step 1 - creating a new node
        Node newNode = new Node(data);
        size++;
        //if the linkedlist is empty
        if(head == null){
            head = tail = newNode;
            return;
        }
        //step 2 - making a link
        tail.next = newNode;
        //step 3 - making the new node as tail
        tail = newNode;
    }

    public void add(int data, int idx){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i < idx-1){
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.add(8,2);
        ll.print();
        System.out.println("Size of the linkedlist: " + ll.size);
    }
}
