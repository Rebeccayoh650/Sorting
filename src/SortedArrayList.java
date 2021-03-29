import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class SortedArrayList<T extends Comparable<T>> implements SortedList<T>{
    protected T[] a;
    protected int size;



    public SortedArrayList() {
        a = (T[]) new Comparable[10];
        size=0;
    }
    //a helper function
    private void grow_array() //doubles size of array
    {
        T [] new_arr = (T[]) new Object[size *= 2];
        for (int i = 0; i < size; i++)
            new_arr[i] = a[i];
        a = new_arr;
    }
    public void swap(int i, int j) {
        T temp = a[j];
        a[j] = a[j+1];
        a[j+1] = temp;
    }
    //For( int i = 0; I < list.length; I ++) {
    //for(int j = 0; j < list.length; j++)
    //If list.get(j).compareTo(list.get(j+1)) > 0)
    //Swap items j and j + 1
    @Override
    public boolean add(T item) {
        if (size == 0) {
            a[0] = item;
            size++;
            return true;
        }
        //using copareto method to add items in sorted order
        if (size == a.length) {
            grow_array();
        }
        a[size] = item;
        //sorting
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (a[j].compareTo(item) > j+1) {
                    swap(j, j+1);

                }
            }
        }
        size++;
        return true; // placeholder need to edit
    }
    @Override
    public T remove(int pos) throws Exception {
        if (pos < 0 || pos >= size) {
            throw new Exception("Invalid Position");
        }

        // copy item in the array
        T item = a[pos];

        // move stuff in array over
        for (int i = pos; i <size-1 ; i++) {
            a[i] = a[i+1];
        }
        a[size-1] = null;

        size -= 1;
        //System.out.println(Arrays.toString(a));
        return item;

    }

    @Override
    public T get(int pos) throws Exception {
        System.out.println(size);
        if (pos < 0 || pos >= size) {
            System.out.println("error");
            throw new Exception("Invalid Position");
        }
        return a[pos];
    }

    @Override
    public int size() {
        return size;
    }
    public String toString(){
        return Arrays.toString(a);
    }


    public static void main(String args[])
    {
        SortedArrayList<Integer> al = new SortedArrayList<Integer>();
        System.out.println("Size of ArrayList " + al.size());
        //al.get(3);

        al.add(1);
        al.add(3);
        al.add(2);
        al.add(4);
        al.add(5);

        System.out.println("Initial ArrayList " + al);
        try {

            //System.out.println(al.get(9));
            //al.remove(1);
            //al.remove("Girl");
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("After the Index Removal " + al.toString());
        //System.out.println("After the Object Removal " + Arrays.toString(al));
        System.out.println("Size of ArrayList " + al.size());
    }

}