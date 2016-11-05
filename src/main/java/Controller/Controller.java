package Controller;

import Model.IStm;
import Model.PrgState;
import Repository.MyIRepository;
import utils.MyException;
import utils.MyIStack;

/**
 * Created by Wyking on 10/29/2016.
 */
public class Controller {

    MyIRepository repo;

    public Controller(MyIRepository r){
        repo = r;
    }

    public void add(PrgState state){
        repo.add(state);
    }

    public String executeOneStep() throws Exception{
        PrgState state = repo.get(0);
        MyIStack<IStm> stack = state.getExStack();
        IStm statement = stack.pop();
        statement.execute(state);
        return state.toString();
    }

    public void executeAllStep() throws Exception {
        PrgState state = repo.get(0);
        MyIStack<IStm> stack = state.getExStack();
        String data;

        while (!stack.isEmpty())
            try {
                data = executeOneStep() + "\n";
                System.out.println(data);
                repo.logPrgStateExec(data);
            }catch(MyException e){}
    }
}
