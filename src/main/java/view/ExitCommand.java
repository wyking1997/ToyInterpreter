package view;

/**
 * Created by Wyking on 11/6/2016.
 */
public class ExitCommand extends Command {
    public ExitCommand(String key, String desc){
        super(key, desc);
    }
    @Override
    public void execute() {
        System.exit(0);
    }
}
