package Repository;

import Model.PrgState;
import utils.MyException;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Wyking on 10/29/2016.
 */
public class Repository implements MyIRepository {

    ArrayList<PrgState> ls;
    private String file_name;

    public Repository(String output_file){

        ls = new ArrayList<PrgState>();
        file_name = output_file;
    }
    public Repository(){

        this("default.txt");
    }

    public void add(PrgState state) {

        ls.add(state);
    }

    public PrgState get(int position) throws Exception{

        if (position < 0 || position > ls.size())
            throw new MyException("Index out of bounds!");
        return ls.get(position);
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
