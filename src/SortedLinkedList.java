import java.util.Arrays;

class Node<T>{
    T data;
    Node<T> next;
    Node<T> prev;

    public Node(Object data){
        this.data = (T) data;
    }
}
public class SortedLinkedList<T extends Comparable<T>> implements SortedList<T>{

    Node<T> head;
    int size;


//    public Node(T value){
//        data = value;
//        next = null;
//    }
    public SortedLinkedList(){
        T head = null;
        size =0;
    }

    @Override
    public boolean add(T item) {
        if(head == null){
            head = new Node<T>(item);
            ++size;
        }
        else{
            Node<T>prev = head;
            while(prev.next != null){
                prev = prev.next;
            }

            Node<T>curr = new Node<T>(item);
            prev.next = curr;
            ++size;

        }
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size - i - 1; j++) {
//                if ([i].compareTo(item) > 0) {
//                    swap(j, j + 1);
//                }
//            }
//        }
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

    @Override
    public int size() {
        return size;
    }
    public String toString(){
        return head.toString();
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

        //al.add(1, "For");

        System.out.println("Initial ArrayList " + al);
        try {

            //System.out.println(al.get(9));
            al.remove(1);
            //al.remove("Girl");
        }catch (Exception e){
            System.out.println(e);
        }



        System.out.println("After the Index Removal " + al.toString());



        //System.out.println("After the Object Removal " + Arrays.toString(al));
        //System.​out​.println(​"A.compareTo(B) = "​ + ​al.get(1)​.compareTo(​b​));
        System.out.println("Size of ArrayList " + al.size());


    }


}