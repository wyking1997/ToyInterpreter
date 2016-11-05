package Model;

import utils.MyException;

/**
 * Created by Wyking on 10/23/2016.
 */
public interface IStm {
    PrgState execute(PrgState state) throws Exception;
    String toString();
}
