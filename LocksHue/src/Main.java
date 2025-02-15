public class Main {
    public static void main(String[] args) {
        Dagger[] daggers = {new Dagger(), new Dagger(), new Dagger(), new Dagger(), new Dagger()};
        Thread t1 = new Thread(new Orc(daggers[0], daggers[1], 1));
        Thread t2 = new Thread(new Orc(daggers[1], daggers[2], 2));
        Thread t3 = new Thread(new Orc(daggers[2], daggers[3], 3));
        Thread t4 = new Thread(new Orc(daggers[3], daggers[4], 4));
        Thread t5 = new Thread(new Orc(daggers[4], daggers[0], 5));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}