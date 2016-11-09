package utils;

/**
 * Created by Wyking on 11/9/2016.
 */
public interface MyIHeap<T> {

    void clear();
    boolean containsKey(Integer key);
    boolean containsValue(T value);
    T get(Integer key);
    boolean isEmpty();
    void put(T value);

    String toString();
}
