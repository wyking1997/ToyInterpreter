package utils;

import java.util.Set;

/**
 * Created by Wyking on 11/2/2016.
 */
public interface MyIFileTable<I,T> {

    Set<I> getKeys();
    boolean containsKey(I key);
    T get(I key);
    void add(I key, T el);
    void remove(I key);
}
