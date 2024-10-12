import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Weapon> weaponList = new ArrayList<>();
        weaponList = Files.lines(new File("weapons.csv").toPath())
                .skip(1)
                .map(s -> s.split(";"))
                .map(s -> new Weapon(
                        s[0], Integer.parseInt(s[1]), s[2], Double.parseDouble(s[3]), Integer.parseInt(s[4]), s[5]
                ))
                .collect(Collectors.toList());
    }

    Player player = new Player();
}