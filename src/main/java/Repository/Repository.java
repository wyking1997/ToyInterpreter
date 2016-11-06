package repository;

import model.PrgState;
import utils.MyException;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Wyking on 10/29/2016.
 */
public class Repository implements MyIRepository {

    ArrayList<PrgState> ls;
    private String file_name;

    public Repository(PrgState state, String output_file) {

        ls = new ArrayList<PrgState>();
        add(state);
        file_name = "files\\repo_files\\" + output_file;
        init_file();
    }

    public Repository(PrgState state){

        this(state, "default.txt");
    }

    public void add(PrgState state) {

        ls.add(state);
    }

    public PrgState get(int position) throws Exception{

        if (position < 0 || position > ls.size())
            throw new MyException("Index out of bounds!");
        return ls.get(position);
    }

    private void init_file(){
        FileWriter fw = null;
        PrintWriter pw = null;

        try{
            fw = new FileWriter(file_name, false);
            pw = new PrintWriter(fw, false);
        } catch (IOException e) {
            System.out.println("!!!INTERNAL ERROR: " + e.getMessage());
        }

        try {
            fw.close();
        } catch (IOException e) {
            System.out.println("!!!INTERNAL ERROR: " + e.getMessage());
        }
        pw.close();
    }

    public void logPrgStateExec(String data) throws Exception {

        FileWriter fw;
        PrintWriter pw;

        try{
            fw = new FileWriter(file_name, true);
            pw = new PrintWriter(fw, true);
        } catch (IOException e) {
            throw new MyException("EROR AT PRINTWRITER");
        }

        pw.write(data + "\n");
        pw.close();
    }

}
