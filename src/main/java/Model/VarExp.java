package Model;

import utils.MyException;
import utils.MyIDictionary;

/**
 * Created by Wyking on 10/29/2016.
 */
public class VarExp extends Exp {

    String nm;

    public VarExp(String name){
        nm = name;
    }


    int eval(MyIDictionary<String, Integer> tbl) throws Exception {
        return tbl.get(nm);
    }

    public String toString(){
        return nm;
    }
}
