package callable;

import java.util.concurrent.Callable;

public class Model implements Callable {
    private String name;
    private String lastname;
    private String team;
    private int number;
    private long lapTime;
    private int penalties;

    private Formatter formatter;

    public Model(String name, String lastname, String team, int number){
        this.name = name;
        this.lastname = lastname;
        this.team = team;
        this.number = number;
        this.lapTime = 0;
        this.penalties = 0;
        this.formatter = s -> s.name + " " + s.lastname + ", " + s.number  + ", " + s.team + ": " + s.lapTime;
    }

    public void addPenalty(){
        penalties++;
    }

    public void drive(){
        if(penalties != 0){
            while(penalties >= 0) {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                }
                penalties--;
            }
        }
        lapTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return formatter.format(this);
    }

    @Override
    public Object call() throws Exception {
        this.drive();
        return this;
    }
}
