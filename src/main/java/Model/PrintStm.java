package Model;

import utils.MyException;
import utils.MyIOut;

/**
 * Created by Wyking on 10/29/2016.
 */
public class PrintStm implements IStm {
    private Exp exp;

    public PrintStm(Exp ex){
        exp = ex;
    }

    public PrgState execute(PrgState state) throws Exception {

        MyIOut<Integer> out = state.getExOut();
        out.add(exp.eval(state.getExDict()));
        return state;
    }

    public String toString(){
        return "print(" + exp.toString() + ")";
    }
}
