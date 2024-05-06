

public class Test {
    public static void main(String[] args) {
       
        int arr[] = {1, 2 , 3,  4, 5};

        Node head = Node.buildLinkedList(arr);

        Node.printLinkedList(head);
        System.out.println();

        //Node.deleteOmega(head);

        int r = Node.search(head, 3);
        System.out.println(r);

        //System.out.println(Node.search(head, 1));

    }

}


class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }

    static void printLinkedList(Node head){
        Node hd = head;
        while(hd != null){
            System.out.println(hd.data);
            hd = hd.next;
        }
    }

    static Node buildLinkedList(int arr[]){
        if(arr.length == 0){
            return null;
        }
        Node head = new Node(arr[0]);
        Node hd = head;
        for(int i = 1; i<arr.length; i++){
            Node ch = new Node(arr[i]);
            hd.next = ch;
            hd = ch;
        }
        return head;
    }

    static int search(Node head, int x){
        Node hd = head;
        int pos = 1;
        while(hd != null){
            if(hd.data == x){
                return pos;

            }else{
                pos++;
                hd = hd.next;
            }
                
            
        }
        return -1;
    }

    static Node insertAtAlpha(Node head, int x){
        Node nw = new Node(x);
        nw.next = head;
        return nw;
    }

    static void insertAtOmega(Node head, int x){
        Node nw = new Node(x);
        Node tail = null, hd = head;

        while(hd != null){
            if(hd.next == null){
                tail = hd;
                break;
            }
            hd = hd.next;
        }
        tail.next = nw;
    }

    static Node deleteAlpha(Node head){
        Node hd = head.next;

        //returning new head as in Java the compiler has automatic garbage collection, it delets the previous head node..
        return hd;   

    }

    static void deleteOmega(Node head){
        Node hd = head;
        
        while(hd.next.next != null){
            hd = hd.next;
        }
        hd.next = null;
    }
}


