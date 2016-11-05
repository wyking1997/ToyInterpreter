package Model;

/**
 * Created by Wyking on 10/29/2016.
 */
public class IfStm implements IStm {

    Exp exp;
    IStm trueS;
    IStm falseS;

    public IfStm(Exp verified_exp, IStm if_ok, IStm if_not_ok){
        exp = verified_exp;
        trueS = if_ok;
        falseS = if_not_ok;
    }

    public PrgState execute(PrgState state) throws Exception {
        if (exp.eval(state.getExDict()) != 0)
            trueS.execute(state);
        else
            falseS.execute(state);
        return state;
    }

    public String toString(){
        return "if (" + exp.toString() + ") then " + trueS.toString() + " else " + falseS.toString();
    }
}
