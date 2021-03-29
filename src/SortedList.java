public interface SortedList<T  extends Comparable<T>> {
    boolean add(T Comparable);

    T remove(int pos) throws Exception;

    T get(int pos) throws Exception;

    int size();


}
