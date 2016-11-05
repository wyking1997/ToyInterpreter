package Model;

import utils.MyException;
import utils.MyIDictionary;

/**
 * Created by Wyking on 10/29/2016.
 */
public class ArithExp extends Exp {

    Exp e1;
    Exp e2;

    char opp;

    public ArithExp(Exp e11, Exp e22, char op){
        opp = op;
        e1 = e11;
        e2 = e22;
    }

    public int eval(MyIDictionary<String, Integer> sbTbl) throws Exception {
       switch (opp) {
           case '+':
               return e1.eval(sbTbl) + e2.eval(sbTbl);
           case '-':
               return e1.eval(sbTbl) - e2.eval(sbTbl);
           case '/':
               if (e2.eval(sbTbl) == 0)
                   throw new MyException("Divide by 0: " + e1.eval(sbTbl) + opp + e2.eval(sbTbl) + "!");
               return e1.eval(sbTbl) / e2.eval(sbTbl);
           case '*':
               return e1.eval(sbTbl) * e2.eval(sbTbl);
           default:
               throw new MyException("Ilegal opperator' " + opp + "'!");
       }
    }

    public String toString() {
        return e1.toString() + " " + opp + " " + e2.toString();
    }
}
