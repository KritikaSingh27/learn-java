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

    public int removeFirst(){
        if(size == 0){ //when ll is empty
            System.out.println("Linked List is empty");
            return Integer.MAX_VALUE;
        }

        else if(size == 1){ //when ll has only one element
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data; //to return which value is deleted
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size == 0){ //when ll is empty
            System.out.println("Linked List is empty");
            return Integer.MAX_VALUE;
        }

        else if(size == 1){ //when ll has only one element
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        
        Node prev = head; 
        // prev: i = size-2
        for(int i=0; i < size-2; i++){
            prev =prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int key){
        Node temp = head;
        int i = 0;

        while(temp !=null){
            if(temp.data == key){ //key found
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1; //if not found
    }

    public int helper(int key, Node head){
        //if ll is empty
        if(head == null){
            return -1;
        }
        // if key is found at head
        if(head.data == key){
            return 0;
        }

        int idx = helper(key, head.next);
        //if key is not found
        if(idx == -1){
            return -1;
        }
        //key is found
        return idx+1;
    }
    public int recSearch(int key){
        return helper(key,head);
    }

    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public void deleteNthFromEnd(int n){
        //calculate size of ll
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }
        //when index is on head
        if(n == sz){
            head = head.next;
            return;
        }
        //else
        int i=1;
        int iToFind = sz-n;
        Node prev = head;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        return slow; //slow is the midNode
    }
    public boolean checkPalindrome(){
        //base case
        if(head == null || head.next == null){
            return true;
        }
        // step 1 - find mid
        Node midNode = findMid(head);

        //step 2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // step 3 - check left half and right half
        Node right = prev; // head of the right half
        Node left = head;

        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true; 
    }

    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        return slow; //slow is the midNode
    }

    public Node merge(Node head1 , Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null){
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        
        return merge(newLeft, newRight);
    }

    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addFirst(6);
        ll.addLast(8);
        ll.addLast(3);
        ll.addLast(4);
        ll.add(8,2);
        ll.print();
        // System.out.println(ll.removeFirst() + " is removed from first");
        // ll.print();
        // System.out.println(ll.removeLast() + " is removed from last");
        // ll.print();
        // System.out.println("Size of the linkedlist: " + ll.size);

        // int idx = ll.itrSearch(10);
        // if(idx == -1){
        //     System.out.println("Key not found");
        // }
        // else{
        //     System.out.println("key is found at index: " + idx);
        // }

        // int i = ll.recSearch(3);
        // if(i == -1){
        //     System.out.println("Key not found");
        // }
        // else{
        //     System.out.println("key is found at index: " + i);
        // }
        
        // ll.reverse();
        // ll.print();

        // ll.deleteNthFromEnd(2);
        // ll.print();

        // ll.addFirst(2);
        // ll.print();
        // System.out.println(ll.checkPalindrome());

        ll.head = ll.mergeSort(ll.head);
        ll.print();
    }
}
