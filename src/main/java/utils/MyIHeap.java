package utils;

/**
 * Created by Wyking on 11/9/2016.
 */
public interface MyIHeap<T> {

    void clear();
    boolean containsKey(Integer key);
    boolean containsValue(T value);
    T get(Integer key) throws Exception;
    boolean isEmpty();

    //returns the addres of the new element
    int put(T value);
    void put(int pos, T value);

    String toString();
}
