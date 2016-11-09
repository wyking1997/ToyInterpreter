package view;


import controller.Controller;
import model.*;
import repository.Repository;
import utils.*;

import java.io.BufferedReader;

/**
 * Created by Wyking on 11/6/2016.
 */
public class Interpreter {
    public static void main(String[] args) {

        IStm statement1 = new CompStm(new OpenRFile("var_f","test.in"), new CompStm(new ReadFile(new VarExp("var_f"),"var_c"), new CompStm(new PrintStm(new VarExp("var_c")), new CompStm(new IfStm(new VarExp("var_c"), new CompStm(new ReadFile(new VarExp("var_f"),"var_c"), new PrintStm(new VarExp("var_c"))), new PrintStm(new ConstExp(0))), new CloseRFile(new VarExp("var_f"))))));
        PrgState state1 = new PrgState(new ExecutionStack<IStm>(), new ExecutionDictionary<String, Integer>(), new ExecutionOut<Integer>(), new ExecutionFileTable<Integer, Pair<String, BufferedReader>>(), statement1);
        Repository repo1 = new Repository(state1);
        Controller ctr1 = new Controller(repo1);

        IStm statement2 = new CompStm(new OpenRFile("var_f","test.in"), new CompStm(new ReadFile(new ArithExp(new VarExp("var_f"), new ConstExp(2), '+'),"var_c"), new CompStm(new PrintStm(new VarExp("var_c")), new CompStm(new IfStm(new VarExp("var_c"), new CompStm(new ReadFile(new VarExp("var_f"),"var_c"), new PrintStm(new VarExp("var_c"))), new PrintStm(new ConstExp(0))), new CloseRFile(new VarExp("var_f"))))));
        PrgState state2 = new PrgState(new ExecutionStack<IStm>(), new ExecutionDictionary<String, Integer>(), new ExecutionOut<Integer>(), new ExecutionFileTable<Integer, Pair<String, BufferedReader>>(), statement2);
        Repository repo2 = new Repository(state2);
        Controller ctr2 = new Controller(repo2);

        IStm stm1 = new CompStm(new PrintStm(new ConstExp(10)), new PrintStm(new ConstExp(100)));
        IStm stm222 = new CompStm(new AssingnStm("a", new ConstExp(10)), new CompStm(new AssingnStm("b", new ConstExp(45)), new PrintStm(new ArithExp(new VarExp("a"), new VarExp("b"), '+'))));
        IStm stm22 = new CompStm(stm1, stm222);
        IStm stm23 = new CompStm(stm22, new PrintStm(new ArithExp(new VarExp("a"), new VarExp("b"), '-')));
        IStm stm24 = new CompStm(stm23, new PrintStm(new ArithExp(new VarExp("a"), new VarExp("b"), '*')));
        IStm stm2 = new CompStm(stm24, new PrintStm(new ArithExp(new VarExp("a"), new VarExp("b"), '/')));
        IStm stm3 = new IfStm(new ArithExp(new VarExp("a"), new VarExp("b"), '+'), new PrintStm(new ConstExp(1)), new PrintStm(new ConstExp(0)));
        IStm stm4 = new CompStm(stm2, stm3);
        PrgState state3 = new PrgState(new ExecutionStack<IStm>(), new ExecutionDictionary<String, Integer>(), new ExecutionOut<Integer>(), new ExecutionFileTable<Integer, Pair<String, BufferedReader>>(), stm4);
        Repository repo3 = new Repository(state3);
        Controller ctr3 = new Controller(repo3);

        String fl_name1 = "da.txt";
        String fl_name2 = "nu.txt";
        IStm stm05 = new CompStm(new OpenRFile("file1", fl_name1), new CompStm(new ReadFile(new VarExp("file1"), "a"), new ReadFile(new VarExp("file1"), "b")));
        IStm stm5 = new CompStm(stm05, new OpenRFile("file2", fl_name2));
        IStm stm51 = new CompStm(new ReadFile(new ConstExp(1), "c"), new CloseRFile(new VarExp("file1")));
        IStm stm6 = new CompStm(stm5, new CompStm(new ReadFile(new VarExp("file2"), "c"), stm51));
        PrgState state4 = new PrgState(new ExecutionStack<IStm>(), new ExecutionDictionary<String, Integer>(), new ExecutionOut<Integer>(), new ExecutionFileTable<Integer, Pair<String, BufferedReader>>(), stm6);
        Repository repo4 = new Repository(state4,"da");
        Controller ctr4 = new Controller(repo4);

        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExampleCommand("1", statement1.toString(),ctr1));
        menu.addCommand(new RunExampleCommand("2", statement2.toString(),ctr2));
        menu.addCommand(new RunExampleCommand("3", stm4.toString(),ctr3));
        menu.addCommand(new RunExampleCommand("4", stm6.toString(),ctr4));
        menu.show();
    }
}
