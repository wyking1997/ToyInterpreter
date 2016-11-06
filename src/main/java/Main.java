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
        IStm stm222 = new CompStm(new AssingnStm("a", new ConstExp(10)), new CompStm(new AssingnStm("b", new ConstExp(45)),                                                            new PrintStm(new ArithExp(new VarExp("a"), new VarExp("b"), '+'))));
        IStm stm22 = new CompStm(stm1,stm222);
        IStm stm23 = new CompStm(stm22, new PrintStm(new ArithExp(new VarExp("a"), new VarExp("b"), '-')));
        IStm stm24 = new CompStm(stm23, new PrintStm(new ArithExp(new VarExp("a"), new VarExp("b"), '*')));
        IStm stm2 = new CompStm(stm24, new PrintStm(new ArithExp(new VarExp("a"), new VarExp("b"), '/')));
        IStm stm3 = new IfStm(new ArithExp(new VarExp("a"), new VarExp("b"), '+'), new PrintStm(new ConstExp(1)), new PrintStm(new ConstExp(0)));
        IStm stm4 = new CompStm(stm2,stm3);
        // stm4 --> all from first lab

        String fl_name1 = "da.txt";
        String fl_name2 = "nu.txt";
        IStm stm05 = new CompStm(new OpenRFile("file1",fl_name1),new CompStm(new readFile(new VarExp("file1"),"a"), new readFile(new VarExp("file1"),"b")));
        IStm stm5 = new CompStm(stm05, new OpenRFile("file2",fl_name2));
        IStm stm51 = new CompStm(new readFile(new ConstExp(1),"c"), new CloseRFile(new VarExp("file1")));
        IStm stm6 = new CompStm(stm5, new CompStm(new readFile(new VarExp("file2"),"c"), stm51));
        //stm6 --> all from second lab

        stack.push(stm6);

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
