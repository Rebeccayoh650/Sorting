public interface SortedList<T  extends Comparable<T>> {
    //interface that will be implemented by other classes along with its methods
    boolean add(T Comparable);

    T remove(int pos) throws Exception;

    T get(int pos) throws Exception;

    int size();


}
