package utils;

/**
 * Created by Wyking on 10/23/2016.
 */
public interface MyIDictionary<S,I> {
    public void clear();
    public boolean	containsKey(S key);
    public boolean	containsValue(I value);
    public I get(S key) throws Exception;
    public boolean isEmpty();
    public void put(S key, I value);

    public String toString();
}
