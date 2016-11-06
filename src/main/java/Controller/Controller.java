package controller;

import model.IStm;
import model.PrgState;
import repository.MyIRepository;
import utils.MyIStack;

/**
 * Created by Wyking on 10/29/2016.
 */
public class Controller {

    MyIRepository repo;

    public Controller(MyIRepository r) {
        repo = r;
    }

    public void add(PrgState state) {
        repo.add(state);
    }

    public String executeOneStep() throws Exception {
        PrgState state = repo.get(0);
        MyIStack<IStm> stack = state.getExStack();
        IStm statement = stack.pop();
        statement.execute(state);
        return state.toString();
    }

    public void executeAllStep() throws Exception {
        PrgState state = repo.get(0);
        System.out.println(state.toString());
        repo.logPrgStateExec(state.toString());
        MyIStack<IStm> stack = state.getExStack();
        String data = null;

        while (!stack.isEmpty()) {
            data = executeOneStep() + "\n";
            System.out.println(data);
            repo.logPrgStateExec(data);
        }
    }
}
