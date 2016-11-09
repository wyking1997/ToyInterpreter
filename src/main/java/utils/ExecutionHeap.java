package utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Wyking on 11/9/2016.
 */
public class ExecutionHeap<T> implements MyIHeap<T> {

    static int nextFreeAddr = 0;

    Map<Integer,T> map;

    public ExecutionHeap(){
        map = new HashMap<Integer, T>();
    }

    public void clear() {
        map.clear();
    }

    public boolean containsKey(Integer key) {
        return map.containsKey(key);
    }

    public boolean containsValue(T value) {
        return map.containsValue(value);
    }

    public T get(Integer key) {
        return map.get(key);
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public void put(T value) {
        map.put(nextFreeAddr++, value);
    }

    public String toString(){
        String res = "SymbolsTable:\n";
        Iterator<Integer> it = map.keySet().iterator();

        while (it.hasNext())
            try {
                int s = it.next();
                res += s + "=" + this.get(s) + "\n";
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        return res + "::::::::::::::::\n";
    }
}
