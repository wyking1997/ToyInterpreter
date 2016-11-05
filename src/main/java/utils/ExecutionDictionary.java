package utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Wyking on 10/23/2016.
 */
public class ExecutionDictionary<S,I> implements MyIDictionary<S,I> {

    Map<S,I> map;
    public ExecutionDictionary(){

        map = new HashMap<S, I>();
    }

    public void clear(){

        map.clear();
    };

    public boolean containsKey(S key){

        return map.containsKey(key);
    };

    public boolean containsValue(I value){

        return map.containsKey(value);
    };

    public I get(S key) throws Exception{

        if(this.containsKey(key))
            return map.get(key);
        throw new MyException("Unknown variable: '" + key.toString() + "'");
    };

    public boolean isEmpty(){

        return map.isEmpty();
    };

    public void put(S key, I value){

        map.put(key, value);
    };

    public String toString(){
        String res = "SymbolsTable:\n";
        Iterator<S> it = map.keySet().iterator();

        while (it.hasNext())
            try {
                S s = it.next();
                res += s + "=" + this.get(s) + "\n";
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        return res + "::::::::::::::::\n";
    }
}
