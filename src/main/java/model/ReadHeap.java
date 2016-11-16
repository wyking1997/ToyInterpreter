package model;

import utils.MyIDictionary;
import utils.MyIHeap;

/**
 * Created by Wyking on 11/16/2016.
 */
public class ReadHeap extends Exp {

    // the name of the variable witch we want to read from
    String var_name;

    public ReadHeap(String var_name) {
        this.var_name = var_name;
    }

    int eval(MyIDictionary<String, Integer> tbl, MyIHeap<Integer> hp) throws Exception {
        Integer var = tbl.get(var_name);
        return hp.get(var);
    }

    public String toString(){
        return "ReadHeap(" + var_name + ")";
    }
}
