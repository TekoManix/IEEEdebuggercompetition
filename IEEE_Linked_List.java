import org.w3c.dom.Node;

public class IEEE_Linked_List {
    private Node head;
    private int size;

    public void remove(int index){
        //TODO: Implement the remove function for linked list
    }

    /**
     * You must swap indexes at int i and j
     * @param i
     * @param j
     */
    public void swap(int i, int j) {
        //TODO: Implement the swap function for linked list
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }else{
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    public int size(){
        return size;
    }

    public int get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        int count = 0;

        while(current != null){
            if(count == index){
                return current.data;
            }
            count ++;
            current = current.next;
        }
        return -1;
    }


    public boolean isEmpty(){
        return size == 0;
    }



    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    public IEEE_Linked_List() {
        head = null;
        size = 0;
    }





}
