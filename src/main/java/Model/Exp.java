package model;

import utils.MyIDictionary;
import utils.MyIHeap;

/**
 * Created by Wyking on 10/29/2016.
 */
abstract class Exp{
    abstract int eval(MyIDictionary<String, Integer> tbl, MyIHeap<Integer> hp) throws Exception;
}
