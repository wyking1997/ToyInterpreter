package Model;

import utils.MyException;
import utils.MyIDictionary;

/**
 * Created by Wyking on 10/29/2016.
 */
abstract class Exp{
    abstract int eval(MyIDictionary<String, Integer> tbl) throws Exception;
}
