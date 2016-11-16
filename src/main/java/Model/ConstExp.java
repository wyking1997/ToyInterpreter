package model;

import utils.MyIDictionary;
import utils.MyIHeap;

/**
 * Created by Wyking on 10/29/2016.
 */
public class ConstExp extends Exp{

    int number;

    public ConstExp(int nb){
        number = nb;
    }

    public int eval(MyIDictionary<String, Integer> sbTbl, MyIHeap<Integer> hp){
        return number;
    }

    public String toString() {
        return String.valueOf(number);
    }
}
