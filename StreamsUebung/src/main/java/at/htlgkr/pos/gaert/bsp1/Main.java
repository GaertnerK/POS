package at.htlgkr.pos.gaert.bsp1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    final static String filename = "weapons.csv";
    public static void main(String[] args) throws IOException {
        List<Weapon> weaponList = new ArrayList<>();
        weaponList = Files.lines(new File(filename).toPath())
                .skip(1)
                .map(s -> s.split(";"))
                .map(s -> new Weapon(
                        s[0],
                        CombatType.valueOf(s[1]),
                        DamageType.valueOf(s[2]),
                        Integer.parseInt(s[3]),
                        Integer.parseInt(s[4]),
                        Integer.parseInt(s[5]),
                        Integer.parseInt(s[6])
                ))
                .collect(Collectors.toList());
        weaponList.forEach(System.out::println);

        weaponList.sort((a,b)->Integer.compare(b.getDamage(), a.getDamage()));
    }
}