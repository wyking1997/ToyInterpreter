package Model;

import utils.*;

import java.io.BufferedReader;

/**
 * Created by Wyking on 10/23/2016.
 */
public class PrgState {

    static int ID = 0;

    MyIStack<IStm> exStack;
    MyIDictionary<String, Integer> exDict;
    MyIOut<Integer> exOut;
    MyIFileTable<Integer, Pair<String,BufferedReader>> exFlTable;
    int id;

    public MyIFileTable<Integer, Pair<String, BufferedReader>> getExFlTable() {
        return exFlTable;
    }

    public PrgState(MyIStack<IStm> st, MyIDictionary<String, Integer> dt,
                    MyIOut<Integer> out, MyIFileTable<Integer, Pair<String,BufferedReader>> fltable){
        exStack = st;
        exDict = dt;
        exOut = out;
        exFlTable = fltable;

        id = ID++;
    }

    public MyIStack<IStm> getExStack() {
        return exStack;
    }

    public MyIDictionary<String, Integer> getExDict() {
        return exDict;
    }

    public MyIOut<Integer> getExOut() {
        return exOut;
    }

    public String toString(){
        return exStack.toString() + exDict.toString() + exOut.toString() +exFlTable.toString();
    }
}
