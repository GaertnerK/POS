public class Model {
    private String name;
    private String lastname;
    private String team;
    private int number;
    private long lapTime;
    private long penalties;

    public Model(String name, String lastname, String team, int number){
        this.name = name;
        this.lastname = lastname;
        this.team = team;
        this.number = number;
        this.penalties = 0;
    }

    public void addPenalty(){
        
    }
}
