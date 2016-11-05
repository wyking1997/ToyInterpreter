package utils;

/**
 * Created by Wyking on 10/23/2016.
 */
public interface MyIOut<T> {
    public boolean add(T e);
    public void clear();
    public T get(int index) throws IndexOutOfBoundsException;
    public boolean isEmpty();
    public void remove(int index) throws IndexOutOfBoundsException;

    public String toString();
}
