package utils;

/**
 * Created by Wyking on 10/23/2016.
 */
public interface MyIStack<T> {
    public void push(T el);
    public T pop();
    public boolean isEmpty();

    public String toString();
}
