package streamsLambda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Player p = new Player("dasf", 9.9, 3.5, new ArrayList<>());
        ReadCsv readCsv = new ReadCsv();
        List<Weapon> weaponList = readCsv.readWeapons();
        System.out.println(p);
    }
}
