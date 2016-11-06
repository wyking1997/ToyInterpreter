package view;

import controller.Controller;

/**
 * Created by Wyking on 11/6/2016.
 */
public class RunExampleCommand extends Command{
    private Controller ctr;
    public RunExampleCommand(String key, String desc,Controller ctr){
        super(key, desc);
        this.ctr=ctr;
    }
    @Override
    public void execute() {
        try{
            ctr.executeAllStep();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
