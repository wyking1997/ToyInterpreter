package utils;

/**
 * Created by Wyking on 10/23/2016.
 */
public interface MyIDictionary<S,I> {
    void clear();
    boolean	containsKey(S key);
    boolean	containsValue(I value);
    I get(S key) throws Exception;
    boolean isEmpty();
    void put(S key, I value);

    String toString();
}
