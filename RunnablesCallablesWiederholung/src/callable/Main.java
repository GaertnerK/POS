package callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Model> drivers = new ArrayList<Model>();
        drivers.add(new Model("Max", "Verstappen", "Red Bull Racing", 1));
        drivers.add(new Model("Sergio", "Perez", "Red Bull Racing", 11));
        drivers.add(new Model("Lewis", "Hamilton", "Mercedes", 44));
        drivers.add(new Model("George", "Russell", "Mercedes", 63));
        drivers.add(new Model("Charles", "Leclerc", "Ferrari", 16));
        drivers.add(new Model("Carlos", "Sainz", "Ferrari", 55));
        drivers.add(new Model("Lando", "Norris", "McLaren", 4));
        drivers.add(new Model("Oscar", "Piastri", "McLaren", 81));
        drivers.add(new Model("Fernando", "Alonso", "Aston Martin", 14));
        drivers.add(new Model("Lance", "Stroll", "Aston Martin", 18));
        drivers.add(new Model("Esteban", "Ocon", "Alpine", 31));
        drivers.add(new Model("Pierre", "Gasly", "Alpine", 10));
        drivers.add(new Model("Daniel", "Ricciardo", "AlphaTauri", 3));
        drivers.add(new Model("Yuki", "Tsunoda", "AlphaTauri", 22));
        drivers.add(new Model("Valtteri", "Bottas", "Alfa Romeo", 77));
        drivers.add(new Model("Zhou", "Guanyu", "Alfa Romeo", 24));
        drivers.add(new Model("Kevin", "Magnussen", "Haas", 20));
        drivers.add(new Model("Nico", "Hulkenberg", "Haas", 27));
        drivers.add(new Model("Alexander", "Albon", "Williams", 23));
        drivers.add(new Model("Logan", "Sargeant", "Williams", 2));

        ExecutorService executor = Executors.newCachedThreadPool();

        drivers.getFirst().addPenalty();
        for (Model driver : drivers) {
            Callable<Model> c = driver;
            Future<Model> future = executor.submit(c);
            System.out.println(future.get());
        }
        executor.shutdown();
    }
}