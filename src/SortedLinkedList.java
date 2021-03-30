/**
 * A program that implents SortedList along with its functions add, get, remove
 * this program creates a linked list that sorts elements as they are added
 * @param <T>
 */

class Node<T extends Comparable> {
    Comparable<T> data;
    Node<T> next;
    //Node<T> prev;

    public Node(Object data){
        this.data = (T) data;
    }
}
public class SortedLinkedList<T extends Comparable<T>> implements SortedList<T>{

    Node<T> head;
    int size;

    public SortedLinkedList() {
        head = null;
        size = 0;
    }

    //two pointer current and prev using while loop to go thrugh linked list
    //comapre item with each node until we find elemnt grater than item
    //prev.next = "new node"
    //"new node".next = current
    //move pointers by ->
    @Override
    public boolean add(T item) {

        if(head == null){
            head = new Node<T>(item);
            ++size;
            return  true;
        }
        else{
            Node prev = head;
            while(prev.next != null){
                prev = prev.next;
            }

            Node<T>curr = new Node<T>(item);
            prev.next = curr;
            ++size;

        }
        Node current = head;
        Node element = null;
        T newNode;
        //just sort while insering the elemnet
        //create current and new node and temperory variable -> newNode
        while(current != null ){
            element = current.next;
            while(element != null){
                if(current.data.compareTo(element.data) > 0){
                    newNode = (T)current.data;
                    current.data = element.data;
                    element.data = newNode;
                }
                element = element.next;
            }
            current = current.next;

        }
        return true;
    }

    @Override
    public T remove(int pos) throws Exception {
        if(pos > size-1 || pos <0){
            throw new IndexOutOfBoundsException("does not work");
        }
        if(pos == 0){
            T item = (T) head.data;
            head = head.next;
            size--;
            return item;
        }
        else{
            Node prev = head;
            Node<T>current = prev;
            for(int i =0; i < pos-1; i++){
                prev = prev.next;
            }
            Node curr = prev.next;
            T item = (T) curr.data;
            size--;
            return item;
        }
    }
    //a function that returns a position

    @Override
    public T get(int pos) throws Exception {
        if(pos>=size||pos<0){
            throw new IndexOutOfBoundsException("does not exist");
        }
        Node prev = head;
        for(int i =0; i <pos; i++){
            prev = prev.next;
        }
        return (T)prev.data;
    }
    //a function that returns the size
    @Override
    public int size() {
        return size;
    }
    public  String toString() {
        String result = "";
        Node current = head;
        while(current != null){
            result += current.data;
            current = current.next;
        }
        return   result;
    }
    public static void main(String args[])
    {
        SortedLinkedList<Integer> al = new SortedLinkedList<Integer>();
        System.out.println("Size of ArrayList " + al.size());

        //al.get(3);

        al.add(1);
        al.add(2);
        al.add(4);
        al.add(3);
        al.add(5);
        al.add(10);
        al.add(7);
        al.add(8);
        al.add(9);

        //al.add(1, "For");
        System.out.println("Initial ArrayList " + al);
        try {

            System.out.println(al.get(5));
            al.remove(1);
            //al.remove("Girl");
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("After the Index Removal " + al.toString());
        System.out.println("Size of ArrayList " + al.size());

    }




}