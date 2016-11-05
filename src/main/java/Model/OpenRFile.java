package Model;

import utils.MyException;
import utils.MyIDictionary;
import utils.MyIFileTable;
import utils.Pair;

import java.io.*;
import java.util.Set;

/**
 * Created by Wyking on 11/5/2016.
 */
public class OpenRFile implements IStm {

    static int ID = 0;
    String var_file_id;
    String name;

    public OpenRFile(String var_file_id, String name) {
        this.var_file_id = var_file_id;
        this.name = name;
    }

    public PrgState execute(PrgState state) throws Exception {
        MyIFileTable<Integer, Pair<String,BufferedReader>> fileTb = state.getExFlTable();
        if (checkFile(fileTb))
            throw new MyException("Can not open file '" + name + "' twice");
        File file = new File(name);
        if (!file.exists())
            throw new MyException("File '" + name + "' does not exist!");
        FileReader fl;
        BufferedReader br;
        try {
            fl = new FileReader(file);
            br = new BufferedReader(fl);
        } catch (FileNotFoundException e) {
            throw new MyException("!!!!INTERNAL EXCEPTION: " + e.getMessage());
        }
        fileTb.add(ID,new Pair<String, BufferedReader>(name,br));
        MyIDictionary<String, Integer> exDict = state.getExDict();
        exDict.put(var_file_id, ID++);
        return state;
    }

    //check if the file is already in the file table
    //return true if the file already exists
    //return false oherwise
    boolean checkFile(MyIFileTable<Integer, Pair<String, BufferedReader>> fileTb) {
        Set<Integer> keys = fileTb.getKeys();
        for (Integer i : keys)
            if (fileTb.get(i).getFirstEl().equals(name))
                return true;
        return false;
    }

    public String toString(){
        return "openRFile(" + var_file_id + ", " + name + ")";
    }
}
