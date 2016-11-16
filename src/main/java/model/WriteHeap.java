package model;

import utils.MyIDictionary;
import utils.MyIHeap;

/**
 * Created by Wyking on 11/16/2016.
 */
public class WriteHeap implements IStm {

    String var_name;
    Exp expression;

    public WriteHeap(String var_name, Exp expression) {
        this.var_name = var_name;
        this.expression = expression;
    }

    public PrgState execute(PrgState state) throws Exception {
        MyIDictionary<String, Integer> sb = state.getExDict();
        MyIHeap<Integer> hp = state.getExHeap();

        int sbVal = sb.get(var_name);
        hp.put(sbVal,expression.eval(sb,hp));

        return state;
    }
}
