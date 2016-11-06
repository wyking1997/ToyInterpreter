import controller.Controller;
import model.*;
import repository.Repository;
import utils.*;

import java.io.BufferedReader;

/**
 * Created by Wyking on 10/29/2016.
 */
public class Main {
    public static void main(String[] args) {
        Repository repo = new Repository();
        Controller c = new Controller(repo);

        //building our prg state
        MyIStack<IStm> stack = new ExecutionStack<IStm>();
        MyIDictionary<String, Integer> smbTable = new ExecutionDictionary<String, Integer>();
        MyIOut<Integer> out = new ExecutionOut<Integer>();
        MyIFileTable<Integer,Pair<String,BufferedReader>> flTable = new ExecutionFileTable<Integer, Pair<String,BufferedReader>>();

        IStm stm1 = new CompStm(new PrintStm(new ConstExp(10)), new PrintStm(new ConstExp(100)));
        IStm stm22 = new CompStm(new AssingnStm("a", new ConstExp(10)), new CompStm(new AssingnStm("b", new ConstExp(45)),
                                                            new PrintStm(new ArithExp(new VarExp("a"), new VarExp("b"), '+'))));
        IStm stm23 = new CompStm(stm22, new PrintStm(new ArithExp(new VarExp("a"), new VarExp("b"), '-')));
        IStm stm24 = new CompStm(stm23, new PrintStm(new ArithExp(new VarExp("a"), new VarExp("b"), '*')));
        IStm stm2 = new CompStm(stm24, new PrintStm(new ArithExp(new VarExp("a"), new VarExp("b"), '/')));
        IStm stm3 = new IfStm(new ArithExp(new VarExp("a"), new VarExp("b"), '+'), new PrintStm(new ConstExp(1)),
                                                            new PrintStm(new ConstExp(0)));
        IStm stm4 = new CompStm(stm2,stm3);

        String fl_name = "E:\\Documents\\Metode avansate de programare\\ToyInterpreter\\src\\main\\resources\\files\\da.txt";
        IStm stm5 = new CompStm(new OpenRFile("x",fl_name),new CompStm(new readFile(new VarExp("x"),"a"),
                                        new readFile(new VarExp("x"),"b")));
        IStm stm6 = new CompStm(stm5, new ConstExp(new readFile(new VarExp("x"),"c"), new CloseRFile(new VarExp("x"))));

        stack.push(stm5);

        PrgState state = new PrgState(stack, smbTable, out, flTable);

        c.add(state);

        try {
            c.executeAllStep();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
